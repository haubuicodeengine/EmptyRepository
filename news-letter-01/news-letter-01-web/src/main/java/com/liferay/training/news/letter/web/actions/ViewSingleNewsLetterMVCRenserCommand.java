package com.liferay.training.news.letter.web.actions;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.news.letter.model.NewsLetter;
import com.liferay.training.news.letter.service.NewsLetterService;
import com.liferay.training.news.letter.web.constants.MVCCommandNames;
import com.liferay.training.news.letter.web.constants.NewsLetter01WebPortletKeys;

import java.text.DateFormat;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + NewsLetter01WebPortletKeys.NEWSLETTER01WEB,
		"mvc.command.name=" + MVCCommandNames.VIEW_NEWSLETTER },
	service = MVCRenderCommand.class)
public class ViewSingleNewsLetterMVCRenserCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long newsletterId = ParamUtil.getLong(renderRequest, "newsletterId");

		try {

			// Call the service to get the course.

			NewsLetter newsletter = _newsLetterService.getNewsLetter(newsletterId);

			DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat("EEEEE, MMMMM dd, yyyy",
					renderRequest.getLocale());

			renderRequest.setAttribute("newsletter", newsletter);
			renderRequest.setAttribute("createDate", dateFormat.format(newsletter.getCreateDate()));

			// Set back icon visible.

			PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

			String redirect = renderRequest.getParameter("redirect");

			portletDisplay.setShowBackIcon(true);
			portletDisplay.setURLBack("/");

			return "/newsletter/view_newsletter.jsp";

		} catch (PortalException pe) {
			throw new PortletException(pe);
		}
	}
	
	@Reference
	private NewsLetterService _newsLetterService;

}
