package com.liferay.training.news.letter.web.actions;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.news.letter.model.NewsLetter_Articles;
import com.liferay.training.news.letter.service.NewsLetterService;
import com.liferay.training.news.letter.service.NewsLetter_ArticlesService;
import com.liferay.training.news.letter.web.constants.MVCCommandNames;
import com.liferay.training.news.letter.web.constants.NewsLetter01WebPortletKeys;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true, 
	property = { 
		"javax.portlet.name=" + NewsLetter01WebPortletKeys.NEWSLETTER01WEB,
		"mvc.command.name=" + MVCCommandNames.DELETE_NEWSLETTER }, 
	service = MVCActionCommand.class)
public class DeleteNewsLetterMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		long newsletterId = ParamUtil.getLong(actionRequest, "newsletterId");

		_deleteRelated(newsletterId);
		_newLetterService.deleteNewsLetter(newsletterId);

	}

	private void _deleteRelated(long newsletterId) throws Exception {
		List<NewsLetter_Articles> newsLetter_Articles = _newsLetter_ArticlesService
				.getNewsLetter_ArticlesByNewsletterId(newsletterId);

		for (NewsLetter_Articles item : newsLetter_Articles) {
			_newsLetter_ArticlesService.deleteNewsLetter_Articles(item.getNewsletter_articles_Id());
		}
	}

	@Reference
	private NewsLetterService _newLetterService;

	@Reference
	private NewsLetter_ArticlesService _newsLetter_ArticlesService;
}
