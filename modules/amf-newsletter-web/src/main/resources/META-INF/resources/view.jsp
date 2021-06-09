<%@ include file="./init.jsp" %>
<%
    Map<String, Map<String, Map<String, List<JournalArticle>>>> arrangedArticles = (Map<String, Map<String, Map<String, List<JournalArticle>>>>) request.getAttribute("arrangedArticles");
    String tabs = (String) request.getAttribute("tabs");
%>

<div class="amf-newsletter-web">
    <div class="closed container-fluid-1280 sidenav-container sidenav-right" id="<portlet:namespace />infoPanelId">

        <liferay-ui:tabs names="${tabs}" refresh="false" tabsValues="${tabs}">

            <c:forEach var="yKey" begin="0" items="${arrangedArticles.keySet()}">
                <liferay-ui:section>
                    <c:forEach var="mKey" begin="0" items="${arrangedArticles.get(yKey).keySet()}">

                        <label class="month-label"> ${mKey}</label>

                        <c:forEach var="issueKey" begin="0" items="${arrangedArticles.get(yKey).get(mKey).keySet()}">

                            <div class="issue-block">
                                <portlet:renderURL var="rowURL">
                                    <portlet:param name="issueId" value="${issueKey}"/>
                                    <portlet:param name="mvcRenderCommandName"
                                                   value="<%= MVCCommandNames.VIEW_ISSUE %>"/>
                                </portlet:renderURL>
                                <%
                                    String StrIssueNumber = String.valueOf(pageContext.getAttribute("issueKey"));

                                    long issueNumber = Long.parseLong(StrIssueNumber);

                                    JournalArticle issue = NewsletterLocalServiceUtil.getNewsletterByIssueNumber(issueNumber);

                                    String issueDate = NewsletterLocalServiceUtil.getJournalArticleContent(issue.getDDMStructure(), issue.getContent(), NewsletterFields.ISSUE_DATE);

                                    String issueTitle = NewsletterLocalServiceUtil.getJournalArticleContent(issue.getDDMStructure(), issue.getContent(), Field.TITLE);
                                %>

                                <label class="issue-date">
                                    <liferay-ui:message key='issue-x-y'
                                                        arguments='<%= new String[] { StrIssueNumber , issueDate }%>'/>
                                </label>
                                <div class="issue-title">
                                    <a href="${rowURL}"><%=issueTitle%>
                                    </a>
                                </div>

                                <c:forEach var="article" begin="0"
                                           items="${arrangedArticles.get(yKey).get(mKey).get(issueKey)}">

                                    <%
                                        JournalArticle article = (JournalArticle) pageContext.getAttribute("article");
                                        String articleTitle = NewsletterLocalServiceUtil.getJournalArticleContent(article.getDDMStructure(), article.getContent(), Field.TITLE);
                                    %>

                                    <div class="article-block">
                                        <a class="article-title" href="${rowURL}"><%=articleTitle%>
                                        </a>
                                    </div>

                                </c:forEach>

                            </div>

                        </c:forEach>

                    </c:forEach>
                </liferay-ui:section>
            </c:forEach>
        </liferay-ui:tabs>
    </div>
</div>