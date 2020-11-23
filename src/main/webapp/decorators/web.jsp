<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ page import="com.codeenginestudio.bookmanagement.dto.BookDto"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Management</title>

<link
	href="<c:url value='/template/web/vendor/bootstrap/css/bootstrap.min.css'/>"
	rel="stylesheet" type="text/css">

<link href="<c:url value='/template/web/css/Style.css'/>"
	rel="stylesheet" type="text/css">
</head>
<body>

	<%@ include file="/common/header.jsp"%>

	<dec:body />

	<script
		src="<c:url value='/template/web/vendor/jquery/jquery.min.js'/>"></script>
	<script
		src="<c:url value='/template/web/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
</body>
</html>