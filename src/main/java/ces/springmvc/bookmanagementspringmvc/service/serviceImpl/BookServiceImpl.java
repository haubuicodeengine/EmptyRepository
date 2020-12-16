package ces.springmvc.bookmanagementspringmvc.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ces.springmvc.bookmanagementspringmvc.service.BookService;
import ces.springmvc.bookmanagementspringmvc.service.Book_BookTypeService;
import ces.springmvc.bookmanagementspringmvc.util.BookUtil;
import ces.springmvc.bookmanagementspringmvc.dao.AuthorDAO;
import ces.springmvc.bookmanagementspringmvc.dao.BookDAO;
import ces.springmvc.bookmanagementspringmvc.dto.BookDTO;
import ces.springmvc.bookmanagementspringmvc.entity.BookEntity;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	AuthorDAO authorDAO;

	@Autowired
	BookDAO bookDAO;

	@Autowired
	Book_BookTypeService book_BookTypeService;

	@Override
	public void deleteBook(Long bookId) {
		book_BookTypeService.deleteBook_BookTypeByBookId(bookId);

		bookDAO.deleteById(bookId);
	}

	@Override
	public void saveBook(BookDTO bookDTO) {
		BookEntity bookEntity = new BookEntity();
		bookEntity.setBookName(bookDTO.getBookName());
		Long authorId = bookDTO.getAuthor().getAuthorId();

		if (authorId == 0) {
			bookEntity.setAuthor(null);
		} else {
			bookEntity.setAuthor(authorDAO.getOne(authorId));
		}
		bookDAO.saveAndFlush(bookEntity);
	}

	@Override
	public void updateBook(BookDTO bookDTO) {
		BookEntity bookEntity = bookDAO.getOne(bookDTO.getBookId());
		bookEntity.setBookName(bookDTO.getBookName());
		Long authorId = bookDTO.getAuthor().getAuthorId();

		if (authorId == 0) {
			bookEntity.setAuthor(null);
		} else {
			bookEntity.setAuthor(authorDAO.getOne(authorId));
		}
		bookDAO.saveAndFlush(bookEntity);
	}

	@Override
	public BookDTO getBookByBookId(Long bookId) throws Exception {

		return BookUtil.parseToDTO(bookDAO.getOne(bookId));
	}

	@Override
	public List<BookDTO> getBooks() {
		List<BookEntity> listBookEntities = (List<BookEntity>) bookDAO.findAll();
		List<BookDTO> bookDTOs = new ArrayList<>();

		for (BookEntity bookEntity : listBookEntities) {

			bookDTOs.add(BookUtil.parseToDTO(bookEntity));
		}
		return bookDTOs;
	}

}
