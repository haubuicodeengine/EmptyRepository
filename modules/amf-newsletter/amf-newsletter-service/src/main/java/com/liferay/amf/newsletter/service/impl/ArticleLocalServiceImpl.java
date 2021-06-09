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

import com.liferay.amf.newsletter.model.Article;
import com.liferay.amf.newsletter.service.base.ArticleLocalServiceBaseImpl;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalService;
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
 * The implementation of the article local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.amf.newsletter.service.ArticleLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ArticleLocalServiceBaseImpl
 */
@Component(
        property = "model.class.name=com.liferay.amf.newsletter.model.Article",
        service = AopService.class
)
public class ArticleLocalServiceImpl extends ArticleLocalServiceBaseImpl {

    private static final Log _log = LogFactoryUtil.getLog(
            ArticleLocalServiceImpl.class);

    @Reference
    private JournalArticleLocalService _journalArticleLocalService;

    public Article addArticle(long groupId, long resourcePrimKey, long issueNumber, ServiceContext serviceContext) throws PortalException {

        Group group = groupLocalService.getGroup(groupId);

        long userId = serviceContext.getUserId();

        User user = userLocalService.getUser(userId);

        Article article = createArticle(resourcePrimKey);

        article.setCompanyId(group.getCompanyId());
        article.setCreateDate(serviceContext.getCreateDate(new Date()));
        article.setGroupId(groupId);
        article.setModifiedDate(serviceContext.getModifiedDate(new Date()));
        article.setUserId(userId);
        article.setUserName(user.getScreenName());
        article.setIssueNumber(issueNumber);

        return super.addArticle(article);
    }

    public List<Article> getArticlesByNewsletter(long issueNumber) {
        ClassLoader classLoader = getClass().getClassLoader();

        DynamicQuery entryQuery = null;

        List<Article> entries = new ArrayList<>();

        entryQuery = DynamicQueryFactoryUtil.forClass(Article.class, classLoader).add(RestrictionsFactoryUtil.eq("issueNumber", issueNumber));

        entries = articleLocalService.dynamicQuery(entryQuery);

        return entries;

    }

    public List<JournalArticle> getArticles(List<Article> articles) {
        List<JournalArticle> journalArticles = new ArrayList<>();

        for (Article article : articles) {
            JournalArticle JournalArticle = null;

            try {
                JournalArticle = _journalArticleLocalService.getLatestArticle(article.getResourcePrimKey());

            } catch (PortalException e) {
                _log.error(e);
            }

            journalArticles.add(JournalArticle);
        }

        return journalArticles;
    }

}