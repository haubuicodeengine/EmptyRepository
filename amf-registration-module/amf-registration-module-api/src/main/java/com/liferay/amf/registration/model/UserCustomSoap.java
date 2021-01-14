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

package com.liferay.amf.registration.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.amf.registration.service.http.UserCustomServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserCustomSoap implements Serializable {

	public static UserCustomSoap toSoapModel(UserCustom model) {
		UserCustomSoap soapModel = new UserCustomSoap();

		soapModel.setUserCustomId(model.getUserCustomId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setMale(model.isMale());
		soapModel.setHomePhone(model.getHomePhone());
		soapModel.setMobilePhone(model.getMobilePhone());

		return soapModel;
	}

	public static UserCustomSoap[] toSoapModels(UserCustom[] models) {
		UserCustomSoap[] soapModels = new UserCustomSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserCustomSoap[][] toSoapModels(UserCustom[][] models) {
		UserCustomSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserCustomSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserCustomSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserCustomSoap[] toSoapModels(List<UserCustom> models) {
		List<UserCustomSoap> soapModels = new ArrayList<UserCustomSoap>(
			models.size());

		for (UserCustom model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserCustomSoap[soapModels.size()]);
	}

	public UserCustomSoap() {
	}

	public long getPrimaryKey() {
		return _userCustomId;
	}

	public void setPrimaryKey(long pk) {
		setUserCustomId(pk);
	}

	public long getUserCustomId() {
		return _userCustomId;
	}

	public void setUserCustomId(long userCustomId) {
		_userCustomId = userCustomId;
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

	public boolean getMale() {
		return _male;
	}

	public boolean isMale() {
		return _male;
	}

	public void setMale(boolean male) {
		_male = male;
	}

	public String getHomePhone() {
		return _homePhone;
	}

	public void setHomePhone(String homePhone) {
		_homePhone = homePhone;
	}

	public String getMobilePhone() {
		return _mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		_mobilePhone = mobilePhone;
	}

	private long _userCustomId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _male;
	private String _homePhone;
	private String _mobilePhone;

}