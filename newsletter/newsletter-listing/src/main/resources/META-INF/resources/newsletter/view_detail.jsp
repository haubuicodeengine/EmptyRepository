<%@ include file="/init.jsp"%>

<div class="container">
	<div class="newsletter-container">
		<p>
			<liferay-ui:message key="issue-text" />
			${newsletter.issueNumber}, ${formater.format(newsletter.issueDate)}
		</p>
		<p class="text-title text-newsletter">
			<aui:a href="${viewNewsletterURL}">${newsletter.title}</aui:a>
		</p>
		<p>
			<i>${newsletter.description}</i>
		</p>

		<c:forEach items="${articles}" var="articles">
			<p class="text-title">${articles.title}</p>
			<p>${articles.content}</p>
		</c:forEach>
	</div>
</div>