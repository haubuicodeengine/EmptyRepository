package servletTutorial.validation;

import java.util.List;

import servletTutorial.entities.Book;
import servletTutorial.manage.BookManagement;

public class BookValidation {

	public static Boolean checkEmpty(String bookName) {
		if (bookName == "") {
			return false;
		}
		return true;
	}
	
	public static Boolean checkExisted(int bookId, String bookName) {
		List<Book> listBooks = BookManagement.getBooks();
		for(Book book: listBooks) {
			if(book.getBookId() != bookId) {
				if(book.getBookName().equals(bookName)) {
					return false;
				}
			}
		}
		return true;
	}
}
