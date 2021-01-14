package amf.registration.web.actions;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import amf.registration.web.constants.AmfRegistrationWebPortletKeys;
import amf.registration.web.constants.MVCCommandNames;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + AmfRegistrationWebPortletKeys.AMF_REGISTRATIONWEB,
			"mvc.command.name=/",
			"mvc.command.name=" + MVCCommandNames.VIEW_LOGGED
		},
		service = MVCRenderCommand.class
	)
public class ViewLoggedMVCRender implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		return "/view-logged.jsp";
	}

}
