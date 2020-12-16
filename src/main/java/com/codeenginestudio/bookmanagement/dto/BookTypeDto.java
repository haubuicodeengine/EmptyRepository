package com.codeenginestudio.bookmanagement.dto;

public class BookTypeDto {

	private Long id;

	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BookTypeDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public BookTypeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BookTypeEntity [id=" + id + ", name=" + name + "]";
	}
}
