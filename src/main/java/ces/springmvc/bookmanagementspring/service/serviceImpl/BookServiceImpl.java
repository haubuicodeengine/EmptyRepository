package ces.springmvc.bookmanagementspring.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ces.springmvc.bookmanagementspring.service.BookService;
import ces.springmvc.bookmanagementspringmvc.dao.BookDAO;
import ces.springmvc.bookmanagementspringmvc.entity.BookEntity;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDAO bookDAO;

	@Override
	public List<BookEntity> getAllBooks() {
		return bookDAO.findAll();
	}

	@Override
	public BookEntity getBookByBookId(int bookId) {
		return bookDAO.getOne(bookId);
	}

	@Override
	public void deleteBook(int bookId) {
		bookDAO.deleteById(bookId);
	}

	@Override
	public void saveBook(BookEntity book) {
		bookDAO.save(book);
	}

}
