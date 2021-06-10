package com.liferay.training.listener.event.impl;

import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.training.newsletter.service.NewsletterArticleLocalService;
import com.liferay.training.newsletter.service.NewsletterLocalService;
import com.liferay.training.newsletter.utils.NewsletterCommandNames;
import com.liferay.training.newsletter.utils.ReadDataWithStructureUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = ModelListener.class)
public class NewsletterAfterCreateListenerEvent extends BaseModelListener<JournalArticle> {

	@Override
	public void onAfterCreate(JournalArticle journalArticle) throws ModelListenerException {

		DDMStructure structure;
		Map<String, Object> attributes;

		long resourcePrimkey = journalArticle.getResourcePrimKey();

		try {

			if (!journalArticle.getDDMStructureKey().equals(NewsletterCommandNames.BASIC_WEB_CONTENT)) {

				structure = newsletterListenerEventUtil.getDDMStructure(journalArticle);
				attributes = newsletterListenerEventUtil.getFileds(structure, journalArticle);

				String currentNameValue = structure.getNameCurrentValue();
				switch (currentNameValue) {
					case NewsletterCommandNames.NEWSLETTERS:

						if (newsletterLocalService.getCountNewsletterByResourcePrimkey(resourcePrimkey) <= 0) {

							_addNewsletters(attributes, journalArticle.getGroupId(), resourcePrimkey);
						}
						break;
					case NewsletterCommandNames.NEWSLETTER_ARTICLES:

						if (newsletterArticleLocalService
								.getCountNewsletterArticlesByResourcePrimkey(resourcePrimkey) <= 0) {

							_addNewsletterArticles(attributes, journalArticle.getUserId(), journalArticle.getGroupId(),
									resourcePrimkey);
						}
						break;
					default: break;
				}
			}
		} catch (PortalException e) {

			if (_log.isInfoEnabled()) {
				_log.info(e.getMessage());
			}
		}

		super.onAfterCreate(journalArticle);
	}

	private void _addNewsletters(Map<String, Object> attributes, long groupId, long resourcePrimKey)
			throws PortalException {

		int issueNumber = (int) attributes.get("issueNumber");

		String title = (String) attributes.get("title");

		String description = (String) attributes.get("description");

		String stringIssueDate = (String) attributes.get("issueDate");

		Date issueDate = null;

		try {
			issueDate = new SimpleDateFormat("yyyy-MM-dd").parse(stringIssueDate);
		} catch (Exception e) {

			if (_log.isInfoEnabled()) {
				_log.info(e.getMessage());
			}
		}

		newsletterLocalService.addNewsletter(resourcePrimKey, issueNumber, title, description, issueDate, groupId);
	}

	private void _addNewsletterArticles(Map<String, Object> attributes, long userId, long groupId, long resourcePrimKey)
			throws PortalException {

		int issueNumber = (int) attributes.get("issueNumber");

		String title = (String) attributes.get("title");

		String content = (String) attributes.get("content");

		newsletterArticleLocalService.addNewsletterArticle(resourcePrimKey, issueNumber, title, content, userId,
				groupId);
	}

	@Reference
	NewsletterLocalService newsletterLocalService;

	@Reference
	NewsletterArticleLocalService newsletterArticleLocalService;

	@Reference
	ReadDataWithStructureUtil newsletterListenerEventUtil;

	private static final Log _log = LogFactoryUtil.getLog(NewsletterAfterCreateListenerEvent.class);
}
