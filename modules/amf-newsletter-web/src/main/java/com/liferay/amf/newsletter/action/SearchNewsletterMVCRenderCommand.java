package com.liferay.amf.newsletter.action;

import com.liferay.amf.newsletter.constants.AmfNewsletterPortletKeys;
import com.liferay.amf.newsletter.constants.MVCCommandNames;
import com.liferay.amf.newsletter.service.NewsletterLocalService;
import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Component(immediate = true, property = {"javax.portlet.name=" + AmfNewsletterPortletKeys.AMFNEWSLETTER,
        "mvc.command.name=" + MVCCommandNames.SEARCH}, service = MVCRenderCommand.class)
public class SearchNewsletterMVCRenderCommand implements MVCRenderCommand {
    private static final Log _log = LogFactoryUtil.getLog(SearchNewsletterMVCRenderCommand.class);

    @Reference
    private NewsletterLocalService _newsletterLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        String keywords = ParamUtil.getString(renderRequest, "keywords");

        HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);

        SearchContext searchContext = SearchContextFactory.getInstance(httpServletRequest);

        Indexer<JournalArticle> indexer = IndexerRegistryUtil.getIndexer(JournalArticle.class);

        searchContext.setKeywords(keywords);

        searchContext.setAttribute("paginationType", "more");

        searchContext.setStart(0);

        searchContext.setEnd(10);

        List<JournalArticle> issues = new ArrayList<>();

        try {
            Hits hits = indexer.search(searchContext);

            List<Document> docs = hits.toList();

            docs.forEach(document -> {
                long groupId = GetterUtil.getLong(document
                        .get(Field.GROUP_ID));

                String articleId = GetterUtil.getString(document
                        .get(Field.ARTICLE_ID));

                JournalArticle issue = _newsletterLocalService.getIssueSearch(groupId, articleId);

                if (issue != null) {
                    issues.add(issue);
                }
            });

            renderRequest.setAttribute("issues", issues);

            renderRequest.setAttribute("keywords", keywords);

        } catch (SearchException e) {
            _log.error(e);
        }

        return "/searchResult.jsp";
    }
}
