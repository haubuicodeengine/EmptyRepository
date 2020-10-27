package com.codeenginestudio.bookManagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.codeenginestudio.bookManagement.model.BookType;
import com.codeenginestudio.bookManagement.utl.HibernateUtil;

public class BookTypeDao {

	    public BookType getOneBookType(int bookId) {

	        Transaction transaction = null;
	        BookType bookType = null;

	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

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

	    @SuppressWarnings("unchecked")
	    public List < BookType > getAllBookType() {

	        Transaction transaction = null;
	        List < BookType > listOfBookType = null;

	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

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
}
