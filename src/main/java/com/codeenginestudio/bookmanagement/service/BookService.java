package com.codeenginestudio.bookmanagement.service;

import java.util.List;

import com.codeenginestudio.bookmanagement.dto.BookDto;

public interface BookService {

	List<BookDto> getAllBooks();

	BookDto getOneBook(Long id) throws Exception;

	void deleteBook(Long id);

	void updateBook(BookDto bookDto);

	BookDto insertBook(BookDto bookDto);
}
