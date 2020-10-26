package hibernate.validation;

import java.util.List;

import hibernate.entities.Book;
import hibernate.entities.Book_BookType;

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

	public static boolean checkBookTypeExisted(List<Book_BookType> listBook_BookType, int bookId, int bookTypeId) {
		for(Book_BookType item: listBook_BookType) {
			if(item.getBook().getBookId() == bookId) {
				if(item.getBookType().getBookTypeId() == bookTypeId) {
					return false;
				}
			}
		}
		return true;
	}
}
