<%@ include file="../init.jsp" %>

<c:set value="${SEARCH_CONTAINER_RESULT_ROW.object}" var="courseRegistration" />

<liferay-ui:icon-menu markupView="lexicon">
	<c:choose>
		<c:when test="${courseRegistration.getStatus().equals('Rejected')}">
			<portlet:actionURL name="<%= MVCCommandNames.REGISTRATION_COURSE_DELETE %>" var="deleteCourseRegistrationURL">
				<portlet:param name="redirect" value="${currentURL}" />
				<portlet:param name="courseRegistrationId" value="${courseRegistration.courseRegistrationId}" />
			</portlet:actionURL>

			<aui:button cssClass="btn-danger" href="${deleteCourseRegistrationURL}" type="button" value="Delete" />
		</c:when>
		<c:when test="${courseRegistration.getStatus().equals('Approved')}">
			<aui:button cssClass="btn-success" disabled="true" type="button" value="Approved" />
		</c:when>
		<c:otherwise>
			<aui:button cssClass="btn-primary" disabled="true" type="button" value="Waiting-approval" />
		</c:otherwise>
	</c:choose>
</liferay-ui:icon-menu>