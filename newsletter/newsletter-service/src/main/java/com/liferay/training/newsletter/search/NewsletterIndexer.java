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
import com.liferay.training.newsletter.model.Newsletter;
import com.liferay.training.newsletter.service.NewsletterLocalService;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = Indexer.class)
public class NewsletterIndexer extends BaseIndexer<Newsletter> {

	public NewsletterIndexer() {

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

		return Newsletter.class.getName();
	}

	@Override
	public void postProcessSearchQuery(BooleanQuery searchQuery, BooleanFilter fullQueryBooleanFilter,
			SearchContext searchContext) throws Exception {

		addSearchLocalizedTerm(searchQuery, searchContext, Field.TITLE, false);
		addSearchLocalizedTerm(searchQuery, searchContext, Field.DESCRIPTION, false);
	}

	@Override
	protected void doDelete(Newsletter newsletter) throws Exception {

		deleteDocument(newsletter.getCompanyId(), newsletter.getNewsletterId());
	}

	@Override
	protected Document doGetDocument(Newsletter newsletter) throws Exception {

		Document document = getBaseModelDocument(Newsletter.class.getName(), newsletter);

		document.addKeyword(Field.COMPANY_ID, newsletter.getCompanyId());
		document.addKeyword(Field.GROUP_ID, newsletter.getGroupId());
		document.addKeyword(Field.SCOPE_GROUP_ID, newsletter.getGroupId());
		document.addKeyword(Field.TITLE, newsletter.getTitle());
		document.addKeyword(Field.DESCRIPTION, newsletter.getDescription());

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

		Newsletter newsletter = newsletterLocalService.getByResourcePrimKey(classPK);
		doReindex(newsletter);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {

		long companyId = GetterUtil.getLong(ids[0]);
		reindexNewsletters(companyId);

	}

	@Override
	protected void doReindex(Newsletter newsletter) throws Exception {

		Document document = getDocument(newsletter);
		indexWriterHelper.updateDocument(getSearchEngineId(), newsletter.getCompanyId(), document,
				isCommitImmediately());

	}

	protected void reindexNewsletters(long companyId) throws PortalException {

		final IndexableActionableDynamicQuery indexableActionableDynamicQuery = newsletterLocalService
				.getIndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setCompanyId(companyId);

		indexableActionableDynamicQuery.setPerformActionMethod((Newsletter Newsletter) -> {
			try {
				indexableActionableDynamicQuery.addDocuments(getDocument(Newsletter));
			} catch (PortalException portalException) {
				if (_log.isWarnEnabled()) {
					_log.warn("Unable to index newsletter " + Newsletter.getNewsletterId(), portalException);
				}
			}
		});

		indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());
		indexableActionableDynamicQuery.performActions();
	}

	private static final Log _log = LogFactoryUtil.getLog(NewsletterIndexer.class);

	@Reference
	NewsletterLocalService newsletterLocalService;

	@Reference
	protected IndexWriterHelper indexWriterHelper;
}
