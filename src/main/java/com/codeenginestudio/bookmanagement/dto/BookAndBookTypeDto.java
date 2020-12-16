package com.codeenginestudio.bookmanagement.dto;

public class BookAndBookTypeDto {

	protected Long bookAndBookTypeId;

	protected BookDto book;

	protected BookTypeDto bookType;

	public Long getBookAndBookTypeId() {
		return bookAndBookTypeId;
	}

	public void setBookAndBookTypeId(Long bookAndBookTypeId) {
		this.bookAndBookTypeId = bookAndBookTypeId;
	}

	public BookDto getBook() {
		return book;
	}

	public void setBook(BookDto book) {
		this.book = book;
	}

	public BookTypeDto getBookType() {
		return bookType;
	}

	public void setBookType(BookTypeDto bookType) {
		this.bookType = bookType;
	}

	public BookAndBookTypeDto(BookDto book, BookTypeDto bookType) {
		super();
		this.book = book;
		this.bookType = bookType;
	}

	public BookAndBookTypeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BookAndBookTypeEntity [bookAndBookTypeId=" + bookAndBookTypeId + ", book=" + book + ", bookType="
				+ bookType + "]";
	}
}
