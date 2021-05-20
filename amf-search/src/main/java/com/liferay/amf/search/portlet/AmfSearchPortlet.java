package com.liferay.amf.search.portlet;

import com.liferay.amf.search.constants.AmfSearchPortletKeys;
import com.liferay.amf.search.validator.AmfSearchValidation;
import com.liferay.amf.search.validator.exception.AmfSearchValidationException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletSession;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author ces-user
 */
@Component(
	immediate = true, 
	property = { 
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", 
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AmfSearch", 
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp", 
		"javax.portlet.name=" + AmfSearchPortletKeys.AMFSEARCH,
		"javax.portlet.resource-bundle=content.Language", 
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.private-session-attributes=false" }, 
	service = Portlet.class
)
public class AmfSearchPortlet extends MVCPortlet {

	public void sendData(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, PortalException {

		String zipCode = ParamUtil.getString(actionRequest, "zipCode").trim();

		try {
			_amfSearchValidation.validate(zipCode);

			PortletSession portletSession = actionRequest.getPortletSession();

			portletSession.setAttribute("zipCode", zipCode, PortletSession.APPLICATION_SCOPE);

		} catch (PortalException portalException) {

			if (portalException instanceof AmfSearchValidationException) {

				SessionErrors.add(actionRequest, portalException.getClass(), portalException);

			} else {
				throw portalException;
			}

		}
	}

	@Reference
	private AmfSearchValidation _amfSearchValidation;

}