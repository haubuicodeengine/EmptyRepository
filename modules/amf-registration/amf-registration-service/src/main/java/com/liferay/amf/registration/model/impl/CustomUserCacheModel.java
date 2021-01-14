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

package com.liferay.amf.registration.model.impl;

import com.liferay.amf.registration.model.CustomUser;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CustomUser in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CustomUserCacheModel
	implements CacheModel<CustomUser>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CustomUserCacheModel)) {
			return false;
		}

		CustomUserCacheModel customUserCacheModel = (CustomUserCacheModel)obj;

		if (customUserId == customUserCacheModel.customUserId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, customUserId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{customUserId=");
		sb.append(customUserId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", home_phone=");
		sb.append(home_phone);
		sb.append(", mobile_phone=");
		sb.append(mobile_phone);
		sb.append(", state=");
		sb.append(state);
		sb.append(", security_question=");
		sb.append(security_question);
		sb.append(", security_answer=");
		sb.append(security_answer);
		sb.append(", accepted_tou=");
		sb.append(accepted_tou);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CustomUser toEntityModel() {
		CustomUserImpl customUserImpl = new CustomUserImpl();

		customUserImpl.setCustomUserId(customUserId);
		customUserImpl.setGroupId(groupId);
		customUserImpl.setCompanyId(companyId);
		customUserImpl.setUserId(userId);

		if (userName == null) {
			customUserImpl.setUserName("");
		}
		else {
			customUserImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			customUserImpl.setCreateDate(null);
		}
		else {
			customUserImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			customUserImpl.setModifiedDate(null);
		}
		else {
			customUserImpl.setModifiedDate(new Date(modifiedDate));
		}

		customUserImpl.setHome_phone(home_phone);
		customUserImpl.setMobile_phone(mobile_phone);

		if (state == null) {
			customUserImpl.setState("");
		}
		else {
			customUserImpl.setState(state);
		}

		if (security_question == null) {
			customUserImpl.setSecurity_question("");
		}
		else {
			customUserImpl.setSecurity_question(security_question);
		}

		if (security_answer == null) {
			customUserImpl.setSecurity_answer("");
		}
		else {
			customUserImpl.setSecurity_answer(security_answer);
		}

		customUserImpl.setAccepted_tou(accepted_tou);

		customUserImpl.resetOriginalValues();

		return customUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		customUserId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		home_phone = objectInput.readInt();

		mobile_phone = objectInput.readInt();
		state = objectInput.readUTF();
		security_question = objectInput.readUTF();
		security_answer = objectInput.readUTF();

		accepted_tou = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(customUserId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(home_phone);

		objectOutput.writeInt(mobile_phone);

		if (state == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(state);
		}

		if (security_question == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(security_question);
		}

		if (security_answer == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(security_answer);
		}

		objectOutput.writeBoolean(accepted_tou);
	}

	public long customUserId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int home_phone;
	public int mobile_phone;
	public String state;
	public String security_question;
	public String security_answer;
	public boolean accepted_tou;

}