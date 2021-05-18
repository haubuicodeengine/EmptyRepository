<%@ taglib prefix="liferay-security" uri="http://liferay.com/tld/security" %>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.petra.string.StringPool" %>
<%@ page import="com.liferay.portal.kernel.security.permission.PermissionChecker" %>
<%@ page import="com.liferay.amf.event.monitor.web.permission.AuditEventPermissionChecker" %>
<%@ page import="com.liferay.portal.kernel.security.permission.ActionKeys" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@include file="./init.jsp" %>
<portlet:defineObjects/>

<%
    List<AuditEvent> all = (List<AuditEvent>) request.getAttribute("all");
    List<AuditEvent> registration = (List<AuditEvent>) request.getAttribute("registration");
    List<AuditEvent> login = (List<AuditEvent>) request.getAttribute("login");

%>
<c:if test="<%= AuditEventPermissionChecker.hasPermission(themeDisplay.getScopeGroupId(), themeDisplay.getPermissionChecker(), ActionKeys.PERMISSIONS) %>">

    <liferay-ui:icon-menu
            direction="right-side"
            icon="<%= StringPool.BLANK %>"
            markupView="lexicon"
            message="<%= StringPool.BLANK %>"
            showWhenSingleIcon="<%= true %>">

        <liferay-security:permissionsURL
                modelResource="<%= AmfMonitorModelResourceKeys.AUDIT_MODEL%>"
                modelResourceDescription="{modelResourceDescription}"
                resourcePrimKey="<%= String.valueOf(themeDisplay.getScopeGroupId()) %>"
                var="permissionsURL"
                windowState="<%= LiferayWindowState.POP_UP.toString() %>"/>

        <liferay-ui:icon method="get" message="permissions" url="${permissionsURL}" useDialog="<%= true %>"/>

    </liferay-ui:icon-menu>

</c:if>

<liferay-ui:tabs names="All,Registration,Login" refresh="false" tabsValues="All,Registration,Login">
    <liferay-ui:section>
        <liferay-ui:search-container id="auditEvent"
                                     emptyResultsMessage="there-are-no-entries" delta="20"
                                     deltaConfigurable="true">

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
                <liferay-ui:search-container-column-text name="Create Date" property="createDate"/>
                <liferay-ui:search-container-column-text name="User Name" property="userName"/>
                <liferay-ui:search-container-column-text name="User ID" property="userId"/>
                <liferay-ui:search-container-column-text name="Client IP" property="clientIP"/>
                <liferay-ui:search-container-column-text name="Event Type"
                                                         value="<%= result.getEventType().equals("ADD") ? "REGISTRATION" : result.getEventType()%>"/>

            </liferay-ui:search-container-row>
            <liferay-ui:search-iterator searchContainer="<%=searchContainer%>"/>
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
                <liferay-ui:search-container-column-text name="Create Date" property="createDate"/>
                <liferay-ui:search-container-column-text name="User Name" property="userName"/>
                <liferay-ui:search-container-column-text name="User ID" property="userId"/>
                <liferay-ui:search-container-column-text name="Client IP" property="clientIP"/>
                <liferay-ui:search-container-column-text name="Event Type"
                                                         value="<%= result.getEventType().equals("ADD") ? "REGISTRATION" : result.getEventType()%>"/>

            </liferay-ui:search-container-row>
            <liferay-ui:search-iterator searchContainer="<%=searchContainer%>"/>
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
                <liferay-ui:search-container-column-text name="Create Date" property="createDate"/>
                <liferay-ui:search-container-column-text name="User Name" property="userName"/>
                <liferay-ui:search-container-column-text name="User ID" property="userId"/>
                <liferay-ui:search-container-column-text name="Client IP" property="clientIP"/>
                <liferay-ui:search-container-column-text name="Event Type" property="eventType"/>

            </liferay-ui:search-container-row>
            <liferay-ui:search-iterator searchContainer="<%=searchContainer%>"/>
        </liferay-ui:search-container>
    </liferay-ui:section>
</liferay-ui:tabs>