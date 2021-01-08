package com.liferay.practice.course.management.approval.portlet.action;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.practice.course.management.approval.portlet.constants.ApprovalRegistrationPortletKeys;
import com.liferay.practice.course.management.approval.portlet.constants.MVCCommandNames;
import com.liferay.practice.course.management.model.Course;
import com.liferay.practice.course.management.model.Registration;
import com.liferay.practice.course.management.service.CourseService;
import com.liferay.practice.course.management.service.RegistrationService;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + ApprovalRegistrationPortletKeys.APPROVALREGISTRATION,
		"mvc.command.name=/", "mvc.command.name=" + MVCCommandNames.VIEW_COURSES }, service = MVCRenderCommand.class)
public class ViewCoursesMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		ServiceContext serviceContext = null;

		try {

			serviceContext = ServiceContextFactory.getInstance(Registration.class.getName(), renderRequest);
		} catch (PortalException e) {

			_log.error(e);
		}

		long userId = serviceContext.getUserId();
		addCourseListAttributes(renderRequest, userId);

		return "/view.jsp";
	}

	private void addCourseListAttributes(RenderRequest renderRequest, long userId) {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_CUR);

		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,
				SearchContainer.DEFAULT_DELTA);

		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = start + delta;

		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "courseName");
		String orderByType = ParamUtil.getString(renderRequest, "orderByType", "asc");

		OrderByComparator<Course> comparator = OrderByComparatorFactoryUtil.create("Course", orderByCol,
				!("asc").equals(orderByType));

		String keywords = ParamUtil.getString(renderRequest, "keywords");

		List<Long> yourCourses = _courseService.getListCourseByUserId(userId);
		List<Registration> registrations = _registrationService.getListRegistration();

		List<Course> visibleCourses = new ArrayList<>();
		List<Registration> visibleRegistration = new ArrayList<>();

		for (Registration registration : registrations) {

			long courseId = registration.getCourseId();

			if (yourCourses.contains(courseId) && registration.getRegistrationStatus() == 0) {

				Course course = null;

				try {

					course = _courseService.getCourse(courseId);
				} catch (Exception e) {
					// TODO Auto-generated catch block  ERROR PAGE
					e.printStackTrace();
				}
				if (course == null) {
					System.out.println("null object course");
				} else {
					visibleCourses.add(course);
					visibleRegistration.add(registration);
				}
			}
		}

		renderRequest.setAttribute("registrations", visibleRegistration);
		renderRequest.setAttribute("courses", visibleCourses);
		renderRequest.setAttribute("courseCount",
				_courseService.getCoursesCountByKeywords(themeDisplay.getScopeGroupId(), keywords));
	}

	@Reference
	protected CourseService _courseService;

	@Reference
	protected RegistrationService _registrationService;

	@Reference
	private Portal _portal;

	private static Log _log = LogFactoryUtil.getLog(ViewCoursesMVCRenderCommand.class);
}
