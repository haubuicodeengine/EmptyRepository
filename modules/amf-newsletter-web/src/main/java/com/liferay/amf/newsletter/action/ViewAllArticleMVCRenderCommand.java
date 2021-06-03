package com.liferay.amf.newsletter.action;

import com.liferay.amf.newsletter.Util.NewsletterUtil;
import com.liferay.amf.newsletter.constants.AmfNewsletterPortletKeys;
import com.liferay.amf.newsletter.listener.JournalArticleListener;
import com.liferay.amf.newsletter.model.Article;
import com.liferay.amf.newsletter.service.ArticleLocalService;
import com.liferay.amf.newsletter.service.NewsletterLocalService;
import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.text.DateFormatSymbols;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component(immediate = true, property = {"javax.portlet.name=" + AmfNewsletterPortletKeys.AMFNEWSLETTER,
        "mvc.command.name=/"}, service = MVCRenderCommand.class)
public class ViewAllArticleMVCRenderCommand implements MVCRenderCommand {

    private static final Log _log = LogFactoryUtil.getLog(
            JournalArticleListener.class);
    @Reference
    private ArticleLocalService _articleLocalService;
    @Reference
    private NewsletterLocalService _newsletterLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        List<JournalArticle> issues = _newsletterLocalService.getNewsletters();

        renderRequest.setAttribute("arrangedArticles", arrangeArticles(issues));

        return "/view.jsp";
    }

    public Map<String, Map<String, Map<String, List<JournalArticle>>>> arrangeArticles(List<JournalArticle> newsletter) {

        Map<String, Map<String, Map<String, List<JournalArticle>>>> arrangedArticles = new LinkedHashMap<>();

        for (JournalArticle article : newsletter) {

            String date = _newsletterLocalService.getJournalArticleContent(article.getDDMStructure(), article.getContent(), "issueDate");

            String yKey = NewsletterUtil.splitDate(date, 0);

            String strMonth = NewsletterUtil.splitDate(date, 1);

            String mKey = new DateFormatSymbols().getMonths()[Integer.parseInt(strMonth) - 1];

            boolean check = false;

            for (String key : arrangedArticles.keySet()) {
                if (key.equals(yKey)) {

                    check = true;
                }
            }

            if (!check) {
                arrangedArticles.put(yKey, new HashMap<>());

                arrangedArticles.get(yKey).put(mKey, new HashMap<>());

            } else {
                arrangedArticles.get(yKey).put(mKey, new HashMap<>());

            }
        }

        for (JournalArticle article : newsletter) {
            String date = _newsletterLocalService.getJournalArticleContent(article.getDDMStructure(), article.getContent(), "issueDate");

            String yKey = NewsletterUtil.splitDate(date, 0);

            String strMonth = NewsletterUtil.splitDate(date, 1);

            String mKey = new DateFormatSymbols().getMonths()[Integer.parseInt(strMonth) - 1];

            String issueKey = _newsletterLocalService.getJournalArticleContent(article.getDDMStructure(), article.getContent(), "issueNumber");

            List<Article> articles = _articleLocalService.getArticlesByNewsletter(Long.parseLong(issueKey));

            List<JournalArticle> journalArticles = _articleLocalService.getArticles(articles);

            arrangedArticles.get(yKey).get(mKey).put(issueKey, journalArticles);

        }

        return arrangedArticles;
    }
}
