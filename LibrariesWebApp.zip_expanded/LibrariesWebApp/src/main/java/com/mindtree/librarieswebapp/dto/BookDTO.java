package com.mindtree.librarieswebapp.dto;

public class BookDTO {
	private long bookId;

	private String bookName;

	private long libraryId;

	public BookDTO() {
		// TODO Auto-generated constructor stub
	}

	public BookDTO(long bookId, String bookName, long libraryId) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.libraryId = libraryId;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public long getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(long libraryId) {
		this.libraryId = libraryId;
	}

}
