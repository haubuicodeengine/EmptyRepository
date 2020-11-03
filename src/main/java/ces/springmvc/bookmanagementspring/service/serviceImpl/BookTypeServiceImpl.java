package ces.springmvc.bookmanagementspring.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ces.springmvc.bookmanagementspring.service.BookTypeService;
import ces.springmvc.bookmanagementspringmvc.dao.BookTypeDAO;
import ces.springmvc.bookmanagementspringmvc.entity.BookTypeEntity;

@Service("bookTypeService")
public class BookTypeServiceImpl implements BookTypeService {

	@Autowired
	BookTypeDAO bookTypeDAO;

	@Override
	public BookTypeEntity getBookTypeById(Long bookTypeId) {
		return bookTypeDAO.getOne(bookTypeId);
	}

	@Override
	public List<BookTypeEntity> getAllBookTypes() {
		return bookTypeDAO.findAll();
	}

}
