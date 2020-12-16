package ces.springmvc.bookmanagementspringmvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ces.springmvc.bookmanagementspringmvc.entity.AuthorEntity;

@Repository
public interface AuthorDAO extends JpaRepository<AuthorEntity, Long> {

}
