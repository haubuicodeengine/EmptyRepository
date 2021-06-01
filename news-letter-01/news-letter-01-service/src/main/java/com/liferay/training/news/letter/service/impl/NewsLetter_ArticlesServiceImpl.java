package com.liferay.training.news.letter.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.training.news.letter.model.NewsLetter_Articles;
import com.liferay.training.news.letter.service.base.NewsLetter_ArticlesServiceBaseImpl;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(
	property = { 
		"json.web.service.context.name=newsletter",
		"json.web.service.context.path=NewsLetter_Articles" }, 
	service = AopService.class)
public class NewsLetter_ArticlesServiceImpl extends NewsLetter_ArticlesServiceBaseImpl {

	public NewsLetter_Articles addNewsLetter_Articles(long newsletterId, long articlesId, ServiceContext serviceContext)
			throws PortalException {

		return newsLetter_ArticlesLocalService.addNewsLetter_Articles(newsletterId, articlesId, serviceContext);
	}

	public NewsLetter_Articles deleteNewsLetter_Articles(long id) throws PortalException {

		NewsLetter_Articles newsLetter_Articles = newsLetter_ArticlesLocalService.getNewsLetter_Articles(id);

		return newsLetter_ArticlesLocalService.deleteNewsLetter_Articles(newsLetter_Articles);
	}

	public List<NewsLetter_Articles> getNewsLetter_Articles() {
		return newsLetter_ArticlesLocalService.getNewsLetter_Articles();
	}

	public List<NewsLetter_Articles> getNewsLetter_ArticlesByNewsletterId(long newsletterId) {
		List<NewsLetter_Articles> newsLetter_Articles = getNewsLetter_Articles();

		List<NewsLetter_Articles> newsLetter_Articles2 = new ArrayList<NewsLetter_Articles>();
		for (NewsLetter_Articles newsArticles : newsLetter_Articles) {
			if (newsArticles.getNewsletterId() == newsletterId) {
				newsLetter_Articles2.add(newsArticles);
			}
		}
		return newsLetter_Articles2;
	}

	public NewsLetter_Articles updateNewsLetter_Articles(long newsletter_articles_Id, long newsletterId,
			long articlesId, ServiceContext serviceContext) throws PortalException {

		return newsLetter_ArticlesLocalService.updateNewsLetter_Articles(newsletter_articles_Id, newsletterId,
				articlesId, serviceContext);

	}
}