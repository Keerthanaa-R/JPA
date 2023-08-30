<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Details</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<h1>Account Details</h1>
	<hr />
	<a href="home"><button class="btn btn-primary">LOGOUT</button></a>
	<hr />
	<table class="table table-striped">
		<tr>
			<th>AccountId</th>
			<th>UserName</th>
			<th>MailId</th>
			<th>MobileNo</th>
			<th>AccountType</th>
			<th>Balance</th>
			<th>Password</th>
		</tr>
		<c:forEach items="${a}" var="account">
			<tr>
				<td>${account.getAccountid()}</td>
				<td>${account.getUsername()}</td>
				<td>${account.getMailid()}</td>
				<td>${account.getMobileno()}</td>
				<td>${account.getAccounttype()}</td>
				<td>${account.getBalance()}</td>
				<td>${account.getPassword()}</td>
				

			</tr>
		</c:forEach>
	</table>
</body>
</html>