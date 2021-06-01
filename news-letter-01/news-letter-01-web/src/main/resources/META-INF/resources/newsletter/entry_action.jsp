<%@ include file="/init.jsp"%>

<c:set var="newsletter" value="${SEARCH_CONTAINER_RESULT_ROW.object}" />

<liferay-ui:icon-menu markupView="lexicon">

    <%-- View action. --%>

    <portlet:renderURL var="viewNewsLetterURL">
        <portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_NEWSLETTER %>" />
        <portlet:param name="redirect" value="${currentURL}" />
        <portlet:param name="newsletterId" value="${newsletter.newsletterId}" />
    </portlet:renderURL>
    <liferay-ui:icon message="view" url="${viewNewsLetterURL}" />

    <%-- Edit action. --%>

    <portlet:renderURL var="editNewsletterURL">
        <portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.EDIT_NEWSLETTER %>" />
        <portlet:param name="redirect" value="${currentURL}" />
        <portlet:param name="newsletterId" value="${newsletter.newsletterId}" />
    </portlet:renderURL>
    <liferay-ui:icon message="edit" url="${editNewsletterURL}" />    

    <%-- Delete action. --%>

    <portlet:actionURL name="<%=MVCCommandNames.DELETE_NEWSLETTER %>" var="deleteNewsletterURL">
        <portlet:param name="redirect" value="${currentURL}" />
        <portlet:param name="newsletterId" value="${newsletter.newsletterId}" />
    </portlet:actionURL>
    <liferay-ui:icon-delete url="${deleteNewsletterURL}" />

</liferay-ui:icon-menu> 