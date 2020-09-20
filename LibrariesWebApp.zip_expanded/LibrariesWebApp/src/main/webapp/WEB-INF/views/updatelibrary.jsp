<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Library</title>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
</head>
<body>
	<div align="center">
		<h2>Edit Library</h2>
		<hr />
		<br>
		<form:form method="post" modelAttribute="library"
			action="${library.libraryId}/editlibsave">
			<table>
				<tr>
					<td>Library Id :</td>
					<td>${library.libraryId}<form:hidden path="libraryId" /></td>
				</tr>
				<tr>
					<td>Library Name :</td>
					<td><form:input path="libraryName" pattern="^[a-zA-Z\s]+$" /></td>
				</tr>



			</table>
			<br>
			<button type="submit" onclick="editLibraryFunction()">Save</button>
		</form:form>
	</div>

	<script type="text/javascript">
		function editLibraryFunction() {
			alert("Library Updated Sucessfully!");
		}
	</script>
</body>
</html>