package com.codeenginestudio.bookManagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.codeenginestudio.bookManagement.model.BookAndBookType;
import com.codeenginestudio.bookManagement.model.BookType;
import com.codeenginestudio.bookManagement.util.HibernateUtil;

public class BookTypeDao {

	private BookAndBookTypeDao bookAndBookTypeDao = new BookAndBookTypeDao();

	@SuppressWarnings("unchecked")
	public List<BookType> getAllBookType() {

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

			e.printStackTrace();
		}

		return listOfBookType;
	}

	public BookType getOneBookType(int bookId) {

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

			e.printStackTrace();
		}

		return bookType;
	}

	public List<String> getListIdOfTypeByBookId(int bookId) {

		List<BookAndBookType> listBookAndTypeByBookId = bookAndBookTypeDao.getAllBookAndBooksTypeByBookId(bookId);
		List<String> listTypeOfBooks = new ArrayList<>();

		for (BookAndBookType bookAndBookType : listBookAndTypeByBookId) {
			String id = String.valueOf(bookAndBookType.getBookType().getBookTypeId());
			listTypeOfBooks.add(id);
		}

		return listTypeOfBooks;
	}
}
