package com.mindtree.librarieswebapp.dto;

public class LibraryDTO {

	private long libraryId;

	private String libraryName;

	private long noOfBooks;

	public LibraryDTO() {
		// TODO Auto-generated constructor stub
	}

	public LibraryDTO(long libraryId, String libraryName, long noOfBooks) {
		this.libraryId = libraryId;
		this.libraryName = libraryName;
		this.noOfBooks = noOfBooks;
	}

	public long getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(long libraryId) {
		this.libraryId = libraryId;
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	public long getNoOfBooks() {
		return noOfBooks;
	}

	public void setNoOfBooks(long noOfBooks) {
		this.noOfBooks = noOfBooks;
	}

	@Override
	public String toString() {
		return "LibraryDTO [libraryId=" + libraryId + ", libraryName=" + libraryName + ", noOfBooks=" + noOfBooks + "]";
	}

}
