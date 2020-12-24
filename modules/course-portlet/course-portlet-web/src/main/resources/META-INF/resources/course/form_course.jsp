<%@ include file="/init.jsp"%>
<liferay-ui:error key="serviceErrorDetails">
    <liferay-ui:message key="error.course-service-error" arguments='<%= SessionErrors.get(liferayPortletRequest, "serviceErrorDetails") %>' />
</liferay-ui:error>
<liferay-ui:error key="courseNameEmpty" message="error.course-name-empty" />
<liferay-ui:error key="courseLecturerEmpty" message="error.course-lecturer-empty" />
<liferay-ui:error key="courseDescriptionEmpty" message="error.course-description-empty" />
<liferay-ui:error key="courseNameTooLong" message="error.course-name-too-long" />
<liferay-ui:error key="courseLecturerTooLong" message="error.course-name-too-long" />
<liferay-ui:error key="courseDescriptionTooLong" message="error.course-name-too-long" />
<liferay-ui:error key="courseDurationTooSmall" message="error.course-duration-too-small" />
<liferay-ui:error key="courseDurationTooLarge" message="error.course-duration-too-large" />
<%-- Generate add / edit action URL and set title. --%>

<c:choose>
    <c:when test="${not empty course}">
        <portlet:actionURL var="courseActionURL" name="<%=MVCCommandNames.EDIT_COURSE %>">
            <portlet:param name="redirect" value="${param.redirect}" />
        </portlet:actionURL>
        <c:set var="editCourseName" value="edit-course"/>
    </c:when>
    <c:otherwise>
        <portlet:actionURL var="courseActionURL" name="<%=MVCCommandNames.ADD_COURSE %>">
            <portlet:param name="redirect" value="${param.redirect}" />
        </portlet:actionURL>
        <c:set var="editCourseName" value="add-course"/>
    </c:otherwise>
</c:choose>

<div class="container-fluid-1280 edit-course">

     <h1><liferay-ui:message key="${editCourseName}" /></h1>

     <aui:model-context bean="${course}" model="${courseClass}" />

     <aui:form action="${courseActionURL}" name="fm">

         <aui:input name="courseId" field="courseId" type="hidden" />

            <aui:fieldset-group markupView="lexicon">
             <aui:fieldset>
                 <aui:input name="courseName" label="courseName" type="text" localized="true" >
                     <aui:validator name="required" errorMessage="ui-validate-course-name-empty"/>
                     <aui:validator name="maxLength">75</aui:validator>
                 </aui:input>

                 <aui:input name="description" type="text" localized="true">
                     <aui:validator name="maxLength">2000</aui:validator>
                 </aui:input>

                 <aui:input name="lecturer" label="Lecturer" type="text" localized="true">
                     <aui:validator name="required" errorMessage="ui-validate-lecturer-empty"/>
                     <aui:validator name="maxLength">75</aui:validator>
                 </aui:input>
                 
                 <aui:input name="duration" type="text" localized="true">
                     <aui:validator name="required" errorMessage="ui-validate-duration-empty" />
                     <aui:validator name="digits" errorMessage="ui-validate-duration-exist-number" />
                     <aui:validator name="min" errorMessage="">1</aui:validator>
                     <aui:validator name="max" errorMessage="">40</aui:validator>
                 </aui:input>
             </aui:fieldset>
        </aui:fieldset-group>

        <%--Buttons. --%>

        <aui:button-row>
            <aui:button cssClass="btn btn-primary" type="submit" />
            <aui:button cssClass="btn btn-secondary" onClick="${param.redirect}" type="cancel" />
        </aui:button-row>
    </aui:form>

</div>