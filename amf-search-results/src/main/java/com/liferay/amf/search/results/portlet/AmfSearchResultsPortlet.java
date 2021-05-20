package com.liferay.amf.search.results.portlet;

import com.liferay.amf.search.results.constants.AmfSearchResultsPortletKeys;
import com.liferay.amf.search.results.util.AmfSearchUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

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
		"javax.portlet.display-name=AmfSearchResults", 
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AmfSearchResultsPortletKeys.AMFSEARCHRESULTS,
		"javax.portlet.resource-bundle=content.Language", 
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.private-session-attributes=false"

	}, 
	service = Portlet.class
)
public class AmfSearchResultsPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		PortletSession portletSession = renderRequest.getPortletSession();

		String zipCode = (String) portletSession.getAttribute("zipCode", PortletSession.APPLICATION_SCOPE);

		List<User> users;
		try {

			users = _amfSearchUtil.getUsersByaddresss(_amfSearchUtil.getAddressByZipCode(zipCode, true));

			renderRequest.setAttribute("zipCode", zipCode);

			renderRequest.setAttribute("users", users);

		} catch (PortalException e) {
			e.printStackTrace();
		}

		super.doView(renderRequest, renderResponse);
	}

	@Reference
	private AmfSearchUtil _amfSearchUtil;

}
