<%@ include file="../common/import.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../static/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link href="../static/css/style.css" rel="stylesheet" type="text/css">
<title>Error</title>
</head>
<body>
	<div class="container error-container">
		<p> ${errors}</p>
		<a href="/bookManagement/book/"><button>Back to list of book</button></a>
	</div>
</body>
</html>