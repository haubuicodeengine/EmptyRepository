package ces.springmvc.bookmanagementspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ces.springmvc.bookmanagementspring.service.AuthorService;
import ces.springmvc.bookmanagementspring.service.BookService;
import ces.springmvc.bookmanagementspring.service.BookTypeService;
import ces.springmvc.bookmanagementspring.service.Book_BookTypeService;
import ces.springmvc.bookmanagementspring.validation.BookValidation;
import ces.springmvc.bookmanagementspringmvc.entity.AuthorEntity;
import ces.springmvc.bookmanagementspringmvc.entity.BookEntity;
import ces.springmvc.bookmanagementspringmvc.entity.BookTypeEntity;

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

	@GetMapping("/books")
	public String listBooks(Model model) {
		List<BookEntity> listBook = bookService.getAllBooks();
		model.addAttribute("listBook", listBook);
		return "listBook/index";
	}

	@GetMapping("/addBook")
	public String showAddForm(Model model) {

		model.addAttribute("url", "/saveAddBook");
		_getFile(model);

		return "addAndEditBook/index";
	}

	@GetMapping("/editBook/{bookId}")
	public String showEditForm(Model model, @PathVariable(name = "bookId") Long bookId) {

		model.addAttribute("url", "/saveEditBook");
		model.addAttribute("bookEdit", bookService.getBookByBookId(bookId));
		model.addAttribute("listBookTypeSelected", book_bookTypeService.getListBookTypeIdByBookId(bookId));
		_getFile(model);

		return "addAndEditBook/index";
	}

	@GetMapping("/deleteBook/{bookId}")
	public String deleteClass(@PathVariable(name = "bookId") Long bookId) {

		bookService.deleteBook(bookId);

		return "redirect:/books";
	}

	@PostMapping("/saveAddBook")
	public String saveAddClass(Model model, @RequestParam("bookId") Long bookId,
			@RequestParam("bookName") String bookName, @RequestParam("author.authorId") Long authorId,
			@RequestParam(required = false, name = "bookTypeSelected") List<Long> listbookTypeId) {

		if (!BookValidation._checkEmpty(bookName)) {

			model.addAttribute("error", "The book's name is not null.");
			model.addAttribute("url", "/saveAddBook");
			_getFile(model);
			return "addAndEditBook/index";

		} else if (!BookValidation._checkExisted(bookId, bookName, bookService.getAllBooks())) {

			model.addAttribute("error", "The book's name is existed.");
			model.addAttribute("url", "/saveAddBook");
			_getFile(model);
			return "addAndEditBook/index";

		} else {
			BookEntity newBook = new BookEntity(bookName, authorService.getAuthorById(authorId));
			bookService.saveBook(newBook);

			if (listbookTypeId != null) {
				for (Long bookTypeId : listbookTypeId) {
					book_bookTypeService.saveBook_BookType(newBook, bookTypeService.getBookTypeById(bookTypeId));
				}
			}
		}
		return "redirect:/books";
	}

	@PostMapping("/saveEditBook")
	public String saveEditClass(Model model, @RequestParam("bookId") Long bookId,
			@RequestParam("bookName") String bookName, @RequestParam("author.authorId") Long authorId,
			@RequestParam(required = false, name = "bookTypeSelected") List<Long> listbookTypeId) {

		if (!BookValidation._checkEmpty(bookName)) {

			model.addAttribute("error", "The book's name is not null.");
			model.addAttribute("url", "/saveEditBook");
			_getFile(model);
			return "addAndEditBook/index";

		} else if (!BookValidation._checkExisted(bookId, bookName, bookService.getAllBooks())) {

			model.addAttribute("error", "The book's name is existed.");
			model.addAttribute("url", "/saveEditBook");
			_getFile(model);
			return "addAndEditBook/index";

		} else {
			BookEntity book = new BookEntity(bookId, bookName, authorService.getAuthorById(authorId));
			bookService.updateBook(book);

			List<Long> listBookTypeChecked = book_bookTypeService.getListBookTypeIdByBookId(bookId);
			if (listbookTypeId != null) {
				// check bookType existed in db
				for (Long bookTypeId : listbookTypeId) {
					if (BookValidation._checkBookTypeExisted(book_bookTypeService.getAllBook_BookType(), bookId,
							bookTypeId)) {
						book_bookTypeService.saveBook_BookType(book, bookTypeService.getBookTypeById(bookTypeId));
					}
				}
				// check bookType is removed
				for (Long bookTypeId : listbookTypeId) {
					for (Long number : listBookTypeChecked) {
						if (bookTypeId == number) {
							book_bookTypeService.deleteBook_BookTypeByBookTypeId(bookTypeId);
						}
					}
				}
			} // check list bookType remove all
			else {
				book_bookTypeService.deleteBook_BookTypeDaoByBookId(bookId);
			}
		}
		return "redirect:/books";
	}

	public void _getFile(Model model) {
		List<AuthorEntity> listAuthor = authorService.getAllAuthors();
		List<BookTypeEntity> listBookType = bookTypeService.getAllBookTypes();

		model.addAttribute("listAuthor", listAuthor);
		model.addAttribute("listBookType", listBookType);
	}

}