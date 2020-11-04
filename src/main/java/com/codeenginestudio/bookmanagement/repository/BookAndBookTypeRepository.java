package com.codeenginestudio.bookmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeenginestudio.bookmanagement.entity.BookAndBookTypeEntity;
import com.codeenginestudio.bookmanagement.entity.BookEntity;
import com.codeenginestudio.bookmanagement.entity.BookTypeEntity;


public interface BookAndBookTypeRepository extends JpaRepository<BookAndBookTypeEntity, Long> {
	
	List<BookAndBookTypeEntity> findByBook(BookEntity theBook);

	BookAndBookTypeEntity findByBookType(BookTypeEntity theBookType);
}
