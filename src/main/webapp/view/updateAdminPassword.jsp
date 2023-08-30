<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Admin Password</title>
</head>
<body>
<center>
		<img
			src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR6zj-VmJHH2IRIKqBUrQumpLHm54o2ySuMsA&usqp=CAU"
			alt="" width="90px" height="90px">

	</center>
	<table>
		<s:form action="adminPasswordUpdated" method="post" modelAttribute="a">
			<tr>
				<td>UserName</td>
				<td><s:input path="username" value="${username}" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><s:input type="password" path="password" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="update" /></td>
			</tr>

		</s:form>
	</table>
</body>
</html>