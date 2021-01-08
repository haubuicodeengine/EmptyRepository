<%@ include file="./init.jsp" %>
<%@ page import="com.liferay.course.exception.CourseRegistrationValidationException" %>
<liferay-ui:error key="serviceErrorDetails">
    <liferay-ui:message arguments='<%= SessionErrors.get(liferayPortletRequest, "serviceErrorDetails") %>' key="error.course-service-error" />
</liferay-ui:error>

<liferay-ui:success key="courseRegistrationSuccess" message="course-regsitered-successfully" />
<liferay-ui:success key="courseRegistrationDeleted" message="course-deleted-successfully" />

<liferay-ui:error exception="<%= CourseRegistrationValidationException.CourseRegistrationMustNotBeDuplicate.class %>" message="error.course-registration-must-not-be-duplicate" />

<div class="container-fluid-1280">
	<liferay-ui:tabs names="Courses,Course Registered" refresh="false" tabsValues="Courses,Course Registered">
		<liferay-ui:section>
			<liferay-ui:search-container emptyResultsMessage="no-courses" id="courseEntries">
				<liferay-ui:search-container-results results="${coursesAvailable}" />

				<liferay-ui:search-container-row className="com.liferay.course.model.Course" modelVar="entry">
					<%@ include file="/course-registration/entry_search_columns.jspf" %>
				</liferay-ui:search-container-row>

				<liferay-ui:search-iterator markupView="lexicon" />
			</liferay-ui:search-container>
		</liferay-ui:section>

		<liferay-ui:section>
			<liferay-ui:search-container emptyResultsMessage="no-courses" id="courseEntries">
				<liferay-ui:search-container-results results="${coursesRegistered}" />

				<liferay-ui:search-container-row className="com.liferay.course.model.CourseRegistration" modelVar="entry">
					<c:forEach items="${courses}" var="course">
						<c:if test="${course.getCourseId() == entry.courseId}">
							<liferay-ui:search-container-column-text name="courseName" value="${course.getCourseName()}" />
						</c:if>
					</c:forEach>
					<%@ include file="/course-registration/registered-search_columns.jspf" %>
				</liferay-ui:search-container-row>

				<liferay-ui:search-iterator markupView="lexicon" />
			</liferay-ui:search-container>
		</liferay-ui:section>
	</liferay-ui:tabs>
</div>