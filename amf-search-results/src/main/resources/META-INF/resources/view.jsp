<%@ include file="/init.jsp"%>

<%
	List<User> users = (List<User>) request.getAttribute("users");
%>
<div>
	<b><liferay-ui:message key="search-result-for" /> ${zipCode}</b>
</div>

<liferay-ui:search-container
	curParam="allCurParam"
	emptyResultsMessage="there-are-no-items"
	delta="3"
	deltaConfigurable="true"
	total="${users.size()}">

	<liferay-ui:search-container-results
		results="<%=ListUtil.subList(users, searchContainer.getStart(), searchContainer.getEnd())%>" />

	<liferay-ui:search-container-row
		className="com.liferay.portal.kernel.model.User"
		modelVar="entry">

		<%@ include file="/entry_column.jsp"%>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator markupView="lexicon" />
</liferay-ui:search-container>