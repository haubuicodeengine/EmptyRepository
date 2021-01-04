<%@ include file="../init.jsp" %>


<style>

</style>
<div class="container-fluid-1280">

    <liferay-ui:search-container 
        emptyResultsMessage="no-courses"
        id="courseEntries"
        iteratorURL="${portletURL}"
        total="${courseCount}">
			
        <liferay-ui:search-container-results results="${courses}" />

        <liferay-ui:search-container-row
            className="com.liferay.practice.course.management.model.Course"
            modelVar="entry">

 			<%@ include file="/registration/view_registered_course_entry_search_columns.jspf" %>
			
			<liferay-ui:search-container-column-text name="Actions"> 

			 	<c:forEach items="${registrations}" var="registration">

			 		<c:if test="${registration.getCourseId() ==  entry.getCourseId() && registration.getUserId() == userId}">

						<liferay-ui:icon-menu markupView="lexicon">
							<c:choose>
							<c:when test="${registration.getRegistrationStatus() == 0}">

						    	<aui:button href="#" value="Requested" disabled="true" style="color: blue;" cssClass="btn-requested"/>
							</c:when>

							<c:when test="${registration.getRegistrationStatus() == 1}">

						    	<aui:button href="#" cssClass="btn-disable btn-approved" style="color: green;" disabled="true" value="Approved"/>
							</c:when>

							<c:when test="${registration.getRegistrationStatus() == 2}">
						    	<portlet:actionURL name="<%=MVCCommandNames.CANCEL_REGISTER_COURSE %>" var="cancelRegisterCourseURL">

							         <portlet:param name="redirect" value="${currentURL}" />
							         <portlet:param name="registrationId" value="${registration.registrationId}" />
							     </portlet:actionURL>

						    	<aui:button href="${cancelRegisterCourseURL}" cssClass="btn-disable btn-rejected" value="Delete"/>
							</c:when>
							</c:choose>
						 </liferay-ui:icon-menu>

			 		</c:if>


				</c:forEach>
			 </liferay-ui:search-container-column-text>
        </liferay-ui:search-container-row>

        <%-- Iterator / Paging --%>

        <liferay-ui:search-iterator 
            displayStyle="${coursesManagementToolbarDisplayContext.getDisplayStyle()}"
            markupView="lexicon" 
        />
    </liferay-ui:search-container>
</div>