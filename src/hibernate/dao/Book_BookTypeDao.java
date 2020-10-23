package hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.entities.Author;
import hibernate.entities.Book;
import hibernate.entities.BookType;
import hibernate.entities.Book_BookType;
import hibernate.util.HibernateUtil;

public class Book_BookTypeDao {
	
	public List<Book_BookType> getAllBook_BookType() {

		Transaction transaction = null;
		List<Book_BookType> listOfBook_BookType = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an Book_BookType object

			listOfBook_BookType = session.createQuery("from Book_BookType").getResultList();

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfBook_BookType;
	}

	public void saveItem(Book book, BookType bookType) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the Book_BookType object
			Book_BookType newItem = new Book_BookType(book, bookType);
			session.save(newItem);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public Book_BookType getBook_BookTypeById(int id) {

		Transaction transaction = null;
		Book_BookType book_BookType = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			book_BookType = session.get(Book_BookType.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return book_BookType;
	}

	public void updateBook_BookType(Book_BookType book_BookType) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.update(book_BookType);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Delete Book_BookType
	 * 
	 * @param id
	 */
	public void deleteBook_BookType(int id) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a user object
			Book_BookType book_BookType = session.get(Book_BookType.class, id);
			if (book_BookType != null) {
				session.delete(book_BookType);
			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
}
