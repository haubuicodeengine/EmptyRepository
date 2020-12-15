package com.codeenginestudio.management.book.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookId")
	protected Long bookId;

	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "bookAuthorId", referencedColumnName = "authorId")
	protected Author bookAuthor;

	@Column(name = "bookName")
	protected String bookName;

	public Book() {
		super();
	}

	public Book(String bookName, Author bookAuthor) {
		super();
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
	}

	public Book(Long bookId, String bookName, Author bookAuthor) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
	}

	public Author getBookAuthor() {
		return bookAuthor;
	}

	public String getBookName() {
		return bookName;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookAuthor(Author bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
}
