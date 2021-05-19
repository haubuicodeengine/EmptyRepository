package com.liferay.amf.event.monitor.action;

import com.liferay.amf.event.monitor.constants.AmfEventMonitorWebPortletKeys;
import com.liferay.amf.event.monitor.resource.permission.AuditEventPermission;
import com.liferay.amf.event.monitor.util.AuditEventFinderImpl;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.audit.event.generators.constants.EventTypes;
import com.liferay.portal.security.audit.storage.model.AuditEvent;
import com.liferay.portal.security.audit.storage.service.AuditEventLocalService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true, 
	property = { 
		"javax.portlet.name=" + AmfEventMonitorWebPortletKeys.AMFEVENTMONITORWEB,
		"mvc.command.name=/", "mvc.command.name=" + "/" },
	service = MVCRenderCommand.class
)
public class ViewAmfEventMonitorRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		List<String> eventTypes = Arrays.asList(EventTypes.LOGIN, EventTypes.ADD);

		renderRequest.setAttribute("allEvents", _getAuditEventsByListEventType(eventTypes));

		renderRequest.setAttribute("registrationEvents",
				_auditEventFinderImpl.getAuditEventByEventType(EventTypes.ADD));

		renderRequest.setAttribute("loginEvents", _auditEventFinderImpl.getAuditEventByEventType(EventTypes.LOGIN));

		renderRequest.setAttribute("allEventsByUserId",
				_getAuditEventsByUserId(_getAuditEventsByListEventType(eventTypes), themeDisplay.getUserId()));

		renderRequest.setAttribute("registrationEventsByUserId", _getAuditEventsByUserId(
				_auditEventFinderImpl.getAuditEventByEventType(EventTypes.ADD), themeDisplay.getUserId()));

		renderRequest.setAttribute("loginEventsByUserId", _getAuditEventsByUserId(
				_auditEventFinderImpl.getAuditEventByEventType(EventTypes.LOGIN), themeDisplay.getUserId()));

		renderRequest.setAttribute("auditEventPermission", _auditEventPermission);

		return "/view.jsp";
	}

	private List<AuditEvent> _getAuditEventsByListEventType(List<String> eventTypes) {

		List<AuditEvent> auditEvents = new ArrayList<AuditEvent>();

		for (String eventType : eventTypes) {
			auditEvents.addAll(_auditEventFinderImpl.getAuditEventByEventType(eventType));
		}

		return auditEvents;
	}

	private List<AuditEvent> _getAuditEventsByUserId(List<AuditEvent> auditEventList, long userId) {

		List<AuditEvent> auditEvents = new ArrayList<AuditEvent>();

		for (AuditEvent auditEvent : auditEventList) {
			if (auditEvent.getUserId() == userId) {
				auditEvents.add(auditEvent);
			}
		}

		return auditEvents;
	}

	@Reference
	private AuditEventFinderImpl _auditEventFinderImpl;

	@Reference
	private AuditEventLocalService _auditEventLocalService;

	@Reference
	private AuditEventPermission _auditEventPermission;
}
