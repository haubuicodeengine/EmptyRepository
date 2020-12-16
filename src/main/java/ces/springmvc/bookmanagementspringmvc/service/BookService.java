package ces.springmvc.bookmanagementspringmvc.service;

import java.util.List;

import ces.springmvc.bookmanagementspringmvc.dto.BookDTO;

public interface BookService {

	void deleteBook(Long bookId);

	void updateBook(BookDTO book);

	void saveBook(BookDTO book);

	BookDTO getBookByBookId(Long bookId) throws Exception;

	List<BookDTO> getBooks();

}
