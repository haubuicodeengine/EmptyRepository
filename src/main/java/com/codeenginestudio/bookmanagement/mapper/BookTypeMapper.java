package com.codeenginestudio.bookmanagement.mapper;

import com.codeenginestudio.bookmanagement.dto.BookTypeDto;
import com.codeenginestudio.bookmanagement.entity.BookTypeEntity;

public class BookTypeMapper {

	public static BookTypeDto _parseToBookTypeDto(BookTypeEntity booktypeEntity) {

		BookTypeDto bookTypeDto = new BookTypeDto();
		bookTypeDto.setId(booktypeEntity.getId());
		bookTypeDto.setName(booktypeEntity.getName());

		return bookTypeDto;
	}
	
	public static BookTypeEntity _parseToBookTypeEntity(BookTypeDto bookTypeDto) {

		BookTypeEntity booktypeEntity = new BookTypeEntity();
		booktypeEntity.setId(bookTypeDto.getId());
		booktypeEntity.setName(bookTypeDto.getName());

		return booktypeEntity;
	}
}
