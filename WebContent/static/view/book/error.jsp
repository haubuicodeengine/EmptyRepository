<%@ include file="../common/import.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="./static/css/style.css" rel="stylesheet" type="text/css">
<title>Error</title>
</head>
<body>
	<div class="col-sm-5">
		<div>
			<p> ${errors}</p>
		</div>

		<div class="welcome-banel">
			<a href="/BookManagement-w1/Book/"><button class="btn-start">Back to list of book</button></a>
		</div>
	</div>
</body>
</html>