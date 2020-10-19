package hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.entities.Book;
import hibernate.util.HibernateUtil;

public class BookDao {

    public List < Book > getAllBook() {

        Transaction transaction = null;
        List < Book > listOfBook = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            listOfBook = session.createQuery("from Book").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfBook;
    }

}
