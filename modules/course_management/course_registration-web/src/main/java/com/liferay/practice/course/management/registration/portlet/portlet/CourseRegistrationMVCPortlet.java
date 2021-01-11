package com.liferay.practice.course.management.registration.portlet.portlet;

import com.liferay.practice.course.management.registration.portlet.constants.CourseRegistrationMVCPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author ces-user
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CourseRegistrationMVC", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CourseRegistrationMVCPortletKeys.COURSEREGISTRATIONMVC,
		"javax.portlet.resource-bundle=content.Language", "javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.display-category=category.test",
		"com.liferay.portlet.instanceable=false" }, service = Portlet.class)
public class CourseRegistrationMVCPortlet extends MVCPortlet {
}