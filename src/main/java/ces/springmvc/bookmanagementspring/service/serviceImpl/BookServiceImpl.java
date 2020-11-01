package ces.springmvc.bookmanagementspring.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ces.springmvc.bookmanagementspring.service.BookService;
import ces.springmvc.bookmanagementspringmvc.dao.AuthorDAO;
import ces.springmvc.bookmanagementspringmvc.dao.BookDAO;
import ces.springmvc.bookmanagementspringmvc.entity.BookEntity;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDAO bookDAO;
	
	@Autowired
	AuthorDAO authorDAO;

	@Override
	public List<BookEntity> getAllBooks() {
		return bookDAO.findAll();
	}

	@Override
	public BookEntity getBookByBookId(Long bookId) {
		return bookDAO.getOne(bookId);
	}

	@Override
	public void deleteBook(Long bookId) {
		bookDAO.deleteById(bookId);
	}

	@Override
	public void saveBook(BookEntity book) {
		bookDAO.save(book);
	}

	@Override
	public void updateBook(BookEntity book) {
		BookEntity bookEntity = bookDAO.getOne(book.getBookId());
		bookEntity.setBookName(book.getBookName());
		Long authorId = book.getAuthor().getAuthorId();
		
		if(authorId == null) {
			bookEntity.setAuthor(null);
		}else {
			bookEntity.setAuthor(authorDAO.getOne(authorId));
		}
		bookDAO.saveAndFlush(bookEntity);
	}

}
