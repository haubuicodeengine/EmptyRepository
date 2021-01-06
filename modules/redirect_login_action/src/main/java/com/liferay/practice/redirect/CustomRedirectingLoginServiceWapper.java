package com.liferay.practice.redirect;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author ces-user
 */
@Component(immediate = true, property = { "key=login.events.post" }, service = LifecycleAction.class)
public class CustomRedirectingLoginServiceWapper implements LifecycleAction {

	private static Log _log = LogFactoryUtil.getLog(CustomRedirectingLoginServiceWapper.class.getClass());

	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {

		HttpServletRequest req = lifecycleEvent.getRequest();

		User user;

		try {

			user = PortalUtil.getUser(req);
			List<Role> roles = user.getRoles();
			HttpServletResponse resp = lifecycleEvent.getResponse();
			boolean isStaff = false;

			for (Role role : roles) {

				if (role.getName().equals("Staff")) {

					isStaff = true;
				}
			}

			if (isStaff == true) {

				resp.sendRedirect("/web/guest/course");
			} else {

				resp.sendRedirect("/web/guest/register");
			}
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}