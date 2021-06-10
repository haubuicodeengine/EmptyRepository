<%@ include file="/init.jsp"%>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.SEARCH%>" />
</liferay-portlet:renderURL>

<aui:form action="<%=searchURL%>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />

	<div class="search-form">
		<aui:input label="" name="keywords" size="30" title="search-entries" type="text" />

		<aui:button cssClass="button-search-style" type="submit" value="search" />
	</div>
</aui:form>

<c:if test="${keywords != null}">
    <p>
        <h1><liferay-ui:message key="search-results-for" />${keywords}</h1>
    </p>
</c:if>

<c:forEach items="${newsletterResults}" var="newsletter">

	<portlet:renderURL var="viewNewsletterURL">
		<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_NEWSLETTER_ARTICLES%>" />
		<portlet:param name="issueNumber" value="${newsletter.issueNumber}" />
		<portlet:param name="redirect" value="${themeDisplay.getURLCurrent()}" />
	</portlet:renderURL>

	<div class="container">
		<div class="newsletter-container">
			<p>
				<liferay-ui:message key="issue-text" />
				${newsletter.issueNumber}, ${formater.format(newsletter.issueDate)}
			</p>
			<p class="text-title text-newsletter">
				<aui:a href="${viewNewsletterURL}">${newsletter.title}</aui:a>
			</p>
		</div>
	</div>
</c:forEach>
