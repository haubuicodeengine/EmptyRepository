package com.liferay.training.news.letter.web.actions;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.news.letter.model.NewsLetter;
import com.liferay.training.news.letter.model.NewsLetter_Articles;
import com.liferay.training.news.letter.service.NewsLetterService;
import com.liferay.training.news.letter.service.NewsLetter_ArticlesService;
import com.liferay.training.news.letter.web.constants.MVCCommandNames;
import com.liferay.training.news.letter.web.constants.NewsLetter01WebPortletKeys;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true, 
	property = { 
		"javax.portlet.name=" + NewsLetter01WebPortletKeys.NEWSLETTER01WEB,
		"mvc.command.name=" + MVCCommandNames.EDIT_NEWSLETTER },
	service = MVCRenderCommand.class)
public class EditNewsLetterMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		_addNewsLettersListAttributes(renderRequest);

		return "/newsletter/form_add.jsp";
	}
	
	private void _addNewsLettersListAttributes(RenderRequest renderRequest) {

		List<JournalArticle> journalArticles = _journalArticleLocalService.getArticles();

		NewsLetter newsletter = null;
		
		long newsletterId = ParamUtil.getLong(renderRequest, "newsletterId");

		if (newsletterId > 0) {
			try {
				newsletter = _newLetterService.getNewsLetter(newsletterId);

			} catch (PortalException pe) {
				pe.printStackTrace();
			}
		}

		renderRequest.setAttribute("newsletter", newsletter);
		renderRequest.setAttribute("articlesSelected", _getNewsletterArticlesSelected(newsletterId));
		renderRequest.setAttribute("newsletterClass", NewsLetter.class);
		renderRequest.setAttribute("journalArticles", journalArticles);

	}
	
	private Set<Long> _getNewsletterArticlesSelected(long newsletterId){
		
		List<NewsLetter_Articles> newsLetter_Articles = newsLetter_ArticlesService.getNewsLetter_ArticlesByNewsletterId(newsletterId);

		Set<Long> articlesSelected = new LinkedHashSet<Long>();
		
		for(NewsLetter_Articles item : newsLetter_Articles) {
			articlesSelected.add(item.getArticlesId());
		}
		return articlesSelected;
	}

	@Reference
	private NewsLetterService _newLetterService;
	
	@Reference
	private JournalArticleLocalService _journalArticleLocalService;
	
	@Reference
	private NewsLetter_ArticlesService newsLetter_ArticlesService;
}