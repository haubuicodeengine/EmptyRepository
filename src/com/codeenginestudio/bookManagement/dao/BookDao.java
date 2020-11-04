package com.codeenginestudio.bookManagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.codeenginestudio.bookManagement.model.Book;
import com.codeenginestudio.bookManagement.util.HibernateUtil;

public class BookDao {

	public void deleteBook(int bookId) {

		Transaction transaction = null;

		try (Session session = HibernateUtil._getSessionFactory().openSession()) {

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

			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Book> getAllBook() {

		Transaction transaction = null;
		List<Book> listOfBook = null;

		try (Session session = HibernateUtil._getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			listOfBook = session.createQuery("from Book").getResultList();
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {

				transaction.rollback();
			}

			e.printStackTrace();
		}

		return listOfBook;
	}

	public Book getOneBook(int bookId) {

		Transaction transaction = null;
		Book book = null;

		try (Session session = HibernateUtil._getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			book = session.get(Book.class, bookId);
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {

				transaction.rollback();
			}

			e.printStackTrace();
		}

		return book;
	}

	public void updateBook(Book book) {

		Transaction transaction = null;

		try (Session session = HibernateUtil._getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			session.update(book);
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {

				transaction.rollback();
			}

			e.printStackTrace();
		}
	}

	public void saveBook(Book book) {

		Transaction transaction = null;

		try (Session session = HibernateUtil._getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			session.save(book);
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {

				transaction.rollback();
			}

			e.printStackTrace();
		}
	}
}
