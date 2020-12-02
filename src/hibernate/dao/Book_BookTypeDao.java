package hibernate.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.entities.Book;
import hibernate.entities.BookType;
import hibernate.entities.Book_BookType;
import hibernate.util.HibernateUtil;
import hibernate.validation.BookValidator;

public class Book_BookTypeDao {

	public void deleteBook_BookType(int id) {
		Transaction transaction = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Book_BookType book_BookType = session.get(Book_BookType.class, id);
			if (book_BookType != null) {
				session.delete(book_BookType);
			}
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
	}

	public void deleteBook_BookTypeByBookId(int bookId) {
		List<Book_BookType> listBook_BookType = _getBook_BookTypeByBookId(bookId);

		for (Book_BookType item : listBook_BookType) {
			deleteBook_BookType(item.getId());
		}
	}

	public void updateBook_BookType(Book book, String[] listbookType, BookTypeDao bookTypeDao) {

		List<Integer> listBookTypeChecked = getListBookTypeIdByBookId(book.getBookId());
		List<Integer> listBookTypeId = _convertStringArrayToListInteger(listbookType);

		if (listBookTypeChecked.size() < 1) {
			if (listBookTypeId != null) {
				for (Integer bookTypeId : listBookTypeId) {
					saveBook_BookType(book, bookTypeDao.getBookTypeById(bookTypeId));
				}
			}
		} else {
			if (listBookTypeId != null) {
				// check bookType existed in db
				for (Integer bookTypeId : listBookTypeId) {
					if (BookValidator.checkBookTypeExisted(getBook_BookTypes(), book.getBookId(), bookTypeId)) {
						saveBook_BookType(book, bookTypeDao.getBookTypeById(bookTypeId));
					}
				}
				// check bookType is removed
				for (Integer BookTypeIdChecked : listBookTypeChecked) {
					if (!listBookTypeId.contains(BookTypeIdChecked)) {
						_deleteBook_BookTypeByBookTypeIdAndBookId(BookTypeIdChecked, book.getBookId());
					}
				}
			} else {
				// check list bookType remove all
				deleteBook_BookTypeByBookId(book.getBookId());
			}
		}
	}

	public void saveBook_BookType(Book book, BookType bookType) {
		Transaction transaction = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Book_BookType newItem = new Book_BookType(book, bookType);
			session.save(newItem);
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
	}

	public List<Integer> getListBookTypeIdByBookId(int bookId) {
		List<Book_BookType> listBook_BookType = _getBook_BookTypeByBookId(bookId);
		List<Integer> listBookTypeId = new ArrayList<Integer>();

		for (Book_BookType item : listBook_BookType) {
			listBookTypeId.add(item.getBookType().getBookTypeId());
		}
		return listBookTypeId;

	}

	public Book_BookType getBook_BookTypeById(int id) {
		Transaction transaction = null;
		Book_BookType book_BookType = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			book_BookType = session.get(Book_BookType.class, id);
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
		return book_BookType;
	}

	public List<Book_BookType> getBook_BookTypes() {
		Transaction transaction = null;
		List<Book_BookType> listOfBook_BookType = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			listOfBook_BookType = session.createQuery("from Book_BookType").getResultList();
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
		return listOfBook_BookType;
	}

	private List<Integer> _convertStringArrayToListInteger(String[] listbookType) {

		if (listbookType != null) {
			List<String> StrListBookTypeId = Arrays.asList(listbookType);
			return StrListBookTypeId.stream().map(Integer::valueOf).collect(Collectors.toList());
		}
		return null;
	}

	private List<Book_BookType> _getBook_BookTypeByBookId(int bookId) {

		Transaction transaction = null;
		List<Book_BookType> listOfBook_BookType = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			String sql = "from Book_BookType b where b.book.bookId = '" + bookId + "'";

			listOfBook_BookType = session.createQuery(sql).getResultList();
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
		return listOfBook_BookType;
	}

	private void _deleteBook_BookTypeByBookTypeIdAndBookId(Integer bookTypeId, int bookId) {
		List<Book_BookType> listBook_BookType = _getBook_BookTypeByBookId(bookId);

		for (Book_BookType item : listBook_BookType) {
			if (item.getBookType().getBookTypeId() == bookTypeId) {
				deleteBook_BookType(item.getId());
			}
		}
	}

}
