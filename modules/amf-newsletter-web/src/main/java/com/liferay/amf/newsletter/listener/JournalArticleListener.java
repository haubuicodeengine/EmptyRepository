package com.liferay.amf.newsletter.listener;

import com.liferay.amf.newsletter.model.Article;
import com.liferay.amf.newsletter.model.Newsletter;
import com.liferay.amf.newsletter.service.ArticleLocalService;
import com.liferay.amf.newsletter.service.NewsletterLocalService;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalService;
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
import com.liferay.portal.kernel.service.ClassNameLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = ModelListener.class)
public class JournalArticleListener extends BaseModelListener<JournalArticle> {

    @Override
    public void onAfterCreate(JournalArticle model) throws ModelListenerException {

        String content = model.getContent();

        ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

        Fields fields = null;

        if (model.getDDMStructure().getNameCurrentValue().equals("Newsletter")) {
            try {
                fields = _journalConverter.getDDMFields(model.getDDMStructure(), content);

                String strIssueNumber = String.valueOf(fields.get("issueNumber").getValue());

                long issueNumber = Long.parseLong(strIssueNumber);

                Newsletter newsletter = _newsletterLocalService.addNewsletter(model.getGroupId(), model.getResourcePrimKey(), issueNumber, serviceContext);

            } catch (PortalException e) {
                _log.error(e);
            }
        } else if (model.getDDMStructure().getNameCurrentValue().equals("Newsletter Article")) {
            try {
                fields = _journalConverter.getDDMFields(model.getDDMStructure(), content);

                JSONObject jsonObject = JSONFactoryUtil.createJSONObject(String.valueOf(fields.get("issue").getValue()));

                String uuid = jsonObject.getString("uuid");

                long groupId = Long.parseLong(jsonObject.getString("groupId"));

                JournalArticle oldNewsletter = _journalArticleLocalService.fetchJournalArticleByUuidAndGroupId(uuid, groupId);

                Fields newsletterFields = _journalConverter.getDDMFields(oldNewsletter.getDDMStructure(), oldNewsletter.getContent());

                String strIssueNumber = String.valueOf(newsletterFields.get("issueNumber").getValue());

                long issueNumber = Long.parseLong(strIssueNumber);

                Article article = _articleLocalService.addArticle(model.getGroupId(), model.getResourcePrimKey(), issueNumber, serviceContext);

            } catch (PortalException e) {
                _log.error(e);
            }
        }

//        try {
//            Fields fields = _journalConverter.getDDMFields(model.getDDMStructure(), content);
//            System.out.println(fields.get("title").getValue() == null);
//
//
//        } catch (PortalException e) {
//            e.printStackTrace();
//        }

//        long classNameId = _classNameLocalService.getClassNameId(
//                JournalArticle.class);
//
//        StructureModifiedDateComparator cprt = new StructureModifiedDateComparator();
//
//        List<DDMStructure> structures = _ddmStructureLocalService.getStructures(model.getGroupId(), classNameId, 0, 100, cprt);
//
//        super.onAfterCreate(model);
    }

    @Reference
    ArticleLocalService _articleLocalService;

    @Reference
    NewsletterLocalService _newsletterLocalService;

    @Reference
    ClassNameLocalService _classNameLocalService;

    @Reference
    DDMStructureLocalService _ddmStructureLocalService;

    @Reference
    JournalConverter _journalConverter;

    @Reference
    JournalArticleLocalService _journalArticleLocalService;

    private static final Log _log = LogFactoryUtil.getLog(
            JournalArticleListener.class);
}
