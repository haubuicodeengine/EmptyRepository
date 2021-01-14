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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserCustom}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserCustom
 * @generated
 */
public class UserCustomWrapper
	extends BaseModelWrapper<UserCustom>
	implements ModelWrapper<UserCustom>, UserCustom {

	public UserCustomWrapper(UserCustom userCustom) {
		super(userCustom);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userCustomId", getUserCustomId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("male", isMale());
		attributes.put("homePhone", getHomePhone());
		attributes.put("mobilePhone", getMobilePhone());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userCustomId = (Long)attributes.get("userCustomId");

		if (userCustomId != null) {
			setUserCustomId(userCustomId);
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

		Boolean male = (Boolean)attributes.get("male");

		if (male != null) {
			setMale(male);
		}

		String homePhone = (String)attributes.get("homePhone");

		if (homePhone != null) {
			setHomePhone(homePhone);
		}

		String mobilePhone = (String)attributes.get("mobilePhone");

		if (mobilePhone != null) {
			setMobilePhone(mobilePhone);
		}
	}

	/**
	 * Returns the company ID of this user custom.
	 *
	 * @return the company ID of this user custom
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this user custom.
	 *
	 * @return the create date of this user custom
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this user custom.
	 *
	 * @return the group ID of this user custom
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the home phone of this user custom.
	 *
	 * @return the home phone of this user custom
	 */
	@Override
	public String getHomePhone() {
		return model.getHomePhone();
	}

	/**
	 * Returns the male of this user custom.
	 *
	 * @return the male of this user custom
	 */
	@Override
	public boolean getMale() {
		return model.getMale();
	}

	/**
	 * Returns the mobile phone of this user custom.
	 *
	 * @return the mobile phone of this user custom
	 */
	@Override
	public String getMobilePhone() {
		return model.getMobilePhone();
	}

	/**
	 * Returns the modified date of this user custom.
	 *
	 * @return the modified date of this user custom
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this user custom.
	 *
	 * @return the primary key of this user custom
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user custom ID of this user custom.
	 *
	 * @return the user custom ID of this user custom
	 */
	@Override
	public long getUserCustomId() {
		return model.getUserCustomId();
	}

	/**
	 * Returns the user ID of this user custom.
	 *
	 * @return the user ID of this user custom
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this user custom.
	 *
	 * @return the user name of this user custom
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this user custom.
	 *
	 * @return the user uuid of this user custom
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this user custom is male.
	 *
	 * @return <code>true</code> if this user custom is male; <code>false</code> otherwise
	 */
	@Override
	public boolean isMale() {
		return model.isMale();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this user custom.
	 *
	 * @param companyId the company ID of this user custom
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this user custom.
	 *
	 * @param createDate the create date of this user custom
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this user custom.
	 *
	 * @param groupId the group ID of this user custom
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the home phone of this user custom.
	 *
	 * @param homePhone the home phone of this user custom
	 */
	@Override
	public void setHomePhone(String homePhone) {
		model.setHomePhone(homePhone);
	}

	/**
	 * Sets whether this user custom is male.
	 *
	 * @param male the male of this user custom
	 */
	@Override
	public void setMale(boolean male) {
		model.setMale(male);
	}

	/**
	 * Sets the mobile phone of this user custom.
	 *
	 * @param mobilePhone the mobile phone of this user custom
	 */
	@Override
	public void setMobilePhone(String mobilePhone) {
		model.setMobilePhone(mobilePhone);
	}

	/**
	 * Sets the modified date of this user custom.
	 *
	 * @param modifiedDate the modified date of this user custom
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this user custom.
	 *
	 * @param primaryKey the primary key of this user custom
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user custom ID of this user custom.
	 *
	 * @param userCustomId the user custom ID of this user custom
	 */
	@Override
	public void setUserCustomId(long userCustomId) {
		model.setUserCustomId(userCustomId);
	}

	/**
	 * Sets the user ID of this user custom.
	 *
	 * @param userId the user ID of this user custom
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this user custom.
	 *
	 * @param userName the user name of this user custom
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this user custom.
	 *
	 * @param userUuid the user uuid of this user custom
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected UserCustomWrapper wrap(UserCustom userCustom) {
		return new UserCustomWrapper(userCustom);
	}

}