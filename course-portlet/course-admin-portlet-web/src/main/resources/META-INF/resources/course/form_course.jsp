<%@ include file="../init.jsp" %>
<%@ page import="com.liferay.course.exception.CourseValidationException" %>

<liferay-ui:error exception="<%= CourseValidationException.CourseNameMustNotBeNull.class %>" message="error.course-name-empty" />
<liferay-ui:error exception="<%= CourseValidationException.CourseLecturerMustNotBeNull.class %>" message="error.course-lecturer-empty" />
<liferay-ui:error exception="<%= CourseValidationException.CourseNameMustBeLonger.class %>" message="error.course-name-too-long" />
<liferay-ui:error exception="<%= CourseValidationException.CourseDescriptionMustBeLonger.class %>" message="error.course-description-too-long" />
<liferay-ui:error exception="<%= CourseValidationException.CourseLecturerMustBeLonger.class %>" message="error.course-lecturer-too-long" />
<liferay-ui:error exception="<%= CourseValidationException.CourseDurationValue.class %>" message="error.course-duration-invalid" />
<liferay-ui:error exception="<%= CourseValidationException.CourseNameMustNotBeDuplicate.class %>" message="error.course-name-duplicate" />

<c:choose>
	<c:when test="${not empty course}">
		<portlet:actionURL name="<%= MVCCommandNames.EDIT_COURSE %>" var="courseActionURL">
			<portlet:param name="redirect" value="${param.redirect}" />
		</portlet:actionURL>

		<c:set value="edit-course" var="editCourseName" />
	</c:when>
	<c:otherwise>
		<portlet:actionURL name="<%= MVCCommandNames.ADD_COURSE %>" var="courseActionURL">
			<portlet:param name="redirect" value="${param.redirect}" />
		</portlet:actionURL>

		<c:set value="add-course" var="editCourseName" />
	</c:otherwise>
</c:choose>

<div class="container-fluid-1280 edit-course">
	<h1>
		<liferay-ui:message key="${editCourseName}" />
	</h1>

	<aui:model-context bean="${course}" model="${courseClass}" />

	<aui:form action="${courseActionURL}" name="fm">
		<aui:input field="courseId" name="courseId" type="hidden" />

		<aui:fieldset-group markupView="lexicon">
			<aui:fieldset>
				<aui:input label="courseName" localized="true" name="courseName" type="text">
					<aui:validator errorMessage="ui-validate-course-name-empty" name="required" />
					<aui:validator name="maxLength">75</aui:validator>
				</aui:input>

				<aui:input localized="true" name="description" type="text">
					<aui:validator name="maxLength">2000</aui:validator>
				</aui:input>

				<aui:input label="Lecturer" localized="true" name="lecturer" type="text">
					<aui:validator errorMessage="ui-validate-lecturer-empty" name="required" />
					<aui:validator name="maxLength">75</aui:validator>
				</aui:input>

				<aui:input name="duration" type="number">
					<aui:validator errorMessage="ui-validate-duration-empty" name="required" />
					<aui:validator errorMessage="ui-validate-duration-exist-number" name="digits" />
					<aui:validator name="min">1</aui:validator>
					<aui:validator name="max">40</aui:validator>
				</aui:input>

				<div class="form-group">
					<label class="control-label">Status</label>

					<span class="lexicon-icon-custom reference-mark text-warning" id="qfkd__column1__0">
						<svg class="lexicon-icon lexicon-icon-asterisk" focusable="false" role="presentation" viewBox="0 0 512 512">
							<path
								class="lexicon-icon-outline"
							d="M323.6,190l146.7-48.8L512,263.9l-149.2,47.6l93.6,125.2l-104.9,76.3l-96.1-126.4l-93.6,126.4L56.9,435.3l92.3-123.9L0,263.8l40.4-122.6L188.4,190v-159h135.3L323.6,190L323.6,190z"></path
						>
						</svg>
					</span>

					<div class="radio-group">
						<aui:input checked="${course.status ? 'true':'false'}" label="Available" name="status" type="radio" value="Available" />
						<aui:input checked="${!course.status ? 'true':'false'}" label="Unavailable" name="status" type="radio" value="Unavailable" />
					</div>
				</div>
			</aui:fieldset>
		</aui:fieldset-group>

		<aui:button-row>
			<aui:button cssClass="btn btn-primary" type="submit" />
			<aui:button cssClass="btn btn-secondary" onClick="${param.redirect}" type="cancel" />
		</aui:button-row>
	</aui:form>
</div>