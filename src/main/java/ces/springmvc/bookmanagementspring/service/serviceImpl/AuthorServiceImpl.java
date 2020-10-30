package ces.springmvc.bookmanagementspring.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ces.springmvc.bookmanagementspring.service.AuthorService;
import ces.springmvc.bookmanagementspringmvc.dao.AuthorDAO;
import ces.springmvc.bookmanagementspringmvc.entity.AuthorEntity;

@Service("authorService")
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorDAO authorDAO;

	@Override
	public List<AuthorEntity> getAllAuthors() {
		return authorDAO.findAll();
	}

	@Override
	public AuthorEntity getAuthorById(int authorId) {
		return authorDAO.getOne(authorId);
	}

}
