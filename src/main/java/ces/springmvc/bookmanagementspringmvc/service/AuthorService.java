package ces.springmvc.bookmanagementspringmvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ces.springmvc.bookmanagementspringmvc.dto.AuthorDTO;

@Service
public interface AuthorService {

	AuthorDTO getAuthorById(Long authorId);

	List<AuthorDTO> getAuthors();

}
