package ces.springmvc.bookmanagementspringmvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ces.springmvc.bookmanagementspringmvc.entity.BookEntity;
import ces.springmvc.bookmanagementspringmvc.entity.Book_BookTypeEntity;

@Repository
public interface Book_BookTypeDAO extends JpaRepository<Book_BookTypeEntity, Long> {

	List<Book_BookTypeEntity> findAllByBook(BookEntity bookEntity);

}
