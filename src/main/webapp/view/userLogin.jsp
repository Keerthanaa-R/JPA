<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LogIn</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<center>
		<img
			src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR6zj-VmJHH2IRIKqBUrQumpLHm54o2ySuMsA&usqp=CAU"
			alt="" width="90px" height="90px">

	</center>
	<a href="home"><button class="btn btn-warning">HOME</button></a>
	<hr />
	<table>
		<s:form action="userLogin" method="post" modelAttribute="u">
			<tr>
				<td>UserName</td>
				<td><s:input path="username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><s:input type="password" path="password" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="LogIn" /></td>
			</tr>
		</s:form>

	</table>
</body>
</html>