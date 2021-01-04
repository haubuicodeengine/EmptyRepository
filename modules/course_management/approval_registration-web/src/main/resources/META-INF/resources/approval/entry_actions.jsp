<%@ include file="../init.jsp" %>

<c:set var="registration" value="${SEARCH_CONTAINER_RESULT_ROW.object}" />

 <liferay-ui:icon-menu markupView="lexicon">

     <portlet:actionURL name="<%=MVCCommandNames.RESPONSE_COURSE_REGISTRATION %>" var="approvalCourseURL">
  
         <portlet:param name="redirect" value="${currentURL}" />
         <portlet:param name="registrationId" value="${registration.registrationId}" />
         <portlet:param name="responseType" value="approve" />
     </portlet:actionURL>

     <aui:button href="${approvalCourseURL}" value="approve"/>

     <portlet:actionURL name="<%=MVCCommandNames.RESPONSE_COURSE_REGISTRATION %>" var="rejectCourseURL">
  
         <portlet:param name="redirect" value="${currentURL}" />
         <portlet:param name="registrationId" value="${registration.registrationId}" />
         <portlet:param name="responseType" value="reject" />
     </portlet:actionURL>

     <aui:button href="${rejectCourseURL}" value="reject"/>

 </liferay-ui:icon-menu>