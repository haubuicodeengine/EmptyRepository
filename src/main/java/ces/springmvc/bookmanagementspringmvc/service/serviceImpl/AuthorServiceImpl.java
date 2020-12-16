package ces.springmvc.bookmanagementspringmvc.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ces.springmvc.bookmanagementspringmvc.service.AuthorService;
import ces.springmvc.bookmanagementspringmvc.util.AuthorUtil;
import ces.springmvc.bookmanagementspringmvc.dao.AuthorDAO;
import ces.springmvc.bookmanagementspringmvc.dto.AuthorDTO;
import ces.springmvc.bookmanagementspringmvc.entity.AuthorEntity;

@Service("authorService")
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorDAO authorDAO;

	@Override
	public AuthorDTO getAuthorById(Long authorId) {

		return AuthorUtil.parseToDTO(authorDAO.getOne(authorId));
	}

	@Override
	public List<AuthorDTO> getAuthors() {
		List<AuthorEntity> listAuthors = (List<AuthorEntity>) authorDAO.findAll();
		List<AuthorDTO> authorDTO = new ArrayList<>();

		for (AuthorEntity author : listAuthors) {

			authorDTO.add(AuthorUtil.parseToDTO(author));
		}

		return authorDTO;
	}

}
