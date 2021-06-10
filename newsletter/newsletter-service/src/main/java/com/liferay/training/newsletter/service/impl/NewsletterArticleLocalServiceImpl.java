package com.liferay.training.newsletter.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.training.newsletter.model.NewsletterArticle;
import com.liferay.training.newsletter.service.base.NewsletterArticleLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(
	property = "model.class.name=com.liferay.training.newsletter.model.NewsletterArticle", 
	service = AopService.class
)
public class NewsletterArticleLocalServiceImpl extends NewsletterArticleLocalServiceBaseImpl {

	public NewsletterArticle addNewsletterArticle(long resourcePrimKey, int issueNumber, String title, String content,
			long userId, long groupId) throws PortalException {

		User user = userLocalService.getUser(userId);

		long newsletterArticleId = counterLocalService.increment(NewsletterArticle.class.getName());

		NewsletterArticle newsletterArticle = createNewsletterArticle(newsletterArticleId);

		newsletterArticle.setUserId(userId);
		newsletterArticle.setAuthor(user.getFullName());
		newsletterArticle.setIssueNumber(issueNumber);
		newsletterArticle.setTitle(title);
		newsletterArticle.setContent(content);
		newsletterArticle.setResourcePrimKey(resourcePrimKey);
		newsletterArticle.setStatus(0);
		newsletterArticle.setGroupId(groupId);

		return super.addNewsletterArticle(newsletterArticle);
	}

	public List<NewsletterArticle> getNewsletterArticles() {

		return newsletterArticlePersistence.findAll();
	}

	public NewsletterArticle getByResourcePrimKey(long resourcePrimKey) {

		List<NewsletterArticle> newsletterArticles = getNewsletterArticles();

		for (NewsletterArticle newsletterArticle : newsletterArticles) {
			if (newsletterArticle.getResourcePrimKey() == resourcePrimKey) {
				return newsletterArticle;
			}
		}

		return null;
	}

	public int getCountNewsletterArticlesByResourcePrimkey(long resourcePrimkey) {

		return newsletterArticlePersistence.countByResourcePrimKey(resourcePrimkey);
	}

	public void updateNewsletterArticleStatus(long resourcePrimkey) throws PortalException {

		List<NewsletterArticle> newsletterArticles = newsletterArticlePersistence
				.findByResourcePrimKey(resourcePrimkey);

		for (NewsletterArticle newsletterArticle : newsletterArticles) {
			updateNewsletterArticle(newsletterArticle.getNewsletterArticleId());
		}
	}

	public NewsletterArticle updateNewsletterArticle(long newsletterArticleId) throws PortalException {

		NewsletterArticle newsletterArticle = getNewsletterArticle(newsletterArticleId);

		newsletterArticle.setStatus(WorkflowConstants.STATUS_IN_TRASH);

		return super.updateNewsletterArticle(newsletterArticle);
	}

	public NewsletterArticle updateNewsletterArticle(long newsletterArticleId, int issueNumber, String title,
			String content) throws PortalException {

		NewsletterArticle newsletterArticle = getNewsletterArticle(newsletterArticleId);

		newsletterArticle.setContent(content);
		newsletterArticle.setTitle(title);
		newsletterArticle.setIssueNumber(issueNumber);

		return super.updateNewsletterArticle(newsletterArticle);
	}

	@Override
	public NewsletterArticle addNewsletterArticle(NewsletterArticle newsletterArticle) {

		throw new UnsupportedOperationException("Not supported.");
	}

	@Override
	public NewsletterArticle updateNewsletterArticle(NewsletterArticle newsletterArticle) {

		throw new UnsupportedOperationException("Not supported.");
	}
}