package com.codeenginestudio.bookManagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.codeenginestudio.bookManagement.model.Author;
import com.codeenginestudio.bookManagement.utl.HibernateUtil;

public class AuthorDao {
	public Author getOneAuthor(int authorId) {

        Transaction transaction = null;
        Author author = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            author = session.get(Author.class, authorId);
            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {

                transaction.rollback();
            }

            e.printStackTrace();
        }

        return author;
    }

    @SuppressWarnings("unchecked")
    public List < Author > getAllAuthor() {

        Transaction transaction = null;
        List < Author > listOfAuthor = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            listOfAuthor = session.createQuery("from Author").getResultList();
            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {

                transaction.rollback();
            }

            e.printStackTrace();
        }

        return listOfAuthor;
    }
}
