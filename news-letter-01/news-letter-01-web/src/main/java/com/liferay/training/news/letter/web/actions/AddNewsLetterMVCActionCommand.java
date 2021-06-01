package com.liferay.training.news.letter.web.actions;

import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.news.letter.exception.NewsLetterValidationException;
import com.liferay.training.news.letter.model.NewsLetter;
import com.liferay.training.news.letter.service.NewsLetterService;
import com.liferay.training.news.letter.service.NewsLetter_ArticlesService;
import com.liferay.training.news.letter.web.constants.MVCCommandNames;
import com.liferay.training.news.letter.web.constants.NewsLetter01WebPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + NewsLetter01WebPortletKeys.NEWSLETTER01WEB,
		"mvc.command.name=" + MVCCommandNames.ADD_NEWSLETTER }, service = MVCActionCommand.class)
public class AddNewsLetterMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(NewsLetter.class.getName(), actionRequest);

		Group group = _groupLocalService.getGroup(themeDisplay.getCompanyId(), GroupConstants.GUEST);

		int issueNumber = ParamUtil.getInteger(actionRequest, "issueNumber");

		String title = ParamUtil.getString(actionRequest, "title").trim();

		String description = ParamUtil.getString(actionRequest, "description").trim();

		long[] articlesIds = ParamUtil.getLongValues(actionRequest, "articlesIds");

		try {

			// Call the service to add a a new newsletter.

			_newsLetterService.addNewsLetter(group.getGroupId(), issueNumber, title, description, serviceContext);

			_addNewsLetter_Articles(issueNumber, articlesIds, serviceContext);

			SessionMessages.add(actionRequest, "newsletterAdded");

			sendRedirect(actionRequest, actionResponse);
		} catch (Exception exception) {
			if (exception instanceof NewsLetterValidationException) {

				SessionErrors.add(actionRequest, exception.getClass());
				actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.EDIT_NEWSLETTER);
			}
		}
	}

	private void _addNewsLetter_Articles(int issueNumber, long[] articlesIds, ServiceContext serviceContext)
			throws Exception {

		NewsLetter newsLetter = _newsLetterService.getNewsLetterByIssueNumber(issueNumber);

		for (long articlesId : articlesIds) {
			if (articlesId != 0) {
				newsLetter_ArticlesService.addNewsLetter_Articles(newsLetter.getNewsletterId(), articlesId,
						serviceContext);
			}
		}

	}

	@Reference
	private GroupLocalService _groupLocalService;

	@Reference
	private NewsLetterService _newsLetterService;

	@Reference
	private NewsLetter_ArticlesService newsLetter_ArticlesService;
}
