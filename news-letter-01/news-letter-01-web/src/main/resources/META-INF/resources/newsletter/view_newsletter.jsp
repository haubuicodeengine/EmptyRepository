<%@ include file="/init.jsp"%>

<div class="container-fluid-1280">
    <h1>${newsletter.getTitle()}</h1>

    <h2>
        <liferay-ui:message key="newsletter-information" />
    </h2>

    <div>
        <dl>
            <dt>
                <liferay-ui:message key="created" />
            </dt>
            <dd>${createDate}</dd>

            <dt>
                <liferay-ui:message key="title" />
            </dt>
            <dd>${newsletter.title}</dd>

            <dt>
                <liferay-ui:message key="issueNumber" />
            </dt>
            <dd>${newsletter.issueNumber}</dd>

            <dt>
                <liferay-ui:message key="description" />
            </dt>
            <dd>${newsletter.getDescription()}</dd>
        </dl>
    </div>
</div>