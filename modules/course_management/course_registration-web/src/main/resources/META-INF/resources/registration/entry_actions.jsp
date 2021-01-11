<%@ include file="../init.jsp" %>

<c:set var="course" value="${SEARCH_CONTAINER_RESULT_ROW.object}" />

 <liferay-ui:icon-menu markupView="lexicon">

     <portlet:actionURL name="<%=MVCCommandNames.REGISTER_COURSE %>" var="registerCourseURL">
  
         <portlet:param name="redirect" value="${currentURL}" />
         <portlet:param name="courseId" value="${course.courseId}" />
     </portlet:actionURL>

     <aui:button href="${registerCourseURL}" value="register"/>

 </liferay-ui:icon-menu>