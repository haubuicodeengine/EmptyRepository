package com.liferay.amf.newsletter.routes;

import com.liferay.amf.newsletter.constants.AmfNewsletterPortletKeys;
import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;
import org.osgi.service.component.annotations.Component;

@Component(
        property = {
                "com.liferay.portlet.friendly-url-routes=/META-INF/routes/routes.xml",
                "javax.portlet.name=" + AmfNewsletterPortletKeys.AMFNEWSLETTER
        },
        service = FriendlyURLMapper.class
)
public class RoutesMapper extends DefaultFriendlyURLMapper {

    @Override
    public String getMapping() {
        return "newsletter";
    }

}