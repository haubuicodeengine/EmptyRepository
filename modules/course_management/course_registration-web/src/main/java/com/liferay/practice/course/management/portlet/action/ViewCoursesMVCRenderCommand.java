package com.liferay.practice.course.management.portlet.action;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.practice.course.management.model.Course;
import com.liferay.practice.course.management.registration.portlet.constants.CourseRegistrationMVCPortletKeys;
import com.liferay.practice.course.management.registration.portlet.constants.MVCCommandNames;
import com.liferay.practice.course.management.service.CourseService;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + CourseRegistrationMVCPortletKeys.COURSEREGISTRATIONMVC,
		"mvc.command.name=/", "mvc.command.name=" + MVCCommandNames.VIEW_COURSES }, service = MVCRenderCommand.class)
public class ViewCoursesMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		addCourseListAttributes(renderRequest);

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
		
		List<Course> visibleCourses = new ArrayList<>();

		for (Course course : courses) {

			if(course.getCourseStatus() == 1) {

				visibleCourses.add(course);
			}
		}

		renderRequest.setAttribute("courses", visibleCourses);
		renderRequest.setAttribute("courseCount",
				_courseService.getCoursesCountByKeywords(themeDisplay.getScopeGroupId(), keywords));

	}

	@Reference
	protected CourseService _courseService;

	@Reference
	private Portal _portal;
}
