package hibernate.validation;

import java.util.List;

import hibernate.entities.Book;

public class BookValidation {

	public static Boolean checkEmpty(String bookName) {
		if (bookName == "") {
			return false;
		}
		return true;
	}
	
	public static Boolean checkExisted(int bookId, String bookName, List<Book> listBooks) {
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
