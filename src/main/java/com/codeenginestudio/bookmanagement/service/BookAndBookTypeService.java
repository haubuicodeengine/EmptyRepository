package com.codeenginestudio.bookmanagement.service;

import java.util.List;

import com.codeenginestudio.bookmanagement.dto.BookAndBookTypeDto;

public interface BookAndBookTypeService {

	List<BookAndBookTypeDto> getAllBookAndBookTypes();

	BookAndBookTypeDto getOneBookAndBooktype(long id);

	void insertBookAndBookType(BookAndBookTypeDto bookAndBookTypeDto);

	void deleteBookAndBookType(Long id);

	List<BookAndBookTypeDto> getAllBookAndBookTypeByBookId(Long bookId);
	
	BookAndBookTypeDto getBookAndBookTypeByBookTypeId(Long bookTypeId);
}
