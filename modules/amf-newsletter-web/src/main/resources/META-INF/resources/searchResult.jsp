<%@ include file="./init.jsp" %>
<%
    List<JournalArticle> issues = (List<JournalArticle>) request.getAttribute("issues");
%>

<div class="amf-newsletter-web">
    <div class="closed container-fluid-1280 sidenav-container sidenav-right" id="<portlet:namespace />infoPanelId">

        <%@ include file="/search.jsp" %>

        <liferay-ui:search-container id="searchResult"
                                     emptyResultsMessage="no-result-found" delta="5"
                                     deltaConfigurable="true">

            <liferay-ui:search-container-results>
                <%
                    searchContainer.setTotal(issues.size());
                    searchContainer.setResults(ListUtil.subList(issues, searchContainer.getStart(), searchContainer.getEnd()));

                %>
            </liferay-ui:search-container-results>

            <liferay-ui:search-container-row className="com.liferay.journal.model.JournalArticle"
                                             keyProperty="resourcePrimKey" modelVar="line">
                <%
                    JournalArticle issue = (JournalArticle) row.getObject();

                    String issueNumber = NewsletterLocalServiceUtil.getJournalArticleContent(issue.getDDMStructure(), issue.getContent(), "issueNumber");

                    String issueDate = NewsletterLocalServiceUtil.getJournalArticleContent(issue.getDDMStructure(), issue.getContent(), "issueDate");

                    String issueTitle = NewsletterLocalServiceUtil.getJournalArticleContent(issue.getDDMStructure(), issue.getContent(), "title");
                %>

                <c:if test="<%= !issueNumber.equals(null) %>">
                    <portlet:renderURL var="rowURL">
                        <portlet:param name="issueId" value="<%=issueNumber%>"/>
                        <portlet:param name="mvcRenderCommandName" value="<%= MVCCommandNames.VIEW_ISSUE %>"/>
                    </portlet:renderURL>


                    <div class="issue-block">
                        <div>
                            <label class="search-key-text"><liferay-ui:message key="search-results-for"/></label> <label class="search-key-text search-key-color"> ${keywords} </label>
                        </div>


                        <label class="issue-date">
                            <liferay-ui:message key='issue-x-y'
                                                arguments='<%= new String[] { issueNumber , issueDate }%>'/>
                        </label>
                        <div class="issue-title">
                            <a href="${rowURL}"><%=issueTitle%>
                            </a>
                        </div>
                    </div>

                </c:if>

            </liferay-ui:search-container-row>
            <liferay-ui:search-iterator
                    markupView="lexicon"
                    searchContainer="<%= searchContainer %>"/>
        </liferay-ui:search-container>
    </div>
</div>
