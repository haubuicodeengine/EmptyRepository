package ces.springmvc.bookmanagementspring.validation;

import java.util.List;

import ces.springmvc.bookmanagementspringmvc.entity.BookEntity;
import ces.springmvc.bookmanagementspringmvc.entity.Book_BookTypeEntity;

public class BookValidation {

	public static Boolean checkEmpty(String bookName) {
		if (bookName == "") {
			return false;
		}
		return true;
	}

	public static Boolean checkExisted(int bookId, String bookName, List<BookEntity> listBook) {
		for (BookEntity book : listBook) {
			if (book.getBookId() != bookId) {
				if (book.getBookName().equals(bookName)) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean checkBookTypeExisted(List<Book_BookTypeEntity> listBook_BookType, int bookId, int bookTypeId) {
		for (Book_BookTypeEntity item : listBook_BookType) {
			if (item.getBook().getBookId() == bookId) {
				if (item.getBookType().getBookTypeId() == bookTypeId) {
					return false;
				}
			}
		}
		return true;
	}

}
