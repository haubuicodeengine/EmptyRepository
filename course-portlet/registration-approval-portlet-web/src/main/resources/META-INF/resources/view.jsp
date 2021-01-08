<%@ include file="./init.jsp" %>
<liferay-ui:error key="serviceErrorDetails">
	<liferay-ui:message arguments='<%= SessionErrors.get(liferayPortletRequest, "serviceErrorDetails") %>' key="error.course-service-error" />
</liferay-ui:error>

<liferay-ui:success key="approveCourseRegistrationSuccess" message="approve-course-registration-successfully" />
<liferay-ui:success key="rejectCousreRegistrationSuccess" message="reject-course-registration-successfully" />

<div class="container-fluid-1280">
	<h1><liferay-ui:message key="courses" /></h1>

	<liferay-ui:search-container emptyResultsMessage="no-courses" id="courseEntries">

		<liferay-ui:search-container-results results="${coursesRegistered}" />

		<liferay-ui:search-container-row className="com.liferay.course.model.CourseRegistration" modelVar="entry">
			<c:forEach items="${courses}" var="course">
				<c:if test="${course.getCourseId() == entry.courseId}">
					<liferay-ui:search-container-column-text value="${course.getCourseName()}" />
				</c:if>
			</c:forEach>

			<%@ include file="/course/entry_search_columns.jspf" %>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator markupView="lexicon" />
	</liferay-ui:search-container>
</div>