package ces.springmvc.bookmanagementspringmvc.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ces.springmvc.bookmanagementspringmvc.service.Book_BookTypeService;
import ces.springmvc.bookmanagementspringmvc.util.Book_BookTypeUtil;
import ces.springmvc.bookmanagementspringmvc.validation.BookValidator;
import ces.springmvc.bookmanagementspringmvc.dao.BookDAO;
import ces.springmvc.bookmanagementspringmvc.dao.BookTypeDAO;
import ces.springmvc.bookmanagementspringmvc.dao.Book_BookTypeDAO;
import ces.springmvc.bookmanagementspringmvc.dto.BookDTO;
import ces.springmvc.bookmanagementspringmvc.dto.Book_BookTypeDTO;
import ces.springmvc.bookmanagementspringmvc.entity.Book_BookTypeEntity;

@Service
public class Book_BookTypeServiceImpl implements Book_BookTypeService {

	@Autowired
	private BookDAO bookDAO;

	@Autowired
	private BookTypeDAO bookTypeDAO;

	@Autowired
	private Book_BookTypeDAO book_BookTypeDAO;

	@Override
	public void deleteBook_BookTypeByBookId(Long bookId) {
		List<Book_BookTypeEntity> listBook_BookType = book_BookTypeDAO.findAllByBook(bookDAO.getOne(bookId));

		for (Book_BookTypeEntity item : listBook_BookType) {
			_deleteBook_BookTypeById(item.getId());
		}
	}

	@Override
	public void updateBook_BookType(BookDTO bookDTO, List<Long> listBookTypeId) {
		List<Long> listBookTypeChecked = getListBookTypeIdByBookId(bookDTO.getBookId());

		if (listBookTypeChecked.size() < 1) {
			if (listBookTypeId != null) {
				for (Long bookTypeId : listBookTypeId) {
					_saveBook_BookType(bookDTO, bookTypeId);
				}
			}
		} else {
			if (listBookTypeId != null) {
				// check bookType existed in db
				for (Long bookTypeId : listBookTypeId) {
					if (BookValidator.checkBookTypeExisted(getBook_BookTypes(), bookDTO.getBookId(), bookTypeId)) {
						_saveBook_BookType(bookDTO, bookTypeId);
					}
				}
				// check bookType is removed
				for (Long BookTypeIdChecked : listBookTypeChecked) {
					if (!listBookTypeId.contains(BookTypeIdChecked)) {
						_deleteBook_BookTypeByBookTypeIdAndBookId(BookTypeIdChecked, bookDTO.getBookId());
					}
				}
			} else {
				// check list bookType remove all
				deleteBook_BookTypeByBookId(bookDTO.getBookId());
			}
		}
	}

	@Override
	public List<Long> getListBookTypeIdByBookId(Long bookId) {
		List<Book_BookTypeEntity> listBook_BookType = book_BookTypeDAO.findAllByBook(bookDAO.getOne(bookId));
		List<Long> listBookTypeId = new ArrayList<Long>();

		for (Book_BookTypeEntity item : listBook_BookType) {
			listBookTypeId.add(item.getBookType().getBookTypeId());
		}
		return listBookTypeId;

	}

	@Override
	public List<Book_BookTypeDTO> getBook_BookTypes() {

		List<Book_BookTypeEntity> listBook_BookTypeEntities = (List<Book_BookTypeEntity>) book_BookTypeDAO.findAll();
		List<Book_BookTypeDTO> book_BookTypeDTOs = new ArrayList<>();

		for (Book_BookTypeEntity book_BookTypeEntity : listBook_BookTypeEntities) {

			book_BookTypeDTOs.add(Book_BookTypeUtil.parseToDTO(book_BookTypeEntity));
		}
		return book_BookTypeDTOs;
	}

	private void _deleteBook_BookTypeById(Long bookId) {

		book_BookTypeDAO.deleteById(bookId);
	}

	private void _deleteBook_BookTypeByBookTypeIdAndBookId(Long bookTypeId, Long bookId) {
		List<Book_BookTypeEntity> listBook_BookTypes = book_BookTypeDAO.findAllByBook(bookDAO.getOne(bookId));

		for (Book_BookTypeEntity item : listBook_BookTypes) {
			if (item.getBookType().getBookTypeId() == bookTypeId) {
				_deleteBook_BookTypeById(item.getId());
			}
		}
	}

	private void _saveBook_BookType(BookDTO bookDTO, Long bookTypeId) {
		Book_BookTypeEntity book_BookTypeEntity = new Book_BookTypeEntity();

		book_BookTypeEntity.setBook(bookDAO.getBookByBookName(bookDTO.getBookName()));
		book_BookTypeEntity.setBookType(bookTypeDAO.getOne(bookTypeId));

		book_BookTypeDAO.saveAndFlush(book_BookTypeEntity);
	}

}
