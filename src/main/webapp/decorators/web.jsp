<%@ include file="/common/configLanguage.jsp"%>
<%@ include file="/common/taglib.jsp"%>
<%@ include file="/common/import.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Management</title>

<link
	href="<c:url value='/template/web/vendor/bootstrap/css/bootstrap.min.css'/>"
	rel="stylesheet" type="text/css">

<link href="<c:url value='/template/web/css/style.css'/>"
	rel="stylesheet" type="text/css">
</head>
<body>

	<%@ include file="/common/header.jsp"%>

	<dec:body />

	<%@ include file="/common/confirm.jsp"%>
	<script
		src="<c:url value='/template/web/vendor/jquery/jquery.min.js'/>"></script>
	<script
		src="<c:url value='/template/web/js/book.js'/>"></script>
	<script
		src="<c:url value='/template/web/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
</body>
</html>