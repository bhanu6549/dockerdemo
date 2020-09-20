<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Libraries</title>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
</head>
<body>

	<div align="center">
		<p id="errorid" style="font-size: 20px;"></p>
		<h2>Delete Library</h2>
		<hr />
		<br>
		<form action="/delete">
			Select Library ID :&nbsp; <select name="id" id="nameid">
				<c:forEach var="lib" items="${librarylist}">
					<option value="${lib.libraryId}">${lib.libraryId}</option>
				</c:forEach>
			</select> <br /> <br />
			<button type="submit" onclick="myerror()">Submit</button>
		</form>
	</div>
	<script type="text/javascript">
		function deleteFunction() {

			alert("Library Deleted Sucessfully!");

		}

		function myerror() {
			var txt = document.getElementById("nameid").value

			document.getElementById("errorid").innerHTML = "Welcome to Possible : "
					+ txt;
		}
	</script>
</body>
</html>