package com.liferay.amf.event.monitor.web.permission;

import com.liferay.amf.event.monitor.web.constants.AmfMonitorModelResourceKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;


public class AuditEventPermissionChecker {

    public static boolean hasPermission(Long groupId, PermissionChecker permissionChecker, String actionId) {

        return permissionChecker.hasPermission(groupId, AmfMonitorModelResourceKeys.AUDIT_MODEL, groupId, actionId);
    }

}
