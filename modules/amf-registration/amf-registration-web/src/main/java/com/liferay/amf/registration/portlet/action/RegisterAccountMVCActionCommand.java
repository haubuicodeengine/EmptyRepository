package com.liferay.amf.registration.portlet.action;

import com.liferay.amf.registration.exception.CustomUserValidationException.BlankFieldException;
import com.liferay.amf.registration.exception.CustomUserValidationException.FieldLengthException;
import com.liferay.amf.registration.exception.CustomUserValidationException.NumericValueException;
import com.liferay.amf.registration.portlet.constants.AMFRegistrationPortletKeys;
import com.liferay.amf.registration.portlet.constants.MVCCommandNames;
import com.liferay.amf.registration.service.CustomUserService;
import com.liferay.amf.registration.validator.RegistrationValidator;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.AddressLocalService;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(property = { "javax.portlet.name=" + AMFRegistrationPortletKeys.AMFREGISTRATION,
		"mvc.command.name=" + MVCCommandNames.ADD_USER }, service = MVCActionCommand.class)
public class RegisterAccountMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		Group guestGroup = _groupLocalService.getGroup(themeDisplay.getCompanyId(), GroupConstants.GUEST);

		String firstName = ParamUtil.getString(actionRequest, "first_name").trim();
		String lastName = ParamUtil.getString(actionRequest, "last_name").trim();
		String email = ParamUtil.getString(actionRequest, "email_address").trim();
		String password = ParamUtil.getString(actionRequest, "password1").trim();
		String confirmPassword = ParamUtil.getString(actionRequest, "password2").trim();
		String male_str = ParamUtil.getString(actionRequest, "male").trim();
		boolean male = Boolean.parseBoolean(male_str);
//		
//		String birthday = ParamUtil.getString(
//				actionRequest, "birthday"
//			).trim();
//
//		String[] b_birthday = birthday.split("-");
//
//		int b_year = Integer.parseInt(b_birthday[0]);
//
//		int b_month = Integer.parseInt(b_birthday[1]);
//
//		int b_day = Integer.parseInt(b_birthday[2]);
//			

		String username = ParamUtil.getString(actionRequest, "username").trim();
		String address1 = ParamUtil.getString(actionRequest, "address").trim();
		String address2 = ParamUtil.getString(actionRequest, "address2").trim();
		String city = ParamUtil.getString(actionRequest, "city").trim();
		String zip = ParamUtil.getString(actionRequest, "zip").trim();
		String security_question = ParamUtil.getString(actionRequest, "security_question").trim();
		String security_answer = ParamUtil.getString(actionRequest, "security_answer").trim();
		String state = ParamUtil.getString(actionRequest, "state").trim();
		String home_phone = ParamUtil.getString(actionRequest, "home_phone").trim();
		String mobile_phone = ParamUtil.getString(actionRequest, "mobile_phone").trim();
		String accepted_tou_str = ParamUtil.getString(actionRequest, "accepted_tou").trim();
		boolean accepted_tou = Boolean.parseBoolean(accepted_tou_str);
		ServiceContext serviceContext = new ServiceContext();
		serviceContext = ServiceContextThreadLocal.getServiceContext();
		long facebookId = 0;
		long prefixId = 0;
		long suffixId = 0;
		long[] groupIds = { guestGroup.getGroupId() };
		long[] organizationIds = null;
		Role userRole = _roleLocalService.getRole(themeDisplay.getCompanyId(), RoleConstants.USER);
		long[] roleIds = { userRole.getRoleId() };
		long[] userGroupIds = null;
		long companyId = PortalUtil.getDefaultCompanyId();
		Role adminRole = null;

		try {
			adminRole = _roleLocalService.getRole(companyId, "Administrator");
		} catch (PortalException pe) {
		    _log.error(pe);
			return;
		}

		List<User> adminUsers = _userLocalService.getRoleUsers(adminRole.getRoleId());
		long adminUserId = adminUsers.get(0).getUserId();

		try {

			_registrationValidator.validate(adminUserId, password, confirmPassword, username, email, firstName,
					lastName, 1, 1, 1997, address1, address2, city, zip, home_phone, mobile_phone, security_answer,
					accepted_tou);

			_userLocalService.addUser(adminUserId, themeDisplay.getCompanyId(), true, password, confirmPassword, true,
					username, email, facebookId, _openId, themeDisplay.getLocale(), firstName, "", lastName, prefixId,
					suffixId, male, 1, 1, 1974, "", groupIds, organizationIds, roleIds, userGroupIds, true,
					serviceContext);

			_addressLocalService.addAddress(adminUserId, null, 0, address1, address2, null, city, zip, 0, 0, 0, false,
					false, serviceContext);

			_customUserService.addCustomUser(themeDisplay.getScopeGroupId(), home_phone, mobile_phone, state,
					security_question, security_answer, accepted_tou, serviceContext);

			actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.LOGIN);

		} catch (PortalException portalException) {

			if (portalException instanceof FieldLengthException || portalException instanceof NumericValueException
					|| portalException instanceof BlankFieldException) {
				
				 _log.error(portalException);
				SessionErrors.add(actionRequest, portalException.getMessage(), portalException);
			} else {
				
				 _log.error(portalException);
				SessionErrors.add(actionRequest, portalException.getClass(), portalException);
			}
		}
	}

	private String _openId = StringPool.BLANK;
	
	private static Log _log = LogFactoryUtil.getLog(RegisterAccountMVCActionCommand.class);
	
	@Reference
	protected GroupLocalService _groupLocalService;

	@Reference
	protected CounterLocalService _counterLocalService;

	@Reference
	protected CustomUserService _customUserService;

	@Reference
	protected UserLocalService _userLocalService;

	@Reference
	protected RegistrationValidator _registrationValidator;

	@Reference
	protected AddressLocalService _addressLocalService;

	@Reference
	protected RoleLocalService _roleLocalService;
}