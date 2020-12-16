package ces.springmvc.bookmanagementspringmvc.util;

import ces.springmvc.bookmanagementspringmvc.dto.BookDTO;
import ces.springmvc.bookmanagementspringmvc.entity.BookEntity;

public class BookUtil {

	public static BookDTO parseToDTO(BookEntity bookEntity) {

		BookDTO bookDTO = GeneralUtil.modelMapper.map(bookEntity, BookDTO.class);

		return bookDTO;
	}

	public static BookEntity parseToEntity(BookDTO bookDTO) {

		BookEntity bookEntity = GeneralUtil.modelMapper.map(bookDTO, BookEntity.class);

		return bookEntity;
	}

}
