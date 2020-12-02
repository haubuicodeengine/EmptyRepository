package hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.entities.BookType;
import hibernate.util.HibernateUtil;

public class BookTypeDao {

	public BookType getBookTypeById(int id) {
		Transaction transaction = null;
		BookType bookType = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			bookType = session.get(BookType.class, id);
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

	public List<BookType> getAllBookType() {
		Transaction transaction = null;
		List<BookType> listOfBookType = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			listOfBookType = session.createQuery("from BookType").getResultList();
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
}
