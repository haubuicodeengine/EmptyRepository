<%@ page import="com.liferay.portal.kernel.model.Address" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="com.liferay.portal.kernel.service.UserLocalService" %>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %>
<%@ include file="/init.jsp" %>

<%
    List<Address> addresses = (List<Address>) request.getAttribute("addresses");
%>

<p>Search results for ${usZip}</p>

<liferay-ui:search-container id="addresses"
                             emptyResultsMessage="no-result-found" delta="20"
                             deltaConfigurable="true">

    <liferay-ui:search-container-results>
        <%
            searchContainer.setTotal(addresses.size());
            searchContainer.setResults(ListUtil.subList(addresses, searchContainer.getStart(), searchContainer.getEnd()));
        %>
    </liferay-ui:search-container-results>

    <liferay-ui:search-container-row className="com.liferay.portal.kernel.model.Address"
                                     keyProperty="addressId" modelVar="line">
        <%
            Address result = (Address) row.getObject();
            User author = UserLocalServiceUtil.getUser(result.getUserId());
        %>

        <liferay-ui:search-container-column-text name="User Name" property="userName"/>
        <liferay-ui:search-container-column-text name="Screen Name" value="<%= author.getScreenName()%>"/>
        <liferay-ui:search-container-column-text name="Email" value="<%= author.getEmailAddress()%>"/>
        <liferay-ui:search-container-column-text name="Street 1" property="street1"/>

    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator
        markupView="lexicon"
        searchContainer="<%= searchContainer %>"/>
</liferay-ui:search-container>