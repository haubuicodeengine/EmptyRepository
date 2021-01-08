<%@ include file="/init.jsp" %>

<div class="container-fluid-1280">
	<h1>${course.getCourseName(locale)}</h1>

	<h2><liferay-ui:message key="course-information" /></h2>

	<div class="course-metadata">
		<dl>
			<dt><liferay-ui:message key="created" /></dt>
			<dd>${createDate}</dd>

			<dt><liferay-ui:message key="created-by" /></dt>
			<dd>${course.userName}</dd>

			<dt><liferay-ui:message key="course-duedate" /></dt>
			<dd>${dueDate}</dd>

			<dt><liferay-ui:message key="description" /></dt>
			<dd>${course.getDescription(locale)}</dd>
		</dl>
	</div>
</div>