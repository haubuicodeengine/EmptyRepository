<%@include file="./init.jsp"%>
<portlet:defineObjects />

<%
	List<AuditEvent> all = (List<AuditEvent>) request.getAttribute("all");
	List<AuditEvent> registration = (List<AuditEvent>) request.getAttribute("registration");
	List<AuditEvent> login = (List<AuditEvent>) request.getAttribute("login");
%>

<liferay-ui:tabs names="All,Registration,Login" refresh="false" tabsValues="All,Registration,Login">
	<liferay-ui:section>
		<liferay-ui:search-container id="auditEvent"
									 emptyResultsMessage="there-are-no-entries" delta="20"
									 deltaConfigurable="true" >

			<liferay-ui:search-container-results>
				<%
					searchContainer.setTotal(registration.size());
					searchContainer.setResults(ListUtil.subList(all, searchContainer.getStart(), searchContainer.getEnd()));
				%>
			</liferay-ui:search-container-results>

			<liferay-ui:search-container-row className="com.liferay.portal.security.audit.storage.model.AuditEvent"
											 keyProperty="auditEventId" modelVar="line">
				<%
					AuditEvent result = (AuditEvent) row.getObject();
				%>
				<liferay-ui:search-container-column-text name="User Name" property="userName"/>
				<liferay-ui:search-container-column-text name="User ID" property="userId" />
				<liferay-ui:search-container-column-text name="Client IP" property="clientIP" />
				<liferay-ui:search-container-column-text name="Event Type" value="<%= result.getEventType().equals("ADD") ? "REGISTRATION" : result.getEventType()%>"/>

			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
		</liferay-ui:search-container>
	</liferay-ui:section>
	<liferay-ui:section>
		<liferay-ui:search-container id="auditEvent"
									 emptyResultsMessage="there-are-no-entries" delta="20"
									 deltaConfigurable="true">

			<liferay-ui:search-container-results>
				<%
					searchContainer.setTotal(registration.size());
					searchContainer.setResults(ListUtil.subList(registration, searchContainer.getStart(), searchContainer.getEnd()));
				%>
			</liferay-ui:search-container-results>

			<liferay-ui:search-container-row className="com.liferay.portal.security.audit.storage.model.AuditEvent"
											 keyProperty="auditEventId" modelVar="line">

				<%
					AuditEvent result = (AuditEvent) row.getObject();
				%>
				<liferay-ui:search-container-column-text name="User Name" property="userName" />
				<liferay-ui:search-container-column-text name="User ID" property="userId" />
				<liferay-ui:search-container-column-text name="Client IP" property="clientIP" />
				<liferay-ui:search-container-column-text name="Event Type" value="<%= result.getEventType().equals("ADD") ? "REGISTRATION" : result.getEventType()%>"/>

			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
		</liferay-ui:search-container>
	</liferay-ui:section>
	<liferay-ui:section>
		<liferay-ui:search-container id="auditEvent"
									 emptyResultsMessage="there-are-no-entries" delta="20"
									 deltaConfigurable="true" total="<%= login.size() %>">

			<liferay-ui:search-container-results>
				<%
					searchContainer.setTotal(login.size());
					searchContainer.setResults(ListUtil.subList(login, searchContainer.getStart(), searchContainer.getEnd()));
				%>
			</liferay-ui:search-container-results>

			<liferay-ui:search-container-row className="com.liferay.portal.security.audit.storage.model.AuditEvent"
											 keyProperty="auditEventId" modelVar="line">
				<liferay-ui:search-container-column-text name="Create Date" property="createDate" />

				<liferay-ui:search-container-column-text name="User Name" property="userName" />
				<liferay-ui:search-container-column-text name="User ID" property="userId" />
				<liferay-ui:search-container-column-text name="Client IP" property="clientIP" />
				<liferay-ui:search-container-column-text name="Event Type" property="eventType" />

			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
		</liferay-ui:search-container>
	</liferay-ui:section>
</liferay-ui:tabs>