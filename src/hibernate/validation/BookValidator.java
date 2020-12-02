package hibernate.validation;

import java.util.ArrayList;
import java.util.List;

import hibernate.entities.Book;
import hibernate.entities.Book_BookType;

public class BookValidator {

	public static boolean checkEmpty(String bookName) {
		if (bookName == null || bookName.trim().length() == 0) {
			return false;
		}
		return true;
	}

	public static boolean checkExisted(int bookId, String bookName, List<Book> listBooks) {
		if (checkEmpty(bookName)) {
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

	public static boolean checkBookTypeExisted(List<Book_BookType> listBook_BookType, int bookId, int bookTypeId) {
		for (Book_BookType item : listBook_BookType) {
			if (item.getBook().getBookId() == bookId) {
				if (item.getBookType().getBookTypeId() == bookTypeId) {
					return false;
				}
			}
		}
		return true;
	}

	public static List<String> validate(int bookId, String bookName, List<Book> listBooks) {
		List<String> errors = new ArrayList<String>();

		if (!checkEmpty(bookName)) {
			errors.add("The book's name is not null.");
		}
		if (!checkExisted(bookId, bookName, listBooks)) {
			errors.add("This book's name is existed.");
		}
		return errors;
	}
}