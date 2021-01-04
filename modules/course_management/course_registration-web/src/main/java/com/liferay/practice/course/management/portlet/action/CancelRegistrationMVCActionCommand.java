package com.liferay.practice.course.management.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.practice.course.management.registration.portlet.constants.CourseRegistrationMVCPortletKeys;
import com.liferay.practice.course.management.registration.portlet.constants.MVCCommandNames;
import com.liferay.practice.course.management.service.RegistrationService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { 
		"javax.portlet.name=" + CourseRegistrationMVCPortletKeys.COURSEREGISTRATIONMVC,
		"mvc.command.name=" + MVCCommandNames.CANCEL_REGISTER_COURSE }, 
service = MVCActionCommand.class)
public class CancelRegistrationMVCActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		long registrationId = ParamUtil.getLong(actionRequest, "registrationId");

		_registrationService.deleteRegistration(registrationId);
	}

	@Reference
	protected RegistrationService _registrationService;
}
