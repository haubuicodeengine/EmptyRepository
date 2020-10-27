package com.codeenginestudio.bookManagement.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Book")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bookId")
	protected int bookId;

	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="bookAuthorId", referencedColumnName = "authorId")
	protected Author bookAuthor;

	@Column(name="bookName")
	protected String bookName;
	
//	@ManyToOne(cascade = CascadeType.DETACH)
//	@JoinColumn(name="bookAndBookTypeId", referencedColumnName = "bookAndBookTypeId",nullable=false)
//	protected BookAndBookType bookAndBookType;

	public Book() {
		super();
	}

	public Book(String bookName, Author bookAuthor) {
//		, BookAndBookType bookAndBookType
		super();
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
//		this.bookAndBookType = bookAndBookType;
	}

	public Book(int bookId, String bookName, Author bookAuthor) {
//		, BookAndBookType bookAndBookType
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
//		this.bookAndBookType = bookAndBookType;
	}

//	public BookAndBookType getBookAndBookType() {
//		return bookAndBookType;
//	}
//
//	public void setBookAndBookType(BookAndBookType bookAndBookType) {
//		this.bookAndBookType = bookAndBookType;
//	}

	public Author getBookAuthor() {
		return bookAuthor;
	}

	public String getBookName() {
		return bookName;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookAuthor(Author bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
}
