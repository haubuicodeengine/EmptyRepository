package hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.entities.BookType;
import hibernate.util.HibernateUtil;

public class BookTypeDao {
	public List<BookType> getAllBookType() {

		Transaction transaction = null;
		List<BookType> listOfBookType = null;
		Session session = null;

		try {

			session = HibernateUtil.getSessionFactory().openSession(); // start a transaction
			transaction = session.beginTransaction();
			// get an book object

			listOfBookType = session.createQuery("from BookType").getResultList();

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return listOfBookType;
	}

	public BookType getBookTypeById(int id) {

		Transaction transaction = null;
		BookType bookType = null;
		Session session = null;

		try {

			session = HibernateUtil.getSessionFactory().openSession(); // start a transaction
			transaction = session.beginTransaction();
			// get an user object
			bookType = session.get(BookType.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return bookType;
	}
}
