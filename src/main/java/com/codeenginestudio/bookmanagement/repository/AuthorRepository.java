package com.codeenginestudio.bookmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeenginestudio.bookmanagement.entity.AuthorEntity;


public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
	
}
