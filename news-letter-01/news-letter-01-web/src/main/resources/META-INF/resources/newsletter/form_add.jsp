<%@ include file="/init.jsp"%>

<liferay-ui:error exception="<%= NewsLetterValidationException.IssueNumberMustNotBeNull.class %>" message="error.issue-number-empty" />
<liferay-ui:error exception="<%= NewsLetterValidationException.TitleMustNotBeNull.class %>" message="error.title-empty" />
<liferay-ui:error exception="<%= NewsLetterValidationException.DescriptionMustNotBeNull.class %>" message="error.description-empty" />
<liferay-ui:error exception="<%= NewsLetterValidationException.IssueNumberMustBeANumber.class %>" message="error.issue-number-not-a-number" />
<liferay-ui:error exception="<%= NewsLetterValidationException.IssueNumberMustNotBeDuplicate.class %>" message="error.issue-number-not-be-duplicate" />

<c:choose>
    <c:when test="${not empty newsletter}">
        <portlet:actionURL var="newsletterActionURL" name="<%=MVCCommandNames.EDIT_NEWSLETTER%>">
            <portlet:param name="redirect" value="${param.redirect}" />
        </portlet:actionURL>
        <c:set var="editNewsletterName" value="edit-newsletter" />
    </c:when>
    <c:otherwise>
        <portlet:actionURL var="newsletterActionURL" name="<%=MVCCommandNames.ADD_NEWSLETTER%>">
            <portlet:param name="redirect" value="${param.redirect}" />
        </portlet:actionURL>
        <c:set var="editNewsletterName" value="add-newsletter" />
    </c:otherwise>
</c:choose>

<div class="container-fluid-1280 edit-newsletter">
    <h1>
        <liferay-ui:message key="${editNewsletterName}" />
    </h1>

    <aui:model-context bean="${newsletter}" model="${newsletterClass}" />

    <aui:form action="${newsletterActionURL}" name="fm">

        <aui:input name="newsletterId" field="newsletterId" type="hidden"/>

        <aui:fieldset-group markupView="lexicon">
            <aui:fieldset>
                <aui:input name="issueNumber" label="text-input-issue-number" type="text">
                    <aui:validator name="required" errorMessage="ui-validate-issue-number-empty" />
                </aui:input>
                
                 <aui:input name="title" type="text">
                    <aui:validator name="required" errorMessage="ui-validate-title-empty" />               
                </aui:input>

                <aui:input name="description" type="text">
                    <aui:validator name="required" errorMessage="ui-validate-description-empty" />               
                </aui:input>
                               
                <label for="newsletter-articles"><liferay-ui:message key="newsletter-articles"/></label>
                <c:forEach items="${journalArticles}" var="articles">
                     <aui:input type="checkbox" name="articlesIds" value="${articles.id}" label="${articles.title}" checked="${articlesSelected.contains(articles.id) ? 'true' : 'false'}"  />
                </c:forEach>

            </aui:fieldset>
        </aui:fieldset-group>

        <aui:button-row>
            <aui:button cssClass="btn btn-primary" type="submit" />
            <aui:button cssClass="btn btn-secondary" onClick="${param.redirect}" type="cancel" />
        </aui:button-row>
    </aui:form>

</div>