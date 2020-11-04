package com.codeenginestudio.bookmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.codeenginestudio.bookmanagement.dto.BookAndBookTypeDto;
import com.codeenginestudio.bookmanagement.dto.BookDto;
import com.codeenginestudio.bookmanagement.dto.BookTypeDto;
import com.codeenginestudio.bookmanagement.service.AuthorService;
import com.codeenginestudio.bookmanagement.service.BookAndBookTypeService;
import com.codeenginestudio.bookmanagement.service.BookService;
import com.codeenginestudio.bookmanagement.service.BookTypeService;

@Controller(value = "bookController")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private BookAndBookTypeService bookAndBookTypeService;
	
	@Autowired
	private BookTypeService bookTypeService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView showListOfBooks(Model model) {

		model.addAttribute("listBookAndtype", bookAndBookTypeService.getAllBookAndBookTypes());
		model.addAttribute("listBooks", bookService.getAllBooks());
		ModelAndView mav = new ModelAndView("list-books");
		return mav;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView showAddForm(Model model) {

		model.addAttribute("authors", authorService.getAllAuthors());
		model.addAttribute("bookTypes", bookTypeService.getAllBookTypes());
		ModelAndView mav = new ModelAndView("book-form");
		return mav;
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertBook(Model model, BookDto bookDto, 
			@RequestParam(required = false, name = "typeId") List<Long> typeIds) {

		BookDto savedBookDto = bookService.insertBook(bookDto);

		for (Long type : typeIds) {

			BookTypeDto typeOfBook = bookTypeService.getOneBookType(type);
			BookAndBookTypeDto bookAndBookTypeDto = new BookAndBookTypeDto();
			bookAndBookTypeDto.setBook(savedBookDto);
			bookAndBookTypeDto.setBookType(typeOfBook);
			BookDto a = new BookDto();
			bookAndBookTypeService.insertBookAndBookType(bookAndBookTypeDto);
		}

		model.addAttribute("listBooks", bookService.getAllBooks());
		return "redirect:/list";
	}

	@RequestMapping(value = "/delete/{bookId}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable(name = "bookId") Long bookId, Model model) {

		bookService.deleteBook(bookId);
		return "redirect:/list";
	}

	@RequestMapping(value = "/edit/{bookId}", method = RequestMethod.GET)
	public ModelAndView showEditForm(@PathVariable(name = "bookId") Long bookId, Model model) {

		
		model.addAttribute("url", "/update");
		model.addAttribute("authors", authorService.getAllAuthors());
		model.addAttribute("bookTypes", bookTypeService.getAllBookTypes());
		model.addAttribute("currentTypes", bookTypeService.getBookTypeIdByBookId(bookId));
		model.addAttribute("book", bookService.getOneBook(bookId));
		ModelAndView mav = new ModelAndView("book-form");
		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateBook(BookDto bookDto, Model model, 
			@RequestParam(required = false, name = "typeId") List<Long> typeIds) {

		bookService.updateBook(bookDto);
		List<BookAndBookTypeDto> listBookAndBookTypes = bookAndBookTypeService.getAllBookAndBookTypeByBookId(bookDto.getBookId());

		for(int i = 0; i < typeIds.size(); i++) {

			if(!_checkDuplicateBooktype(bookDto.getBookId(), typeIds.get(i))) {

				BookTypeDto newBookType = bookTypeService.getOneBookType(typeIds.get(i));
				BookAndBookTypeDto newBookAndBookType = new BookAndBookTypeDto(bookDto, newBookType);
				bookAndBookTypeService.insertBookAndBookType(newBookAndBookType);
			}
		}

		for(int i = 0; i < listBookAndBookTypes.size(); i++) {

			if(!typeIds.contains(listBookAndBookTypes.get(i).getBookType().getId())) {

				bookAndBookTypeService.deleteBookAndBookType(listBookAndBookTypes.get(i).getBookAndBookTypeId());
			}
		}

		model.addAttribute("listBooks", bookService.getAllBooks());
		return "redirect:/list";
	}
	
	private Boolean _checkDuplicateBooktype(Long bookId, Long bookTypeId) {

		List<Long> bookTypes = bookTypeService.getBookTypeIdByBookId(bookId);
		
		if(bookTypes == null || bookTypes.size() == 0) {
			return false;
		}
		
		if (bookTypes.contains(bookTypeId)) {
			return true;
		}

		return false;
	}
}
