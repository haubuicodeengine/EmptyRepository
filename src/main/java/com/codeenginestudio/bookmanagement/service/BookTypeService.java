package com.codeenginestudio.bookmanagement.service;

import java.util.List;

import com.codeenginestudio.bookmanagement.dto.BookTypeDto;

public interface BookTypeService {

	List<BookTypeDto> getAllBookTypes();

	BookTypeDto getOneBookType(Long id);
	
	List<Long> getBookTypeIdByBookId (Long bookId);
}
