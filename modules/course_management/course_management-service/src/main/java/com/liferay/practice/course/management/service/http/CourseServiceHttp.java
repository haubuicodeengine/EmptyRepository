/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.practice.course.management.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.practice.course.management.service.CourseServiceUtil;

/**
 * Provides the HTTP utility for the <code>CourseServiceUtil</code> service
 * utility. The static methods of this class calls the same methods of the
 * service utility. However, the signatures are different because it requires an
 * additional <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CourseServiceSoap
 * @generated
 */
public class CourseServiceHttp {

	public static com.liferay.practice.course.management.model.Course addCourse(HttpPrincipal httpPrincipal,
			long groupId, java.util.Map<java.util.Locale, String> courseNameMap,
			java.util.Map<java.util.Locale, String> descriptionMap, java.util.Map<java.util.Locale, String> lecturerMap,
			java.util.Map<java.util.Locale, String> durationMap,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(CourseServiceUtil.class, "addCourse", _addCourseParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId, courseNameMap, descriptionMap,
					lecturerMap, durationMap, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				if (exception instanceof com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException) exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.liferay.practice.course.management.model.Course) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.practice.course.management.model.Course deleteCourse(HttpPrincipal httpPrincipal,
			long courseId) throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(CourseServiceUtil.class, "deleteCourse", _deleteCourseParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, courseId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				if (exception instanceof com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException) exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.liferay.practice.course.management.model.Course) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.practice.course.management.model.Course getCourse(HttpPrincipal httpPrincipal,
			long courseId) throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(CourseServiceUtil.class, "getCourse", _getCourseParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, courseId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				if (exception instanceof com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException) exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.liferay.practice.course.management.model.Course) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.practice.course.management.model.Course> getCoursesByGroupId(
			HttpPrincipal httpPrincipal, long groupId) {

		try {
			MethodKey methodKey = new MethodKey(CourseServiceUtil.class, "getCoursesByGroupId",
					_getCoursesByGroupIdParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (java.util.List<com.liferay.practice.course.management.model.Course>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.practice.course.management.model.Course> getCoursesByKeywords(
			HttpPrincipal httpPrincipal, long groupId, String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<com.liferay.practice.course.management.model.Course> orderByComparator) {

		try {
			MethodKey methodKey = new MethodKey(CourseServiceUtil.class, "getCoursesByKeywords",
					_getCoursesByKeywordsParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId, keywords, start, end,
					orderByComparator);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (java.util.List<com.liferay.practice.course.management.model.Course>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static long getCoursesCountByKeywords(HttpPrincipal httpPrincipal, long groupId, String keywords) {

		try {
			MethodKey methodKey = new MethodKey(CourseServiceUtil.class, "getCoursesCountByKeywords",
					_getCoursesCountByKeywordsParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId, keywords);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return ((Long) returnObj).longValue();
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.practice.course.management.model.Course updateCourse(HttpPrincipal httpPrincipal,
			long courseId, java.util.Map<java.util.Locale, String> courseNameMap,
			java.util.Map<java.util.Locale, String> descriptionMap, java.util.Map<java.util.Locale, String> lecturerMap,
			java.util.Map<java.util.Locale, String> durationMap,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(CourseServiceUtil.class, "updateCourse", _updateCourseParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey, courseId, courseNameMap, descriptionMap,
					lecturerMap, durationMap, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				if (exception instanceof com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException) exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.liferay.practice.course.management.model.Course) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(CourseServiceHttp.class);

	private static final Class<?>[] _addCourseParameterTypes0 = new Class[] { long.class, java.util.Map.class,
			java.util.Map.class, java.util.Map.class, java.util.Map.class,
			com.liferay.portal.kernel.service.ServiceContext.class };
	private static final Class<?>[] _deleteCourseParameterTypes1 = new Class[] { long.class };
	private static final Class<?>[] _getCourseParameterTypes2 = new Class[] { long.class };
	private static final Class<?>[] _getCoursesByGroupIdParameterTypes3 = new Class[] { long.class };
	private static final Class<?>[] _getCoursesByKeywordsParameterTypes4 = new Class[] { long.class, String.class,
			int.class, int.class, com.liferay.portal.kernel.util.OrderByComparator.class };
	private static final Class<?>[] _getCoursesCountByKeywordsParameterTypes5 = new Class[] { long.class,
			String.class };
	private static final Class<?>[] _updateCourseParameterTypes6 = new Class[] { long.class, java.util.Map.class,
			java.util.Map.class, java.util.Map.class, java.util.Map.class,
			com.liferay.portal.kernel.service.ServiceContext.class };

}