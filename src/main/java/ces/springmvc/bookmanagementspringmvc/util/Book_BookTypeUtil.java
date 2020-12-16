package ces.springmvc.bookmanagementspringmvc.util;

import ces.springmvc.bookmanagementspringmvc.dto.Book_BookTypeDTO;
import ces.springmvc.bookmanagementspringmvc.entity.Book_BookTypeEntity;

public class Book_BookTypeUtil {

	public static Book_BookTypeDTO parseToDTO(Book_BookTypeEntity book_BookTypeEntity) {

		Book_BookTypeDTO book_BookTypeDTO = GeneralUtil.modelMapper.map(book_BookTypeEntity, Book_BookTypeDTO.class);

		return book_BookTypeDTO;
	}

	public static Book_BookTypeEntity parseToEntity(Book_BookTypeDTO book_BookTypeDTO) {

		Book_BookTypeEntity book_BookTypeEntity = GeneralUtil.modelMapper.map(book_BookTypeDTO,
				Book_BookTypeEntity.class);

		return book_BookTypeEntity;
	}

}
