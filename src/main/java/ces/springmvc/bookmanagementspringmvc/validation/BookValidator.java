package ces.springmvc.bookmanagementspringmvc.validation;

import java.util.ArrayList;
import java.util.List;

import ces.springmvc.bookmanagementspringmvc.dto.BookDTO;
import ces.springmvc.bookmanagementspringmvc.dto.Book_BookTypeDTO;

public class BookValidator {

	public static boolean checkBookNameEmpty(String bookName) {
		if(bookName == null || bookName.trim().length() == 0 ) {
			return false;
		}
		return true;
	}

	public static boolean checkBookNameExisted(Long bookId, String bookName, List<BookDTO> listBook) {
		for (BookDTO book : listBook) {
			if (!bookId.equals(book.getBookId()) && book.getBookName().equals(bookName)) {
				return false;
			}
		}
		return true;
	}

	public static boolean checkBookTypeExisted(List<Book_BookTypeDTO> listBook_BookType, Long bookId, Long bookTypeId) {
		for (Book_BookTypeDTO item : listBook_BookType) {
			if (item.getBook().getBookId() == bookId && item.getBookType().getBookTypeId() == bookTypeId) {
				return false;
			}
		}
		return true;
	}

	public static List<String> validate(BookDTO bookDTO, List<BookDTO> bookDTOs) {
		List<String> errors = new ArrayList<String>();

		if (!checkBookNameEmpty(bookDTO.getBookName())) {
			errors.add("The book's name is not null.");
		}else {
			if (!checkBookNameExisted(bookDTO.getBookId(), bookDTO.getBookName(), bookDTOs)) {
				errors.add("This book's name is existed.");
			}
		}
		return errors;
	}

}
