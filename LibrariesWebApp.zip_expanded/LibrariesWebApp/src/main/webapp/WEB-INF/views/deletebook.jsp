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
<body   > 
	<div align="center">
		<h2>Delete Book</h2>
		<hr />
		<br>
		
		<form action="bookdeleted">
			Select Book ID :&nbsp; <select name="id">
				<c:forEach var="book" items="${booklist}">
					<option value="${book.bookId}">${book.bookId}</option>
				</c:forEach>
			</select> <br /> <br /> <button type="submit" onclick="deleteFunction()">Submit</button> 
		</form>
	</div>
	<script type="text/javascript">
		function deleteFunction() {

			alert("Book Deleted Sucessfully!");

		}
	</script>
</body>
</html>