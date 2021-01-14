package amf.registration.web.actions;

import amf.registration.web.constants.AmfRegistrationWebPortletKeys;
import amf.registration.web.constants.MVCCommandNames;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserService;

import java.util.Random;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + AmfRegistrationWebPortletKeys.AMF_REGISTRATIONWEB,
		"mvc.command.name=/",
		"mvc.command.name=" + MVCCommandNames.VIEW_REGISTRATION
	},
	service = MVCRenderCommand.class
)
public class ViewRegistrationFormMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		addListAttributes(renderRequest);

		return "/view.jsp";
	}

	@Reference
	protected UserService _userService;

	private void addListAttributes(RenderRequest renderRequest) {
		String[] Reminderquestions = {
			"What is your mother's maidenname?",
			"What is the make of your firstcar?",
			"What is your high schoolmascot?", "Who is your favorite actor?"
		};

		String termsOfUseText =
			"I have read, understand, and agree with the Terms of Use governing myaccess to and use of the Acme Movie Fanatics web site";

		renderRequest.setAttribute(
			"questionRender", getRandom(Reminderquestions));

		renderRequest.setAttribute("termsOfUseText", termsOfUseText);
	}

	private String getRandom(String[] array) {
		return array[new Random().nextInt(array.length)];
	}

}