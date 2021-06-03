<%@ taglib prefix="liferay-frontend" uri="http://liferay.com/tld/frontend" %>
<%@ page import="com.liferay.amf.newsletter.constants.MVCCommandNames" %>
<%@ include file="./init.jsp" %>
<%
    Map<String, Map<String, Map<String, List<JournalArticle>>>> arrangedArticles = (Map<String, Map<String, Map<String, List<JournalArticle>>>>) request.getAttribute("arrangedArticles");

    String tabs = null;
    for (String key : arrangedArticles.keySet()) {
        if (tabs == null) {
            tabs = key + ", ";
        } else {
            tabs = tabs + key + ", ";
        }
    }
%>

<liferay-ui:tabs names="<%= tabs%>" refresh="false" tabsValues="<%= tabs%>">

    <c:forEach var="yKey" begin="0" items="${arrangedArticles.keySet()}">
        <liferay-ui:section>
            <c:forEach var="mKey" begin="0" items="${arrangedArticles.get(yKey).keySet()}">
                <div class="amf-newsletter-web">
                    <div class="newsletter--container">

                        <div class="title-label">
                            <p> ${mKey}</p>
                        </div>

                        <c:forEach var="issueKey" begin="0" items="${arrangedArticles.get(yKey).get(mKey).keySet()}">

                            <portlet:renderURL var="rowURL">
                                <portlet:param name="issueId" value="${issueKey}"/>
                                <portlet:param name="mvcRenderCommandName" value="<%= MVCCommandNames.VIEW_ISSUE %>"/>
                            </portlet:renderURL>
                            <%
                                String issueNumber = String.valueOf(pageContext.getAttribute("issueKey"));

                                long issue = Long.parseLong(issueNumber);

                                JournalArticle aa = NewsletterLocalServiceUtil.getNewsletterByIssueNumber(issue);

                                String issueDate = NewsletterLocalServiceUtil.getJournalArticleContent(aa.getDDMStructure(), aa.getContent(), "issueDate");

                                String issueTitle = NewsletterLocalServiceUtil.getJournalArticleContent(aa.getDDMStructure(), aa.getContent(), "title");
                            %>

                            <p class="issue-date">
                                <liferay-ui:message key='issue-x-y'
                                                    arguments='<%= new String[] { issueNumber , issueDate }%>'/>
                            </p>
                            <div class="issue-title">
                                <a href="${rowURL}"><%=issueTitle%>
                                </a>
                            </div>

                            <c:forEach var="article" begin="0"
                                       items="${arrangedArticles.get(yKey).get(mKey).get(issueKey)}">

                                <%
                                    JournalArticle article = (JournalArticle) pageContext.getAttribute("article");
                                    String articleTitle = NewsletterLocalServiceUtil.getJournalArticleContent(article.getDDMStructure(), article.getContent(), "title");
                                %>

                                <div class="article-title">
                                    <a href="#"><%=articleTitle%>
                                    </a>
                                </div>

                            </c:forEach>
                        </c:forEach>

                    </div>
                </div>
            </c:forEach>
        </liferay-ui:section>
    </c:forEach>
</liferay-ui:tabs>