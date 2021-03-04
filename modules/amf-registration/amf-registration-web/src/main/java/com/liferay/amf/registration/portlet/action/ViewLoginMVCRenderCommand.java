package com.liferay.amf.registration.portlet.action;

import com.liferay.amf.registration.portlet.constants.AMFRegistrationPortletKeys;
import com.liferay.amf.registration.portlet.constants.MVCCommandNames;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "javax.portlet.name=" + AMFRegistrationPortletKeys.AMFREGISTRATION,
"mvc.command.name=" + MVCCommandNames.LOGIN }, service = MVCRenderCommand.class)
public class ViewLoginMVCRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		return "/login.jsp";
	}

}
