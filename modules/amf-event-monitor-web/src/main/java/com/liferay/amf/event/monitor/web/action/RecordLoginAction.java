package com.liferay.portal.security.audit.event.generators.internal.events;

import com.liferay.portal.kernel.audit.AuditMessage;
import com.liferay.portal.kernel.audit.AuditRouter;
import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.security.audit.event.generators.constants.EventTypes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Bruno Farache
 * @author Mika Koivisto
 * @author Brian Wing Shun Chan
 */
@Component(
        immediate = true, property = "key=login.events.post",
        service = LifecycleAction.class
)
public class RecordLoginAction extends Action {

    @Override
    public void run(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse)
            throws ActionException {

        try {
            doRun(httpServletRequest, httpServletResponse);
        } catch (Exception exception) {
            throw new ActionException(exception);
        }
    }

    protected void doRun(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse)
            throws Exception {

        User user = _portal.getUser(httpServletRequest);

        AuditMessage auditMessage = new AuditMessage(
                EventTypes.LOGIN, user.getCompanyId(), user.getUserId(),
                user.getFullName(), User.class.getName(),
                String.valueOf(user.getUserId()));

        _auditRouter.route(auditMessage);
    }

    @Reference
    private AuditRouter _auditRouter;

    @Reference
    private Portal _portal;

}