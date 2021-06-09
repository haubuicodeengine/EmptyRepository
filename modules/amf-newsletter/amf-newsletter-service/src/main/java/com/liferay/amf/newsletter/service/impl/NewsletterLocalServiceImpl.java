/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.amf.newsletter.service.impl;

import com.liferay.amf.newsletter.constants.NewsletterFields;
import com.liferay.amf.newsletter.model.Newsletter;
import com.liferay.amf.newsletter.service.base.NewsletterLocalServiceBaseImpl;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.storage.Fields;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.journal.util.JournalConverter;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The implementation of the newsletter local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.amf.newsletter.service.NewsletterLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NewsletterLocalServiceBaseImpl
 */
@Component(
        property = "model.class.name=com.liferay.amf.newsletter.model.Newsletter",
        service = AopService.class
)
public class NewsletterLocalServiceImpl extends NewsletterLocalServiceBaseImpl {

    private static final Log _log = LogFactoryUtil.getLog(NewsletterLocalServiceImpl.class);

    @Reference
    private JournalArticleLocalService _journalArticleLocalService;

    @Reference
    private JournalConverter _journalConverter;

    public Newsletter addNewsletter(long groupId, long resourcePrimKey, long issueNumber, ServiceContext serviceContext) throws PortalException {

        Group group = groupLocalService.getGroup(groupId);

        long userId = serviceContext.getUserId();

        User user = userLocalService.getUser(userId);

        Newsletter newsletter = createNewsletter(resourcePrimKey);

        newsletter.setCompanyId(group.getCompanyId());
        newsletter.setCreateDate(serviceContext.getCreateDate(new Date()));
        newsletter.setGroupId(groupId);
        newsletter.setModifiedDate(serviceContext.getModifiedDate(new Date()));
        newsletter.setUserId(userId);
        newsletter.setUserName(user.getScreenName());
        newsletter.setIssueNumber(issueNumber);
        newsletter.setResourcePrimKey(resourcePrimKey);

        return super.addNewsletter(newsletter);
    }

    public String getJournalArticleContent(DDMStructure ddmStructure, String content, String elementKey) {
        String result = null;
        Fields fields = null;

        try {
            fields = _journalConverter.getDDMFields(ddmStructure, content);

        } catch (PortalException e) {
            _log.error(e);
        } finally {

            if (fields.contains(elementKey)) {

                result = String.valueOf(fields.get(elementKey).getValue());
            }

            return result;
        }
    }

    public List<Newsletter> getAllNewsletter() {
        ClassLoader classLoader = getClass().getClassLoader();

        DynamicQuery entryQuery = null;

        List<Newsletter> entries = new ArrayList<>();

        entryQuery = DynamicQueryFactoryUtil.forClass(Newsletter.class, classLoader);

        entries = newsletterLocalService.dynamicQuery(entryQuery);

        return entries;
    }

    public JournalArticle getNewsletterByIssueNumber(long issueNumber) {
        ClassLoader classLoader = getClass().getClassLoader();

        DynamicQuery entryQuery = null;

        List<Newsletter> entries = new ArrayList<>();

        entryQuery = DynamicQueryFactoryUtil.forClass(Newsletter.class, classLoader).add(RestrictionsFactoryUtil.eq(NewsletterFields.ISSUE_NUMBER, issueNumber));

        entries = newsletterLocalService.dynamicQuery(entryQuery);

        JournalArticle newsletter = null;

        try {
            newsletter = _journalArticleLocalService.getLatestArticle(entries.get(0).getResourcePrimKey());

        } catch (PortalException e) {
            _log.error(e);
        }

        return newsletter;
    }

    public List<JournalArticle> getNewsletters() {
        List<Newsletter> newsletters = getAllNewsletter();

        List<JournalArticle> journalArticles = new ArrayList<>();

        for (Newsletter newsletter : newsletters) {
            JournalArticle JournalArticle = null;

            try {
                JournalArticle = _journalArticleLocalService.getLatestArticle(newsletter.getResourcePrimKey());

            } catch (PortalException e) {
                _log.error(e);
            }

            journalArticles.add(JournalArticle);
        }

        return journalArticles;
    }
}