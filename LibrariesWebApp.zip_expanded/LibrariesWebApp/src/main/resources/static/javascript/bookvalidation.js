/**
 * 
 */

function myBook() {
	var book = document.getElementById("bookname").value;
	var regex =/^[a-zA-Z]+$/;
	if (book.trim() == "") {
		document.getElementById("bname").innerHTML = "*Book Name Can not Be Empty !";
		return false;
	} else if (!(regex.test(book)) ) {
	
		document.getElementById("bname").innerHTML = "*Book Name Can Not Contain Numbers !";
		return false;
	} else if (!(book.length >= 5 && book.length <= 15)) {
		document.getElementById("bname").innerHTML = "*Book Name Must contain characters between 5 and 15 ! ";
		return false;
	}

}
