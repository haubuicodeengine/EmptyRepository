package com.codeenginestudio.bookManagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BookType")
public class BookType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bookTypeId")
	protected int bookTypeId;

	@Column(name="bookTypeName")
	protected String bookTypeName;

	public int getBookTypeId() {
		return bookTypeId;
	}

	public void setBookTypeId(int bookTypeId) {
		this.bookTypeId = bookTypeId;
	}

	public String getBookTypeName() {
		return bookTypeName;
	}

	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}

}
