package com.liferay.training.news.letter.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.training.news.letter.model.NewsLetter;
import com.liferay.training.news.letter.service.base.NewsLetterLocalServiceBaseImpl;
import com.liferay.training.news.letter.validator.NewsLetterValidation;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	property = "model.class.name=com.liferay.training.news.letter.model.NewsLetter",
	service = AopService.class
)
public class NewsLetterLocalServiceImpl extends NewsLetterLocalServiceBaseImpl {

	public NewsLetter addNewsLetter(long groupId, int issueNumber, String title, String description,
			ServiceContext serviceContext) throws PortalException {

		Group group = groupLocalService.getGroup(groupId);

		long userId = serviceContext.getUserId();

		User user = userLocalService.getUser(userId);

		long newsletterId = counterLocalService.increment(NewsLetter.class.getName());

		newsLetterValidation.validate(newsletterId, issueNumber, title, description, getNewsLetters());

		NewsLetter newsLetter = createNewsLetter(newsletterId);

		newsLetter.setUserId(userId);
		newsLetter.setUserName(user.getFullName());
		newsLetter.setCompanyId(group.getCompanyId());
		newsLetter.setGroupId(groupId);
		newsLetter.setDescription(description);
		newsLetter.setTitle(title);
		newsLetter.setIssueNumber(issueNumber);
		newsLetter.setCreateDate(serviceContext.getCreateDate(new Date()));
		newsLetter.setIssueDate(serviceContext.getModifiedDate(new Date()));

		return super.addNewsLetter(newsLetter);
	}
	
	public List<NewsLetter> getNewsLetters(){ 
		return newsLetterPersistence.findAll();
	}
	
	public NewsLetter updateNewsLetter(long newsletterId, int issueNumber, String title, String description, 
			ServiceContext serviceContext) throws PortalException {

		NewsLetter newsLetter = getNewsLetter(newsletterId);

		newsLetterValidation.validate(newsletterId, issueNumber, title, description, getNewsLetters());

		newsLetter.setDescription(description);
		newsLetter.setTitle(title);
		newsLetter.setIssueNumber(issueNumber);
		newsLetter.setIssueDate(serviceContext.getModifiedDate(new Date()));

		return super.updateNewsLetter(newsLetter);
	}
	
	@Override
	public NewsLetter updateNewsLetter(NewsLetter newsLetter) {

		throw new UnsupportedOperationException("Not supported.");
	}

	@Override
	public NewsLetter addNewsLetter(NewsLetter newsLetter) {
		
		throw new UnsupportedOperationException("Not supported.");
	}

	@Reference
	NewsLetterValidation newsLetterValidation;
}