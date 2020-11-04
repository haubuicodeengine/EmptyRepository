package hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.entities.Author;
import hibernate.util.HibernateUtil;

public class AuthorDao {

	public List<Author> getAllAuthor() {

		Transaction transaction = null;
		List<Author> listOfAuthor = null;
		Session session = null;

		try {

			session = HibernateUtil.getSessionFactory().openSession();
			// start a transaction
			transaction = session.beginTransaction();
			// get an book object

			listOfAuthor = session.createQuery("from Author").getResultList();

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return listOfAuthor;
	}

	public Author getAuthorById(int id) {

		Transaction transaction = null;
		Author author = null;
		Session session = null;

		try {

			session = HibernateUtil.getSessionFactory().openSession();
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			author = session.get(Author.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return author;
	}

	public Author getAuthorByName(String name) {
		Transaction transaction = null;
		Author author = null;
		Session session = null;

		try {

			session = HibernateUtil.getSessionFactory().openSession();
			// start a transaction
			transaction = session.beginTransaction();
			// get an author object
			author = session.get(Author.class, name);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return author;
	}
}
