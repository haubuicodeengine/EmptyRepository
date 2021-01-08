package com.liferay.course.registration.approval.portlet;

import com.liferay.course.registration.approval.constants.RegistrationApprovalPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author ces-user
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"javax.portlet.display-name=RegistrationApproval",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + RegistrationApprovalPortletKeys.REGISTRATION_APPROVAL,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.display-category=course.registration-approval",
		"javax.portlet.init-param.add-process-action-success-action=false"
	},
	service = Portlet.class
)
public class RegistrationApprovalPortlet extends MVCPortlet {
}