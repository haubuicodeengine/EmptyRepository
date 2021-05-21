<%@ taglib prefix="liferay" uri="http://liferay.com/tld/ui" %>
<%@ include file="/init.jsp" %>


<c:choose>

	<c:when test="${permissionChecker.hasPermission(themeDisplay.scopeGroupId, 'com_liferay_amf_search_AmfSearchPortlet', themeDisplay.companyId, 'SEARCH')}" >
		<portlet:actionURL name="sendData" var="sendData"/>
		<liferay-ui:error key="not-a-zip-code" message="Expected a US Zip Code" />
		<aui:form action="${sendData}" method="post" name="searchForm">
			<aui:input label="Enter US Zip" name="usZip" type="text">
				<aui:validator name="required" />
				<aui:validator name="number" />
			</aui:input>
			<aui:button type="submit" />
		</aui:form>
	</c:when>

	<c:otherwise>
		<liferay-ui:message key="do-not-have-required-permission"/>
	</c:otherwise>
</c:choose>


