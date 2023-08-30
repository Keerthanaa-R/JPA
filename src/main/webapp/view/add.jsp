<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<h1>Add the Account Details</h1>
	<hr />
	<table>
		<s:form action="addAccount" method="post" modelAttribute="a">
			<tr>
				<td>AccountId</td>
				<td><s:input path="accountid" /></td>
			</tr>

			<tr>
				<td>UserName</td>
				<td><s:input path="username" /></td>
			</tr>

			<tr>
				<td>MailId</td>
				<td><s:input path="mailid" /></td>
			</tr>

			<tr>
				<td>MobileNo</td>
				<td><s:input path="mobileno" /></td>
			</tr>

			<tr>
				<td>AccountType</td>
				<td><s:input path="accounttype" /></td>
			</tr>

			<tr>
				<td>Balance</td>
				<td><s:input path="balance" /></td>
			</tr>

			<tr>
				<td>Password</td>
				<td><s:input path="password" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="ADD" /></td>
			</tr>
		</s:form>
	</table>
</body>
</html>