package com.liferay.training.newsletter.listing.actions;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.newsletter.listing.constants.MVCCommandNames;
import com.liferay.training.newsletter.listing.constants.NewsletterListingPortletKeys;
import com.liferay.training.newsletter.listing.util.NewsLetterListingUtil;
import com.liferay.training.newsletter.model.Newsletter;
import com.liferay.training.newsletter.service.NewsletterArticleService;
import com.liferay.training.newsletter.service.NewsletterService;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + NewsletterListingPortletKeys.NEWSLETTERLISTING,
		"mvc.command.name=" + MVCCommandNames.VIEW_NEWSLETTER_ARTICLES },
	service = MVCRenderCommand.class)
public class NewsletterArticleMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		int issueNumber = ParamUtil.getInteger(renderRequest, "issueNumber");

	    Newsletter newsletter = newsletterService.getNewsletterByIssueNumber(issueNumber);

		renderRequest.setAttribute("newsletter", newsletter);
		renderRequest.setAttribute("articles", newsletterArticleService.getNewsletterArticleByIssueNumber(issueNumber));		

		renderRequest.setAttribute("formater", newsLetterListingUtil.formatDateTimes("MMMM dd yyyy"));		

		// Set back icon visible.

		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

		String redirect = renderRequest.getParameter("redirect");

		portletDisplay.setShowBackIcon(true);
		portletDisplay.setURLBack(redirect);

		return "/newsletter/view_detail.jsp";

	}

	@Reference
	NewsLetterListingUtil newsLetterListingUtil;

	@Reference
	NewsletterService newsletterService;

	@Reference
	NewsletterArticleService newsletterArticleService;
}
