package ces.springmvc.bookmanagementspring.service;

import ces.springmvc.bookmanagementspringmvc.entity.BookEntity;
import ces.springmvc.bookmanagementspringmvc.entity.BookTypeEntity;

public interface Book_BookTypeService {

	void saveBook_BookType(BookEntity newBook, BookTypeEntity bookTypeById);

}