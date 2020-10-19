package com.codeenginestudio.bookManagement.models;

public class Book {

	public Book() {
		super();
	}

	public Book(String bookName, String bookAuthor) {
		super();
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
	}

	public Book(int bookId, String bookName, String bookAuthor) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public String getBookName() {
		return bookName;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	private String bookAuthor;
	private String bookName;
	private int bookId;
}
