<%@ include file="/init.jsp"%>

<%

String primKey = themeDisplay.getPlid() + LiferayPortletSession.LAYOUT_SEPARATOR  + themeDisplay.getPortletDisplay().getId();

%>

<liferay-ui:error
	exception="<%=AmfSearchValidationException.ZipCodeMustBe5Digits.class%>"
	message="error.zip-code-must-be-5-digits" />
<liferay-ui:error
	exception="<%=AmfSearchValidationException.ZipCodeMustNotBeNull.class%>"
	message="error.zip-code-cannot-be-null" />

<portlet:actionURL
	name="sendData"
	var="sendData">
	<portlet:param
		name="redirect"
		value="${param.redirect}" />
</portlet:actionURL>

<aui:form
	action="${sendData}"
	name="<portlet:namespace />fm">

	<aui:fieldset>
		<aui:input name="zipCode" label="text-input-zip-code">
            <aui:validator name="required" />
            <aui:validator name="number" />
		</aui:input>
	</aui:fieldset>

	<div>
		<aui:button-row>
			<c:choose>
				<c:when
					test="<%=permissionChecker.hasPermission(scopeGroupId, AmfSearchPortletKeys.AMFSEARCH, primKey,
									"SEARCH_BY_ZIPCODE")%>">
                    <aui:button type="submit" value="Search"></aui:button>
				</c:when>
				<c:otherwise>
                    <aui:button type="submit" value="Search" disabled="true"></aui:button>
				</c:otherwise>
			</c:choose>
			
		</aui:button-row>
	</div>
</aui:form>
