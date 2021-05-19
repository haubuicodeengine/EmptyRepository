<%@ include file="./init.jsp"%>

<%
	List<AuditEvent> allEvents = (List<AuditEvent>) request.getAttribute("allEvents");
	List<AuditEvent> loginEvents = (List<AuditEvent>) request.getAttribute("loginEvents");
	List<AuditEvent> registrationEvents = (List<AuditEvent>) request.getAttribute("registrationEvents");
	List<AuditEvent> allEventsByUserId = (List<AuditEvent>) request.getAttribute("allEventsByUserId");
	List<AuditEvent> loginEventsByUserId = (List<AuditEvent>) request.getAttribute("loginEventsByUserId");
	List<AuditEvent> registrationEventsByUserId = (List<AuditEvent>) request.getAttribute("registrationEventsByUserId");
%>

<c:if test="${auditEventPermission.contains(permissionChecker, scopeGroupId, 'PERMISSIONS')}">
	<div class="portlet-header-style">
	   <h1><liferay-ui:message key="hi-admin" /></h1>

		<liferay-ui:icon-menu
			direction="right-side"
			icon="<%= StringPool.BLANK %>"
			markupView="lexicon"
			message="<%=StringPool.BLANK%>"
			showWhenSingleIcon="<%= true %>">
			<liferay-security:permissionsURL
				modelResource="com.liferay.portal.security.audit.storage.model"
				modelResourceDescription="{modelResourceDescription}"
				resourcePrimKey="${scopeGroupId}"
				var="permissionsURL"
				windowState="<%= LiferayWindowState.POP_UP.toString() %>" />
			<liferay-ui:icon
				method="get"
				message="permissions"
				url="${permissionsURL}"
				useDialog="<%= true %>" />
		</liferay-ui:icon-menu>
	</div>
</c:if>

