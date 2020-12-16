package ces.springmvc.bookmanagementspringmvc.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.modelmapper.spi.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ces.springmvc.bookmanagementspringmvc.service.AuthorService;
import ces.springmvc.bookmanagementspringmvc.service.BookService;
import ces.springmvc.bookmanagementspringmvc.service.BookTypeService;
import ces.springmvc.bookmanagementspringmvc.service.Book_BookTypeService;
import ces.springmvc.bookmanagementspringmvc.validation.BookValidator;
import ces.springmvc.bookmanagementspringmvc.constant.ErrorMessagesCommand;
import ces.springmvc.bookmanagementspringmvc.constant.MVCCommandNames;
import ces.springmvc.bookmanagementspringmvc.dto.AuthorDTO;
import ces.springmvc.bookmanagementspringmvc.dto.BookDTO;
import ces.springmvc.bookmanagementspringmvc.dto.BookTypeDTO;

@Controller
public class BookController {

	@Autowired
	private AuthorService authorService;

	@Autowired
	private BookService bookService;

	@Autowired
	private BookTypeService bookTypeService;

	@Autowired
	private Book_BookTypeService book_bookTypeService;

	@GetMapping("/")
	public String welcome(Model model) {

		return "index";
	}

	@GetMapping("/books")
	public String listBooks(Model model) {
		List<BookDTO> listBook = bookService.getBooks();
		model.addAttribute("listBook", listBook);

		return MVCCommandNames.VIEW_BOOKS;
	}

	@GetMapping("/addBook")
	public String showAddForm(Model model) {
		model.addAttribute("url", MVCCommandNames.URL_SAVE_ADD);

		_getFile(model);
		return MVCCommandNames.VIEW_FORM;
	}

	@GetMapping("/editBook-id={bookId}")
	public String showEditForm(Model model, @PathVariable(name = "bookId") Long bookId) {
		try {
			model.addAttribute("url", MVCCommandNames.URL_SAVE_EDIT);
			model.addAttribute("bookEdit", bookService.getBookByBookId(bookId));
			model.addAttribute("listBookTypeSelected", book_bookTypeService.getListBookTypeIdByBookId(bookId));

			_getFile(model);

			return MVCCommandNames.VIEW_FORM;

		} catch (Exception e) {
			logger.error(ErrorMessagesCommand.NOT_FOUND_ERROR_MESSAGES, e);

			return "redirect:/error";

		}
	}

	@GetMapping("/deleteBook-id={bookId}")
	public String deleteClass(@PathVariable(name = "bookId") Long bookId) {

		bookService.deleteBook(bookId);

		return "redirect:/books";
	}

	@PostMapping("/saveAddBook")
	public String saveAddBook(Model model, BookDTO bookDTO,
			@RequestParam(required = false, name = "bookTypeSelected") List<Long> listbookTypeId) {
		List<String> errors = BookValidator.validate(bookDTO, bookService.getBooks());

		if (errors.size() > 0) {
			model.addAttribute("url", MVCCommandNames.URL_SAVE_ADD);
			model.addAttribute("errors", errors);

			_getFile(model);
			return MVCCommandNames.VIEW_FORM;

		} else {

			bookService.saveBook(bookDTO);
			book_bookTypeService.updateBook_BookType(bookDTO, listbookTypeId);
		}
		return "redirect:/books";
	}

	@PostMapping("/saveEditBook")
	public String saveEditBook(Model model, BookDTO bookDTO,
			@RequestParam(required = false, name = "bookTypeSelected") List<Long> listbookTypeId) {
		List<String> errors = BookValidator.validate(bookDTO, bookService.getBooks());

		if (errors.size() > 0) {
			model.addAttribute("url", MVCCommandNames.URL_SAVE_EDIT);
			model.addAttribute("errors", errors);

			_getFile(model);
			return MVCCommandNames.VIEW_FORM;

		} else {

			bookService.updateBook(bookDTO);
			book_bookTypeService.updateBook_BookType(bookDTO, listbookTypeId);
		}
		return "redirect:/books";
	}

	private void _getFile(Model model) {
		List<AuthorDTO> listAuthor = authorService.getAuthors();
		List<BookTypeDTO> listBookType = bookTypeService.getBookTypes();

		model.addAttribute("listAuthor", listAuthor);
		model.addAttribute("listBookType", listBookType);
	}

	private static final Logger logger = Logger.getLogger(BookController.class);

}