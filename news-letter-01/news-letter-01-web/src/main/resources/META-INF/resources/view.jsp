<%@ include file="/init.jsp" %>

<div class="container-fluid-1280">
    <h1><liferay-ui:message key="newsLetters" /></h1>

    <%-- Clay management toolbar. --%>

    <clay:management-toolbar
        disabled="${courseCount eq 0}"
        displayContext="${newsLettersManagementToolbarDisplayContext}"
        itemsTotal="${courseCount}"
        searchContainerId="courseEntries"
        selectable="false"
    />

	<liferay-ui:search-container
	    curParam="allCurParam"
	    emptyResultsMessage="there-are-no-items"
	    delta="3"
	    deltaConfigurable="true"
	    total="${newsLetters.size()}">
	
	    <liferay-ui:search-container-results
	        results="${newsLetters}" />
	
	    <liferay-ui:search-container-row
	        className="com.liferay.training.news.letter.model.NewsLetter"
	        modelVar="entry">
	
	        <%@ include file="/newsletter/entry_search_columns.jspf"%>
	    </liferay-ui:search-container-row>
	
	    <liferay-ui:search-iterator displayStyle="${newsLettersManagementToolbarDisplayContext.getDisplayStyle()}" markupView="lexicon" />
	</liferay-ui:search-container>

</div> 