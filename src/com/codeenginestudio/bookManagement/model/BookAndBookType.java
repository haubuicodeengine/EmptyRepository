package com.codeenginestudio.bookManagement.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BookAndBookType")
public class BookAndBookType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookAndBookTypeId")
	protected int bookAndBookTypeId;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "bookId", referencedColumnName = "bookId")
	protected Book book;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "bookTypeId", referencedColumnName = "bookTypeId")
	protected BookType bookType;

	public BookAndBookType() {
		super();
	}

	public BookAndBookType(Book book, BookType bookType) {
		super();
		this.book = book;
		this.bookType = bookType;
	}

	public int getBookAndBookTypeId() {
		return bookAndBookTypeId;
	}

	public void setBookAndBookTypeId(int bookAndBookTypeId) {
		this.bookAndBookTypeId = bookAndBookTypeId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public BookType getBookType() {
		return bookType;
	}

	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}
}
