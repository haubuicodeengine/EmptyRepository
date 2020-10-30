package ces.springmvc.bookmanagementspring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ces.springmvc.bookmanagementspringmvc.entity.BookTypeEntity;

public interface BookTypeService {

	List<BookTypeEntity> getAllBookTypes();

	BookTypeEntity getBookTypeById(Integer bookTypeId);

}
