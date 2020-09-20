/**
 * 
 */

 myFunction=()=> {

	console.log("Function hitted");
	var name = document.getElementById("username").value;
	var pswd = document.getElementById("password").value;

	if (name.trim() == "" && pswd.length == 0) {
		document.getElementById("m1").innerHTML = "*Username Cannot Be Empty !";
		document.getElementById("m2").innerHTML = "*Password Cannot Be Empty !";

		/* alert("Hello"); */
		return false;
	} else if (!(name.charAt(0) >= 'A' && name.charAt(0) <= 'Z')) {
		document.getElementById("m1").innerHTML = "*First Letter Must be UpperCase Character !";
		return false;
	} else if (!(name.length >= 5 && name.length <= 15)) {
		document.getElementById("m1").innerHTML = "*Username characters must be between 5 and 15 ! ";
		return false;
	}

	for (var i = 0; i < pswd.length; i++) {
		if (pswd.charAt(i) == '@') {
			return true;
		}

	}
	

	document.getElementById("m2").innerHTML = "*Password Must Contain @ !";

	return false;

}

 myLibrary=()=> {
	var library = document.getElementById("libraryName").value;
	var regex = /^[a-zA-Z ]*$/;
	if (library.trim() == "") {
		document.getElementById("lname").innerHTML = "*Library Name Cannot Be Empty !";
		return false;
	} else if (!(regex.test(library))) {

		document.getElementById("lname").innerHTML = "*Library Name Can Not Contain Numbers !";
		return false;
	} else if (!(library.length >= 5 && library.length <= 15)) {
		document.getElementById("lname").innerHTML = "*Library Name Must contain characters between 5 and 15 ! ";
		return false;
	}

}

 function myBook(){
	var book = document.getElementById("bookname").value;
	var regex = /^[a-zA-Z ]*$/;
	if (book.trim() == "") {
		document.getElementById("bname").innerHTML = "*Book Name Can not Be Empty !";
		return false;
	} else if (!(regex.test(book))) {

		document.getElementById("bname").innerHTML = "*Book Name Can Not Contain Numbers !";
		return false;
	} else if (!(book.length >= 5 && book.length <= 15)) {
		document.getElementById("bname").innerHTML = "*Book Name Must contain characters between 5 and 15 ! ";
		return false;
	}

}
