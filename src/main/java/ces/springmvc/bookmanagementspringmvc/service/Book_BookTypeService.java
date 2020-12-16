package ces.springmvc.bookmanagementspringmvc.service;

import java.util.List;

import ces.springmvc.bookmanagementspringmvc.dto.BookDTO;
import ces.springmvc.bookmanagementspringmvc.dto.Book_BookTypeDTO;

public interface Book_BookTypeService {

	void deleteBook_BookTypeByBookId(Long bookId);

	void updateBook_BookType(BookDTO book, List<Long> listbookTypeId);

	List<Long> getListBookTypeIdByBookId(Long bookId);

	List<Book_BookTypeDTO> getBook_BookTypes();

}