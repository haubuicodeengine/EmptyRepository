<%@ include file="/init.jsp"%>

<%@ include file="/newsletter/view_search.jsp"%>

<liferay-ui:tabs names="${years}" refresh="false" tabsValues="${years}">

    <c:forEach items="${years}" var="year">

        <liferay-ui:section>
            <c:forEach items="${months}" var="month">

                <c:forEach items="${dates}" var="date">

                    <c:if test="${newsLetterListingUtil.splitString(date.value)[0] eq month && newsLetterListingUtil.splitString(date.value)[1] eq year}">
                        <p class="month-label">${month}</p>
                    </c:if>
                </c:forEach>

                <c:forEach items="${newsletters}" var="newsletter">
                    
                    <portlet:renderURL var="viewNewsletterURL">
                        <portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_NEWSLETTER_ARTICLES%>" />
                        <portlet:param name="issueNumber" value="${newsletter.issueNumber}" />
                        <portlet:param name="redirect" value="${themeDisplay.getURLCurrent()}" />
                    </portlet:renderURL>

                    <c:if test="${formaterByYear.format(newsletter.issueDate) eq year}">
                        <c:if test="${formaterByMonth.format(newsletter.issueDate) eq month}">

                            <div class="container">
                                <div class="newsletter-container">
                                    <p>
						                <liferay-ui:message key="issue-text" />
						                ${newsletter.issueNumber}, ${formater.format(newsletter.issueDate)}
						            </p>
						            <p class="text-title text-newsletter">
						                <aui:a href="${viewNewsletterURL}">${newsletter.title}</aui:a>
						            </p>

                                    <c:forEach items="${articles}" var="articles">
                                        <c:if test="${newsletter.issueNumber == articles.issueNumber}">
                                            <p class="text-title">${articles.title}</p>
                                        </c:if>
                                    </c:forEach>
                                </div>
                            </div>
                        </c:if>
                    </c:if>
                </c:forEach>
            </c:forEach>
        </liferay-ui:section>
    </c:forEach>
</liferay-ui:tabs>