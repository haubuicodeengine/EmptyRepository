<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui" %>
<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay" %>
<%@ taglib prefix="liferay-item-selector" uri="http://liferay.com/tld/item-selector" %>
<%@ taglib prefix="liferay-frontend" uri="http://liferay.com/tld/frontend" %>
<%@ taglib prefix="liferay-portlet" uri="http://liferay.com/tld/portlet" %>
<%@ taglib prefix="liferay-theme" uri="http://liferay.com/tld/theme" %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>

<%@ page import="java.util.Date"%>
<%@ page import="javax.portlet.WindowState"%>

<%@ page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="amf.registration.web.constants.MVCCommandNames"%>

<%@page import="com.liferay.portal.kernel.exception.UserScreenNameException"%>
<%@page import="com.liferay.portal.kernel.exception.UserPasswordException"%>
<%@page import="com.liferay.portal.kernel.exception.UserEmailAddressException"%>
<%@page import="com.liferay.amf.registration.exception.UserRegistrationValidationException"%>
<%@page import="com.liferay.amf.registration.exception.AddressValidationException"%>
<%@page import="com.liferay.amf.registration.exception.UserRegistrationReminderQueryException"%>
<%@page import="com.liferay.amf.registration.exception.UserCustomRegistrationValidationException"%>

<script src="https://code.jquery.com/jquery-latest.js"></script>

<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />

<portlet:defineObjects />