<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Displaying Libraries</title>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
<style type="text/css">
#AlertDiv {
	/* top: 198px;
	left: 365px;
	 */
	width: 100%;
	height: 40px;
	color: white;
	/* 	position: absolute;
 */
	text-align: center;
	/* 	background-color: black;
 */
}

#AlertDiv h1 {
	margin: auto;
	line-height: 70px;
	vertical-align: middle;
}
</style>
</head>
<body>


	<a href="/"><button type="button" id="log">Logout</button></a>



	<!-- <button style="margin-left: 45%" class="open-button"
		onclick="openTable();">Libraries Details</button>
	<button style="margin-left: 4%" class="close-button"
		onclick="closeTable()">Close</button>
		id="myTable" style="display: none;
 -->
	<form:form>
		<div align="center">
			<h2>Library Management</h2>

			<hr>
			<a href="/exportlibrary"><button style="margin-right: 90%;"
					type="button">Export</button></a>
			<table border="2" width=70% cellpadding="5">
				<tr>
					<th>Id</th>
					<th>Library Name</th>
					<th>No. Of Books</th>

					<th>Update</th>
					<th>Details</th>
				</tr>

				<c:forEach var="library" items="${librarylist}">

					<tr align="center">
						<td>${library.libraryId}</td>
						<td>${library.libraryName}</td>
						<td>${library.noOfBooks}</td>


						<td><a href="editlibrary/${library.libraryId}">Update</a></td>
						<td><a href="${library.libraryId}">Details</a></td>


					</tr>
				</c:forEach>

			</table>
			<br>
			<br>
			<a href="/addnewlibrary"><button type="button">Add New
					Library</button></a> <a href="/librarydelete"><button type="button"
					style="margin-left: 4%;">Delete Library</button></a>
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