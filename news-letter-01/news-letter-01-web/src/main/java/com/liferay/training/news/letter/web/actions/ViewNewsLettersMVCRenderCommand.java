package com.liferay.training.news.letter.web.actions;

import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.training.news.letter.model.NewsLetter;
import com.liferay.training.news.letter.service.NewsLetterService;
import com.liferay.training.news.letter.web.constants.MVCCommandNames;
import com.liferay.training.news.letter.web.constants.NewsLetter01WebPortletKeys;
import com.liferay.training.news.letter.web.display.context.NewsLettersManagementToolbarDisplayContext;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true, 
	property = { 
		"javax.portlet.name=" + NewsLetter01WebPortletKeys.NEWSLETTER01WEB,
		"mvc.command.name=/",
		"mvc.command.name=" + MVCCommandNames.VIEW_NEWSLETTERS }, 
	service = MVCRenderCommand.class)
public class ViewNewsLettersMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		_addNewsLettersListAttributes(renderRequest);

		_addManagementToolbarAttributes(renderRequest, renderResponse);

		return "/view.jsp";
	}

	private void _addNewsLettersListAttributes(RenderRequest renderRequest) {

		List<NewsLetter> newsLetters = _newsLetterService.getNewsLetters();

		renderRequest.setAttribute("newsLetters", newsLetters);

	}

	private void _addManagementToolbarAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {

		LiferayPortletRequest liferayPortletRequest = _portal.getLiferayPortletRequest(renderRequest);

		LiferayPortletResponse liferayPortletResponse = _portal.getLiferayPortletResponse(renderResponse);

		NewsLettersManagementToolbarDisplayContext newsLettersManagementToolbarDisplayContext = new NewsLettersManagementToolbarDisplayContext(liferayPortletRequest, liferayPortletResponse, _portal.getHttpServletRequest(renderRequest));
		
		renderRequest.setAttribute("newsLettersManagementToolbarDisplayContext", newsLettersManagementToolbarDisplayContext);

	}

	@Reference
	private NewsLetterService _newsLetterService;

	@Reference
	private Portal _portal;
}
