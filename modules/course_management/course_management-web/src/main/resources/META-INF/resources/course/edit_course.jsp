<%@ include file="../init.jsp"%>

<liferay-ui:error key="serviceErrorDetails">
	<liferay-ui:message key="error.course-service-error"
		arguments='<%=SessionErrors.get(liferayPortletRequest, "serviceErrorDetails")%>' />
</liferay-ui:error>
<liferay-ui:error key="courseNameEmpty"
	message="error.course-name-empty" />

<liferay-ui:error key="courseLecturerLengthInvalid"
	message="error.course-lecturer-length-invalid" />

<liferay-ui:error key="courseNameLengthInvalid"
	message="error.course-name-length-invalid" />

<liferay-ui:error key="courseDescriptionLengthInvalid"
	message="error.course-description-length-invalid" />

<liferay-ui:error key="courseDurationValueInvalid"
	message="error.course-duration-length-invalid" />

<liferay-ui:error key="courseDescriptionEmpty"
	message="error.course-description-empty" />
<liferay-ui:error key="courseLecturerEmpty"
	message="error.course-lecturer-empty" />
<liferay-ui:error key="courseDurationEmpty"
	message="error.course-duration-empty" />

<c:choose>
	<c:when test="${not empty course}">
		<portlet:actionURL var="courseActionURL"
			name="<%=MVCCommandNames.EDIT_COURSE%>">
			<portlet:param name="redirect" value="${param.redirect}" />
		</portlet:actionURL>

		<c:set var="editCourseName" value="edit-course" />
	</c:when>
	<c:otherwise>
		<portlet:actionURL var="courseActionURL"
			name="<%=MVCCommandNames.ADD_COURSE%>">
			<portlet:param name="redirect" value="${param.redirect}" />
		</portlet:actionURL>

		<c:set var="editCourseName" value="add-course" />
	</c:otherwise>
</c:choose>

<div class="container-fluid-1280 edit-course">

	<h1>
		<liferay-ui:message key="${editCourseName}" />
	</h1>

	<aui:model-context bean="${course}" model="${courseClass}" />

	<aui:form action="${courseActionURL}" name="fm">

		<aui:input name="courseId" field="courseId" type="hidden" />

		<aui:fieldset-group markupView="lexicon">

			<aui:fieldset>

				<aui:input name="courseName">
					<aui:validator name="required" />
					<aui:validator name="rangeLength">[1,20]</aui:validator>
				</aui:input>

				<aui:input name="description">
					<aui:validator name="rangeLength">[1,2000]</aui:validator>
				</aui:input>

				<aui:input name="lecturer">
					<aui:validator name="rangeLength">[1,75]</aui:validator>
					<aui:validator name="required" />
				</aui:input>

				<aui:input label="duration" name="duration" type="text"> 
					<aui:validator name="required" />
					<aui:validator name="range">[1,40]</aui:validator>
				</aui:input>

				<aui:input label="Course Status" name="name"/>

				<aui:input checked="<%=true%>" inlineField="true" label="Available"
					value="1" type="radio" name="courseStatus"></aui:input>

				<aui:input inlineField="true" label="Unavailable" value="0"
					type="radio" name="courseStatus"></aui:input>

			</aui:fieldset>
		</aui:fieldset-group>

		<aui:button-row>
			<aui:button cssClass="btn btn-primary" type="submit" />
			<aui:button cssClass="btn btn-secondary" onClick="${param.redirect}"
				type="cancel" />
		</aui:button-row>
	</aui:form>

</div>