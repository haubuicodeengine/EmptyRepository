package com.codeenginestudio.bookmanagement.mapper;

import com.codeenginestudio.bookmanagement.dto.BookAndBookTypeDto;
import com.codeenginestudio.bookmanagement.dto.BookDto;
import com.codeenginestudio.bookmanagement.dto.BookTypeDto;
import com.codeenginestudio.bookmanagement.entity.BookAndBookTypeEntity;
import com.codeenginestudio.bookmanagement.entity.BookEntity;
import com.codeenginestudio.bookmanagement.entity.BookTypeEntity;

public class BookAndBookTypeMapper {

	public static BookAndBookTypeEntity _parseToBookAndBookTypeEntity (BookAndBookTypeDto bookAndBookTypeDto) {

		BookAndBookTypeEntity bookAndBookTypeEntity = new BookAndBookTypeEntity();
		bookAndBookTypeEntity.setBookAndBookTypeId(bookAndBookTypeDto.getBookAndBookTypeId());
		BookEntity bookEntity = BookMapper._parseToBookEntity(bookAndBookTypeDto.getBook());
		bookAndBookTypeEntity.setBook(bookEntity);
		BookTypeEntity bookTypeEntity = BookTypeMapper._parseToBookTypeEntity(bookAndBookTypeDto.getBookType());
		bookAndBookTypeEntity.setBookType(bookTypeEntity);

		return bookAndBookTypeEntity;
	}

	public static BookAndBookTypeDto _parseToBookAndBookTypeDto (BookAndBookTypeEntity bookAndBookTypeEntity) {

		BookAndBookTypeDto bookAndBookTypeDto = new BookAndBookTypeDto();
		bookAndBookTypeDto.setBookAndBookTypeId(bookAndBookTypeEntity.getBookAndBookTypeId());
		BookDto bookDto = BookMapper._parseToBookDto(bookAndBookTypeEntity.getBook());
		bookAndBookTypeDto.setBook(bookDto);
		BookTypeDto bookTypeDto = BookTypeMapper._parseToBookTypeDto(bookAndBookTypeEntity.getBookType());
		bookAndBookTypeDto.setBookType(bookTypeDto);

		return bookAndBookTypeDto;
	}
}
