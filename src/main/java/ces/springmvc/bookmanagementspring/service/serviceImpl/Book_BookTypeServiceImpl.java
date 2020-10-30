package ces.springmvc.bookmanagementspring.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ces.springmvc.bookmanagementspring.service.Book_BookTypeService;
import ces.springmvc.bookmanagementspringmvc.dao.AuthorDAO;
import ces.springmvc.bookmanagementspringmvc.dao.Book_BookTypeDAO;
import ces.springmvc.bookmanagementspringmvc.entity.BookEntity;
import ces.springmvc.bookmanagementspringmvc.entity.BookTypeEntity;
import ces.springmvc.bookmanagementspringmvc.entity.Book_BookTypeEntity;

@Service
public class Book_BookTypeServiceImpl implements Book_BookTypeService{

	@Autowired
	private Book_BookTypeDAO book_BookTypeDAO;
	
	@Override
	public void saveBook_BookType(BookEntity newBook, BookTypeEntity bookType) {
//		Book_BookTypeEntity newItem = new Book_BookTypeEntity(newBook,bookType);
//		
//		book_BookTypeDAO.save(newItem);
		
	}

}
