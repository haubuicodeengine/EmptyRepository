package ces.springmvc.bookmanagementspring.service;

import java.util.List;

import ces.springmvc.bookmanagementspringmvc.entity.BookEntity;

public interface BookService {

	void deleteBook(Long bookId);

	void updateBook(BookEntity book);

	void saveBook(BookEntity book);

	BookEntity getBookByBookId(Long bookId);

	List<BookEntity> getAllBooks();

}
