package com.liferay.amf.event.monitor.web.action;

import com.liferay.amf.event.monitor.web.constants.AmfMonitorPortletKeys;
import com.liferay.amf.event.monitor.web.constants.MVCCommandNames;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.security.audit.storage.model.AuditEvent;
import com.liferay.portal.security.audit.event.generators.constants.EventTypes;
import com.liferay.portal.security.audit.storage.service.AuditEventLocalService;
import com.liferay.portal.security.audit.storage.service.AuditEventLocalServiceUtil;
import com.liferay.portal.security.audit.storage.service.persistence.AuditEventPersistence;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

@Component(immediate = true, property = {"javax.portlet.name=" + AmfMonitorPortletKeys.AMFMONITOR,
        "mvc.command.name=/", "mvc.command.name=" + MVCCommandNames.VIEW_ALL_EVENT}, service = MVCRenderCommand.class)
public class ViewAllEventMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        renderRequest.setAttribute("all", findByAuditEvents(ALL));

        renderRequest.setAttribute("registration", findByAuditEvents(EventTypes.ADD));

        renderRequest.setAttribute("login", findByAuditEvents(EventTypes.LOGIN));

        return "/view.jsp";
    }

    public List<AuditEvent> findByAuditEvents(String auditEventType) {
        ClassLoader classLoader = getClass().getClassLoader();

        DynamicQuery entryQuery = null;

        List<AuditEvent> entries = new ArrayList<>();
        try {
            if (!auditEventType.equals(EventTypes.ADD) && !auditEventType.equals(EventTypes.LOGIN)) {
                entryQuery = DynamicQueryFactoryUtil.forClass(AuditEvent.class, classLoader).add(RestrictionsFactoryUtil.in("eventType", new String[]{EventTypes.ADD, EventTypes.LOGIN}));

            } else {
                entryQuery = DynamicQueryFactoryUtil.forClass(AuditEvent.class, classLoader).add(RestrictionsFactoryUtil.eq("eventType", auditEventType));

            }

            entries = _auditEventLocalService.dynamicQuery(entryQuery);
        } catch (Exception e) {
            try {
                throw new SystemException(e);
            } catch (SystemException se) {
                se.printStackTrace();
            }
        } finally {
            return entries;
        }
    }

    @Reference
    private AuditEventLocalService _auditEventLocalService;

    private final String ALL = "ALL";
}
