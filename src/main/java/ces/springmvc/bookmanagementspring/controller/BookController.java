package ces.springmvc.bookmanagementspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	private BookService bookService;

	@Autowired
	private AuthorService authorService;

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
		_GetFile(model);

		return "addAndEditBook/index";
	}

	@PostMapping("/saveAddBook")
	public String saveAddClass(Model model, @RequestParam("bookId") int bookId, @RequestParam("name") String bookName,
			@RequestParam("author.authorId") int authorId,
			@RequestParam(required = false, name = "bookTypeSelected") List<Integer> listbookTypeId) {

		if (!BookValidation.checkEmpty(bookName)) {

			model.addAttribute("error", "The book's name is not null.");
			_GetFile(model);
			return "addAndEditBook/index";

		} else if (!BookValidation.checkExisted(bookId, bookName, bookService.getAllBooks())) {

			model.addAttribute("error", "The book's name is existed.");
			_GetFile(model);
			return "addAndEditBook/index";

		} else {
			BookEntity newBook = new BookEntity(bookName, authorService.getAuthorById(authorId));
			bookService.saveBook(newBook);

			if (listbookTypeId != null) {
				for (Integer bookTypeId : listbookTypeId) {
					book_bookTypeService.saveBook_BookType(newBook, bookTypeService.getBookTypeById(bookTypeId));
				}
			}
		}
		return "redirect:/books";
	}

	public void _GetFile(Model model) {
		List<AuthorEntity> listAuthor = authorService.getAllAuthors();
		List<BookTypeEntity> listBookType = bookTypeService.getAllBookTypes();

		model.addAttribute("listAuthor", listAuthor);
		model.addAttribute("listBookType", listBookType);

	}

}