package ces.springmvc.bookmanagementspring.service;

import java.util.List;

import ces.springmvc.bookmanagementspringmvc.entity.BookEntity;

public interface BookService {

	List<BookEntity> getAllBooks();

	void saveBook(BookEntity book);

	BookEntity getBookByBookId(Long bookId);

	void deleteBook(Long bookId);

	void updateBook(BookEntity book);

}
