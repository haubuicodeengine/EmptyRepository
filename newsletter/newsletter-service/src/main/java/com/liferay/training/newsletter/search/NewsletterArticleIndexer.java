package com.liferay.training.newsletter.search;

import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexWriterHelper;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.training.newsletter.model.NewsletterArticle;
import com.liferay.training.newsletter.service.NewsletterArticleLocalService;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = Indexer.class)
public class NewsletterArticleIndexer extends BaseIndexer<NewsletterArticle> {

	public NewsletterArticleIndexer() {

		setDefaultSelectedFieldNames(
				Field.ASSET_TAG_NAMES,
				Field.COMPANY_ID,
				Field.CONTENT,
				Field.ENTRY_CLASS_NAME,
				Field.ENTRY_CLASS_PK,
				Field.GROUP_ID,
				Field.MODIFIED_DATE,
				Field.SCOPE_GROUP_ID,
				Field.TITLE,
				Field.UID,
				Field.DESCRIPTION);
		// Set to false in case we are not needing permission check
		setPermissionAware(false);
	}

	@Override
	public String getClassName() {

		return NewsletterArticle.class.getName();
	}

	@Override
	public void postProcessSearchQuery(BooleanQuery searchQuery, BooleanFilter fullQueryBooleanFilter,
			SearchContext searchContext) throws Exception {

		addSearchLocalizedTerm(searchQuery, searchContext, Field.TITLE, false);
		addSearchLocalizedTerm(searchQuery, searchContext, Field.DESCRIPTION, false);
	}

	@Override
	protected void doDelete(NewsletterArticle newsletterArticle) throws Exception {

		deleteDocument(newsletterArticle.getCompanyId(), newsletterArticle.getNewsletterArticleId());
	}

	@Override
	protected Document doGetDocument(NewsletterArticle newsletterArticle) throws Exception {

		Document document = getBaseModelDocument(NewsletterArticle.class.getName(), newsletterArticle);

		document.addKeyword(Field.COMPANY_ID, newsletterArticle.getCompanyId());
		document.addKeyword(Field.GROUP_ID, newsletterArticle.getGroupId());
		document.addKeyword(Field.SCOPE_GROUP_ID, newsletterArticle.getGroupId());
		document.addKeyword(Field.TITLE, newsletterArticle.getTitle());
		document.addKeyword(Field.DESCRIPTION, newsletterArticle.getContent());

		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletRequest portletRequest,
			PortletResponse portletResponse) throws Exception {

		Summary summary = createSummary(document);
		summary.setMaxContentLength(200);

		return summary;
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {

		NewsletterArticle newsletterArticle = newsletterArticleLocalService.getByResourcePrimKey(classPK);
		doReindex(newsletterArticle);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {

		long companyId = GetterUtil.getLong(ids[0]);
		reindexNewsletterArticles(companyId);

	}

	@Override
	protected void doReindex(NewsletterArticle newsletterArticle) throws Exception {

		Document document = getDocument(newsletterArticle);
		indexWriterHelper.updateDocument(getSearchEngineId(), newsletterArticle.getCompanyId(), document,
				isCommitImmediately());

	}

	protected void reindexNewsletterArticles(long companyId) throws PortalException {

		final IndexableActionableDynamicQuery indexableActionableDynamicQuery = newsletterArticleLocalService
				.getIndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setCompanyId(companyId);

		indexableActionableDynamicQuery.setPerformActionMethod((NewsletterArticle newsletterArticle) -> {
			try {
				indexableActionableDynamicQuery.addDocuments(getDocument(newsletterArticle));
			} catch (PortalException portalException) {
				if (_log.isWarnEnabled()) {
					_log.warn("Unable to index newsletter article " + newsletterArticle.getNewsletterArticleId(),
							portalException);
				}
			}
		});

		indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());
		indexableActionableDynamicQuery.performActions();
	}

	private static final Log _log = LogFactoryUtil.getLog(NewsletterArticleIndexer.class);

	@Reference
	NewsletterArticleLocalService newsletterArticleLocalService;

	@Reference
	protected IndexWriterHelper indexWriterHelper;
}
