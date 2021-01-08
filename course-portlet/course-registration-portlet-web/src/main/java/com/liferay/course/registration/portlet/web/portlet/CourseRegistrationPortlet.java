package com.liferay.course.registration.portlet.web.portlet;

import com.liferay.course.registration.portlet.web.constants.CourseRegistrationPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"javax.portlet.display-name=CourseRegister",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CourseRegistrationPortletKeys.COURSE_REGISTRATION,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.display-category=course.registration",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.init-param.add-process-action-success-action=false"
	},
	service = Portlet.class
)
public class CourseRegistrationPortlet extends MVCPortlet {
}