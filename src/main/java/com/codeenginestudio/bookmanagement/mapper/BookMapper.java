package com.codeenginestudio.bookmanagement.mapper;

import com.codeenginestudio.bookmanagement.dto.AuthorDto;
import com.codeenginestudio.bookmanagement.dto.BookDto;
import com.codeenginestudio.bookmanagement.entity.AuthorEntity;
import com.codeenginestudio.bookmanagement.entity.BookEntity;

public class BookMapper {

	public static BookDto _parseToBookDto(BookEntity bookEntity) {
		
		BookDto bookDto = new BookDto();
		bookDto.setBookId(bookEntity.getBookId());
		AuthorDto authorDto = AuthorMapper._parseToAuthorDto(bookEntity.getBookAuthor());
		bookDto.setBookAuthor(authorDto);
		bookDto.setBookName(bookEntity.getBookName());

		return bookDto;
	}

	public static BookEntity _parseToBookEntity(BookDto bookDto) {

		BookEntity bookEntity = new BookEntity();
		bookEntity.setBookId(bookDto.getBookId());
		AuthorEntity authorEntity = AuthorMapper._parseToAuthorEntity(bookDto.getBookAuthor());
		bookEntity.setBookAuthor(authorEntity);
		bookEntity.setBookName(bookDto.getBookName());

		return bookEntity;
	}
}
