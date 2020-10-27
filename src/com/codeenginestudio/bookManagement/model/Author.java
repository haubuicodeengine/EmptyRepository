package com.codeenginestudio.bookManagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Author")
public class Author {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="authorId")
	protected int authorId;

	@Column(name="authorName")
	protected String authorName;
	
	public Author() {
		super();
	}
	
	public Author(int authorId, String authorName) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

}
