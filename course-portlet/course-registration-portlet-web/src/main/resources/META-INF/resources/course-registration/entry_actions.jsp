<%@ include file="../init.jsp" %>

<c:set value="${SEARCH_CONTAINER_RESULT_ROW.object}" var="course" />

<liferay-ui:icon-menu markupView="lexicon">
	<c:choose>
		<c:when test="${!listCourseIdRegistered.contains(course.courseId)}">
			<portlet:actionURL name="<%= MVCCommandNames.REGISTRATION_COURSE_ADD %>" var="courseRegistrationURL">
				<portlet:param name="redirect" value="${currentURL}" />
				<portlet:param name="courseId" value="${course.courseId}" />
			</portlet:actionURL>

			<aui:button cssClass="btn-primary" href="${courseRegistrationURL}" type="button" value="Registration" />
		</c:when>
		<c:otherwise>
			<aui:button cssClass="btn-primary" disabled="true" type="button" value="Registration" />
		</c:otherwise>
	</c:choose>
</liferay-ui:icon-menu>