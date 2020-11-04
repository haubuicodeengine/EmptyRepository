package com.codeenginestudio.bookmanagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeenginestudio.bookmanagement.dto.BookAndBookTypeDto;
import com.codeenginestudio.bookmanagement.dto.BookDto;
import com.codeenginestudio.bookmanagement.dto.BookTypeDto;
import com.codeenginestudio.bookmanagement.entity.BookAndBookTypeEntity;
import com.codeenginestudio.bookmanagement.entity.BookEntity;
import com.codeenginestudio.bookmanagement.entity.BookTypeEntity;
import com.codeenginestudio.bookmanagement.mapper.BookAndBookTypeMapper;
import com.codeenginestudio.bookmanagement.mapper.BookTypeMapper;
import com.codeenginestudio.bookmanagement.repository.BookAndBookTypeRepository;
import com.codeenginestudio.bookmanagement.repository.BookRepository;
import com.codeenginestudio.bookmanagement.repository.BookTypeRepository;
import com.codeenginestudio.bookmanagement.service.BookAndBookTypeService;
import com.codeenginestudio.bookmanagement.service.BookService;

@Service
public class BookAndBookTypeServiceImpl implements BookAndBookTypeService{

	@Autowired
	private BookAndBookTypeRepository bookAndBookTypeRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookTypeRepository bookTypeRepository;

	@Override
	public List<BookAndBookTypeDto> getAllBookAndBookTypes() {
		
		List<BookAndBookTypeDto> bookAndBookTypeDtos = new ArrayList<>();
		List<BookAndBookTypeEntity> listBookAndBookTypeEntities = bookAndBookTypeRepository.findAll();

		for (BookAndBookTypeEntity bookAndBookTypeEntity : listBookAndBookTypeEntities) {
			bookAndBookTypeDtos.add(BookAndBookTypeMapper._parseToBookAndBookTypeDto(bookAndBookTypeEntity));
		}

		return bookAndBookTypeDtos;
	}

	@Override
	public BookAndBookTypeDto getOneBookAndBooktype(long id) {
		
		BookAndBookTypeEntity bookAndBookTypeEntity = bookAndBookTypeRepository.findOne(id);
		return BookAndBookTypeMapper._parseToBookAndBookTypeDto(bookAndBookTypeEntity);
	}

	@Override
	public void insertBookAndBookType(BookAndBookTypeDto bookAndBookTypeDto) {

		BookAndBookTypeEntity bookAndBookTypeEntity = BookAndBookTypeMapper._parseToBookAndBookTypeEntity(bookAndBookTypeDto);

		bookAndBookTypeRepository.saveAndFlush(bookAndBookTypeEntity);
	}

	@Override
	public void deleteBookAndBookType(Long id) {
		
		bookAndBookTypeRepository.delete(id);
	}

	@Override
	public List<BookAndBookTypeDto> getAllBookAndBookTypeByBookId(Long bookId) {

		List<BookAndBookTypeDto> bookAndBookTypeDtos = new ArrayList<>();
		
		BookEntity theBook = bookRepository.getOne(bookId);
		List<BookAndBookTypeEntity> listBookAndBookTypeEntities = bookAndBookTypeRepository.findByBook(theBook);

		for (BookAndBookTypeEntity bookAndBookTypeEntity : listBookAndBookTypeEntities) {
			bookAndBookTypeDtos.add(BookAndBookTypeMapper._parseToBookAndBookTypeDto(bookAndBookTypeEntity));
		}

		return bookAndBookTypeDtos;
	}

	@Override
	public BookAndBookTypeDto getBookAndBookTypeByBookTypeId(Long bookTypeId) {

		BookTypeEntity theBookType = bookTypeRepository.findOne(bookTypeId);
		BookAndBookTypeEntity theBookAndBookType = bookAndBookTypeRepository.findByBookType(theBookType);

		return BookAndBookTypeMapper._parseToBookAndBookTypeDto(theBookAndBookType);
	}
}
