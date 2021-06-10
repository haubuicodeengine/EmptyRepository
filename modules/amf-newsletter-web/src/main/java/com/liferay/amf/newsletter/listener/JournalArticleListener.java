package com.liferay.amf.newsletter.listener;

import com.liferay.amf.newsletter.constants.DDMStructureNames;
import com.liferay.amf.newsletter.constants.NewsletterFields;
import com.liferay.amf.newsletter.service.ArticleLocalService;
import com.liferay.amf.newsletter.service.NewsletterLocalService;
import com.liferay.dynamic.data.mapping.storage.Fields;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.journal.util.JournalConverter;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = ModelListener.class)
public class JournalArticleListener extends BaseModelListener<JournalArticle> {

    private static final Log _log = LogFactoryUtil.getLog(
            JournalArticleListener.class);

    @Reference
    private ArticleLocalService _articleLocalService;

    @Reference
    private NewsletterLocalService _newsletterLocalService;

    @Reference
    private JournalConverter _journalConverter;

    @Reference
    private JournalArticleLocalService _journalArticleLocalService;

    @Override
    public void onAfterCreate(JournalArticle model) throws ModelListenerException {

        String content = model.getContent();

        ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

        Fields fields = null;

        if (model.getDDMStructure().getNameCurrentValue().equals(DDMStructureNames.NEWSLETTER)) {
            try {
                fields = _journalConverter.getDDMFields(model.getDDMStructure(), content);

                String strIssueNumber = String.valueOf(fields.get(NewsletterFields.ISSUE_NUMBER).getValue());

                long issueNumber = Long.parseLong(strIssueNumber);

                _newsletterLocalService.addNewsletter(model.getGroupId(), model.getResourcePrimKey(), issueNumber, serviceContext);

            } catch (PortalException e) {
                _log.error(e);
            }
        } else if (model.getDDMStructure().getNameCurrentValue().equals(DDMStructureNames.NEWSLETTER_ARTICLE)) {
            try {
                fields = _journalConverter.getDDMFields(model.getDDMStructure(), content);

                JSONObject jsonObject = JSONFactoryUtil.createJSONObject(String.valueOf(fields.get(NewsletterFields.ISSUE).getValue()));

                String uuid = jsonObject.getString(Field.UUID);

                long groupId = Long.parseLong(jsonObject.getString(Field.GROUP_ID));

                JournalArticle oldNewsletter = _journalArticleLocalService.fetchJournalArticleByUuidAndGroupId(uuid, groupId);

                Fields newsletterFields = _journalConverter.getDDMFields(oldNewsletter.getDDMStructure(), oldNewsletter.getContent());

                String strIssueNumber = String.valueOf(newsletterFields.get(NewsletterFields.ISSUE_NUMBER).getValue());

                long issueNumber = Long.parseLong(strIssueNumber);

                _articleLocalService.addArticle(model.getGroupId(), model.getResourcePrimKey(), issueNumber, serviceContext);

            } catch (PortalException e) {
                _log.error(e);
            }
        }
    }

    @Override
    public void onAfterRemove(JournalArticle model) throws ModelListenerException {

        if (model.getDDMStructure().getNameCurrentValue().equals(DDMStructureNames.NEWSLETTER)) {
            try {
                _newsletterLocalService.deleteNewsletter(model.getResourcePrimKey());

            } catch (PortalException e) {
                _log.error(e);
            }

        } else if (model.getDDMStructure().getNameCurrentValue().equals(DDMStructureNames.NEWSLETTER_ARTICLE)) {
            try {
                _articleLocalService.deleteArticle(model.getResourcePrimKey());

            } catch (PortalException e) {
                _log.error(e);
            }
        }
    }
}
