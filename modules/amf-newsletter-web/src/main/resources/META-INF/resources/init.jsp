<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib prefix="liferay-frontend" uri="http://liferay.com/tld/frontend" %>
<%@ page import="com.liferay.amf.newsletter.constants.MVCCommandNames" %>
<%@ page import="com.liferay.amf.newsletter.constants.NewsletterFields" %>
<%@ page import="com.liferay.amf.newsletter.service.NewsletterLocalServiceUtil" %>
<%@ page import="com.liferay.journal.model.JournalArticle" %>
<%@ page import="com.liferay.portal.kernel.search.Field" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>

<liferay-theme:defineObjects/>

<portlet:defineObjects/>