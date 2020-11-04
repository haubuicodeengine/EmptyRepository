package com.codeenginestudio.bookmanagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeenginestudio.bookmanagement.dto.BookTypeDto;
import com.codeenginestudio.bookmanagement.entity.BookAndBookTypeEntity;
import com.codeenginestudio.bookmanagement.entity.BookEntity;
import com.codeenginestudio.bookmanagement.entity.BookTypeEntity;
import com.codeenginestudio.bookmanagement.mapper.BookTypeMapper;
import com.codeenginestudio.bookmanagement.repository.BookAndBookTypeRepository;
import com.codeenginestudio.bookmanagement.repository.BookRepository;
import com.codeenginestudio.bookmanagement.repository.BookTypeRepository;
import com.codeenginestudio.bookmanagement.service.BookTypeService;

@Service
public class BookTypeServiceImpl implements BookTypeService{

	@Autowired
	private BookTypeRepository bookTypeRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookAndBookTypeRepository bookAndbookTypeRepository;

	@Override
	public List<BookTypeDto> getAllBookTypes() {
		
		List<BookTypeDto> bookTypeDtos = new ArrayList<>();
		List<BookTypeEntity> listBookTypeEntities = bookTypeRepository.findAll();

		for (BookTypeEntity bookTypeEntity : listBookTypeEntities) {
			bookTypeDtos.add(BookTypeMapper._parseToBookTypeDto(bookTypeEntity));
		}

		return bookTypeDtos;
	}

	@Override
	public BookTypeDto getOneBookType(Long id) {

		BookTypeEntity bookTypeEntity = bookTypeRepository.findOne(id);
		return BookTypeMapper._parseToBookTypeDto(bookTypeEntity);
	}

	@Override
	public List<Long> getBookTypeIdByBookId(Long bookId) {

		BookEntity theBook = bookRepository.findOne(bookId);
		List<Long> bookTypeIds = new ArrayList<>();
		List<BookAndBookTypeEntity> bookAndBookTypeEntities =  bookAndbookTypeRepository.findByBook(theBook);
		
		for (BookAndBookTypeEntity bookAndBookTypeEntity : bookAndBookTypeEntities) {

			bookTypeIds.add(bookAndBookTypeEntity.getBookType().getId());
		}

		return bookTypeIds;
	}

}
