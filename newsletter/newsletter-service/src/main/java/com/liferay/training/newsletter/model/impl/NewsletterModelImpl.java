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

package com.liferay.training.newsletter.model.impl;

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
import com.liferay.training.newsletter.model.Newsletter;
import com.liferay.training.newsletter.model.NewsletterModel;
import com.liferay.training.newsletter.model.NewsletterSoap;

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
 * The base model implementation for the Newsletter service. Represents a row in the &quot;NEWSLETTER_Newsletter&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>NewsletterModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link NewsletterImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NewsletterImpl
 * @generated
 */
@JSON(strict = true)
public class NewsletterModelImpl
	extends BaseModelImpl<Newsletter> implements NewsletterModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a newsletter model instance should use the <code>Newsletter</code> interface instead.
	 */
	public static final String TABLE_NAME = "NEWSLETTER_Newsletter";

	public static final Object[][] TABLE_COLUMNS = {
		{"newsletterId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"issueNumber", Types.INTEGER},
		{"title", Types.VARCHAR}, {"description", Types.VARCHAR},
		{"issueDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("newsletterId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("issueNumber", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("issueDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table NEWSLETTER_Newsletter (newsletterId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,issueNumber INTEGER,title VARCHAR(75) null,description VARCHAR(75) null,issueDate DATE null)";

	public static final String TABLE_SQL_DROP =
		"drop table NEWSLETTER_Newsletter";

	public static final String ORDER_BY_JPQL =
		" ORDER BY newsletter.newsletterId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY NEWSLETTER_Newsletter.newsletterId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

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
	public static Newsletter toModel(NewsletterSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Newsletter model = new NewsletterImpl();

		model.setNewsletterId(soapModel.getNewsletterId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setIssueNumber(soapModel.getIssueNumber());
		model.setTitle(soapModel.getTitle());
		model.setDescription(soapModel.getDescription());
		model.setIssueDate(soapModel.getIssueDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Newsletter> toModels(NewsletterSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Newsletter> models = new ArrayList<Newsletter>(soapModels.length);

		for (NewsletterSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public NewsletterModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _newsletterId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setNewsletterId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _newsletterId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Newsletter.class;
	}

	@Override
	public String getModelClassName() {
		return Newsletter.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Newsletter, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Newsletter, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Newsletter, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Newsletter)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Newsletter, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Newsletter, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Newsletter)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Newsletter, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Newsletter, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Newsletter>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Newsletter.class.getClassLoader(), Newsletter.class,
			ModelWrapper.class);

		try {
			Constructor<Newsletter> constructor =
				(Constructor<Newsletter>)proxyClass.getConstructor(
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

	private static final Map<String, Function<Newsletter, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Newsletter, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Newsletter, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Newsletter, Object>>();
		Map<String, BiConsumer<Newsletter, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Newsletter, ?>>();

		attributeGetterFunctions.put(
			"newsletterId", Newsletter::getNewsletterId);
		attributeSetterBiConsumers.put(
			"newsletterId",
			(BiConsumer<Newsletter, Long>)Newsletter::setNewsletterId);
		attributeGetterFunctions.put("groupId", Newsletter::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Newsletter, Long>)Newsletter::setGroupId);
		attributeGetterFunctions.put("companyId", Newsletter::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<Newsletter, Long>)Newsletter::setCompanyId);
		attributeGetterFunctions.put("userId", Newsletter::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<Newsletter, Long>)Newsletter::setUserId);
		attributeGetterFunctions.put("userName", Newsletter::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<Newsletter, String>)Newsletter::setUserName);
		attributeGetterFunctions.put("createDate", Newsletter::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<Newsletter, Date>)Newsletter::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", Newsletter::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<Newsletter, Date>)Newsletter::setModifiedDate);
		attributeGetterFunctions.put("issueNumber", Newsletter::getIssueNumber);
		attributeSetterBiConsumers.put(
			"issueNumber",
			(BiConsumer<Newsletter, Integer>)Newsletter::setIssueNumber);
		attributeGetterFunctions.put("title", Newsletter::getTitle);
		attributeSetterBiConsumers.put(
			"title", (BiConsumer<Newsletter, String>)Newsletter::setTitle);
		attributeGetterFunctions.put("description", Newsletter::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<Newsletter, String>)Newsletter::setDescription);
		attributeGetterFunctions.put("issueDate", Newsletter::getIssueDate);
		attributeSetterBiConsumers.put(
			"issueDate",
			(BiConsumer<Newsletter, Date>)Newsletter::setIssueDate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getNewsletterId() {
		return _newsletterId;
	}

	@Override
	public void setNewsletterId(long newsletterId) {
		_newsletterId = newsletterId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
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
	public Integer getIssueNumber() {
		return _issueNumber;
	}

	@Override
	public void setIssueNumber(Integer issueNumber) {
		_issueNumber = issueNumber;
	}

	@JSON
	@Override
	public String getTitle() {
		if (_title == null) {
			return "";
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		_title = title;
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@JSON
	@Override
	public Date getIssueDate() {
		return _issueDate;
	}

	@Override
	public void setIssueDate(Date issueDate) {
		_issueDate = issueDate;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Newsletter.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Newsletter toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Newsletter>
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
		NewsletterImpl newsletterImpl = new NewsletterImpl();

		newsletterImpl.setNewsletterId(getNewsletterId());
		newsletterImpl.setGroupId(getGroupId());
		newsletterImpl.setCompanyId(getCompanyId());
		newsletterImpl.setUserId(getUserId());
		newsletterImpl.setUserName(getUserName());
		newsletterImpl.setCreateDate(getCreateDate());
		newsletterImpl.setModifiedDate(getModifiedDate());
		newsletterImpl.setIssueNumber(getIssueNumber());
		newsletterImpl.setTitle(getTitle());
		newsletterImpl.setDescription(getDescription());
		newsletterImpl.setIssueDate(getIssueDate());

		newsletterImpl.resetOriginalValues();

		return newsletterImpl;
	}

	@Override
	public int compareTo(Newsletter newsletter) {
		long primaryKey = newsletter.getPrimaryKey();

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

		if (!(obj instanceof Newsletter)) {
			return false;
		}

		Newsletter newsletter = (Newsletter)obj;

		long primaryKey = newsletter.getPrimaryKey();

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
		NewsletterModelImpl newsletterModelImpl = this;

		newsletterModelImpl._setModifiedDate = false;
	}

	@Override
	public CacheModel<Newsletter> toCacheModel() {
		NewsletterCacheModel newsletterCacheModel = new NewsletterCacheModel();

		newsletterCacheModel.newsletterId = getNewsletterId();

		newsletterCacheModel.groupId = getGroupId();

		newsletterCacheModel.companyId = getCompanyId();

		newsletterCacheModel.userId = getUserId();

		newsletterCacheModel.userName = getUserName();

		String userName = newsletterCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			newsletterCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			newsletterCacheModel.createDate = createDate.getTime();
		}
		else {
			newsletterCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			newsletterCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			newsletterCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		newsletterCacheModel.issueNumber = getIssueNumber();

		newsletterCacheModel.title = getTitle();

		String title = newsletterCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			newsletterCacheModel.title = null;
		}

		newsletterCacheModel.description = getDescription();

		String description = newsletterCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			newsletterCacheModel.description = null;
		}

		Date issueDate = getIssueDate();

		if (issueDate != null) {
			newsletterCacheModel.issueDate = issueDate.getTime();
		}
		else {
			newsletterCacheModel.issueDate = Long.MIN_VALUE;
		}

		return newsletterCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Newsletter, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Newsletter, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Newsletter, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Newsletter)this));
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
		Map<String, Function<Newsletter, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Newsletter, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Newsletter, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Newsletter)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Newsletter>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _newsletterId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private Integer _issueNumber;
	private String _title;
	private String _description;
	private Date _issueDate;
	private Newsletter _escapedModel;

}