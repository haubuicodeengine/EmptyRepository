<%@ include file="./init.jsp" %>

<%
    JournalArticle issue = (JournalArticle) request.getAttribute("issue");

    List<JournalArticle> issueArticles = (List<JournalArticle>) request.getAttribute("issueArticles");

    String issueDate = NewsletterLocalServiceUtil.getJournalArticleContent(issue.getDDMStructure(), issue.getContent(), "issueDate");

    String issueNumber = NewsletterLocalServiceUtil.getJournalArticleContent(issue.getDDMStructure(), issue.getContent(), "issueNumber");

    String issueTitle = NewsletterLocalServiceUtil.getJournalArticleContent(issue.getDDMStructure(), issue.getContent(), "title");

    String issueDescription = NewsletterLocalServiceUtil.getJournalArticleContent(issue.getDDMStructure(), issue.getContent(), "description");
%>
<div class="amf-newsletter-web">

    <div class="issue">
        <p class="issue-date">
            <liferay-ui:message key='issue-x-y' arguments='<%= new String[] { issueNumber , issueDate }%>'/>
        </p>
        <a href="#" class="detail-issue-title" href=""><%=issueTitle%>
        </a>
        <p clas="description"><%=issueDescription%>
        </p>
    </div>

    <c:forEach var="article" begin="0" items="${issueArticles}">
        <%
            JournalArticle article = (JournalArticle) pageContext.getAttribute("article");
            String articleTitle = NewsletterLocalServiceUtil.getJournalArticleContent(article.getDDMStructure(), article.getContent(), "title");
            String articleContent = NewsletterLocalServiceUtil.getJournalArticleContent(article.getDDMStructure(), article.getContent(), "content");
        %>

        <div class="article">
            <a href="#" class="detail-article-title"><%=articleTitle%>
            </a>
            <p clas="description"><%=articleContent%>}</p>
        </div>
    </c:forEach>
</div>

