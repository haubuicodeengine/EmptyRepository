package ces.springmvc.bookmanagementspring.service;

import java.util.List;

import ces.springmvc.bookmanagementspringmvc.entity.BookTypeEntity;

public interface BookTypeService {

	List<BookTypeEntity> getAllBookTypes();

	BookTypeEntity getBookTypeById(Long bookTypeId);

}
