package com.liferay.practice.course.management.approval.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.practice.course.management.approval.portlet.constants.ApprovalRegistrationPortletKeys;
import com.liferay.practice.course.management.approval.portlet.constants.MVCCommandNames;
import com.liferay.practice.course.management.service.RegistrationService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + ApprovalRegistrationPortletKeys.APPROVALREGISTRATION,
		"mvc.command.name=" + MVCCommandNames.RESPONSE_COURSE_REGISTRATION }, service = MVCActionCommand.class)
public class ResponseRegistrationMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		long registrationId = ParamUtil.getLong(actionRequest, "registrationId");

		String responseType = ParamUtil.getString(actionRequest, "responseType");

		int status = 0;

		if (responseType.contentEquals("reject")) {

			status = 2;
		} else {

			status = 1;
		}
		_registrationService.updateRegistrationStatus(registrationId, status);
	}

	@Reference
	protected RegistrationService _registrationService;
}
