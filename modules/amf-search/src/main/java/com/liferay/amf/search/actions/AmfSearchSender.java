package com.liferay.amf.search.actions;

import com.liferay.amf.search.constants.AmfSearchPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;

import javax.portlet.*;
import java.io.IOException;

@Component(immediate = true, property = {
        "javax.portlet.name=" + AmfSearchPortletKeys.AMFSEARCH,
        "com.liferay.portlet.private-session-attributes=false",
        "javax.portlet.init-param.view-template=/view.jsp",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.security-role-ref=power-user,user",
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.supported-public-render-parameter=usZip"}, service = Portlet.class)
public class AmfSearchSender extends MVCPortlet {

    public void sendData(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
        String usZip = ParamUtil.getString(actionRequest, "usZip");

        if (usZip.length() != ZIP_LENGTH) {
            SessionErrors.add(actionRequest, "not-a-zip-code");

        } else {
            actionResponse.getRenderParameters().setValue("usZip", usZip);

        }
    }

    private final int ZIP_LENGTH = 5;
}
