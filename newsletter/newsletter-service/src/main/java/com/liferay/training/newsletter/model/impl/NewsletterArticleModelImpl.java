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
import com.liferay.training.newsletter.model.NewsletterArticle;
import com.liferay.training.newsletter.model.NewsletterArticleModel;
import com.liferay.training.newsletter.model.NewsletterArticleSoap;

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
 * The base model implementation for the NewsletterArticle service. Represents a row in the &quot;NEWSLETTER_NewsletterArticle&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>NewsletterArticleModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link NewsletterArticleImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NewsletterArticleImpl
 * @generated
 */
@JSON(strict = true)
public class NewsletterArticleModelImpl
	extends BaseModelImpl<NewsletterArticle> implements NewsletterArticleModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a newsletter article model instance should use the <code>NewsletterArticle</code> interface instead.
	 */
	public static final String TABLE_NAME = "NEWSLETTER_NewsletterArticle";

	public static final Object[][] TABLE_COLUMNS = {
		{"newsletterArticleId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"author", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"issueNumber", Types.INTEGER},
		{"title", Types.VARCHAR}, {"content", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("newsletterArticleId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("author", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("issueNumber", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("content", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table NEWSLETTER_NewsletterArticle (newsletterArticleId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,author VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,issueNumber INTEGER,title VARCHAR(75) null,content VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table NEWSLETTER_NewsletterArticle";

	public static final String ORDER_BY_JPQL =
		" ORDER BY newsletterArticle.newsletterArticleId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY NEWSLETTER_NewsletterArticle.newsletterArticleId ASC";

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
	public static NewsletterArticle toModel(NewsletterArticleSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		NewsletterArticle model = new NewsletterArticleImpl();

		model.setNewsletterArticleId(soapModel.getNewsletterArticleId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setAuthor(soapModel.getAuthor());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setIssueNumber(soapModel.getIssueNumber());
		model.setTitle(soapModel.getTitle());
		model.setContent(soapModel.getContent());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<NewsletterArticle> toModels(
		NewsletterArticleSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<NewsletterArticle> models = new ArrayList<NewsletterArticle>(
			soapModels.length);

		for (NewsletterArticleSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public NewsletterArticleModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _newsletterArticleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setNewsletterArticleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _newsletterArticleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return NewsletterArticle.class;
	}

	@Override
	public String getModelClassName() {
		return NewsletterArticle.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<NewsletterArticle, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<NewsletterArticle, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<NewsletterArticle, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((NewsletterArticle)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<NewsletterArticle, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<NewsletterArticle, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(NewsletterArticle)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<NewsletterArticle, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<NewsletterArticle, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, NewsletterArticle>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			NewsletterArticle.class.getClassLoader(), NewsletterArticle.class,
			ModelWrapper.class);

		try {
			Constructor<NewsletterArticle> constructor =
				(Constructor<NewsletterArticle>)proxyClass.getConstructor(
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

	private static final Map<String, Function<NewsletterArticle, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<NewsletterArticle, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<NewsletterArticle, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<NewsletterArticle, Object>>();
		Map<String, BiConsumer<NewsletterArticle, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<NewsletterArticle, ?>>();

		attributeGetterFunctions.put(
			"newsletterArticleId", NewsletterArticle::getNewsletterArticleId);
		attributeSetterBiConsumers.put(
			"newsletterArticleId",
			(BiConsumer<NewsletterArticle, Long>)
				NewsletterArticle::setNewsletterArticleId);
		attributeGetterFunctions.put("groupId", NewsletterArticle::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<NewsletterArticle, Long>)NewsletterArticle::setGroupId);
		attributeGetterFunctions.put(
			"companyId", NewsletterArticle::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<NewsletterArticle, Long>)
				NewsletterArticle::setCompanyId);
		attributeGetterFunctions.put("userId", NewsletterArticle::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<NewsletterArticle, Long>)NewsletterArticle::setUserId);
		attributeGetterFunctions.put("author", NewsletterArticle::getAuthor);
		attributeSetterBiConsumers.put(
			"author",
			(BiConsumer<NewsletterArticle, String>)
				NewsletterArticle::setAuthor);
		attributeGetterFunctions.put(
			"createDate", NewsletterArticle::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<NewsletterArticle, Date>)
				NewsletterArticle::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", NewsletterArticle::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<NewsletterArticle, Date>)
				NewsletterArticle::setModifiedDate);
		attributeGetterFunctions.put(
			"issueNumber", NewsletterArticle::getIssueNumber);
		attributeSetterBiConsumers.put(
			"issueNumber",
			(BiConsumer<NewsletterArticle, Integer>)
				NewsletterArticle::setIssueNumber);
		attributeGetterFunctions.put("title", NewsletterArticle::getTitle);
		attributeSetterBiConsumers.put(
			"title",
			(BiConsumer<NewsletterArticle, String>)NewsletterArticle::setTitle);
		attributeGetterFunctions.put("content", NewsletterArticle::getContent);
		attributeSetterBiConsumers.put(
			"content",
			(BiConsumer<NewsletterArticle, String>)
				NewsletterArticle::setContent);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getNewsletterArticleId() {
		return _newsletterArticleId;
	}

	@Override
	public void setNewsletterArticleId(long newsletterArticleId) {
		_newsletterArticleId = newsletterArticleId;
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
	public String getAuthor() {
		if (_author == null) {
			return "";
		}
		else {
			return _author;
		}
	}

	@Override
	public void setAuthor(String author) {
		_author = author;
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
	public String getContent() {
		if (_content == null) {
			return "";
		}
		else {
			return _content;
		}
	}

	@Override
	public void setContent(String content) {
		_content = content;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), NewsletterArticle.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public NewsletterArticle toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, NewsletterArticle>
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
		NewsletterArticleImpl newsletterArticleImpl =
			new NewsletterArticleImpl();

		newsletterArticleImpl.setNewsletterArticleId(getNewsletterArticleId());
		newsletterArticleImpl.setGroupId(getGroupId());
		newsletterArticleImpl.setCompanyId(getCompanyId());
		newsletterArticleImpl.setUserId(getUserId());
		newsletterArticleImpl.setAuthor(getAuthor());
		newsletterArticleImpl.setCreateDate(getCreateDate());
		newsletterArticleImpl.setModifiedDate(getModifiedDate());
		newsletterArticleImpl.setIssueNumber(getIssueNumber());
		newsletterArticleImpl.setTitle(getTitle());
		newsletterArticleImpl.setContent(getContent());

		newsletterArticleImpl.resetOriginalValues();

		return newsletterArticleImpl;
	}

	@Override
	public int compareTo(NewsletterArticle newsletterArticle) {
		long primaryKey = newsletterArticle.getPrimaryKey();

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

		if (!(obj instanceof NewsletterArticle)) {
			return false;
		}

		NewsletterArticle newsletterArticle = (NewsletterArticle)obj;

		long primaryKey = newsletterArticle.getPrimaryKey();

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
		NewsletterArticleModelImpl newsletterArticleModelImpl = this;

		newsletterArticleModelImpl._setModifiedDate = false;
	}

	@Override
	public CacheModel<NewsletterArticle> toCacheModel() {
		NewsletterArticleCacheModel newsletterArticleCacheModel =
			new NewsletterArticleCacheModel();

		newsletterArticleCacheModel.newsletterArticleId =
			getNewsletterArticleId();

		newsletterArticleCacheModel.groupId = getGroupId();

		newsletterArticleCacheModel.companyId = getCompanyId();

		newsletterArticleCacheModel.userId = getUserId();

		newsletterArticleCacheModel.author = getAuthor();

		String author = newsletterArticleCacheModel.author;

		if ((author != null) && (author.length() == 0)) {
			newsletterArticleCacheModel.author = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			newsletterArticleCacheModel.createDate = createDate.getTime();
		}
		else {
			newsletterArticleCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			newsletterArticleCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			newsletterArticleCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		newsletterArticleCacheModel.issueNumber = getIssueNumber();

		newsletterArticleCacheModel.title = getTitle();

		String title = newsletterArticleCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			newsletterArticleCacheModel.title = null;
		}

		newsletterArticleCacheModel.content = getContent();

		String content = newsletterArticleCacheModel.content;

		if ((content != null) && (content.length() == 0)) {
			newsletterArticleCacheModel.content = null;
		}

		return newsletterArticleCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<NewsletterArticle, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<NewsletterArticle, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<NewsletterArticle, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((NewsletterArticle)this));
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
		Map<String, Function<NewsletterArticle, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<NewsletterArticle, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<NewsletterArticle, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((NewsletterArticle)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, NewsletterArticle>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _newsletterArticleId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _author;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private Integer _issueNumber;
	private String _title;
	private String _content;
	private NewsletterArticle _escapedModel;

}