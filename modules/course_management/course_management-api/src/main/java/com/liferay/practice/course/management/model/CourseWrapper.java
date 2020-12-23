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

package com.liferay.practice.course.management.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Course}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Course
 * @generated
 */
public class CourseWrapper
	extends BaseModelWrapper<Course> implements Course, ModelWrapper<Course> {

	public CourseWrapper(Course course) {
		super(course);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("courseId", getCourseId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("courseName", getCourseName());
		attributes.put("lecturer", getLecturer());
		attributes.put("description", getDescription());
		attributes.put("duration", getDuration());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long courseId = (Long)attributes.get("courseId");

		if (courseId != null) {
			setCourseId(courseId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String courseName = (String)attributes.get("courseName");

		if (courseName != null) {
			setCourseName(courseName);
		}

		String lecturer = (String)attributes.get("lecturer");

		if (lecturer != null) {
			setLecturer(lecturer);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String duration = (String)attributes.get("duration");

		if (duration != null) {
			setDuration(duration);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this course.
	 *
	 * @return the company ID of this course
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the course ID of this course.
	 *
	 * @return the course ID of this course
	 */
	@Override
	public long getCourseId() {
		return model.getCourseId();
	}

	/**
	 * Returns the course name of this course.
	 *
	 * @return the course name of this course
	 */
	@Override
	public String getCourseName() {
		return model.getCourseName();
	}

	/**
	 * Returns the localized course name of this course in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized course name of this course
	 */
	@Override
	public String getCourseName(java.util.Locale locale) {
		return model.getCourseName(locale);
	}

	/**
	 * Returns the localized course name of this course in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized course name of this course. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getCourseName(java.util.Locale locale, boolean useDefault) {
		return model.getCourseName(locale, useDefault);
	}

	/**
	 * Returns the localized course name of this course in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized course name of this course
	 */
	@Override
	public String getCourseName(String languageId) {
		return model.getCourseName(languageId);
	}

	/**
	 * Returns the localized course name of this course in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized course name of this course
	 */
	@Override
	public String getCourseName(String languageId, boolean useDefault) {
		return model.getCourseName(languageId, useDefault);
	}

	@Override
	public String getCourseNameCurrentLanguageId() {
		return model.getCourseNameCurrentLanguageId();
	}

	@Override
	public String getCourseNameCurrentValue() {
		return model.getCourseNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized course names of this course.
	 *
	 * @return the locales and localized course names of this course
	 */
	@Override
	public Map<java.util.Locale, String> getCourseNameMap() {
		return model.getCourseNameMap();
	}

	/**
	 * Returns the create date of this course.
	 *
	 * @return the create date of this course
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the description of this course.
	 *
	 * @return the description of this course
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the localized description of this course in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this course
	 */
	@Override
	public String getDescription(java.util.Locale locale) {
		return model.getDescription(locale);
	}

	/**
	 * Returns the localized description of this course in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this course. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDescription(java.util.Locale locale, boolean useDefault) {
		return model.getDescription(locale, useDefault);
	}

	/**
	 * Returns the localized description of this course in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this course
	 */
	@Override
	public String getDescription(String languageId) {
		return model.getDescription(languageId);
	}

	/**
	 * Returns the localized description of this course in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this course
	 */
	@Override
	public String getDescription(String languageId, boolean useDefault) {
		return model.getDescription(languageId, useDefault);
	}

	@Override
	public String getDescriptionCurrentLanguageId() {
		return model.getDescriptionCurrentLanguageId();
	}

	@Override
	public String getDescriptionCurrentValue() {
		return model.getDescriptionCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized descriptions of this course.
	 *
	 * @return the locales and localized descriptions of this course
	 */
	@Override
	public Map<java.util.Locale, String> getDescriptionMap() {
		return model.getDescriptionMap();
	}

	/**
	 * Returns the duration of this course.
	 *
	 * @return the duration of this course
	 */
	@Override
	public String getDuration() {
		return model.getDuration();
	}

	/**
	 * Returns the localized duration of this course in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized duration of this course
	 */
	@Override
	public String getDuration(java.util.Locale locale) {
		return model.getDuration(locale);
	}

	/**
	 * Returns the localized duration of this course in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized duration of this course. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDuration(java.util.Locale locale, boolean useDefault) {
		return model.getDuration(locale, useDefault);
	}

	/**
	 * Returns the localized duration of this course in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized duration of this course
	 */
	@Override
	public String getDuration(String languageId) {
		return model.getDuration(languageId);
	}

	/**
	 * Returns the localized duration of this course in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized duration of this course
	 */
	@Override
	public String getDuration(String languageId, boolean useDefault) {
		return model.getDuration(languageId, useDefault);
	}

	@Override
	public String getDurationCurrentLanguageId() {
		return model.getDurationCurrentLanguageId();
	}

	@Override
	public String getDurationCurrentValue() {
		return model.getDurationCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized durations of this course.
	 *
	 * @return the locales and localized durations of this course
	 */
	@Override
	public Map<java.util.Locale, String> getDurationMap() {
		return model.getDurationMap();
	}

	/**
	 * Returns the group ID of this course.
	 *
	 * @return the group ID of this course
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the lecturer of this course.
	 *
	 * @return the lecturer of this course
	 */
	@Override
	public String getLecturer() {
		return model.getLecturer();
	}

	/**
	 * Returns the localized lecturer of this course in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized lecturer of this course
	 */
	@Override
	public String getLecturer(java.util.Locale locale) {
		return model.getLecturer(locale);
	}

	/**
	 * Returns the localized lecturer of this course in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized lecturer of this course. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getLecturer(java.util.Locale locale, boolean useDefault) {
		return model.getLecturer(locale, useDefault);
	}

	/**
	 * Returns the localized lecturer of this course in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized lecturer of this course
	 */
	@Override
	public String getLecturer(String languageId) {
		return model.getLecturer(languageId);
	}

	/**
	 * Returns the localized lecturer of this course in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized lecturer of this course
	 */
	@Override
	public String getLecturer(String languageId, boolean useDefault) {
		return model.getLecturer(languageId, useDefault);
	}

	@Override
	public String getLecturerCurrentLanguageId() {
		return model.getLecturerCurrentLanguageId();
	}

	@Override
	public String getLecturerCurrentValue() {
		return model.getLecturerCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized lecturers of this course.
	 *
	 * @return the locales and localized lecturers of this course
	 */
	@Override
	public Map<java.util.Locale, String> getLecturerMap() {
		return model.getLecturerMap();
	}

	/**
	 * Returns the modified date of this course.
	 *
	 * @return the modified date of this course
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this course.
	 *
	 * @return the primary key of this course
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this course.
	 *
	 * @return the user ID of this course
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this course.
	 *
	 * @return the user name of this course
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this course.
	 *
	 * @return the user uuid of this course
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
			java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	/**
	 * Sets the company ID of this course.
	 *
	 * @param companyId the company ID of this course
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the course ID of this course.
	 *
	 * @param courseId the course ID of this course
	 */
	@Override
	public void setCourseId(long courseId) {
		model.setCourseId(courseId);
	}

	/**
	 * Sets the course name of this course.
	 *
	 * @param courseName the course name of this course
	 */
	@Override
	public void setCourseName(String courseName) {
		model.setCourseName(courseName);
	}

	/**
	 * Sets the localized course name of this course in the language.
	 *
	 * @param courseName the localized course name of this course
	 * @param locale the locale of the language
	 */
	@Override
	public void setCourseName(String courseName, java.util.Locale locale) {
		model.setCourseName(courseName, locale);
	}

	/**
	 * Sets the localized course name of this course in the language, and sets the default locale.
	 *
	 * @param courseName the localized course name of this course
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setCourseName(
		String courseName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setCourseName(courseName, locale, defaultLocale);
	}

	@Override
	public void setCourseNameCurrentLanguageId(String languageId) {
		model.setCourseNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized course names of this course from the map of locales and localized course names.
	 *
	 * @param courseNameMap the locales and localized course names of this course
	 */
	@Override
	public void setCourseNameMap(Map<java.util.Locale, String> courseNameMap) {
		model.setCourseNameMap(courseNameMap);
	}

	/**
	 * Sets the localized course names of this course from the map of locales and localized course names, and sets the default locale.
	 *
	 * @param courseNameMap the locales and localized course names of this course
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setCourseNameMap(
		Map<java.util.Locale, String> courseNameMap,
		java.util.Locale defaultLocale) {

		model.setCourseNameMap(courseNameMap, defaultLocale);
	}

	/**
	 * Sets the create date of this course.
	 *
	 * @param createDate the create date of this course
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this course.
	 *
	 * @param description the description of this course
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the localized description of this course in the language.
	 *
	 * @param description the localized description of this course
	 * @param locale the locale of the language
	 */
	@Override
	public void setDescription(String description, java.util.Locale locale) {
		model.setDescription(description, locale);
	}

	/**
	 * Sets the localized description of this course in the language, and sets the default locale.
	 *
	 * @param description the localized description of this course
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescription(
		String description, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setDescription(description, locale, defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(String languageId) {
		model.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized descriptions of this course from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this course
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap) {

		model.setDescriptionMap(descriptionMap);
	}

	/**
	 * Sets the localized descriptions of this course from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this course
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap,
		java.util.Locale defaultLocale) {

		model.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	 * Sets the duration of this course.
	 *
	 * @param duration the duration of this course
	 */
	@Override
	public void setDuration(String duration) {
		model.setDuration(duration);
	}

	/**
	 * Sets the localized duration of this course in the language.
	 *
	 * @param duration the localized duration of this course
	 * @param locale the locale of the language
	 */
	@Override
	public void setDuration(String duration, java.util.Locale locale) {
		model.setDuration(duration, locale);
	}

	/**
	 * Sets the localized duration of this course in the language, and sets the default locale.
	 *
	 * @param duration the localized duration of this course
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDuration(
		String duration, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setDuration(duration, locale, defaultLocale);
	}

	@Override
	public void setDurationCurrentLanguageId(String languageId) {
		model.setDurationCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized durations of this course from the map of locales and localized durations.
	 *
	 * @param durationMap the locales and localized durations of this course
	 */
	@Override
	public void setDurationMap(Map<java.util.Locale, String> durationMap) {
		model.setDurationMap(durationMap);
	}

	/**
	 * Sets the localized durations of this course from the map of locales and localized durations, and sets the default locale.
	 *
	 * @param durationMap the locales and localized durations of this course
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDurationMap(
		Map<java.util.Locale, String> durationMap,
		java.util.Locale defaultLocale) {

		model.setDurationMap(durationMap, defaultLocale);
	}

	/**
	 * Sets the group ID of this course.
	 *
	 * @param groupId the group ID of this course
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the lecturer of this course.
	 *
	 * @param lecturer the lecturer of this course
	 */
	@Override
	public void setLecturer(String lecturer) {
		model.setLecturer(lecturer);
	}

	/**
	 * Sets the localized lecturer of this course in the language.
	 *
	 * @param lecturer the localized lecturer of this course
	 * @param locale the locale of the language
	 */
	@Override
	public void setLecturer(String lecturer, java.util.Locale locale) {
		model.setLecturer(lecturer, locale);
	}

	/**
	 * Sets the localized lecturer of this course in the language, and sets the default locale.
	 *
	 * @param lecturer the localized lecturer of this course
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setLecturer(
		String lecturer, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setLecturer(lecturer, locale, defaultLocale);
	}

	@Override
	public void setLecturerCurrentLanguageId(String languageId) {
		model.setLecturerCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized lecturers of this course from the map of locales and localized lecturers.
	 *
	 * @param lecturerMap the locales and localized lecturers of this course
	 */
	@Override
	public void setLecturerMap(Map<java.util.Locale, String> lecturerMap) {
		model.setLecturerMap(lecturerMap);
	}

	/**
	 * Sets the localized lecturers of this course from the map of locales and localized lecturers, and sets the default locale.
	 *
	 * @param lecturerMap the locales and localized lecturers of this course
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setLecturerMap(
		Map<java.util.Locale, String> lecturerMap,
		java.util.Locale defaultLocale) {

		model.setLecturerMap(lecturerMap, defaultLocale);
	}

	/**
	 * Sets the modified date of this course.
	 *
	 * @param modifiedDate the modified date of this course
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this course.
	 *
	 * @param primaryKey the primary key of this course
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this course.
	 *
	 * @param userId the user ID of this course
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this course.
	 *
	 * @param userName the user name of this course
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this course.
	 *
	 * @param userUuid the user uuid of this course
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected CourseWrapper wrap(Course course) {
		return new CourseWrapper(course);
	}

}