package ces.springmvc.bookmanagementspring.service;

import java.util.List;

import ces.springmvc.bookmanagementspringmvc.entity.BookEntity;
import ces.springmvc.bookmanagementspringmvc.entity.BookTypeEntity;
import ces.springmvc.bookmanagementspringmvc.entity.Book_BookTypeEntity;

public interface Book_BookTypeService {

	void saveBook_BookType(BookEntity book, BookTypeEntity bookType);

	void deleteBook_BookTypeById(Long bookId);

	void deleteBook_BookTypeByBookTypeId(Long bookTypeId);

	void deleteBook_BookTypeDaoByBookId(Long bookId);

	List<Long> getListBookTypeIdByBookId(Long bookId);

	List<Book_BookTypeEntity> getAllBook_BookType();

}