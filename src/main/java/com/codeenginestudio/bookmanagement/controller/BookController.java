package com.codeenginestudio.bookmanagement.controller;

import java.util.List;
import java.util.Map;

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
import com.codeenginestudio.bookmanagement.validator.BookValidator;

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

		return _returnListBook(model);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView showAddForm(Model model) {

		model.addAttribute("authors", authorService.getAllAuthors());
		model.addAttribute("bookTypes", bookTypeService.getAllBookTypes());
		ModelAndView mav = new ModelAndView("book-form");
		return mav;
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insertBook(Model model, BookDto bookDto,
			@RequestParam(required = false, name = "typeId") List<Long> typeIds) {

		Map<String, String> Errors = BookValidator.validate(bookDto, typeIds);

		if (!Errors.isEmpty()) {

			model.addAttribute("book", bookDto);
			model.addAttribute("errors", Errors);
			model.addAttribute("authors", authorService.getAllAuthors());
			model.addAttribute("bookTypes", bookTypeService.getAllBookTypes());
			ModelAndView mav = new ModelAndView("book-form");
			return mav;
		} else {

			BookDto savedBookDto = bookService.insertBook(bookDto);

			for (Long type : typeIds) {

				BookTypeDto typeOfBook = bookTypeService.getOneBookType(type);
				BookAndBookTypeDto bookAndBookTypeDto = new BookAndBookTypeDto();
				bookAndBookTypeDto.setBook(savedBookDto);
				bookAndBookTypeDto.setBookType(typeOfBook);
				bookAndBookTypeService.insertBookAndBookType(bookAndBookTypeDto);
			}

			return _returnListBook(model);
		}
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
	public ModelAndView updateBook(BookDto bookDto, Model model,
			@RequestParam(required = false, name = "typeId") List<Long> typeIds) {

		Map<String, String> Errors = BookValidator.validate(bookDto, typeIds);

		if (!Errors.isEmpty()) {

			model.addAttribute("book", bookDto);
			model.addAttribute("errors", Errors);
			model.addAttribute("currentTypes", bookTypeService.getBookTypeIdByBookId(bookDto.getBookId()));
			model.addAttribute("authors", authorService.getAllAuthors());
			model.addAttribute("bookTypes", bookTypeService.getAllBookTypes());
			ModelAndView mav = new ModelAndView("book-form");
			return mav;
		} else {

			bookService.updateBook(bookDto);
			bookAndBookTypeService.updateBookAndBookType(typeIds, bookDto);
			return _returnListBook(model);
		}
	}

	public ModelAndView _returnListBook(Model model) {

		model.addAttribute("listBookAndtype", bookAndBookTypeService.getAllBookAndBookTypes());
		model.addAttribute("listBooks", bookService.getAllBooks());
		ModelAndView mav = new ModelAndView("list-books");
		return mav;
	}
}
