package com.codeenginestudio.bookManagement.dao;

import java.util.List;

//import org.hibernate.Query;

//import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.codeenginestudio.bookManagement.model.Book;
import com.codeenginestudio.bookManagement.model.BookAndBookType;
import com.codeenginestudio.bookManagement.model.BookType;
import com.codeenginestudio.bookManagement.utl.HibernateUtil;

public class BookAndBookTypeDao {

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

    @SuppressWarnings("unchecked")
    public List < BookAndBookType > getAllBookAndBookType() {

        Transaction transaction = null;
        List < BookAndBookType > listOfBookAndBookType = null;

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

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List < BookAndBookType > getAllBookAndBooksTypeByBookId(int bookId) {

        Transaction transaction = null;
        List < BookAndBookType > listOfBookAndBookType = null;

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
        BookAndBookType bookAndBookType = null;

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
