package com.codeenginestudio.management.book.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.codeenginestudio.management.book.model.Author;
import com.codeenginestudio.management.book.util.HibernateUtil;

public class AuthorDao {

	static Logger logger = Logger.getLogger(AuthorDao.class);

	@SuppressWarnings("unchecked")
	public List<Author> getAuthors() {

		Transaction transaction = null;
		List<Author> listOfAuthor = null;
		Session session = null;

		try {

			session = HibernateUtil._getSessionFactory().openSession();
			transaction = session.beginTransaction();
			listOfAuthor = session.createQuery("from Author").getResultList();
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {

				transaction.rollback();
			}

			logger.error("Some things went wrong", e);
		} finally {

			if (session != null) {

				session.close();
			}
		}

		return listOfAuthor;
	}

	public Author getAuthor(Long authorId) {

		Transaction transaction = null;
		Author author = null;
		Session session = null;

		try {

			session = HibernateUtil._getSessionFactory().openSession();
			transaction = session.beginTransaction();
			author = session.get(Author.class, authorId);
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {

				transaction.rollback();
			}

			logger.error("Some things went wrong", e);
		} finally {

			if (session != null) {

				session.close();
			}
		}

		return author;
	}
}
