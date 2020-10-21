package hibernate.service;

import java.util.List;

import hibernate.entities.Author;

public class AuthorServiceImp {

	public static Author getAuthorByAuthorName(List<Author> listAuthors, String authorName) {
		for (Author author : listAuthors) {
			if (author.getAuthorName().equals(authorName)) {
				return author;
			}
		}
		return null;
	}

	public static Author getAuthorByAuthorId(List<Author> listAuthors, int authorId) {
		for (Author author : listAuthors) {
			if (author.getAuthorId() == authorId) {
				return author;
			}
		}
		return null;
	}
}
