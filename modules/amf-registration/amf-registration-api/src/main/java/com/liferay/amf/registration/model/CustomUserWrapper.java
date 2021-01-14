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
 * This class is a wrapper for {@link CustomUser}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomUser
 * @generated
 */
public class CustomUserWrapper
	extends BaseModelWrapper<CustomUser>
	implements CustomUser, ModelWrapper<CustomUser> {

	public CustomUserWrapper(CustomUser customUser) {
		super(customUser);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("customUserId", getCustomUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("home_phone", getHome_phone());
		attributes.put("mobile_phone", getMobile_phone());
		attributes.put("state", getState());
		attributes.put("security_question", getSecurity_question());
		attributes.put("security_answer", getSecurity_answer());
		attributes.put("accepted_tou", isAccepted_tou());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long customUserId = (Long)attributes.get("customUserId");

		if (customUserId != null) {
			setCustomUserId(customUserId);
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

		Integer home_phone = (Integer)attributes.get("home_phone");

		if (home_phone != null) {
			setHome_phone(home_phone);
		}

		Integer mobile_phone = (Integer)attributes.get("mobile_phone");

		if (mobile_phone != null) {
			setMobile_phone(mobile_phone);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String security_question = (String)attributes.get("security_question");

		if (security_question != null) {
			setSecurity_question(security_question);
		}

		String security_answer = (String)attributes.get("security_answer");

		if (security_answer != null) {
			setSecurity_answer(security_answer);
		}

		Boolean accepted_tou = (Boolean)attributes.get("accepted_tou");

		if (accepted_tou != null) {
			setAccepted_tou(accepted_tou);
		}
	}

	/**
	 * Returns the accepted_tou of this custom user.
	 *
	 * @return the accepted_tou of this custom user
	 */
	@Override
	public boolean getAccepted_tou() {
		return model.getAccepted_tou();
	}

	/**
	 * Returns the company ID of this custom user.
	 *
	 * @return the company ID of this custom user
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this custom user.
	 *
	 * @return the create date of this custom user
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the custom user ID of this custom user.
	 *
	 * @return the custom user ID of this custom user
	 */
	@Override
	public long getCustomUserId() {
		return model.getCustomUserId();
	}

	/**
	 * Returns the custom user uuid of this custom user.
	 *
	 * @return the custom user uuid of this custom user
	 */
	@Override
	public String getCustomUserUuid() {
		return model.getCustomUserUuid();
	}

	/**
	 * Returns the group ID of this custom user.
	 *
	 * @return the group ID of this custom user
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the home_phone of this custom user.
	 *
	 * @return the home_phone of this custom user
	 */
	@Override
	public int getHome_phone() {
		return model.getHome_phone();
	}

	/**
	 * Returns the mobile_phone of this custom user.
	 *
	 * @return the mobile_phone of this custom user
	 */
	@Override
	public int getMobile_phone() {
		return model.getMobile_phone();
	}

	/**
	 * Returns the modified date of this custom user.
	 *
	 * @return the modified date of this custom user
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this custom user.
	 *
	 * @return the primary key of this custom user
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the security_answer of this custom user.
	 *
	 * @return the security_answer of this custom user
	 */
	@Override
	public String getSecurity_answer() {
		return model.getSecurity_answer();
	}

	/**
	 * Returns the security_question of this custom user.
	 *
	 * @return the security_question of this custom user
	 */
	@Override
	public String getSecurity_question() {
		return model.getSecurity_question();
	}

	/**
	 * Returns the state of this custom user.
	 *
	 * @return the state of this custom user
	 */
	@Override
	public String getState() {
		return model.getState();
	}

	/**
	 * Returns the user ID of this custom user.
	 *
	 * @return the user ID of this custom user
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this custom user.
	 *
	 * @return the user name of this custom user
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this custom user.
	 *
	 * @return the user uuid of this custom user
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this custom user is accepted_tou.
	 *
	 * @return <code>true</code> if this custom user is accepted_tou; <code>false</code> otherwise
	 */
	@Override
	public boolean isAccepted_tou() {
		return model.isAccepted_tou();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this custom user is accepted_tou.
	 *
	 * @param accepted_tou the accepted_tou of this custom user
	 */
	@Override
	public void setAccepted_tou(boolean accepted_tou) {
		model.setAccepted_tou(accepted_tou);
	}

	/**
	 * Sets the company ID of this custom user.
	 *
	 * @param companyId the company ID of this custom user
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this custom user.
	 *
	 * @param createDate the create date of this custom user
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the custom user ID of this custom user.
	 *
	 * @param customUserId the custom user ID of this custom user
	 */
	@Override
	public void setCustomUserId(long customUserId) {
		model.setCustomUserId(customUserId);
	}

	/**
	 * Sets the custom user uuid of this custom user.
	 *
	 * @param customUserUuid the custom user uuid of this custom user
	 */
	@Override
	public void setCustomUserUuid(String customUserUuid) {
		model.setCustomUserUuid(customUserUuid);
	}

	/**
	 * Sets the group ID of this custom user.
	 *
	 * @param groupId the group ID of this custom user
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the home_phone of this custom user.
	 *
	 * @param home_phone the home_phone of this custom user
	 */
	@Override
	public void setHome_phone(int home_phone) {
		model.setHome_phone(home_phone);
	}

	/**
	 * Sets the mobile_phone of this custom user.
	 *
	 * @param mobile_phone the mobile_phone of this custom user
	 */
	@Override
	public void setMobile_phone(int mobile_phone) {
		model.setMobile_phone(mobile_phone);
	}

	/**
	 * Sets the modified date of this custom user.
	 *
	 * @param modifiedDate the modified date of this custom user
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this custom user.
	 *
	 * @param primaryKey the primary key of this custom user
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the security_answer of this custom user.
	 *
	 * @param security_answer the security_answer of this custom user
	 */
	@Override
	public void setSecurity_answer(String security_answer) {
		model.setSecurity_answer(security_answer);
	}

	/**
	 * Sets the security_question of this custom user.
	 *
	 * @param security_question the security_question of this custom user
	 */
	@Override
	public void setSecurity_question(String security_question) {
		model.setSecurity_question(security_question);
	}

	/**
	 * Sets the state of this custom user.
	 *
	 * @param state the state of this custom user
	 */
	@Override
	public void setState(String state) {
		model.setState(state);
	}

	/**
	 * Sets the user ID of this custom user.
	 *
	 * @param userId the user ID of this custom user
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this custom user.
	 *
	 * @param userName the user name of this custom user
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this custom user.
	 *
	 * @param userUuid the user uuid of this custom user
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected CustomUserWrapper wrap(CustomUser customUser) {
		return new CustomUserWrapper(customUser);
	}

}