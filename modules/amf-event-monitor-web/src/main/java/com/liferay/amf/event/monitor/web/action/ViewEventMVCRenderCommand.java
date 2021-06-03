package com.liferay.amf.event.monitor.web.action;

import com.liferay.amf.event.monitor.web.constants.AmfMonitorPortletKeys;
import com.liferay.amf.event.monitor.web.constants.MVCCommandNames;
import com.liferay.amf.event.monitor.web.constants.ModelActionTypes;
import com.liferay.amf.event.monitor.web.permission.AuditEventPermissionChecker;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.audit.event.generators.constants.EventTypes;
import com.liferay.portal.security.audit.storage.model.AuditEvent;
import com.liferay.portal.security.audit.storage.service.AuditEventLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

@Component(immediate = true, property = {"javax.portlet.name=" + AmfMonitorPortletKeys.AMFMONITOR,
        "mvc.command.name=/", "mvc.command.name=" + MVCCommandNames.VIEW_ALL_EVENT}, service = MVCRenderCommand.class)
public class ViewEventMVCRenderCommand implements MVCRenderCommand {

    @Reference
    private AuditEventLocalService _auditEventLocalService;

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        boolean isAbleToViewAllAction = AuditEventPermissionChecker.hasPermission(themeDisplay.getScopeGroupId(), themeDisplay.getPermissionChecker(), ModelActionTypes.VIEW_ALL_ACTION);

        if (!isAbleToViewAllAction) {
            renderRequest.setAttribute("all", findByUser(ModelActionTypes.ALL, themeDisplay.getUserId()));

            renderRequest.setAttribute("registration", findByUser(EventTypes.ADD, themeDisplay.getUserId()));

            renderRequest.setAttribute("login", findByUser(EventTypes.LOGIN, themeDisplay.getUserId()));

        } else {
            renderRequest.setAttribute("all", findByAuditEventType(ModelActionTypes.ALL));

            renderRequest.setAttribute("registration", findByAuditEventType(EventTypes.ADD));

            renderRequest.setAttribute("login", findByAuditEventType(EventTypes.LOGIN));

        }

        return "/view.jsp";
    }

    public List<AuditEvent> findByAuditEventType(String auditEventType) {
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

    public List<AuditEvent> findByUser(String auditEventType, Long userId) {
        ClassLoader classLoader = getClass().getClassLoader();

        DynamicQuery entryQuery = null;

        List<AuditEvent> entries = new ArrayList<>();

        try {
            if (!auditEventType.equals(EventTypes.ADD) && !auditEventType.equals(EventTypes.LOGIN)) {

                entryQuery = DynamicQueryFactoryUtil.forClass(AuditEvent.class, classLoader).add(RestrictionsFactoryUtil.in("eventType", new String[]{EventTypes.ADD, EventTypes.LOGIN})).add(RestrictionsFactoryUtil.eq("userId", userId));

            } else {
                entryQuery = DynamicQueryFactoryUtil.forClass(AuditEvent.class, classLoader).add(RestrictionsFactoryUtil.eq("eventType", auditEventType)).add(RestrictionsFactoryUtil.eq("userId", userId));

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
}
