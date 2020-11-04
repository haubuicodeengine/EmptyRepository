package com.codeenginestudio.bookmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeenginestudio.bookmanagement.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
	
}
