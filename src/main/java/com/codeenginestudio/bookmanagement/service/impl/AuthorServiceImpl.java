package com.codeenginestudio.bookmanagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeenginestudio.bookmanagement.dto.AuthorDto;
import com.codeenginestudio.bookmanagement.entity.AuthorEntity;
import com.codeenginestudio.bookmanagement.mapper.AuthorMapper;
import com.codeenginestudio.bookmanagement.repository.AuthorRepository;
import com.codeenginestudio.bookmanagement.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService{

	@Autowired
	private AuthorRepository authorRepository;
	
	@Override
	public List<AuthorDto> getAllAuthors() {

		List<AuthorDto> listAuthorDtos = new ArrayList<>();
		List<AuthorEntity> listAuthorEntities = authorRepository.findAll();

		for (AuthorEntity authorEntity : listAuthorEntities) {
			listAuthorDtos.add(AuthorMapper._parseToAuthorDto(authorEntity));
		}
		
		return listAuthorDtos;
	}

	@Override
	public AuthorDto getOneAuthor(Long id) {

		AuthorEntity authorEntity = authorRepository.findOne(id);
		return AuthorMapper._parseToAuthorDto(authorEntity);
	}

}
