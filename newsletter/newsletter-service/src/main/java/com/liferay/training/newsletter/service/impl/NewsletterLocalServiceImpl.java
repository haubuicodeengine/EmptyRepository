package com.liferay.training.newsletter.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.training.newsletter.model.Newsletter;
import com.liferay.training.newsletter.service.base.NewsletterLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(
	property = "model.class.name=com.liferay.training.newsletter.model.Newsletter", 
	service = AopService.class
)
public class NewsletterLocalServiceImpl extends NewsletterLocalServiceBaseImpl {

	public Newsletter addNewsletter(long resourcePrimKey, int issueNumber, String title, String description,
			Date issueDate) throws PortalException {

		long newsletterId = counterLocalService.increment(Newsletter.class.getName());

		Newsletter newsletter = createNewsletter(newsletterId);

		newsletter.setDescription(description);
		newsletter.setTitle(title);
		newsletter.setIssueDate(issueDate);
		newsletter.setIssueNumber(issueNumber);
		newsletter.setResourcePrimKey(resourcePrimKey);
		newsletter.setStatus(0);

		return super.addNewsletter(newsletter);
	}

	public int getCountNewsletterByResourcePrimkey(long resourcePrimkey) {

		return newsletterPersistence.countByResourcePrimKey(resourcePrimkey);
	}

	public List<Newsletter> getNewsletters() {

		return newsletterPersistence.findAll();
	}

	public void updateNewsletterStatus(long resourcePrimkey) throws PortalException {

		List<Newsletter> newsletters = newsletterPersistence.findByResourcePrimKey(resourcePrimkey);

		for (Newsletter newsletter : newsletters) {
			updateNewsletter(newsletter.getNewsletterId());
		}
	}

	public Newsletter updateNewsletter(long newsletterId) throws PortalException {

		Newsletter newsletter = getNewsletter(newsletterId);

		newsletter.setStatus(WorkflowConstants.STATUS_IN_TRASH);

		return super.updateNewsletter(newsletter);
	}

	public Newsletter updateNewsletter(long newsletterId, int issueNumber, String title, String description,
			Date issueDate) throws PortalException {

		Newsletter newsletter = getNewsletter(newsletterId);

		newsletter.setDescription(description);
		newsletter.setTitle(title);
		newsletter.setIssueNumber(issueNumber);
		newsletter.setIssueDate(issueDate);

		return super.updateNewsletter(newsletter);
	}

	@Override
	public Newsletter addNewsletter(Newsletter newsletter) {

		throw new UnsupportedOperationException("Not supported.");
	}

	@Override
	public Newsletter updateNewsletter(Newsletter newsletter) {

		throw new UnsupportedOperationException("Not supported.");
	}
}