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
 * This class is used by SOAP remote services, specifically {@link com.liferay.amf.registration.service.http.CustomUserServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CustomUserSoap implements Serializable {

	public static CustomUserSoap toSoapModel(CustomUser model) {
		CustomUserSoap soapModel = new CustomUserSoap();

		soapModel.setCustomUserId(model.getCustomUserId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setHome_phone(model.getHome_phone());
		soapModel.setMobile_phone(model.getMobile_phone());
		soapModel.setState(model.getState());
		soapModel.setSecurity_question(model.getSecurity_question());
		soapModel.setSecurity_answer(model.getSecurity_answer());
		soapModel.setAccepted_tou(model.isAccepted_tou());

		return soapModel;
	}

	public static CustomUserSoap[] toSoapModels(CustomUser[] models) {
		CustomUserSoap[] soapModels = new CustomUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CustomUserSoap[][] toSoapModels(CustomUser[][] models) {
		CustomUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CustomUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CustomUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CustomUserSoap[] toSoapModels(List<CustomUser> models) {
		List<CustomUserSoap> soapModels = new ArrayList<CustomUserSoap>(
			models.size());

		for (CustomUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CustomUserSoap[soapModels.size()]);
	}

	public CustomUserSoap() {
	}

	public long getPrimaryKey() {
		return _customUserId;
	}

	public void setPrimaryKey(long pk) {
		setCustomUserId(pk);
	}

	public long getCustomUserId() {
		return _customUserId;
	}

	public void setCustomUserId(long customUserId) {
		_customUserId = customUserId;
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

	public int getHome_phone() {
		return _home_phone;
	}

	public void setHome_phone(int home_phone) {
		_home_phone = home_phone;
	}

	public int getMobile_phone() {
		return _mobile_phone;
	}

	public void setMobile_phone(int mobile_phone) {
		_mobile_phone = mobile_phone;
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
	}

	public String getSecurity_question() {
		return _security_question;
	}

	public void setSecurity_question(String security_question) {
		_security_question = security_question;
	}

	public String getSecurity_answer() {
		return _security_answer;
	}

	public void setSecurity_answer(String security_answer) {
		_security_answer = security_answer;
	}

	public boolean getAccepted_tou() {
		return _accepted_tou;
	}

	public boolean isAccepted_tou() {
		return _accepted_tou;
	}

	public void setAccepted_tou(boolean accepted_tou) {
		_accepted_tou = accepted_tou;
	}

	private long _customUserId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _home_phone;
	private int _mobile_phone;
	private String _state;
	private String _security_question;
	private String _security_answer;
	private boolean _accepted_tou;

}