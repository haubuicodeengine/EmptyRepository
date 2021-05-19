<%@ include file="/init.jsp"%>

<liferay-ui:search-container-column-text
	name="text-create-date"
	property="createDate" />
<liferay-ui:search-container-column-text
	name="text-username"
	property="userName" />
<liferay-ui:search-container-column-text
	name="text-address-ip"
	property="clientIP" />

<c:choose>
	<c:when test="${entry.eventType.equals('LOGIN')}">
		<liferay-ui:search-container-column-text
			name="text-event-type"
			property="eventType" />
	</c:when>
	<c:otherwise>
		<liferay-ui:search-container-column-text
			name="text-event-type"
			value="REGISTRATION" />
	</c:otherwise>
</c:choose>

