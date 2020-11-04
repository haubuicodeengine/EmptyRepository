package com.codeenginestudio.bookmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeenginestudio.bookmanagement.entity.BookTypeEntity;

public interface BookTypeRepository extends JpaRepository<BookTypeEntity, Long> {

}