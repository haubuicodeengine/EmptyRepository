<%@ include file="/init.jsp" %>

<c:set value="${SEARCH_CONTAINER_RESULT_ROW.object}" var="course" />

<liferay-ui:icon-menu markupView="lexicon">

	<%-- View action. --%>

	<portlet:renderURL var="viewCourseURL">
		<portlet:param name="mvcRenderCommandName" value="<%= MVCCommandNames.VIEW_COURSE %>" />
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="courseId" value="${course.courseId}" />
	</portlet:renderURL>

	<liferay-ui:icon message="view" url="${viewCourseURL}" />

	<%-- Edit action. --%>

	<portlet:renderURL var="editCourseURL">
		<portlet:param name="mvcRenderCommandName" value="<%= MVCCommandNames.EDIT_COURSE %>" />
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="courseId" value="${course.courseId}" />
	</portlet:renderURL>

	<liferay-ui:icon message="edit" url="${editCourseURL}" />

	<%-- Delete action. --%>

	<portlet:actionURL name="<%= MVCCommandNames.DELETE_COURSE %>" var="deleteCourseURL">
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="courseId" value="${course.courseId}" />
	</portlet:actionURL>

	<liferay-ui:icon-delete url="${deleteCourseURL}" />
</liferay-ui:icon-menu>