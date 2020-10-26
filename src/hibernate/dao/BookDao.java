package hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.entities.Book;
import hibernate.util.HibernateUtil;

public class BookDao {

	public List<Book> getAllBook() {

		Transaction transaction = null;
		List<Book> listOfBook = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			// start a transaction
			transaction = session.beginTransaction();
			// get an book object
			listOfBook = session.createQuery("from Book").getResultList();
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
		return listOfBook;
	}

	public void saveBook(Book book) {

		Transaction transaction = null;
		Session session = null;

		try {

			session = HibernateUtil.getSessionFactory().openSession(); // start a transaction
			transaction = session.beginTransaction();
			// save the book object
			session.save(book);
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
	}

	public Book getBookById(int id) {

		Transaction transaction = null;
		Book book = null;
		Session session = null;

		try {

			session = HibernateUtil.getSessionFactory().openSession(); // start a transaction
			transaction = session.beginTransaction();
			// get an user object
			book = session.get(Book.class, id);
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
		return book;
	}

	public void updateBook(Book book) {
		Transaction transaction = null;
		Session session = null;

		try {

			session = HibernateUtil.getSessionFactory().openSession(); // start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.update(book);
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
	}

	/**
	 * Delete book
	 * 
	 * @param id
	 */
	public void deleteBook(int id) {

		Transaction transaction = null;
		Session session = null;

		try {

			session = HibernateUtil.getSessionFactory().openSession(); // start a transaction
			transaction = session.beginTransaction();

			// Delete a user object
			Book book = session.get(Book.class, id);
			if (book != null) {
				session.delete(book);
			}

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
	}

}
