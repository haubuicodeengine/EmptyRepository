package com.liferay.practice.course.management.portlet.action;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.practice.course.management.model.Course;
import com.liferay.practice.course.management.portlet.constants.CourseManagementMVCPortletKeys;
import com.liferay.practice.course.management.portlet.constants.MVCCommandNames;
import com.liferay.practice.course.management.portlet.display.context.CoursesManagementToolbarDisplayContext;
import com.liferay.practice.course.management.service.CourseService;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + CourseManagementMVCPortletKeys.COURSEMANAGEMENTMVC,
		"mvc.command.name=/", "mvc.command.name=" + MVCCommandNames.VIEW_COURSES }, service = MVCRenderCommand.class)
public class ViewCoursesMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		addCourseListAttributes(renderRequest);
		addManagementToolbarAttributes(renderRequest, renderResponse);

		return "/view.jsp";
	}

	private void addCourseListAttributes(RenderRequest renderRequest) {

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

		List<Course> courses = _courseService.getCoursesByKeywords(themeDisplay.getScopeGroupId(), keywords, start, end,
				comparator);

		renderRequest.setAttribute("courses", courses);
		renderRequest.setAttribute("courseCount",
				_courseService.getCoursesCountByKeywords(themeDisplay.getScopeGroupId(), keywords));
	}

	private void addManagementToolbarAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {

		LiferayPortletRequest liferayPortletRequest = _portal.getLiferayPortletRequest(renderRequest);

		LiferayPortletResponse liferayPortletResponse = _portal.getLiferayPortletResponse(renderResponse);

		CoursesManagementToolbarDisplayContext coursesManagementToolbarDisplayContext = new CoursesManagementToolbarDisplayContext(
				liferayPortletRequest, liferayPortletResponse, _portal.getHttpServletRequest(renderRequest));

		renderRequest.setAttribute("coursesManagementToolbarDisplayContext", coursesManagementToolbarDisplayContext);
	}

	@Reference
	protected CourseService _courseService;

	@Reference
	private Portal _portal;
}
