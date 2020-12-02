package hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.entities.Book;
import hibernate.util.HibernateUtil;

public class BookDao {

	public void deleteBook(int id) {
		Transaction transaction = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession(); // start a transaction
			transaction = session.beginTransaction();

			Book book = session.get(Book.class, id);
			if (book != null) {
				session.delete(book);
			}
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

	public void updateBook(Book book) {
		Transaction transaction = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession(); // start a transaction
			transaction = session.beginTransaction();

			session.update(book);
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

	public void saveBook(Book book) {
		Transaction transaction = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession(); // start a transaction
			transaction = session.beginTransaction();

			session.save(book);
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

	public Book getBookById(int id) throws Exception {
		Transaction transaction = null;
		Book book = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession(); // start a transaction
			transaction = session.beginTransaction();

			book = session.get(Book.class, id);
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
		if (book == null) {
			throw new Exception("Book not found with id = " + id);
		}
		return book;
	}

	public List<Book> getBooks() {
		Transaction transaction = null;
		List<Book> listOfBook = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			listOfBook = session.createQuery("from Book").getResultList();
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

}
