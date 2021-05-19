package com.liferay.amf.event.monitor.resource.permission;

import com.liferay.amf.event.monitor.constants.ConstantsCommandNames;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true,
    service= AuditEventPermission.class
)
public class AuditEventPermission {

    public static void check(PermissionChecker permissionChecker, long groupId, String actionId) throws PortalException {
        if(!contains(permissionChecker, groupId, actionId)) {
            throw new PrincipalException();
        }
    }

    public static boolean contains(
            PermissionChecker permissionChecker, long groupId, String actionId) {

        return permissionChecker.hasPermission(
                groupId, ConstantsCommandNames.RESOURCE_NAME, groupId, actionId);
    }

}