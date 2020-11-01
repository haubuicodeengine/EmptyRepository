package ces.springmvc.bookmanagementspringmvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ces.springmvc.bookmanagementspringmvc.entity.BookTypeEntity;

@Repository
public interface BookTypeDAO extends JpaRepository<BookTypeEntity, Long>{

}
