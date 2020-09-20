<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Library</title>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
</head>
<body style="background-color: menu;">
	<div align="center">
		<h2>Add New Library</h2>
		<!-- <hr style="width:50%" /> -->
		<hr />
		<br>
		<form:form method="post" modelAttribute="library" action="savelibrary">
			<table>
				<tr>
					<td>Library Name : <form:input path="libraryName"
							placeholder="Enter Library Name" id="libraryName" /> <br> <b><span
							id="lname" style="color: red;"></span></b>
					</td>
				</tr>


			</table>
			<br>
			<button type="submit" onclick="return myLibrary()">Save</button>


		</form:form>

	</div>
<script type="text/javascript"
		src="<c:url value="/resources/javascript/Pages_Validation.js"/>"></script>
	<!-- 
	<script type="text/javascript">
		/* 	function mySaveFunction() {
				var inputVal = document.getElementById("name").value;
				console.log(inputVal);
				if (inputval == "Kiit") {
					alert("Book Added Sucessfully!");

				} else
					alert("Failed");
			} */
		function textInput(name) {
			/* var inputVal = document.getElementById("name").value;
			 */
			var letters = /^[A-Za-z]+$/;
			if (name.value.match(letters)) {
				return true;
			} else {
				alert("Library Name must have alphabet characters only");
				name.focus();
				return false;
			}
		}
	</script>
 -->
</body>
</html>