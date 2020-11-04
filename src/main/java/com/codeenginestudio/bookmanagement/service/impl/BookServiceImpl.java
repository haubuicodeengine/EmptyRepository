package com.codeenginestudio.bookmanagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeenginestudio.bookmanagement.dto.BookDto;
import com.codeenginestudio.bookmanagement.entity.BookAndBookTypeEntity;
import com.codeenginestudio.bookmanagement.entity.BookEntity;
import com.codeenginestudio.bookmanagement.mapper.BookMapper;
import com.codeenginestudio.bookmanagement.repository.BookAndBookTypeRepository;
import com.codeenginestudio.bookmanagement.repository.BookRepository;
import com.codeenginestudio.bookmanagement.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookrepository;

	@Autowired
	private BookAndBookTypeRepository bookAndBookTypeRepository;
	
	@Override
	public List<BookDto> getAllBooks() {

		List<BookDto> bookDtos = new ArrayList<>();
		List<BookEntity> bookEntities = bookrepository.findAll();
		
		for (BookEntity bookEntity : bookEntities) {
			bookDtos.add(BookMapper._parseToBookDto(bookEntity));
		}

		return bookDtos;
	}

	@Override
	public BookDto getOneBook(Long id) {

		BookEntity bookEntity = bookrepository.findOne(id);

		return BookMapper._parseToBookDto(bookEntity);
	}

	@Override
	public void deleteBook(Long id) {

		BookEntity theBook = bookrepository.getOne(id);
		List<BookAndBookTypeEntity> listBookAndBookTypes = bookAndBookTypeRepository.findByBook(theBook);

		for (BookAndBookTypeEntity bookAndBookTypeEntity : listBookAndBookTypes) {
			bookAndBookTypeRepository.delete(bookAndBookTypeEntity);
		}

		bookrepository.delete(id);
	}

	@Override
	public void updateBook(BookDto bookDto) {

		BookEntity bookEntity = BookMapper._parseToBookEntity(bookDto);
		bookrepository.saveAndFlush(bookEntity);
	}

	@Override
	public BookDto insertBook(BookDto bookDto) {
		
		BookEntity bookEntity = BookMapper._parseToBookEntity(bookDto);
		bookrepository.saveAndFlush(bookEntity);
		
		return BookMapper._parseToBookDto(bookEntity);
	}
}
