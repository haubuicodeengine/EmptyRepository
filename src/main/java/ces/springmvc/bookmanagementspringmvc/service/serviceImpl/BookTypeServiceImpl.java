package ces.springmvc.bookmanagementspringmvc.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ces.springmvc.bookmanagementspringmvc.service.BookTypeService;
import ces.springmvc.bookmanagementspringmvc.util.BookTypeUtil;
import ces.springmvc.bookmanagementspringmvc.dao.BookTypeDAO;
import ces.springmvc.bookmanagementspringmvc.dto.BookTypeDTO;
import ces.springmvc.bookmanagementspringmvc.entity.BookTypeEntity;

@Service("bookTypeService")
public class BookTypeServiceImpl implements BookTypeService {

	@Autowired
	BookTypeDAO bookTypeDAO;

	@Override
	public BookTypeDTO getBookTypeById(Long bookTypeId) {
		return BookTypeUtil.parseToDTO(bookTypeDAO.getOne(bookTypeId));
	}

	@Override
	public List<BookTypeDTO> getBookTypes() {
		List<BookTypeEntity> listBookTypeEntities = (List<BookTypeEntity>) bookTypeDAO.findAll();
		List<BookTypeDTO> bookTypeDTOs = new ArrayList<>();

		for (BookTypeEntity bookTypeEntity : listBookTypeEntities) {

			bookTypeDTOs.add(BookTypeUtil.parseToDTO(bookTypeEntity));
		}
		return bookTypeDTOs;
	}

}
