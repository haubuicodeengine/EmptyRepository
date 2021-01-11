<%@ include file="./init.jsp" %>

<div class="container-fluid-1280">
 	
 	<h1><liferay-ui:message key="Approval" /></h1>
 	
 	
    <liferay-ui:search-container
        emptyResultsMessage="no-courses"
        id="courseEntries"
        iteratorURL="${portletURL}"
        total="${courseCount}">

        <liferay-ui:search-container-results results="${registrations}" />

        <liferay-ui:search-container-row
            className="com.liferay.practice.course.management.model.Registration"
            modelVar="entry">
			<c:set var="count" value="0"/>
			 <liferay-ui:search-container-column-text name="courseName"> 
			 	<c:forEach items="${courses}" var="course">
					<c:if test="${course.getCourseId() ==  entry.getCourseId()}">
						<c:if test="${count == 0}">
							<p>${course.getCourseName()}</p>
							<c:set var="count" value="1"/>
						</c:if>
					</c:if>
				</c:forEach>
			 </liferay-ui:search-container-column-text>
            <%-- name="courseName" value="${courses.get(0).getCourseId()} --%>
            <liferay-ui:search-container-column-text property="userName" />

            <%@ include file="/approval/entry_search_columns.jspf" %>

        </liferay-ui:search-container-row>

 		<liferay-ui:search-iterator 
            displayStyle="${coursesManagementToolbarDisplayContext.getDisplayStyle()}"
            markupView="lexicon" 
        />
        <%-- Iterator / Paging --%>
    </liferay-ui:search-container>
</div>