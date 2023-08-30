<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ALL ACCOUNT</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<h1>List of AccountDetails Available!!!</h1>
	<a href="home"><button class="btn btn-primary">HOME</button></a>
	<a href="view"><button class="btn btn-success">REFRESH</button></a>
	<a href="add"><button class="btn btn-warning">ADD</button></a>
	<a href="viewUser"><button class="btn btn-primary">USER</button></a>

	<hr />
	<h3>${msg}</h3>
	<div style="width: 800px">
		<table class="table table-striped">
			<tr>
				<th>AccountId</th>
				<th>UserName</th>
				<th>MailId</th>
				<th>MobileNo</th>
				<th>AccountType</th>
				<th>Balance</th>
				<th>Password</th>
				<th>Update</th>
				<th>Delete</th>
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
					<td><a
						href="update?accountid=${account.getAccountid()}&username=${account.getUsername()}
				&mailid=${account.getMailid()}&mobileno=${account.getMobileno()}&accounttype=${account.getAccounttype()}
				&balance=${account.getBalance()}&password=${account.getPassword()}">Update</a></td>
					<td><a href="delete?accountid=${account.getAccountid()}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>