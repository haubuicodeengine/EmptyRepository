package com.codeenginestudio.management.book.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.codeenginestudio.management.book.model.Book;
import com.codeenginestudio.management.book.util.HibernateUtil;

public class BookDao {

	static Logger logger = Logger.getLogger(BookDao.class);

	public void deleteBook(Long bookId) {

		Transaction transaction = null;
		Session session = null;

		try {

			session = HibernateUtil._getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Book book = session.get(Book.class, bookId);

			if (book != null) {

				session.delete(book);
				System.out.println("user is deleted");

			}

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
	}

	@SuppressWarnings("unchecked")
	public List<Book> getBooks() {

		Transaction transaction = null;
		List<Book> listOfBook = new ArrayList<>();
		Session session = null;

		try {

			session = HibernateUtil._getSessionFactory().openSession();
			transaction = session.beginTransaction();
			listOfBook = session.createQuery("from Book").getResultList();
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

		return listOfBook;
	}

	public Book getBook(Long bookId) throws Exception {

		Transaction transaction = null;
		Book book = new Book();
		Session session = null;

		try {

			session = HibernateUtil._getSessionFactory().openSession();
			transaction = session.beginTransaction();
			book = session.get(Book.class, bookId);
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

		if (book == null) {

			throw new Exception("book's not found with id = " + bookId);
		}

		return book;
	}

	public void updateBook(Book book) {

		Transaction transaction = null;
		Session session = null;

		try {

			session = HibernateUtil._getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(book);
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
	}

	public void saveBook(Book book) {

		Transaction transaction = null;
		Session session = null;

		try {

			session = HibernateUtil._getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(book);
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
	}
}
