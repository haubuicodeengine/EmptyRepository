package ces.springmvc.bookmanagementspring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ces.springmvc.bookmanagementspringmvc.entity.AuthorEntity;

@Service
public interface AuthorService {

	List<AuthorEntity> getAllAuthors();

	AuthorEntity getAuthorById(int authorId);

}
