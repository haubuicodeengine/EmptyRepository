<%@ include file="/init.jsp"%>

<div class="container">

    <div class="newsletter-container">

        <p>Issue: #${newsletter.issueNumber},
            ${formater.format(newsletter.issueDate)}</p>
        <p class="text-title text-newsletter">
            <b><aui:a href="${viewNewsletterURL}"> ${newsletter.title} </aui:a></b>
        </p>
        <p><i>${newsletter.description}</i></p>
        <c:forEach
            items="${newsletter_articles}"
            var="newsletter_articles">
            <c:if
                test="${newsletter.newsletterId == newsletter_articles.newsletterId}">

                <c:forEach
                    items="${articles}"
                    var="articles">
                    <c:if test="${articles.id == newsletter_articles.articlesId}">
                        <p class="text-title">${articles.title}</p>
                        <p>${articles.content}</p>
                    </c:if>

                </c:forEach>
            </c:if>
        </c:forEach>
    </div>
</div>
    