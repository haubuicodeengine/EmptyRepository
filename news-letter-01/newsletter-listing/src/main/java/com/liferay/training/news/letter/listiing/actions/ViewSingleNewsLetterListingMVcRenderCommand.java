package com.liferay.training.news.letter.listiing.actions;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.news.letter.listiing.constants.MVCCommandNames;
import com.liferay.training.news.letter.listiing.constants.NewsletterListingPortletKeys;
import com.liferay.training.news.letter.listiing.util.NewsLetterListingUtil;
import com.liferay.training.news.letter.model.NewsLetter;
import com.liferay.training.news.letter.service.NewsLetterLocalService;
import com.liferay.training.news.letter.service.NewsLetter_ArticlesService;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + NewsletterListingPortletKeys.NEWSLETTERLISTING,
		"mvc.command.name=" + MVCCommandNames.VIEW_NEWSLETTER },
	service = MVCRenderCommand.class)
public class ViewSingleNewsLetterListingMVcRenderCommand implements MVCRenderCommand
{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long newsletterId = ParamUtil.getLong(renderRequest, "newsletterId");

		try {
			NewsLetter newsLetter = newsLetterLocalService.getNewsLetter(newsletterId);

			renderRequest.setAttribute("newsletter", newsLetter);
			renderRequest.setAttribute("newsletter_articles",
					newsLetter_ArticlesService.getNewsLetter_ArticlesByNewsletterId(newsletterId));
			renderRequest.setAttribute("articles", newsLetterListingUtil.getArticles());

			renderRequest.setAttribute("formater", newsLetterListingUtil.formatDateTimes("MMMM dd yyyy"));

			// Set back icon visible.

			PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

			String redirect = renderRequest.getParameter("redirect");

			portletDisplay.setShowBackIcon(true);
			portletDisplay.setURLBack(redirect);

			return "/newsletter/view_detail.jsp";

		} catch (PortalException pe) {
			throw new PortletException(pe);
		}

	}
		
	@Reference
	NewsLetterListingUtil newsLetterListingUtil;
	
	@Reference
	NewsLetterLocalService newsLetterLocalService;

	@Reference
	NewsLetter_ArticlesService newsLetter_ArticlesService;
}
