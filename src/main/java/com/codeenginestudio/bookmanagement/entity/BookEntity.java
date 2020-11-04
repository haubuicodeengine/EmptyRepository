package com.codeenginestudio.bookmanagement.entity;

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
@Table(name = "book")
public class BookEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private Long bookId;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "author_id", referencedColumnName = "author_id")
	private AuthorEntity bookAuthor;

	@Column(name = "name")
	private String bookName;

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public AuthorEntity getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(AuthorEntity bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public BookEntity(Long bookId, AuthorEntity bookAuthor, String bookName) {
		super();
		this.bookId = bookId;
		this.bookAuthor = bookAuthor;
		this.bookName = bookName;
	}

	public BookEntity(AuthorEntity bookAuthor, String bookName) {
		super();
		this.bookAuthor = bookAuthor;
		this.bookName = bookName;
	}

	public BookEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BookEntity [bookId=" + bookId + ", bookAuthor=" + bookAuthor + ", bookName=" + bookName + "]";
	}
}
