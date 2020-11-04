package com.codeenginestudio.bookmanagement.service;

import java.util.List;

import com.codeenginestudio.bookmanagement.dto.AuthorDto;

public interface AuthorService {

	List<AuthorDto> getAllAuthors();

	AuthorDto getOneAuthor(Long id);
}
