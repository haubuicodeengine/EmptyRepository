package ces.springmvc.bookmanagementspringmvc.service;

import java.util.List;

import ces.springmvc.bookmanagementspringmvc.dto.BookTypeDTO;

public interface BookTypeService {

	BookTypeDTO getBookTypeById(Long bookTypeId);

	List<BookTypeDTO> getBookTypes();

}
