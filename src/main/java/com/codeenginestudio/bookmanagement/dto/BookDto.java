package com.codeenginestudio.bookmanagement.dto;

import com.codeenginestudio.bookmanagement.entity.AuthorEntity;

public class BookDto {

	private Long bookId;

	private AuthorDto bookAuthor;

	private String bookName;

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public AuthorDto getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(AuthorDto bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public BookDto(Long bookId, AuthorDto bookAuthor, String bookName) {
		super();
		this.bookId = bookId;
		this.bookAuthor = bookAuthor;
		this.bookName = bookName;
	}

	public BookDto(AuthorDto bookAuthor, String bookName) {
		super();
		this.bookAuthor = bookAuthor;
		this.bookName = bookName;
	}

	public BookDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BookEntity [bookId=" + bookId + ", bookAuthor=" + bookAuthor + ", bookName=" + bookName + "]";
	}
}
