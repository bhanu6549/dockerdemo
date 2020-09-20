<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">

</head>
<body>
	<div align="center">
		<form:form method="post" modelAttribute="loginobj" action="verify">
			<h2>
				<b>Account Login</b>
			</h2>
			<hr>
			<table cellpadding=5%>

				<tr>
					<td><b>Username : </b><form:input path="username"
							placeholder="Enter Username" id="username"/><br>
						<b><span id="m1" style="color: red;" onkeydown="myFunction()"></span></b></td>
				</tr>
				<tr>


				</tr>

				<tr>
					<td><b>Password : </b><form:password path="password"
							placeholder="Enter Password" id="password" name="pswd" /><br>
						<b><span id="m2" style="color: red;" onkeydown="myFunction()"></span></b></td>

				</tr>

			</table>
			<br>
			<a href="/indexpage"><button type="submit"
					onclick="return myFunction()">
					<b>Login</b>
				</button></a>
		</form:form>
	</div>
	<script type="text/javascript"
		src="<c:url value="/resources/javascript/Pages_Validation.js"/>"></script>

</body>
</html>