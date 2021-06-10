package com.liferay.training.newsletter.listing.routes;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;
import com.liferay.training.newsletter.listing.constants.NewsletterListingPortletKeys;

import org.osgi.service.component.annotations.Component;

@Component(
	property = { 
		"com.liferay.portlet.friendly-url-routes=META-INF/routes/routes.xml",
		"javax.portlet.name=" + NewsletterListingPortletKeys.NEWSLETTERLISTING }, 
	service = FriendlyURLMapper.class)
public class NewsLetterRoutesMapper extends DefaultFriendlyURLMapper {

	@Override
	public String getMapping() {

		return _MAPPING;
	}

	private static final String _MAPPING = "newsletter";
}