package ces.springmvc.bookmanagementspringmvc.util;

import ces.springmvc.bookmanagementspringmvc.dto.AuthorDTO;
import ces.springmvc.bookmanagementspringmvc.entity.AuthorEntity;

public class AuthorUtil {

	public static AuthorDTO parseToDTO(AuthorEntity authorEntity) {

		AuthorDTO authorDTO = GeneralUtil.modelMapper.map(authorEntity, AuthorDTO.class);

		return authorDTO;
	}

	public static AuthorEntity parseToEntity(AuthorDTO authorDTO) {

		AuthorEntity authorEntity = GeneralUtil.modelMapper.map(authorDTO, AuthorEntity.class);

		return authorEntity;
	}

}
