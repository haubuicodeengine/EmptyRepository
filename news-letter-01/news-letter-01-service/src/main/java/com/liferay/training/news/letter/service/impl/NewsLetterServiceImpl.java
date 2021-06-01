package com.liferay.training.news.letter.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.training.news.letter.model.NewsLetter;
import com.liferay.training.news.letter.service.base.NewsLetterServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(
	property = {
		"json.web.service.context.name=newsletter",
		"json.web.service.context.path=NewsLetter" },
	service = AopService.class)
public class NewsLetterServiceImpl extends NewsLetterServiceBaseImpl {

	public NewsLetter addNewsLetter(long groupId, int issueNumber, String title, String description,
			ServiceContext serviceContext) throws PortalException {

		return newsLetterLocalService.addNewsLetter(groupId, issueNumber, title, description, serviceContext);
	}

	public NewsLetter deleteNewsLetter(long newsletterId) throws PortalException {

		NewsLetter newsLetter = newsLetterLocalService.getNewsLetter(newsletterId);

		return newsLetterLocalService.deleteNewsLetter(newsLetter);
	}

	public NewsLetter getNewsLetter(long newsletterId) throws PortalException {
		return newsLetterLocalService.getNewsLetter(newsletterId);
	}

	public NewsLetter getNewsLetterByIssueNumber(int issueNumber) throws PortalException {

		List<NewsLetter> newsletters = getNewsLetters();
		for (NewsLetter newsletter : newsletters) {
			if (newsletter.getIssueNumber() == issueNumber) {
				return newsletter;
			}
		}
		return null;
	}

	public NewsLetter updateNewsLetter(long newsletterId, int issueNumber, String title, String description,
			ServiceContext serviceContext) throws PortalException {

		return newsLetterLocalService.updateNewsLetter(newsletterId, issueNumber, title, description, serviceContext);
	}

	public List<NewsLetter> getNewsLetters() {

		return newsLetterLocalService.getNewsLetters();
	}

}