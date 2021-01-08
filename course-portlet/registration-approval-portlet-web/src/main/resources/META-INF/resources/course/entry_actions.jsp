<%@ include file="../init.jsp" %>

<c:set value="${SEARCH_CONTAINER_RESULT_ROW.object}" var="courseRegistration" />

<liferay-ui:icon-menu markupView="lexicon">
	<portlet:actionURL name="<%= MVCCommandNames.APPROVAL_COURSE %>" var="approvalCourseRegisterURL">
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="courseRegistrationId" value="${courseRegistration.courseRegistrationId}" />
	</portlet:actionURL>

	<aui:button cssClass="btn-primary" href="${approvalCourseRegisterURL}" type="button" value="Approve" />

	<portlet:actionURL name="<%= MVCCommandNames.REJECT_COURSE %>" var="rejectCourseRegisterURL">
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="courseRegistrationId" value="${courseRegistration.courseRegistrationId}" />
	</portlet:actionURL>

	<aui:button cssClass="btn-danger" href="${rejectCourseRegisterURL}" type="button" value="reject" />
</liferay-ui:icon-menu>