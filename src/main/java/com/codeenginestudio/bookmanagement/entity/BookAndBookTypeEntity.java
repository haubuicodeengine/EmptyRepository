package com.codeenginestudio.bookmanagement.entity;

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
@Table(name = "book_and_book_type")
public class BookAndBookTypeEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	protected Long bookAndBookTypeId;

	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "book_id", referencedColumnName = "book_id")
	protected BookEntity book;

	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "book_type_id", referencedColumnName = "book_type_id")
	protected BookTypeEntity bookType;

	public Long getBookAndBookTypeId() {
		return bookAndBookTypeId;
	}

	public void setBookAndBookTypeId(Long bookAndBookTypeId) {
		this.bookAndBookTypeId = bookAndBookTypeId;
	}

	public BookEntity getBook() {
		return book;
	}

	public void setBook(BookEntity book) {
		this.book = book;
	}

	public BookTypeEntity getBookType() {
		return bookType;
	}

	public void setBookType(BookTypeEntity bookType) {
		this.bookType = bookType;
	}

	public BookAndBookTypeEntity(Long bookAndBookTypeId, BookEntity book, BookTypeEntity bookType) {
		super();
		this.bookAndBookTypeId = bookAndBookTypeId;
		this.book = book;
		this.bookType = bookType;
	}

	public BookAndBookTypeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BookAndBookTypeEntity [bookAndBookTypeId=" + bookAndBookTypeId + ", book=" + book + ", bookType="
				+ bookType + "]";
	}
}
