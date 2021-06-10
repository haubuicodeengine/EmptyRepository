<%@ include file="./init.jsp" %>

<portlet:renderURL var="searchURL">
    <portlet:param name="mvcRenderCommandName" value="<%= MVCCommandNames.SEARCH %>"/>
</portlet:renderURL>

<aui:form action="${searchURL}" method="port" name="fm">
    <liferay-ui:input-search buttonLabel="Search" placeholder="Enter your keywords ..." name="keywords" autoFocus="true"
                             showButton="true"/>
</aui:form>