package ces.springmvc.bookmanagementspringmvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ces.springmvc.bookmanagementspringmvc.entity.Book_BookTypeEntity;

@Repository
public interface Book_BookTypeDAO extends JpaRepository<Book_BookTypeEntity, Long>{

}
