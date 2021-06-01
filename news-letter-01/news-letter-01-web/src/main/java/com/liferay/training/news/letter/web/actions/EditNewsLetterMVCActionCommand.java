package com.liferay.training.news.letter.web.actions;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.news.letter.exception.NewsLetterValidationException;
import com.liferay.training.news.letter.model.NewsLetter;
import com.liferay.training.news.letter.model.NewsLetter_Articles;
import com.liferay.training.news.letter.service.NewsLetterService;
import com.liferay.training.news.letter.service.NewsLetter_ArticlesService;
import com.liferay.training.news.letter.web.constants.MVCCommandNames;
import com.liferay.training.news.letter.web.constants.NewsLetter01WebPortletKeys;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true, 
	property = { 
		"javax.portlet.name=" + NewsLetter01WebPortletKeys.NEWSLETTER01WEB,
		"mvc.command.name=" + MVCCommandNames.EDIT_NEWSLETTER }, 
	service = MVCActionCommand.class)
public class EditNewsLetterMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(NewsLetter.class.getName(), actionRequest);

		long newsletterId = ParamUtil.getLong(actionRequest, "newsletterId");

		int issueNumber = ParamUtil.getInteger(actionRequest, "issueNumber");

		String title = ParamUtil.getString(actionRequest, "title").trim();

		String description = ParamUtil.getString(actionRequest, "description").trim();

		long[] articlesIds = ParamUtil.getLongValues(actionRequest, "articlesIds");
		
		try {

			// Call the service to update a newsletter.

			_newLetterService.updateNewsLetter(newsletterId, issueNumber, title, description, serviceContext);

			_updateNewsLetter_Articles(articlesIds, newsletterId, serviceContext);

			SessionMessages.add(actionRequest, "newsletterUpdated");

			sendRedirect(actionRequest, actionResponse);
		} catch (Exception exception) {
			if (exception instanceof NewsLetterValidationException) {

				SessionErrors.add(actionRequest, exception.getClass());
				actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.EDIT_NEWSLETTER);
			}
		}
	}

	private void _updateNewsLetter_Articles(long[] articlesIds, long newsletterId, ServiceContext serviceContext)
			throws Exception {

		List<Long> listArticlesIds = Arrays.asList(ArrayUtil.toArray(articlesIds));

		List<NewsLetter_Articles> newsLetter_Articles = _newsLetter_ArticlesService
				.getNewsLetter_ArticlesByNewsletterId(newsletterId);
		
		if (listArticlesIds != null) {

			if (newsLetter_Articles.size() != 0) {
				for (NewsLetter_Articles item : newsLetter_Articles) {

					if (!listArticlesIds.contains(item.getArticlesId())) {
						_newsLetter_ArticlesService.deleteNewsLetter_Articles(item.getNewsletter_articles_Id());
					}
				}

				for (Long articlesId : listArticlesIds) {

					if (!listArticlesIdsSelected(newsletterId).contains(articlesId)) {
						_newsLetter_ArticlesService.addNewsLetter_Articles(newsletterId, articlesId, serviceContext);
					}
				}
			} else {

				for (Long articlesId : listArticlesIds) {
					_newsLetter_ArticlesService.addNewsLetter_Articles(newsletterId, articlesId, serviceContext);
				}
			}
		} else {
			for (NewsLetter_Articles item : newsLetter_Articles) {
				_newsLetter_ArticlesService.deleteNewsLetter_Articles(item.getNewsletter_articles_Id());
			}
		}
	}

	private Set<Long> listArticlesIdsSelected(long newsletterId) {
		List<NewsLetter_Articles> newsLetter_Articles = _newsLetter_ArticlesService
				.getNewsLetter_ArticlesByNewsletterId(newsletterId);

		Set<Long> listIds = new LinkedHashSet<Long>();

		for (NewsLetter_Articles item : newsLetter_Articles) {
			listIds.add(item.getArticlesId());
		}

		return listIds;
	}

	@Reference
	private NewsLetterService _newLetterService;

	@Reference
	private NewsLetter_ArticlesService _newsLetter_ArticlesService;
}
