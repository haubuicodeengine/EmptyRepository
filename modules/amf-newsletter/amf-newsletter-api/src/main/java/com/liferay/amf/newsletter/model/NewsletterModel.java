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

package com.liferay.amf.newsletter.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Newsletter service. Represents a row in the &quot;TS_Newsletter&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.amf.newsletter.model.impl.NewsletterModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.amf.newsletter.model.impl.NewsletterImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Newsletter
 * @generated
 */
@ProviderType
public interface NewsletterModel
	extends BaseModel<Newsletter>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a newsletter model instance should use the {@link Newsletter} interface instead.
	 */

	/**
	 * Returns the primary key of this newsletter.
	 *
	 * @return the primary key of this newsletter
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this newsletter.
	 *
	 * @param primaryKey the primary key of this newsletter
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this newsletter.
	 *
	 * @return the uuid of this newsletter
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this newsletter.
	 *
	 * @param uuid the uuid of this newsletter
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the resource prim key of this newsletter.
	 *
	 * @return the resource prim key of this newsletter
	 */
	public long getResourcePrimKey();

	/**
	 * Sets the resource prim key of this newsletter.
	 *
	 * @param resourcePrimKey the resource prim key of this newsletter
	 */
	public void setResourcePrimKey(long resourcePrimKey);

	/**
	 * Returns the group ID of this newsletter.
	 *
	 * @return the group ID of this newsletter
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this newsletter.
	 *
	 * @param groupId the group ID of this newsletter
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this newsletter.
	 *
	 * @return the company ID of this newsletter
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this newsletter.
	 *
	 * @param companyId the company ID of this newsletter
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this newsletter.
	 *
	 * @return the user ID of this newsletter
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this newsletter.
	 *
	 * @param userId the user ID of this newsletter
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this newsletter.
	 *
	 * @return the user uuid of this newsletter
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this newsletter.
	 *
	 * @param userUuid the user uuid of this newsletter
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this newsletter.
	 *
	 * @return the user name of this newsletter
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this newsletter.
	 *
	 * @param userName the user name of this newsletter
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this newsletter.
	 *
	 * @return the create date of this newsletter
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this newsletter.
	 *
	 * @param createDate the create date of this newsletter
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this newsletter.
	 *
	 * @return the modified date of this newsletter
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this newsletter.
	 *
	 * @param modifiedDate the modified date of this newsletter
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the issue number of this newsletter.
	 *
	 * @return the issue number of this newsletter
	 */
	public long getIssueNumber();

	/**
	 * Sets the issue number of this newsletter.
	 *
	 * @param issueNumber the issue number of this newsletter
	 */
	public void setIssueNumber(long issueNumber);

}