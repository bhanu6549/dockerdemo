<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Book</title>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
</head>
<body>
	<div align="center">
		<h2>Edit Book</h2>
		<hr />
		<br>
		<form:form method="post" modelAttribute="book"
			action="${book.bookId}/editbooksave">
			<table>
				<tr>
					<td>Book Id :</td>
					<td>${book.bookId}<form:hidden path="bookId" /></td>
				</tr>
				<tr>
					<td>Book Name :</td>
					<td><form:input path="bookName" pattern="^[a-zA-Z\s]+$" /></td>
				</tr>



			</table>
			<br>
			<button type="submit" onclick="editBookFunction()">Save</button>
		</form:form>
	</div>

	<script type="text/javascript">
		function editBookFunction() {
			alert("Book Updated Sucessfully!");
		}
	</script>
</body>
</html>