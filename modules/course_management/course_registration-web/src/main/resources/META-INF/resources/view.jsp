<%@ include file="./init.jsp" %>


<liferay-ui:error key="serviceErrorDetails">
     <liferay-ui:message arguments='<%= SessionErrors.get(liferayPortletRequest, "serviceErrorDetails") %>' key="error.register-service-error" />
 </liferay-ui:error>
 
 <liferay-ui:error key="alreadyRegistered" message="course-already-registered" />
 <liferay-ui:error key="fullRegistered" message="course-full-registered" />
 
<div class="container-fluid-1280">

<liferay-ui:icon-menu markupView="lexicon">

     <%-- View action. --%>

     <portlet:renderURL var="viewCourseURL">
         <portlet:param name="mvcRenderCommandName"
             value="<%=MVCCommandNames.VIEW_REGISTERED_COURSE %>" />
         <portlet:param name="redirect" value="${currentURL}" />
         <portlet:param name="courseId" value="${course.courseId}" />
     </portlet:renderURL>

     <liferay-ui:icon message="View registered course" url="${viewCourseURL}" />

 </liferay-ui:icon-menu>
 
    <liferay-ui:search-container
        emptyResultsMessage="no-courses"
        id="courseEntries"
        iteratorURL="${portletURL}"
        total="${courseCount}">

        <liferay-ui:search-container-results results="${courses}" />

        <liferay-ui:search-container-row
            className="com.liferay.practice.course.management.model.Course"
            modelVar="entry">

            <%@ include file="/registration/entry_search_columns.jspf" %>

        </liferay-ui:search-container-row>

        <%-- Iterator / Paging --%>

        <liferay-ui:search-iterator 
            displayStyle="${coursesManagementToolbarDisplayContext.getDisplayStyle()}"
            markupView="lexicon" 
        />
    </liferay-ui:search-container>
</div>