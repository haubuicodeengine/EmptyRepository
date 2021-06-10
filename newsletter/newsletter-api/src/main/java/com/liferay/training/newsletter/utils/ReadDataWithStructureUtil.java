package com.liferay.training.newsletter.utils;

import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalService;
import com.liferay.dynamic.data.mapping.storage.Field;
import com.liferay.dynamic.data.mapping.storage.Fields;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.util.JournalConverter;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ClassNameLocalService;

import java.util.HashMap;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	service = ReadDataWithStructureUtil.class,
	immediate = true
)
public class ReadDataWithStructureUtil {

	public DDMStructure getDDMStructure(JournalArticle journalArticle) throws PortalException {

		DDMStructure structure = ddmStructureLocalService.getStructure(journalArticle.getGroupId(),
				classNameLocalService.getClassNameId(JournalArticle.class.getName()), journalArticle.getStructureId());

		return structure;
	}

	public Map<String, Object> getFileds(DDMStructure ddmStructure, JournalArticle journalArticle)
			throws PortalException {

		Map<String, Object> attributes = new HashMap<String, Object>();

		Fields fields = journalConverter.getDDMFields(ddmStructure, journalArticle.getContent());

		for (Field field : fields) {
			attributes.put(field.getName(), field.getValue());
		}

		return attributes;
	}

	@Reference
	ClassNameLocalService classNameLocalService;

	@Reference
	JournalConverter journalConverter;

	@Reference
	DDMStructureLocalService ddmStructureLocalService;
}
