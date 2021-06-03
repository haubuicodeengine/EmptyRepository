package com.liferay.amf.search.results.actions;

import com.liferay.amf.search.results.constants.AmfSearchResultsPortletKeys;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.AddressLocalService;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component(immediate = true, property = {
        "javax.portlet.name=" + AmfSearchResultsPortletKeys.AMFSEARCHRESULTS,
        "com.liferay.portlet.private-session-attributes=false",
        "javax.portlet.init-param.view-template=/view.jsp",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.supported-public-render-parameter=usZip",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.security-role-ref=power-user,user",
        "javax.portlet.resource-bundle=content.Language"
}, service = Portlet.class)
public class AmfSearchResultReceiver extends MVCPortlet {

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        String usZip = ParamUtil.getString(renderRequest, "usZip");

        List<Address> addresses = findAddressByUsZipCode(usZip);

        renderRequest.setAttribute("usZip", usZip);

        renderRequest.setAttribute("addresses", addresses);

        super.doView(renderRequest, renderResponse);
    }

    public List<Address> findAddressByUsZipCode(String UsZipCode) {

        ClassLoader classLoader = getClass().getClassLoader();

        DynamicQuery entryQuery = null;

        List<Address> entries = new ArrayList<>();

        entryQuery = DynamicQueryFactoryUtil.forClass(Address.class, classLoader).add(RestrictionsFactoryUtil.eq("zip", UsZipCode));

        entries = _addressLocalService.dynamicQuery(entryQuery);

        return entries;
    }

    @Reference
    AddressLocalService _addressLocalService;
}
