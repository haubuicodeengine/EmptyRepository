<%@ include file="./init.jsp" %>

<%
    JournalArticle issue = (JournalArticle) request.getAttribute("issue");

    List<JournalArticle> issueArticles = (List<JournalArticle>) request.getAttribute("issueArticles");

    String issueDate = NewsletterLocalServiceUtil.getJournalArticleContent(issue.getDDMStructure(), issue.getContent(), NewsletterFields.ISSUE_DATE);

    String issueNumber = NewsletterLocalServiceUtil.getJournalArticleContent(issue.getDDMStructure(), issue.getContent(), NewsletterFields.ISSUE_NUMBER);

    String issueTitle = NewsletterLocalServiceUtil.getJournalArticleContent(issue.getDDMStructure(), issue.getContent(), Field.TITLE);

    String issueDescription = NewsletterLocalServiceUtil.getJournalArticleContent(issue.getDDMStructure(), issue.getContent(), NewsletterFields.DESCRIPTION);
%>
<div class="amf-newsletter-web">

    <div class="closed container-fluid-1280 sidenav-container sidenav-right" id="<portlet:namespace />infoPanelId">

        <%@ include file="/search.jsp" %>

        <div class="issue-block">
            <p class="issue-date">
                <liferay-ui:message key='issue-x-y' arguments='<%= new String[] { issueNumber , issueDate }%>'/>
            </p>
            <a href="#" class="issue-title" href=""><%=issueTitle%>
            </a>
            <p class="description"><%=issueDescription%>
            </p>

            <c:forEach var="article" begin="0" items="${issueArticles}">
                <%
                    JournalArticle article = (JournalArticle) pageContext.getAttribute("article");
                    String articleTitle = NewsletterLocalServiceUtil.getJournalArticleContent(article.getDDMStructure(), article.getContent(), Field.TITLE);
                    String articleContent = NewsletterLocalServiceUtil.getJournalArticleContent(article.getDDMStructure(), article.getContent(), NewsletterFields.CONTENT);
                %>

                <div class="article-block">
                    <a href="#" class="article-title"><%=articleTitle%>
                    </a>
                    <p class="description"><%=articleContent%>}</p>
                </div>
            </c:forEach>
        </div>
    </div>

</div>