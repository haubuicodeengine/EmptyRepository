package com.liferay.training.listener.event.impl;

import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.training.newsletter.model.Newsletter;
import com.liferay.training.newsletter.model.NewsletterArticle;
import com.liferay.training.newsletter.service.NewsletterArticleService;
import com.liferay.training.newsletter.service.NewsletterService;
import com.liferay.training.newsletter.utils.NewsletterCommandNames;
import com.liferay.training.newsletter.utils.ReadDataWithStructureUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = ModelListener.class)
public class NewsletterAfterUpdateListenerEvent extends BaseModelListener<JournalArticle> {

	@Override
	public void onAfterUpdate(JournalArticle journalArticle) throws ModelListenerException {

		DDMStructure structure;
		Map<String, Object> attributes;

		long resourcePrimKey = journalArticle.getResourcePrimKey();

		try {

			if (!journalArticle.getDDMStructureKey().equals(NewsletterCommandNames.BASIC_WEB_CONTENT)) {

				structure = newsletterListenerEventUtil.getDDMStructure(journalArticle);
				attributes = newsletterListenerEventUtil.getFileds(structure, journalArticle);

				String currentNameValue = structure.getNameCurrentValue();
				switch (currentNameValue) {
					case NewsletterCommandNames.NEWSLETTERS:

						_updateNewsletters(attributes, resourcePrimKey);

						if (journalArticle.getStatus() == WorkflowConstants.STATUS_IN_TRASH) {
							newsletterService.updateNewsletterStatus(resourcePrimKey);
						}
						break;
					case NewsletterCommandNames.NEWSLETTER_ARTICLES:

						_updateNewsletterArticles(attributes, journalArticle.getUserId(), resourcePrimKey);

						if (journalArticle.getStatus() == WorkflowConstants.STATUS_IN_TRASH) {
							newsletterArticleService.updateNewsletterArticleStatus(resourcePrimKey);
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

		super.onAfterUpdate(journalArticle);
	}

	private void _updateNewsletters(Map<String, Object> attributes, long resourcePrimKey) throws PortalException {

		Newsletter newsletter = newsletterService.getNewsletterByResourcePrimKey(resourcePrimKey);

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

		newsletterService.updateNewsletter(newsletter.getNewsletterId(), issueNumber, title, description, issueDate);
	}

	private void _updateNewsletterArticles(Map<String, Object> attributes, long userId, long resourcePrimKey)
			throws PortalException {

		NewsletterArticle newsletterArticle = newsletterArticleService.getNewsletterByResourcePrimKey(resourcePrimKey);

		int issueNumber = (int) attributes.get("issueNumber");

		String title = (String) attributes.get("title");

		String content = (String) attributes.get("content");

		newsletterArticleService.updateNewsletterArticle(newsletterArticle.getNewsletterArticleId(), issueNumber, title,
				content);
	}

	@Reference
	NewsletterService newsletterService;

	@Reference
	NewsletterArticleService newsletterArticleService;

	@Reference
	ReadDataWithStructureUtil newsletterListenerEventUtil;

	private static final Log _log = LogFactoryUtil.getLog(NewsletterAfterUpdateListenerEvent.class);
}
