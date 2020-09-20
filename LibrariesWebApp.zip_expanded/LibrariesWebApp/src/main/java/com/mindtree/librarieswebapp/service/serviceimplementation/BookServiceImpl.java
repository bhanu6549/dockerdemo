package com.mindtree.librarieswebapp.service.serviceimplementation;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.librarieswebapp.entity.Book;
import com.mindtree.librarieswebapp.entity.Library;
import com.mindtree.librarieswebapp.repository.BookRepository;
import com.mindtree.librarieswebapp.repository.LibraryRepository;
import com.mindtree.librarieswebapp.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private LibraryRepository libraryRepository;

	public boolean saveBook(Book book, long id) {
		Library library = libraryRepository.findById(id).get();
		if (library.getBooksList().isEmpty()) {

			library.setBooksList(book);
			library.setNoOfBooks(library.getBooksList().size());
			book.setLibrary(library);
			bookRepository.save(book);
			return true;
		}

		for (Book book2 : library.getBooksList()) {
			if (book2.getBookName().equalsIgnoreCase(book.getBookName()))
				return false;
		}

		library.setBooksList(book);
		library.setNoOfBooks(library.getBooksList().size());
		book.setLibrary(library);
		bookRepository.save(book);
		return true;
	}

	public List<Book> listAllBook(long id) {

		Library library = libraryRepository.findById(id).get();
		List<Book> books = library.getBooksList();

		return books;
	}

	public Book getBook(long id) {
		return bookRepository.findById(id).get();
	}

	public void updateBook(Book book, long id) {
		Book book2 = bookRepository.findById(id).get();
		book2.setBookName(book.getBookName());

		bookRepository.save(book2);
	}

	public void deleteBook(long id) {
		Book book = bookRepository.findById(id).get();
		Library library = book.getLibrary();
		library.getBooksList().remove(book);
		library.setNoOfBooks(library.getBooksList().size());
		bookRepository.deleteById(id);
	}

	public ByteArrayInputStream writingBookDataIntoExcel(long id) {

		List<Book> books = listAllBook(id);
		try {
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Books");

			Row row;
			row = sheet.createRow(0);
			Cell cell01 = row.createCell(0);
			cell01.setCellValue("Book_Id");
			Cell cell02 = row.createCell(1);
			cell02.setCellValue("Book_Name");
			Cell cell03 = row.createCell(2);
			cell03.setCellValue("Library_Id");

			int rownum = 1;

			for (Book book : books) {

				row = sheet.createRow(rownum++);
				Cell cell1 = row.createCell(0);
				cell1.setCellValue((long) book.getBookId());

				Cell cell2 = row.createCell(1);
				cell2.setCellValue(book.getBookName());

				Cell cell3 = row.createCell(2);
				cell3.setCellValue((long) book.getLibrary().getLibraryId());

			}

			FileOutputStream fileOutputStream = new FileOutputStream(new File(
					"C:\\Users\\m1057636\\git\\repository4\\LibrariesWebApp\\src\\main\\resources\\static\\ExcelSheets\\BookData.xlsx"));

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

			workbook.write(fileOutputStream);

			workbook.write(outputStream);
			workbook.close();
			return new ByteArrayInputStream(outputStream.toByteArray());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	/*
	 * public List<BookDTO> readBookDataFromExcel(long id) {
	 * 
	 * List<BookDTO> booksdata = new LinkedList<BookDTO>(); FileInputStream
	 * fileInputStream; try { fileInputStream = new FileInputStream(
	 * "C:\\Users\\m1057636\\git\\repository4\\LibrariesWebApp\\src\\main\\resources\\static\\ExcelSheets\\BookData.xlsx"
	 * );
	 * 
	 * XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream); XSSFSheet sheet =
	 * workbook.getSheet("Books");
	 * 
	 * for (int i = 1; i <= sheet.getLastRowNum(); i++) {
	 * 
	 * if (id == (long) sheet.getRow(i).getCell(2).getNumericCellValue()) { BookDTO
	 * bookDTO = new BookDTO();
	 * 
	 * bookDTO.setBookId((long) sheet.getRow(i).getCell(0).getNumericCellValue());
	 * 
	 * bookDTO.setBookName(sheet.getRow(i).getCell(1).getStringCellValue());
	 * 
	 * bookDTO.setLibraryId((long)
	 * sheet.getRow(i).getCell(2).getNumericCellValue());
	 * 
	 * booksdata.add(bookDTO); }
	 * 
	 * }
	 * 
	 * workbook.close(); fileInputStream.close();
	 * 
	 * } catch (IOException e) { e.printStackTrace(); } return booksdata;
	 * 
	 * }
	 */
}