<liferay-ui:tabs
	names="All, Login, Register"
	refresh="false"
	tabsValues="All, Login, Register">
	<liferay-ui:section>
		<c:choose>
			<c:when
				test="<%=permissionChecker.hasPermission(themeDisplay.getScopeGroupId(),
									ConstantsCommandNames.RESOURCE_NAME, themeDisplay.getScopeGroupId(), "VIEW_ALL")%>">

				<liferay-ui:search-container
					curParam="allCurParam"
					emptyResultsMessage="there-are-no-items"
					delta="20"
					deltaConfigurable="true"
					total="${allEvents.size()}">
					<liferay-ui:search-container-results
						results="<%=ListUtil.subList(allEvents, searchContainer.getStart(),
										searchContainer.getEnd())%>" />

					<liferay-ui:search-container-row
						className="com.liferay.portal.security.audit.storage.model.AuditEvent"
						modelVar="entry">

						<%@ include file="/audit-event/entry_column.jsp"%>
					</liferay-ui:search-container-row>

					<liferay-ui:search-iterator markupView="lexicon"/>
				</liferay-ui:search-container>
			</c:when>
			<c:when
				test="<%=permissionChecker.hasPermission(themeDisplay.getScopeGroupId(),
									ConstantsCommandNames.RESOURCE_NAME, themeDisplay.getScopeGroupId(),
									"VIEW_ONE_SIDE")%>">
				
				<liferay-ui:search-container
					curParam="allCurParam"
					emptyResultsMessage="there-are-no-items"
					delta="20"
					deltaConfigurable="true"
					total="${allEventsByUserId.size()}">
					<liferay-ui:search-container-results
						results="<%=ListUtil.subList(allEventsByUserId, searchContainer.getStart(),
										searchContainer.getEnd())%>" />

					<liferay-ui:search-container-row
						className="com.liferay.portal.security.audit.storage.model.AuditEvent"
						modelVar="entry">

						<%@ include file="/audit-event/entry_column.jsp"%>
					</liferay-ui:search-container-row>

                    <liferay-ui:search-iterator markupView="lexicon"/>
				</liferay-ui:search-container>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
	</liferay-ui:section>
    <liferay-ui:section>
        <c:choose>
            <c:when
                test="<%=permissionChecker.hasPermission(themeDisplay.getScopeGroupId(),
                                    ConstantsCommandNames.RESOURCE_NAME, themeDisplay.getScopeGroupId(), "VIEW_ALL")%>">

                <liferay-ui:search-container
                    curParam="allCurParam"
                    emptyResultsMessage="there-are-no-items"
                    delta="20"
                    deltaConfigurable="true"
                    total="${loginEvents.size()}">
					<liferay-ui:search-container-results
						results="<%=ListUtil.subList(loginEvents, searchContainer.getStart(),
										searchContainer.getEnd())%>" />

					<liferay-ui:search-container-row
                        className="com.liferay.portal.security.audit.storage.model.AuditEvent"
                        modelVar="entry">

                        <%@ include file="/audit-event/entry_column.jsp"%>
                    </liferay-ui:search-container-row>

                    <liferay-ui:search-iterator markupView="lexicon"/>
                </liferay-ui:search-container>
            </c:when>
            <c:when
                test="<%=permissionChecker.hasPermission(themeDisplay.getScopeGroupId(),
                                    ConstantsCommandNames.RESOURCE_NAME, themeDisplay.getScopeGroupId(),
                                    "VIEW_ONE_SIDE")%>">
                
                <liferay-ui:search-container
                    curParam="allCurParam"
                    emptyResultsMessage="there-are-no-items"
                    delta="20"
                    deltaConfigurable="true"
                    total="${loginEventsByUserId.size()}">
                    <liferay-ui:search-container-results
                        results="<%=ListUtil.subList(loginEventsByUserId, searchContainer.getStart(),
                                        searchContainer.getEnd())%>" />

                    <liferay-ui:search-container-row
                        className="com.liferay.portal.security.audit.storage.model.AuditEvent"
                        modelVar="entry">

                        <%@ include file="/audit-event/entry_column.jsp"%>
                    </liferay-ui:search-container-row>

                    <liferay-ui:search-iterator markupView="lexicon"/>
                </liferay-ui:search-container>
            </c:when>
            <c:otherwise>
            </c:otherwise>
        </c:choose>
    </liferay-ui:section>

    <liferay-ui:section>
        <c:choose>
            <c:when
                test="<%=permissionChecker.hasPermission(themeDisplay.getScopeGroupId(),
                                    ConstantsCommandNames.RESOURCE_NAME, themeDisplay.getScopeGroupId(), "VIEW_ALL")%>">

                <liferay-ui:search-container
                    curParam="allCurParam"
                    emptyResultsMessage="there-are-no-items"
                    delta="20"
                    deltaConfigurable="true"
                    total="${registrationEvents.size()}">
                    <liferay-ui:search-container-results
                        results="<%=ListUtil.subList(registrationEvents, searchContainer.getStart(),
                                        searchContainer.getEnd())%>" />

                    <liferay-ui:search-container-row
                        className="com.liferay.portal.security.audit.storage.model.AuditEvent"
                        modelVar="entry">

                        <%@ include file="/audit-event/entry_column.jsp"%>
                    </liferay-ui:search-container-row>

                    <liferay-ui:search-iterator markupView="lexicon"/>
                </liferay-ui:search-container>
            </c:when>
            <c:when
                test="<%=permissionChecker.hasPermission(themeDisplay.getScopeGroupId(),
                                    ConstantsCommandNames.RESOURCE_NAME, themeDisplay.getScopeGroupId(),
                                    "VIEW_ONE_SIDE")%>">
                
                <liferay-ui:search-container
                    curParam="allCurParam"
                    emptyResultsMessage="there-are-no-items"
                    delta="20"
                    deltaConfigurable="true"
                    total="${registrationEventsByUserId.size()}">
                    <liferay-ui:search-container-results
                        results="<%=ListUtil.subList(registrationEventsByUserId, searchContainer.getStart(),
                                        searchContainer.getEnd())%>" />

                    <liferay-ui:search-container-row
                        className="com.liferay.portal.security.audit.storage.model.AuditEvent"
                        modelVar="entry">

                        <%@ include file="/audit-event/entry_column.jsp"%>
                    </liferay-ui:search-container-row>

                    <liferay-ui:search-iterator markupView="lexicon"/>
                </liferay-ui:search-container>
            </c:when>
            <c:otherwise>
            </c:otherwise>
        </c:choose>
    </liferay-ui:section>
</liferay-ui:tabs>