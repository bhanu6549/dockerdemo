package com.mindtree.librarieswebapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "bookId")
@Table(name = "Book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private long bookId;

	@Column(name = "Name")
	private String bookName;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Library library;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String bookName, Library library) {
		this.bookName = bookName;
		this.library = library;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	public long getBookId() {
		return bookId;
	}

}
