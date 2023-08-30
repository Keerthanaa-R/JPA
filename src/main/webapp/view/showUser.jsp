<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<h1>User Details</h1>
	<hr />
	<a href="home"><button class="btn btn-warning">LOGOUT</button></a>
	<a href="home"><button class="btn btn-danger">HOME</button></a>
	<a href="viewUser"><button class="btn btn-primary">REFRESH</button></a>
	
	<hr />
	<table class="table table-bordered table-striped table-hover">
		<tr>
			<th>AccountId</th>
			<th>UserName</th>
			<th>Password</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${u}" var="user">
			<tr>
				<td>${user.getAccountid()}</td>
				<td>${user.getUsername()}</td>
				<td>${user.getPassword()}</td>
				<td><a href="deleted?accountid=${user.getAccountid()}">Delete</a></td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>