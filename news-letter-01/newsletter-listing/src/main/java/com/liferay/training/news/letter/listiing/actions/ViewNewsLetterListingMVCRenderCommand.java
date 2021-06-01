package com.liferay.training.news.letter.listiing.actions;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.training.news.letter.listiing.constants.MVCCommandNames;
import com.liferay.training.news.letter.listiing.constants.NewsletterListingPortletKeys;
import com.liferay.training.news.letter.listiing.util.NewsLetterListingUtil;
import com.liferay.training.news.letter.model.NewsLetter;

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
		service = MVCRenderCommand.class)
public class ViewNewsLetterListingMVCRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		List<NewsLetter> newsLetters = newsLetterListingUtil.getNewsLetter();

		renderRequest.setAttribute("formaterByYear", newsLetterListingUtil.formatDateTimes("yyyy"));
		renderRequest.setAttribute("formaterByMonth", newsLetterListingUtil.formatDateTimes("MMMM"));
		renderRequest.setAttribute("formater", newsLetterListingUtil.formatDateTimes("MMMM dd yyyy"));

		renderRequest.setAttribute("years", newsLetterListingUtil.getYearsFromNewsLetter(newsLetters));
		renderRequest.setAttribute("months", newsLetterListingUtil.getMonthsFromNewsLetter(newsLetters));
		renderRequest.setAttribute("dates", newsLetterListingUtil.getDateTimesFromNewsLetter(newsLetters));

		renderRequest.setAttribute("newsletters", newsLetters);
		renderRequest.setAttribute("newsletter_articles", newsLetterListingUtil.getNewsLetterArticles());
		renderRequest.setAttribute("articles", newsLetterListingUtil.getArticles());
		renderRequest.setAttribute("newsLetterListingUtil", newsLetterListingUtil);
		return "/view.jsp";
	}
	
	@Reference
	NewsLetterListingUtil newsLetterListingUtil;
}
