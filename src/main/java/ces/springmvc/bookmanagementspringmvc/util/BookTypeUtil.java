package ces.springmvc.bookmanagementspringmvc.util;

import ces.springmvc.bookmanagementspringmvc.dto.BookTypeDTO;
import ces.springmvc.bookmanagementspringmvc.entity.BookTypeEntity;

public class BookTypeUtil {

	public static BookTypeDTO parseToDTO(BookTypeEntity bookTypeEntity) {

		BookTypeDTO bookTypeDTO = GeneralUtil.modelMapper.map(bookTypeEntity, BookTypeDTO.class);

		return bookTypeDTO;
	}

	public static BookTypeEntity parseToEntity(BookTypeDTO bookTypeDTO) {

		BookTypeEntity bookTypeEntity = GeneralUtil.modelMapper.map(bookTypeDTO, BookTypeEntity.class);

		return bookTypeEntity;
	}

}
