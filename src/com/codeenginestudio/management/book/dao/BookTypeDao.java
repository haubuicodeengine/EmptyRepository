package com.codeenginestudio.management.book.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.codeenginestudio.management.book.model.BookAndBookType;
import com.codeenginestudio.management.book.model.BookType;
import com.codeenginestudio.management.book.util.HibernateUtil;

public class BookTypeDao {

	static Logger logger = Logger.getLogger(BookTypeDao.class);

	private BookAndBookTypeDao bookAndBookTypeDao = new BookAndBookTypeDao();

	@SuppressWarnings("unchecked")
	public List<BookType> getBookTypes() {

		Transaction transaction = null;
		List<BookType> listOfBookType = null;

		try (Session session = HibernateUtil._getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			listOfBookType = session.createQuery("from BookType").getResultList();
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {

				transaction.rollback();
			}

			logger.error("Some things went wrong", e);
		}

		return listOfBookType;
	}

	public BookType getBookType(Long bookId) {

		Transaction transaction = null;
		BookType bookType = null;

		try (Session session = HibernateUtil._getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			bookType = session.get(BookType.class, bookId);
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {

				transaction.rollback();
			}

			logger.error("Some things went wrong", e);
		}

		return bookType;
	}

	public List<Long> getListIdOfTypeByBookId(Long bookId) {

		List<BookAndBookType> listBookAndTypeByBookId = bookAndBookTypeDao.getBookAndBookTypesByBookId(bookId);
		List<Long> listTypeOfBooks = new ArrayList<>();

		for (BookAndBookType bookAndBookType : listBookAndTypeByBookId) {
			Long id = bookAndBookType.getBookType().getBookTypeId();
			listTypeOfBooks.add(id);
		}

		return listTypeOfBooks;
	}
}
