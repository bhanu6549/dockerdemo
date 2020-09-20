<%@page import="com.mindtree.librarieswebapp.entity.Library"%>
<%@page import="org.springframework.web.bind.annotation.ModelAttribute"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Displaying Book Details</title>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
</head>
<body>



	<!-- 	<button style="margin-left: 40%; margin-top: 4%;" class="open-button"
		onclick="openTable();">Books Details</button>
	<button style="margin-left: 4%" class="close-button"
		onclick="closeTable()">Close</button> -->



	<form:form>
		<div align="center" id="myTable"">
			<h2>Book Details</h2>
			<hr />
			<c:import url="/{libraryId}"></c:import>
			<a href="/exportbook?id=${libraryId}"><button
					style="margin-right: 90%;" type="button">Export</button></a> <br>
			<table border="2" width=70% cellpadding="5">
				<tr>
					<th>Id</th>
					<th>Book Name</th>
					<th>Update</th>

				</tr>

				<c:forEach var="book" items="${booklist}">

					<tr align="center">
						<td>${book.bookId}</td>
						<td>${book.bookName}</td>


						<td><a href="editbook/${book.bookId}">Update</a></td>



					</tr>
				</c:forEach>
			</table>
			<c:import url="/{libraryId}"></c:import>
			<br></br> <a href="bookadd?id=${libraryId}"><button type="button">Add
					New Book</button></a> <a href="bookdelete?id=${libraryId}"><button
					style="margin-left: 4%" type="button">Delete Book</button></a> <a
				href="/indexpage"><button style="margin-left: 4%" type="button">Library
					Details</button></a>

		</div>
	</form:form>


	<script type="text/javascript">
		function openTable() {
			document.getElementById("myTable").style.display = "block";
		}
		function closeTable() {
			document.getElementById("myTable").style.display = "none";
		}
	</script>

</body>
</html>