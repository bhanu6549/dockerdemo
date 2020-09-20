<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
</head>
<body>
<body>
	<div align="center">
		<h2>Add New Book</h2>
		<!-- <hr style="width:50%" /> -->
		<hr />
		<br>

		<form:form method="post" modelAttribute="book"
			action="savebook?id=${lib.libraryId}">

			<table>
				<tr>
					<td>Book Name : <form:input path="bookName" id="bookname"
							placeholder="Enter Book Name" /> <br> <b><span
							id="bname" style="color: red;"></span></b></td>
				</tr>


			</table>
			<br>
			<button type="submit" onclick="return myBook()">Save</button>


		</form:form>

	</div>
<script type="text/javascript"
		src="<c:url value="/resources/javascript/Pages_Validation.js"/>"></script>

	<!-- 	<script type="text/javascript">
		function mySaveFunction() {
			var inputVal = document.getElementById("name");
			if (inputval.trim() != "") {
				alert("Book Added Sucessfully!");
			} else {

			}
		}

		function myerror() {
			/*  var txt = document.getElementById("nameid").value 
			 */

			document.getElementById("nameid").innerHTML = "Welcome to Possible";
		}
	</script> -->
</body>
</html>