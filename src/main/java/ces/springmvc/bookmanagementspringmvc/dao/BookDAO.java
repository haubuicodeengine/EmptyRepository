package ces.springmvc.bookmanagementspringmvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ces.springmvc.bookmanagementspringmvc.entity.BookEntity;

@Repository
public interface BookDAO extends JpaRepository<BookEntity, Long>{

	BookEntity getBookByBookName(String bookName);

}
