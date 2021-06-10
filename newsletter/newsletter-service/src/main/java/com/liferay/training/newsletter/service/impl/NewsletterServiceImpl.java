package com.liferay.training.newsletter.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.training.newsletter.model.Newsletter;
import com.liferay.training.newsletter.service.base.NewsletterServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(
	property = { 
		"json.web.service.context.name=newsletter",
		"json.web.service.context.path=Newsletter" },
	service = AopService.class)
public class NewsletterServiceImpl extends NewsletterServiceBaseImpl {

	public Newsletter addNewsletter(long resourcePrimKey, int issueNumber, String title, String description, Date issueDate)
			throws PortalException {

		return newsletterLocalService.addNewsletter(resourcePrimKey, issueNumber, title, description, issueDate);
	}
	
	public void updateNewsletterStatus(long resourcePrimKey) throws PortalException {
		
		newsletterLocalService.updateNewsletterStatus(resourcePrimKey);
	}

	public Newsletter getNewsletterByIssueNumber(int issueNumber) {

		List<Newsletter> newsletters = newsletterLocalService.getNewsletters();
		
		for (Newsletter newsletter : newsletters) {
			if (newsletter.getIssueNumber() == issueNumber) {
				return newsletter;
			}
		}

		return null;
	}
	
	public Newsletter getNewsletterByResourcePrimKey(long resourcePrimKey) {

		List<Newsletter> newsletters = newsletterLocalService.getNewsletters();

		for (Newsletter newsletter : newsletters) {
			if (newsletter.getResourcePrimKey() == resourcePrimKey) {
				return newsletter;
			}
		}

		return null;
	}
	
	public Newsletter updateNewsletter(long newsletterId, int issueNumber, String title, String description,
			Date issueDate) throws PortalException {

		return newsletterLocalService.updateNewsletter(newsletterId, issueNumber, title, description, issueDate);
	}
}