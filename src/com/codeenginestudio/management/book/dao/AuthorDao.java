package com.codeenginestudio.management.book.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.codeenginestudio.management.book.model.Author;
import com.codeenginestudio.management.book.util.HibernateUtil;

public class AuthorDao {

	@SuppressWarnings("unchecked")
	public List<Author> getAuthors() {

		Transaction transaction = null;
		List<Author> listOfAuthor = null;

		try (Session session = HibernateUtil._getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			listOfAuthor = session.createQuery("from Author").getResultList();
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {

				transaction.rollback();
			}

			System.out.println("getAuthors() failed: " + e.getMessage());
			e.printStackTrace();
		}

		return listOfAuthor;
	}

	public Author getAuthor(Long authorId) {

		Transaction transaction = null;
		Author author = null;

		try (Session session = HibernateUtil._getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			author = session.get(Author.class, authorId);
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {

				transaction.rollback();
			}

			System.out.println("getAuthor() failed: " + e.getMessage());
			e.printStackTrace();
		}

		return author;
	}
}
