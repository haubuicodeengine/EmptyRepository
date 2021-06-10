package com.liferay.training.newsletter.listing.actions;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.training.newsletter.listing.constants.MVCCommandNames;
import com.liferay.training.newsletter.listing.constants.NewsletterListingPortletKeys;
import com.liferay.training.newsletter.listing.util.NewsLetterListingUtil;
import com.liferay.training.newsletter.model.Newsletter;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true, 
	property = { 
		"javax.portlet.name=" + NewsletterListingPortletKeys.NEWSLETTERLISTING,
		"mvc.command.name=/",
		"mvc.command.name=" + MVCCommandNames.VIEW_NEWSLETTERS }, 
	service = MVCRenderCommand.class
)
public class NewslettersMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		List<Newsletter> newsletters = newsLetterListingUtil.getNewsletters();

		renderRequest.setAttribute("formaterByYear", newsLetterListingUtil.formatDateTimes("yyyy"));
		renderRequest.setAttribute("formaterByMonth", newsLetterListingUtil.formatDateTimes("MMMM"));
		renderRequest.setAttribute("formater", newsLetterListingUtil.formatDateTimes("MMMM dd yyyy"));

		renderRequest.setAttribute("years", newsLetterListingUtil.getYearsFromNewsLetter(newsletters));
		renderRequest.setAttribute("months", newsLetterListingUtil.getMonthsFromNewsLetter(newsletters));
		renderRequest.setAttribute("dates", newsLetterListingUtil.getDateTimesFromNewsLetter(newsletters));

		renderRequest.setAttribute("newsletters", newsletters);
		renderRequest.setAttribute("articles", newsLetterListingUtil.getNewsletterArticles());
		renderRequest.setAttribute("newsLetterListingUtil", newsLetterListingUtil);

		return "/view.jsp";
	}

	@Reference
	NewsLetterListingUtil newsLetterListingUtil;
}