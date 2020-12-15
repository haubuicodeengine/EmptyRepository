package servletTutorial.validation;

import java.util.ArrayList;
import java.util.List;

import servletTutorial.entities.Book;
import servletTutorial.repository.BookRepository;

public class BookValidator {

	public static boolean checkEmpty(String bookName) {
		if (bookName == null || bookName.trim().length() == 0) {
			return false;
		}
		return true;
	}

	public static boolean checkExisted(int bookId, String bookName) {
		if (checkEmpty(bookName)) {
			List<Book> listBooks = BookRepository.getBooks();
			for (Book book : listBooks) {
				if (book.getBookId() != bookId) {
					if (book.getBookName().equals(bookName)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static List<String> validate(int bookId, String bookName) {
		List<String> errors = new ArrayList<String>();
		
		if (!checkEmpty(bookName)) {
			errors.add("The book's name is not null.");
		}
		if (!checkExisted(bookId, bookName)) {
			errors.add("This book's name is existed.");
		}
		return errors;
	}
	
}
