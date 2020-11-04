package com.codeenginestudio.bookManagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.codeenginestudio.bookManagement.model.Book;
import com.codeenginestudio.bookManagement.model.BookAndBookType;
import com.codeenginestudio.bookManagement.model.BookType;
import com.codeenginestudio.bookManagement.util.BookTypeUtil;
import com.codeenginestudio.bookManagement.util.HibernateUtil;

public class BookAndBookTypeDao {

	public static BookTypeDao _bookTypeDao = new BookTypeDao();

	public void deleteBookAndBookType(int bookAndBookTypeId) {

		Transaction transaction = null;

		try (Session session = HibernateUtil._getSessionFactory().openSession()) {

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

			e.printStackTrace();
		}
	}

	public void deleteAllBookAndBookTypeByBookId(int bookId) {

		List<BookAndBookType> listOfBookAndBookType = getAllBookAndBooksTypeByBookId(bookId);

		for (BookAndBookType bookAndBookType : listOfBookAndBookType) {
			deleteBookAndBookType(bookAndBookType.getBookAndBookTypeId());
		}
	}

	@SuppressWarnings("unchecked")
	public List<BookAndBookType> getAllBookAndBookType() {

		Transaction transaction = null;
		List<BookAndBookType> listOfBookAndBookType = null;

		try (Session session = HibernateUtil._getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			listOfBookAndBookType = session.createQuery("from BookAndBookType").getResultList();
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {

				transaction.rollback();
			}

			e.printStackTrace();
		}

		return listOfBookAndBookType;
	}

	public BookAndBookType getBookAndBookTypeByBookIdAndTypeId(int bookId, int typeId) {
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

			e.printStackTrace();
		}

		return bookAndBookType;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BookAndBookType> getAllBookAndBooksTypeByBookId(int bookId) {

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

			e.printStackTrace();
		}

		return listOfBookAndBookType;
	}

	public BookAndBookType getOneBookAndBookType(int bookAndBookTypeId) {

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

			e.printStackTrace();
		}

		return bookAndBookType;
	}

	public void updateBookAndBookType(int bookId, Book book, BookType bookType) {

		Transaction transaction = null;

		try (Session session = HibernateUtil._getSessionFactory().openSession()) {

			BookAndBookType bookAndBookType = getOneBookAndBookType(bookId);
			bookAndBookType.setBook(book);
			bookAndBookType.setBookType(bookType);
			transaction = session.beginTransaction();
			session.update(bookAndBookType);
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {

				transaction.rollback();
			}

			e.printStackTrace();
		}
	}

	public void updateBookAndBookTypeByBookId(List<String> newListIdTypes, List<String> currentTypes, Book book) {

		for (int i = 0; i < newListIdTypes.size(); i++) {

			int typeId = Integer.parseInt(newListIdTypes.get(i).toString());

			if (!BookTypeUtil._checkDuplicateBooktype(currentTypes, newListIdTypes.get(i))) {

				BookType newBookType = _bookTypeDao.getOneBookType(typeId);
				BookAndBookType newBookAndBookType = new BookAndBookType(book, newBookType);
				saveBookAndBookType(newBookAndBookType);
			}
		}

		for (int i = 0; i < currentTypes.size(); i++) {

			if (!newListIdTypes.contains(currentTypes.get(i))) {

				int id = Integer.parseInt(currentTypes.get(i));
				BookAndBookType a = getBookAndBookTypeByBookIdAndTypeId(book.getBookId(), id);
				deleteBookAndBookType(a.getBookAndBookTypeId());
			}
		}
	}

	public void insertListOfBookAndBookType(String[] bookTypeIds, Book newBook) {

		for (int i = 0; i < bookTypeIds.length; i++) {

			int idType = Integer.parseInt(bookTypeIds[i].toString());
			BookType bookType = _bookTypeDao.getOneBookType(idType);
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

			e.printStackTrace();
		}
	}

}
