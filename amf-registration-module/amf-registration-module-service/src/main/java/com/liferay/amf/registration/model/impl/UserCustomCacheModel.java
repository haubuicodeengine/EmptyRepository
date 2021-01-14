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

import com.liferay.amf.registration.model.UserCustom;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserCustom in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserCustomCacheModel
	implements CacheModel<UserCustom>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserCustomCacheModel)) {
			return false;
		}

		UserCustomCacheModel userCustomCacheModel = (UserCustomCacheModel)obj;

		if (userCustomId == userCustomCacheModel.userCustomId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userCustomId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{userCustomId=");
		sb.append(userCustomId);
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
		sb.append(", male=");
		sb.append(male);
		sb.append(", homePhone=");
		sb.append(homePhone);
		sb.append(", mobilePhone=");
		sb.append(mobilePhone);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserCustom toEntityModel() {
		UserCustomImpl userCustomImpl = new UserCustomImpl();

		userCustomImpl.setUserCustomId(userCustomId);
		userCustomImpl.setGroupId(groupId);
		userCustomImpl.setCompanyId(companyId);
		userCustomImpl.setUserId(userId);

		if (userName == null) {
			userCustomImpl.setUserName("");
		}
		else {
			userCustomImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			userCustomImpl.setCreateDate(null);
		}
		else {
			userCustomImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			userCustomImpl.setModifiedDate(null);
		}
		else {
			userCustomImpl.setModifiedDate(new Date(modifiedDate));
		}

		userCustomImpl.setMale(male);

		if (homePhone == null) {
			userCustomImpl.setHomePhone("");
		}
		else {
			userCustomImpl.setHomePhone(homePhone);
		}

		if (mobilePhone == null) {
			userCustomImpl.setMobilePhone("");
		}
		else {
			userCustomImpl.setMobilePhone(mobilePhone);
		}

		userCustomImpl.resetOriginalValues();

		return userCustomImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userCustomId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		male = objectInput.readBoolean();
		homePhone = objectInput.readUTF();
		mobilePhone = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(userCustomId);

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

		objectOutput.writeBoolean(male);

		if (homePhone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(homePhone);
		}

		if (mobilePhone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mobilePhone);
		}
	}

	public long userCustomId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean male;
	public String homePhone;
	public String mobilePhone;

}