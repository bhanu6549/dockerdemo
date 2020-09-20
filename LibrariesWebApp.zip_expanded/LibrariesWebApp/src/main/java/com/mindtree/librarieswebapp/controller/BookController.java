package com.mindtree.librarieswebapp.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mindtree.librarieswebapp.entity.Book;
import com.mindtree.librarieswebapp.entity.Library;
import com.mindtree.librarieswebapp.service.BookService;
import com.mindtree.librarieswebapp.service.LibraryService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private LibraryService libraryService;

	@RequestMapping(value = "/{libraryId}", method = RequestMethod.GET)
	public String bookhomepage(Model model, @PathVariable long libraryId) {

		model.addAttribute("booklist", bookService.listAllBook(libraryId));

		return "booklistpage";
	}

	@ResponseBody
	@RequestMapping(value = "/exportbook", method = RequestMethod.GET)
	public void exportInExcel(HttpServletResponse response, @RequestParam("id") long id) throws IOException {
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=BookData.xlsx");

		ByteArrayInputStream stream = bookService.writingBookDataIntoExcel(id);
		IOUtils.copy(stream, response.getOutputStream());

	}

	@RequestMapping(value = "bookadd", method = RequestMethod.GET)
	public String displayAddBookPage(Model model, @RequestParam("id") long id) {
		Library library = libraryService.getLibrary(id);
		model.addAttribute("lib", library);

		model.addAttribute("book", new Book());
		return "addbook";
	}

	@RequestMapping(value = "savebook", method = RequestMethod.POST)
	public String addBook(@ModelAttribute("book") Book book, @RequestParam("id") long id, Model model) {

		if (bookService.saveBook(book, id)) {
			return "redirect:/" + id;
		}

		Library library = libraryService.getLibrary(id);
		model.addAttribute("lib1", library);

		return "errorbookpage";

	}

	@RequestMapping(value = "bookdelete", method = RequestMethod.GET)
	public String deleteBookPage(Model model, @RequestParam("id") long id) {

		List<Book> books = bookService.listAllBook(id);
		model.addAttribute("booklist", books);

		return "deletebook";
	}

	@RequestMapping(value = "bookdeleted")
	public String deleteBookData(@RequestParam(name = "id") long id) {
		Book book = bookService.getBook(id);
		long libId = book.getLibrary().getLibraryId();
		bookService.deleteBook(id);

		return "redirect:/" + libId;

	}

	@RequestMapping(value = "editbook/{bookId}", method = RequestMethod.GET)
	public String editLibraryPage(@PathVariable long bookId, Model model) {
		model.addAttribute("book", bookService.getBook(bookId));
		return "updatebook";
	}

	@RequestMapping(value = "editbook/{bookId}/editbooksave", method = RequestMethod.POST)
	public String editLibrarySave(@ModelAttribute("book") Book book, @PathVariable long bookId) {

		bookService.updateBook(book, bookId);
		Book bookdata = bookService.getBook(bookId);
		long libId = bookdata.getLibrary().getLibraryId();

		return "redirect:/" + libId;
	}

}
