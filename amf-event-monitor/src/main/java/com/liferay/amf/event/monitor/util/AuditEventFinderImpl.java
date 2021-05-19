package com.liferay.amf.event.monitor.util;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.security.audit.storage.model.AuditEvent;
import com.liferay.portal.security.audit.storage.service.AuditEventLocalService;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	service = AuditEventFinderImpl.class, 
	immediate = true
)
public class AuditEventFinderImpl {

	public List<AuditEvent> getAuditEvents() {

		DynamicQuery auditEventsQuery = auditEventLocalService.dynamicQuery();

		return auditEventLocalService.dynamicQuery(auditEventsQuery);
	}

	public List<AuditEvent> getAuditEventByEventType(String eventType) {

		Order order = OrderFactoryUtil.desc("createDate");

		DynamicQuery auditEventsQuery = auditEventLocalService.dynamicQuery()
				.add(RestrictionsFactoryUtil.eq("eventType", eventType)).addOrder(order);

		return auditEventLocalService.dynamicQuery(auditEventsQuery);
	}

	@Reference
	AuditEventLocalService auditEventLocalService;
}
