<%@ include file="./init.jsp" %>
<liferay-ui:error key="serviceErrorDetails">
	<liferay-ui:message arguments='<%= SessionErrors.get(liferayPortletRequest, "serviceErrorDetails") %>' key="error.course-service-error" />
</liferay-ui:error>

<liferay-ui:success key="courseAdded" message="course-added-successfully" />
<liferay-ui:success key="courseUpdated" message="course-updated-successfully" />
<liferay-ui:success key="courseDeleted" message="course-deleted-successfully" />

<div class="container-fluid-1280">
	<h1><liferay-ui:message key="courses" /></h1>

	<%-- Clay management toolbar. --%>

	<clay:management-toolbar
		disabled="${courseCount eq 0}"
		displayContext="${coursesManagementToolbarDisplayContext}"
		itemsTotal="${courseCount}"
		searchContainerId="courseEntries"
		selectable="false"
	/>

	<%-- Search container. --%>
	<liferay-ui:search-container emptyResultsMessage="no-courses" id="courseEntries" iteratorURL="${portletURL}" total="${courseCount}">
		<liferay-ui:search-container-results results="${courses}" />

		<liferay-ui:search-container-row className="com.liferay.course.model.Course" modelVar="entry">
			<%@ include file="/course/entry_search_columns.jspf" %>
		</liferay-ui:search-container-row>

		<%-- Iterator / Paging --%>
		<liferay-ui:search-iterator displayStyle="${coursesManagementToolbarDisplayContext.getDisplayStyle()}" markupView="lexicon" />
	</liferay-ui:search-container>
</div>