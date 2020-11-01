package ces.springmvc.bookmanagementspring.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ces.springmvc.bookmanagementspring.service.Book_BookTypeService;
import ces.springmvc.bookmanagementspringmvc.dao.Book_BookTypeDAO;
import ces.springmvc.bookmanagementspringmvc.entity.BookEntity;
import ces.springmvc.bookmanagementspringmvc.entity.BookTypeEntity;
import ces.springmvc.bookmanagementspringmvc.entity.Book_BookTypeEntity;

@Service
public class Book_BookTypeServiceImpl implements Book_BookTypeService {

	@Autowired
	private Book_BookTypeDAO book_BookTypeDAO;

	@Override
	public List<Book_BookTypeEntity> getAllBook_BookType() {
		return book_BookTypeDAO.findAll();
	}

	@Override
	public void saveBook_BookType(BookEntity newBook, BookTypeEntity bookType) {

		Book_BookTypeEntity newItem = new Book_BookTypeEntity(newBook, bookType);
		book_BookTypeDAO.save(newItem);
	}

	@Override
	public List<Long> getListBookTypeIdByBookId(Long bookId) {
		List<Book_BookTypeEntity> listBook_BookType = book_BookTypeDAO.findAll();
		List<Long> listBookTypeId = new ArrayList<Long>();

		for (Book_BookTypeEntity item : listBook_BookType) {
			if (item.getBook().getBookId() == bookId) {
				listBookTypeId.add(item.getBookType().getBookTypeId());
			}
		}
		return listBookTypeId;
	}

	@Override
	public void deleteBook_BookTypeById(Long bookId) {

		book_BookTypeDAO.deleteById(bookId);
	}

	@Override
	public void deleteBook_BookTypeByBookTypeId(Long bookTypeId) {
		List<Book_BookTypeEntity> listBook_BookType = getAllBook_BookType();
		for (Book_BookTypeEntity item : listBook_BookType) {
			if (item.getBookType().getBookTypeId() == bookTypeId) {
				deleteBook_BookTypeById(item.getId());
			}
		}

	}

	@Override
	public void deleteBook_BookTypeDaoByBookId(Long bookId) {
		List<Book_BookTypeEntity> listBook_BookType = getAllBook_BookType();
		for (Book_BookTypeEntity item : listBook_BookType) {
			if (item.getBook().getBookId() == bookId) {
				deleteBook_BookTypeById(item.getId());
			}
		}
	}

}
