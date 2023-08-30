<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User HomePage</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<h1>Welcome To User HomePage!!!</h1>
	<a href="home"><button class="btn btn-warning">HOME</button></a>
	<a href="updateUserPassword?username=${username}"><button
			class="btn btn-primary">Update Password</button></a>
	<hr />
	<a href="viewDetails?username=${username}">VIEW ACCOUNT</a>
</body>
</html>