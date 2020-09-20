package com.mindtree.librarieswebapp.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "libraryId")
@Table(name = "Library")
public class Library {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long libraryId;

	@Column(name = "Name")
	private String libraryName;

	@Column(name = "No_Of_Books")
	private long noOfBooks;

	@JsonIgnore
	@OneToMany(mappedBy = "library", cascade = CascadeType.PERSIST, orphanRemoval = true)
	private List<Book> booksList = new LinkedList<Book>();

	public Library() {
		// TODO Auto-generated constructor stub
	}

	public Library(long libraryId, String libraryName, long noOfBooks, List<Book> booksList) {
		this.libraryId = libraryId;
		this.libraryName = libraryName;
		this.noOfBooks = noOfBooks;
		this.booksList = booksList;
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

	public List<Book> getBooksList() {
		return booksList;
	}

	public void setBooksList(Book book) {
		this.booksList.add(book);
	}

}
