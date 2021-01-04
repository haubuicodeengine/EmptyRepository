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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.practice.course.management.service.http.RegistrationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RegistrationSoap implements Serializable {

	public static RegistrationSoap toSoapModel(Registration model) {
		RegistrationSoap soapModel = new RegistrationSoap();

		soapModel.setRegistrationId(model.getRegistrationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCourseId(model.getCourseId());
		soapModel.setRegistrationStatus(model.getRegistrationStatus());

		return soapModel;
	}

	public static RegistrationSoap[] toSoapModels(Registration[] models) {
		RegistrationSoap[] soapModels = new RegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RegistrationSoap[][] toSoapModels(Registration[][] models) {
		RegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RegistrationSoap[] toSoapModels(List<Registration> models) {
		List<RegistrationSoap> soapModels = new ArrayList<RegistrationSoap>(
			models.size());

		for (Registration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RegistrationSoap[soapModels.size()]);
	}

	public RegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _registrationId;
	}

	public void setPrimaryKey(long pk) {
		setRegistrationId(pk);
	}

	public long getRegistrationId() {
		return _registrationId;
	}

	public void setRegistrationId(long registrationId) {
		_registrationId = registrationId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getCourseId() {
		return _courseId;
	}

	public void setCourseId(long courseId) {
		_courseId = courseId;
	}

	public int getRegistrationStatus() {
		return _registrationStatus;
	}

	public void setRegistrationStatus(int registrationStatus) {
		_registrationStatus = registrationStatus;
	}

	private long _registrationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _courseId;
	private int _registrationStatus;

}