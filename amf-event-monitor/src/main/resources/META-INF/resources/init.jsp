<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay" %>
<%@ taglib prefix="liferay-security" uri="http://liferay.com/tld/security" %>

<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="com.liferay.portal.security.audit.storage.model.*"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.security.permission.ActionKeys" %>
<%@ page import="com.liferay.portal.kernel.security.permission.PermissionChecker" %>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay" %>

<%@ page import="com.liferay.amf.event.monitor.constants.*"%>
<%@ page import="com.liferay.portal.security.audit.event.generators.constants.EventTypes"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />