package com.codeenginestudio.management.book.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.codeenginestudio.management.book.model.Book;
import com.codeenginestudio.management.book.model.BookAndBookType;
import com.codeenginestudio.management.book.model.BookType;
import com.codeenginestudio.management.book.util.BookTypeUtil;
import com.codeenginestudio.management.book.util.HibernateUtil;

public class BookAndBookTypeDao {

	static Logger logger = Logger.getLogger(BookAndBookTypeDao.class);

	public static BookTypeDao _bookTypeDao = new BookTypeDao();

	public void deleteBookAndBookType(Long bookAndBookTypeId) {

		Transaction transaction = null;
		Session session = null;

		try {

			session = HibernateUtil._getSessionFactory().openSession();
			transaction = session.beginTransaction();
			BookAndBookType bookAndBookType = session.get(BookAndBookType.class, bookAndBookTypeId);

			if (bookAndBookType != null) {

				session.delete(bookAndBookType);
				System.out.println("bookAndBookType is deleted");
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

	public void deleteAllBookAndBookTypeByBookId(Long bookId) {

		List<BookAndBookType> listOfBookAndBookType = getBookAndBookTypesByBookId(bookId);

		for (BookAndBookType bookAndBookType : listOfBookAndBookType) {
			deleteBookAndBookType(bookAndBookType.getBookAndBookTypeId());
		}
	}

	@SuppressWarnings("unchecked")
	public List<BookAndBookType> getBookAndBookTypes() {

		Transaction transaction = null;
		List<BookAndBookType> listOfBookAndBookType = new ArrayList<>();
		Session session = null;

		try {

			session = HibernateUtil._getSessionFactory().openSession();
			transaction = session.beginTransaction();
			listOfBookAndBookType = session.createQuery("from BookAndBookType").getResultList();
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

		return listOfBookAndBookType;
	}

	public BookAndBookType getBookAndBookTypeByBookIdAndTypeId(Long bookId, Long typeId) {
		Transaction transaction = null;
		BookAndBookType bookAndBookType = new BookAndBookType();

		try (Session session = HibernateUtil._getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			String hql = " FROM BookAndBookType B WHERE B.book.bookId = " + bookId + "and B.bookType.bookTypeId = "
					+ typeId;
			Query query = session.createQuery(hql);
			bookAndBookType = (BookAndBookType) query.getSingleResult();
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {

				transaction.rollback();
			}

			logger.error("Some things went wrong", e);
		}

		return bookAndBookType;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BookAndBookType> getBookAndBookTypesByBookId(Long bookId) {

		Transaction transaction = null;
		List<BookAndBookType> listOfBookAndBookType = new ArrayList<>();

		try (Session session = HibernateUtil._getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			String hql = " FROM BookAndBookType B WHERE B.book.bookId = " + bookId;
			Query query = session.createQuery(hql);
			listOfBookAndBookType = query.list();
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {

				transaction.rollback();
			}

			logger.error("Some things went wrong", e);
		}

		return listOfBookAndBookType;
	}

	public BookAndBookType getBookAndBookType(Long bookAndBookTypeId) {

		Transaction transaction = null;
		BookAndBookType bookAndBookType = new BookAndBookType();

		try (Session session = HibernateUtil._getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			bookAndBookType = session.get(BookAndBookType.class, bookAndBookTypeId);
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {

				transaction.rollback();
			}

			logger.error("Some things went wrong", e);
		}

		return bookAndBookType;
	}

	public void updateBookAndBookType(Long bookId, Book book, BookType bookType) {

		Transaction transaction = null;

		try (Session session = HibernateUtil._getSessionFactory().openSession()) {

			BookAndBookType bookAndBookType = getBookAndBookType(bookId);
			bookAndBookType.setBook(book);
			bookAndBookType.setBookType(bookType);
			transaction = session.beginTransaction();
			session.update(bookAndBookType);
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {

				transaction.rollback();
			}

			logger.error("Some things went wrong", e);
		}
	}

	public void updateBookAndBookTypeByBookId(List<Long> newListIdTypes, List<Long> currentTypes, Book book) {

		for (int i = 0; i < newListIdTypes.size(); i++) {

			Long typeId = newListIdTypes.get(i);

			if (!BookTypeUtil.checkDuplicateBooktype(currentTypes, newListIdTypes.get(i))) {

				BookType newBookType = _bookTypeDao.getBookType(typeId);
				BookAndBookType newBookAndBookType = new BookAndBookType(book, newBookType);
				saveBookAndBookType(newBookAndBookType);
			}
		}

		for (int i = 0; i < currentTypes.size(); i++) {

			if (!newListIdTypes.contains(currentTypes.get(i))) {

				Long id = currentTypes.get(i);
				BookAndBookType a = getBookAndBookTypeByBookIdAndTypeId(book.getBookId(), id);
				deleteBookAndBookType(a.getBookAndBookTypeId());
			}
		}
	}

	public void insertListOfBookAndBookType(List<Long> bookTypeIds, Book newBook) {

		for (int i = 0; i < bookTypeIds.size(); i++) {

			Long idType = bookTypeIds.get(i);
			BookType bookType = _bookTypeDao.getBookType(idType);
			saveBookAndBookType(new BookAndBookType(newBook, bookType));
		}
	}

	public void saveBookAndBookType(BookAndBookType bookAndBookType) {

		Transaction transaction = null;

		try (Session session = HibernateUtil._getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			session.save(bookAndBookType);
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {

				transaction.rollback();
			}

			logger.error("Some things went wrong", e);
		}
	}

}
