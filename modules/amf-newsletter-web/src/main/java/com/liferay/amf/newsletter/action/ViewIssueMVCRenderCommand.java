package com.liferay.amf.newsletter.action;

import com.liferay.amf.newsletter.constants.AmfNewsletterPortletKeys;
import com.liferay.amf.newsletter.constants.MVCCommandNames;
import com.liferay.amf.newsletter.model.Article;
import com.liferay.amf.newsletter.service.ArticleLocalService;
import com.liferay.amf.newsletter.service.NewsletterLocalService;
import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

@Component(immediate = true, property = {"javax.portlet.name=" + AmfNewsletterPortletKeys.AMFNEWSLETTER,
        "mvc.command.name=" + MVCCommandNames.VIEW_ISSUE}, service = MVCRenderCommand.class)
public class ViewIssueMVCRenderCommand implements MVCRenderCommand {

    @Reference
    private ArticleLocalService _articleLocalService;
    @Reference
    private NewsletterLocalService _newsletterLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        long issueNumber = Long.parseLong(renderRequest.getParameter("issueId"));

        JournalArticle issue = _newsletterLocalService.getNewsletterByIssueNumber(issueNumber);

        List<Article> articles = _articleLocalService.getArticlesByNewsletter(issueNumber);

        List<JournalArticle> issueArticles = _articleLocalService.getArticles(articles);

        renderRequest.setAttribute("issue", issue);

        renderRequest.setAttribute("issueArticles", issueArticles);

        return "/viewIssue.jsp";
    }
}
