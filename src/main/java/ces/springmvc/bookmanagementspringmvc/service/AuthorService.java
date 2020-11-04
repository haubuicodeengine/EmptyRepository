package ces.springmvc.bookmanagementspringmvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ces.springmvc.bookmanagementspringmvc.entity.AuthorEntity;

@Service
public interface AuthorService {

	AuthorEntity getAuthorById(Long authorId);

	List<AuthorEntity> getAllAuthors();

}
