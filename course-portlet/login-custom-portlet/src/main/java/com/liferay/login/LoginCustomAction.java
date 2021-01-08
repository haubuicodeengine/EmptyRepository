package com.liferay.login;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true, property = {"key=login.events.post"},
	service = LifecycleAction.class
)
public class LoginCustomAction implements LifecycleAction {

	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent)
		throws ActionException {

		HttpServletRequest request = lifecycleEvent.getRequest();

		HttpServletResponse response = lifecycleEvent.getResponse();

		try {
			User user = PortalUtil.getUser(request);

			for (Role role : user.getRoles()) {

				if (role.getName().equals("Staff") || role.getName().equals("Administrator")) {

					response.sendRedirect("/courses");

					break;
				}

				if (role.getName().equals("User")) {
					response.sendRedirect("/register");

					break;
				}
			}
		}
		catch (IOException | PortalException e) {
			e.printStackTrace();
		}
	}

}