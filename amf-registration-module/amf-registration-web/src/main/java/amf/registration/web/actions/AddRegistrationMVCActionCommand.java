package amf.registration.web.actions;

import amf.registration.web.constants.AmfRegistrationWebPortletKeys;
import amf.registration.web.constants.MVCCommandNames;

import com.liferay.amf.registration.exception.AddressValidationException;
import com.liferay.amf.registration.exception.UserCustomRegistrationValidationException;
import com.liferay.amf.registration.exception.UserRegistrationReminderQueryException;
import com.liferay.amf.registration.exception.UserRegistrationValidationException;
import com.liferay.amf.registration.service.UserCustomService;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.UserEmailAddressException;
import com.liferay.portal.kernel.exception.UserPasswordException;
import com.liferay.portal.kernel.exception.UserScreenNameException;
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
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + AmfRegistrationWebPortletKeys.AMF_REGISTRATIONWEB,
		"mvc.command.name=" + MVCCommandNames.ADD_REGISTRATION
	},
	service = MVCActionCommand.class
)
public class AddRegistrationMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			User.class.getName(), actionRequest);

		Group guestGroup = _groupLocalService.getGroup(
			themeDisplay.getCompanyId(), GroupConstants.GUEST);

		String first_name = ParamUtil.getString(
			actionRequest, "first_name"
		).trim();

		String last_name = ParamUtil.getString(
			actionRequest, "last_name"
		).trim();

		String email = ParamUtil.getString(
			actionRequest, "email_address"
		).trim();

		String username = ParamUtil.getString(
			actionRequest, "username"
		).trim();

		boolean male = ParamUtil.getBoolean(actionRequest, "male");

		String password1 = ParamUtil.getString(
			actionRequest, "password1"
		).trim();

		String password2 = ParamUtil.getString(
			actionRequest, "password2"
		).trim();

		String home_phone = ParamUtil.getString(
			actionRequest, "home_phone"
		).trim();

		String mobile_phone = ParamUtil.getString(
			actionRequest, "mobile_phone"
		).trim();

		boolean accepted_tou = ParamUtil.getBoolean(
			actionRequest, "accepted_tou");

		String security_answer = ParamUtil.getString(
			actionRequest, "security_answer"
		).trim();

		String security_question = ParamUtil.getString(
			actionRequest, "security_question"
		).trim();

		String birthday = ParamUtil.getString(
			actionRequest, "birthday"
		).trim();

		String[] b_birthday = birthday.split("-");

		int b_year = Integer.parseInt(b_birthday[0]);

		int b_month = Integer.parseInt(b_birthday[1]);

		int b_day = Integer.parseInt(b_birthday[2]);

		String address1 = ParamUtil.getString(
			actionRequest, "address1"
		).trim();

		String address2 = ParamUtil.getString(
			actionRequest, "address2"
		).trim();

		String city = ParamUtil.getString(
			actionRequest, "city"
		).trim();

		String state = ParamUtil.getString(
			actionRequest, "state"
		).trim();

		String zip = ParamUtil.getString(
			actionRequest, "zip"
		).trim();

		long facebookId = 0;

		String openId = StringPool.BLANK;

		long prefixId = 0;

		long suffixId = 0;

		long[] groupIds = {guestGroup.getGroupId()};

		long[] organizationIds = null;

		Role userRole = _roleLocalService.getRole(
			themeDisplay.getCompanyId(), RoleConstants.USER);

		long[] roleIds = {userRole.getRoleId()};

		long[] userGroupIds = null;

		long userId = _counterLocalService.increment(User.class.getName());

		try {

			// Call the service to add a a new user.

			_userLocalService.addUser(
				userId, themeDisplay.getCompanyId(), true, password1, password2,
				true, username, email, facebookId, openId,
				themeDisplay.getLocale(), first_name, "", last_name, prefixId,
				suffixId, male, b_month, b_day, b_year, "", groupIds,
				organizationIds, roleIds, userGroupIds, true, serviceContext);

			_addressLocalService.addAddress(
				userId, "", 0, address1, address2, "", city, zip, 0,
				themeDisplay.getCompanyId(), 0, true, true, serviceContext);

			_userCustomService.addUserCustom(
				guestGroup.getGroupId(), userId, male, home_phone, mobile_phone,
				serviceContext);

			User user = _userLocalService.getUserByEmailAddress(
				themeDisplay.getCompanyId(), email);

			_userLocalService.updateReminderQuery(
				user.getUserId(), security_question, security_answer);
		
			actionResponse.setRenderParameter(
					"mvcRenderCommandName", MVCCommandNames.VIEW_LOGGED);
		}
		catch (PortalException portalException) {
			if (portalException instanceof UserPasswordException ||
				portalException instanceof UserEmailAddressException ||
				portalException instanceof UserScreenNameException ||
				portalException instanceof
					UserRegistrationValidationException ||
				portalException instanceof
					UserRegistrationReminderQueryException ||
				portalException instanceof AddressValidationException ||
				portalException instanceof
					UserCustomRegistrationValidationException) {

				SessionErrors.add(
					actionRequest, portalException.getClass(), portalException);

				actionResponse.setRenderParameter(
					"mvcRenderCommandName", MVCCommandNames.VIEW_REGISTRATION);
			}
			else {
				throw portalException;
			}
		}
	}

	@Reference
	protected AddressLocalService _addressLocalService;

	@Reference
	protected CounterLocalService _counterLocalService;

	@Reference
	protected GroupLocalService _groupLocalService;

	@Reference
	protected RoleLocalService _roleLocalService;

	@Reference
	protected UserCustomService _userCustomService;

	@Reference
	protected UserLocalService _userLocalService;

}