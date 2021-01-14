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
import com.liferay.amf.registration.model.CustomUserModel;
import com.liferay.amf.registration.model.CustomUserSoap;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the CustomUser service. Represents a row in the &quot;AMFRegistration_CustomUser&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CustomUserModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CustomUserImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomUserImpl
 * @generated
 */
@JSON(strict = true)
public class CustomUserModelImpl
	extends BaseModelImpl<CustomUser> implements CustomUserModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a custom user model instance should use the <code>CustomUser</code> interface instead.
	 */
	public static final String TABLE_NAME = "AMFRegistration_CustomUser";

	public static final Object[][] TABLE_COLUMNS = {
		{"customUserId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"home_phone", Types.INTEGER},
		{"mobile_phone", Types.INTEGER}, {"state_", Types.VARCHAR},
		{"security_question", Types.VARCHAR},
		{"security_answer", Types.VARCHAR}, {"accepted_tou", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("customUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("home_phone", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("mobile_phone", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("state_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("security_question", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("security_answer", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("accepted_tou", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table AMFRegistration_CustomUser (customUserId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,home_phone INTEGER,mobile_phone INTEGER,state_ VARCHAR(75) null,security_question VARCHAR(75) null,security_answer VARCHAR(75) null,accepted_tou BOOLEAN)";

	public static final String TABLE_SQL_DROP =
		"drop table AMFRegistration_CustomUser";

	public static final String ORDER_BY_JPQL =
		" ORDER BY customUser.customUserId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY AMFRegistration_CustomUser.customUserId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long GROUPID_COLUMN_BITMASK = 1L;

	public static final long CUSTOMUSERID_COLUMN_BITMASK = 2L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CustomUser toModel(CustomUserSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CustomUser model = new CustomUserImpl();

		model.setCustomUserId(soapModel.getCustomUserId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setHome_phone(soapModel.getHome_phone());
		model.setMobile_phone(soapModel.getMobile_phone());
		model.setState(soapModel.getState());
		model.setSecurity_question(soapModel.getSecurity_question());
		model.setSecurity_answer(soapModel.getSecurity_answer());
		model.setAccepted_tou(soapModel.isAccepted_tou());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CustomUser> toModels(CustomUserSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CustomUser> models = new ArrayList<CustomUser>(soapModels.length);

		for (CustomUserSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public CustomUserModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _customUserId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCustomUserId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _customUserId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CustomUser.class;
	}

	@Override
	public String getModelClassName() {
		return CustomUser.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CustomUser, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CustomUser, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CustomUser, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((CustomUser)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CustomUser, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CustomUser, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CustomUser)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CustomUser, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CustomUser, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CustomUser>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CustomUser.class.getClassLoader(), CustomUser.class,
			ModelWrapper.class);

		try {
			Constructor<CustomUser> constructor =
				(Constructor<CustomUser>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<CustomUser, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CustomUser, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CustomUser, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<CustomUser, Object>>();
		Map<String, BiConsumer<CustomUser, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<CustomUser, ?>>();

		attributeGetterFunctions.put(
			"customUserId", CustomUser::getCustomUserId);
		attributeSetterBiConsumers.put(
			"customUserId",
			(BiConsumer<CustomUser, Long>)CustomUser::setCustomUserId);
		attributeGetterFunctions.put("groupId", CustomUser::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<CustomUser, Long>)CustomUser::setGroupId);
		attributeGetterFunctions.put("companyId", CustomUser::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<CustomUser, Long>)CustomUser::setCompanyId);
		attributeGetterFunctions.put("userId", CustomUser::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<CustomUser, Long>)CustomUser::setUserId);
		attributeGetterFunctions.put("userName", CustomUser::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<CustomUser, String>)CustomUser::setUserName);
		attributeGetterFunctions.put("createDate", CustomUser::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<CustomUser, Date>)CustomUser::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", CustomUser::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<CustomUser, Date>)CustomUser::setModifiedDate);
		attributeGetterFunctions.put("home_phone", CustomUser::getHome_phone);
		attributeSetterBiConsumers.put(
			"home_phone",
			(BiConsumer<CustomUser, Integer>)CustomUser::setHome_phone);
		attributeGetterFunctions.put(
			"mobile_phone", CustomUser::getMobile_phone);
		attributeSetterBiConsumers.put(
			"mobile_phone",
			(BiConsumer<CustomUser, Integer>)CustomUser::setMobile_phone);
		attributeGetterFunctions.put("state", CustomUser::getState);
		attributeSetterBiConsumers.put(
			"state", (BiConsumer<CustomUser, String>)CustomUser::setState);
		attributeGetterFunctions.put(
			"security_question", CustomUser::getSecurity_question);
		attributeSetterBiConsumers.put(
			"security_question",
			(BiConsumer<CustomUser, String>)CustomUser::setSecurity_question);
		attributeGetterFunctions.put(
			"security_answer", CustomUser::getSecurity_answer);
		attributeSetterBiConsumers.put(
			"security_answer",
			(BiConsumer<CustomUser, String>)CustomUser::setSecurity_answer);
		attributeGetterFunctions.put(
			"accepted_tou", CustomUser::getAccepted_tou);
		attributeSetterBiConsumers.put(
			"accepted_tou",
			(BiConsumer<CustomUser, Boolean>)CustomUser::setAccepted_tou);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getCustomUserId() {
		return _customUserId;
	}

	@Override
	public void setCustomUserId(long customUserId) {
		_customUserId = customUserId;
	}

	@Override
	public String getCustomUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getCustomUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setCustomUserUuid(String customUserUuid) {
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public int getHome_phone() {
		return _home_phone;
	}

	@Override
	public void setHome_phone(int home_phone) {
		_home_phone = home_phone;
	}

	@JSON
	@Override
	public int getMobile_phone() {
		return _mobile_phone;
	}

	@Override
	public void setMobile_phone(int mobile_phone) {
		_mobile_phone = mobile_phone;
	}

	@JSON
	@Override
	public String getState() {
		if (_state == null) {
			return "";
		}
		else {
			return _state;
		}
	}

	@Override
	public void setState(String state) {
		_state = state;
	}

	@JSON
	@Override
	public String getSecurity_question() {
		if (_security_question == null) {
			return "";
		}
		else {
			return _security_question;
		}
	}

	@Override
	public void setSecurity_question(String security_question) {
		_security_question = security_question;
	}

	@JSON
	@Override
	public String getSecurity_answer() {
		if (_security_answer == null) {
			return "";
		}
		else {
			return _security_answer;
		}
	}

	@Override
	public void setSecurity_answer(String security_answer) {
		_security_answer = security_answer;
	}

	@JSON
	@Override
	public boolean getAccepted_tou() {
		return _accepted_tou;
	}

	@JSON
	@Override
	public boolean isAccepted_tou() {
		return _accepted_tou;
	}

	@Override
	public void setAccepted_tou(boolean accepted_tou) {
		_accepted_tou = accepted_tou;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), CustomUser.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CustomUser toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CustomUser>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CustomUserImpl customUserImpl = new CustomUserImpl();

		customUserImpl.setCustomUserId(getCustomUserId());
		customUserImpl.setGroupId(getGroupId());
		customUserImpl.setCompanyId(getCompanyId());
		customUserImpl.setUserId(getUserId());
		customUserImpl.setUserName(getUserName());
		customUserImpl.setCreateDate(getCreateDate());
		customUserImpl.setModifiedDate(getModifiedDate());
		customUserImpl.setHome_phone(getHome_phone());
		customUserImpl.setMobile_phone(getMobile_phone());
		customUserImpl.setState(getState());
		customUserImpl.setSecurity_question(getSecurity_question());
		customUserImpl.setSecurity_answer(getSecurity_answer());
		customUserImpl.setAccepted_tou(isAccepted_tou());

		customUserImpl.resetOriginalValues();

		return customUserImpl;
	}

	@Override
	public int compareTo(CustomUser customUser) {
		long primaryKey = customUser.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CustomUser)) {
			return false;
		}

		CustomUser customUser = (CustomUser)obj;

		long primaryKey = customUser.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		CustomUserModelImpl customUserModelImpl = this;

		customUserModelImpl._originalGroupId = customUserModelImpl._groupId;

		customUserModelImpl._setOriginalGroupId = false;

		customUserModelImpl._setModifiedDate = false;

		customUserModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CustomUser> toCacheModel() {
		CustomUserCacheModel customUserCacheModel = new CustomUserCacheModel();

		customUserCacheModel.customUserId = getCustomUserId();

		customUserCacheModel.groupId = getGroupId();

		customUserCacheModel.companyId = getCompanyId();

		customUserCacheModel.userId = getUserId();

		customUserCacheModel.userName = getUserName();

		String userName = customUserCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			customUserCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			customUserCacheModel.createDate = createDate.getTime();
		}
		else {
			customUserCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			customUserCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			customUserCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		customUserCacheModel.home_phone = getHome_phone();

		customUserCacheModel.mobile_phone = getMobile_phone();

		customUserCacheModel.state = getState();

		String state = customUserCacheModel.state;

		if ((state != null) && (state.length() == 0)) {
			customUserCacheModel.state = null;
		}

		customUserCacheModel.security_question = getSecurity_question();

		String security_question = customUserCacheModel.security_question;

		if ((security_question != null) && (security_question.length() == 0)) {
			customUserCacheModel.security_question = null;
		}

		customUserCacheModel.security_answer = getSecurity_answer();

		String security_answer = customUserCacheModel.security_answer;

		if ((security_answer != null) && (security_answer.length() == 0)) {
			customUserCacheModel.security_answer = null;
		}

		customUserCacheModel.accepted_tou = isAccepted_tou();

		return customUserCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CustomUser, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CustomUser, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CustomUser, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((CustomUser)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<CustomUser, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CustomUser, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CustomUser, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CustomUser)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CustomUser>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _customUserId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private int _home_phone;
	private int _mobile_phone;
	private String _state;
	private String _security_question;
	private String _security_answer;
	private boolean _accepted_tou;
	private long _columnBitmask;
	private CustomUser _escapedModel;

}