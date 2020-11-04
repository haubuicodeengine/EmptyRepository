package com.codeenginestudio.bookmanagement.mapper;

import com.codeenginestudio.bookmanagement.dto.AuthorDto;
import com.codeenginestudio.bookmanagement.entity.AuthorEntity;

public class AuthorMapper {

	public static AuthorDto _parseToAuthorDto(AuthorEntity authorEntity) {

		AuthorDto authorDto = new AuthorDto();
		authorDto.setId(authorEntity.getId());
		authorDto.setName(authorEntity.getName());

		return authorDto;
	}
	
	public static AuthorEntity _parseToAuthorEntity(AuthorDto authorDto) {

		AuthorEntity authorEntity = new AuthorEntity();
		authorEntity.setId(authorDto.getId());
		authorEntity.setName(authorDto.getName());

		return authorEntity;
	}
}
