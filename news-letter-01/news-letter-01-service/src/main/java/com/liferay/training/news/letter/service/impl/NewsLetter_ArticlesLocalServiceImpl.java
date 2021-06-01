package com.liferay.training.news.letter.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.training.news.letter.model.NewsLetter_Articles;
import com.liferay.training.news.letter.service.base.NewsLetter_ArticlesLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(
	property = "model.class.name=com.liferay.training.news.letter.model.NewsLetter_Articles",
	service = AopService.class
)
public class NewsLetter_ArticlesLocalServiceImpl
	extends NewsLetter_ArticlesLocalServiceBaseImpl {

	public NewsLetter_Articles addNewsLetter_Articles(long newsletterId, long articlesId, ServiceContext serviceContext) throws PortalException {

		long userId = serviceContext.getUserId();

		User user = userLocalService.getUser(userId);

		long newsletter_articles_Id = counterLocalService.increment(NewsLetter_Articles.class.getName());

		NewsLetter_Articles newsLetter_Articles = createNewsLetter_Articles(newsletter_articles_Id);
		
		newsLetter_Articles.setUserId(userId);
		newsLetter_Articles.setUserName(user.getFullName());
		newsLetter_Articles.setCompanyId(serviceContext.getCompanyId());
		newsLetter_Articles.setArticlesId(articlesId);
		newsLetter_Articles.setNewsletterId(newsletterId);
		newsLetter_Articles.setCreateDate(serviceContext.getCreateDate(new Date()));
		newsLetter_Articles.setIssueDate(serviceContext.getModifiedDate(new Date()));
		
		return super.addNewsLetter_Articles(newsLetter_Articles);
	}
	
	public List<NewsLetter_Articles> getNewsLetter_Articles(){
		return newsLetter_ArticlesPersistence.findAll();
	}
	
	public NewsLetter_Articles updateNewsLetter_Articles(long newsletter_articles_Id, long newsletterId,
			long articlesId, ServiceContext serviceContext) throws PortalException {

		NewsLetter_Articles newsLetter_Articles = getNewsLetter_Articles(newsletter_articles_Id);

		newsLetter_Articles.setArticlesId(articlesId);
		newsLetter_Articles.setNewsletterId(newsletterId);
		newsLetter_Articles.setIssueDate(serviceContext.getModifiedDate(new Date()));

		return super.addNewsLetter_Articles(newsLetter_Articles);
	}
	
	@Override
	public NewsLetter_Articles addNewsLetter_Articles(NewsLetter_Articles newsLetter_Articles) {

		throw new UnsupportedOperationException("Not supported.");
	}
	
	@Override
	public NewsLetter_Articles updateNewsLetter_Articles(NewsLetter_Articles newsLetter_Articles) {

		throw new UnsupportedOperationException("Not supported.");
	}
}