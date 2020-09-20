<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
<title>Login Error</title>
</head>
<body>
	<div align="center">
		<h3>
			<b>Please enter correct username and password</b>
		</h3>
		<a href="/"><button type="submit">
				<b>Login</b>
			</button></a>
	</div>
</body>
</html>