package servletTutorial.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import servletTutorial.entities.Book;

public class BookRepository {

	private static List<Book> listBooks = new ArrayList<>();

	public static void addBook(int bookId, String bookName, String author) {
		Book book = new Book();
		book.setBookId(bookId);
		book.setBookName(bookName);
		book.setAuthor(author);

		listBooks.add(book);
	}

	public static void editBook(int bookId, String bookName, String author) {
		for (Book book : listBooks) {
			if (book.getBookId() == bookId) {
				book.setBookName(bookName);
				book.setAuthor(author);
			}
		}
	}

	public static void deleteBook(int bookId) {
		for (int i = 0; i < listBooks.size(); i++) {
			if (listBooks.get(i).getBookId() == bookId) {
				listBooks.remove(i);
			}
		}
	}

	public static Book getBookById(int bookId) throws Exception {
		Book newBook = null;
		for (Book book : listBooks) {
			if (book.getBookId() == bookId) {
				newBook = book;
			}
		}
		if (newBook == null) {
			throw new Exception("Book not found with id = " + bookId);
		}
		return newBook;
	}

	public static List<Integer> getListBookId() {
		List<Integer> listBookId = new ArrayList<Integer>();
		for (Book book : listBooks) {
			listBookId.add(book.getBookId());
		}
		return listBookId;
	}

	public static List<Book> getBooks() {
		return listBooks;
	}

	public static int randomBookId(int n) {
		Random random = new Random();
		List<Integer> exBookIds = getListBookId();

		if (exBookIds.size() > 0) {
			int randNumber;
			do {
				randNumber = random.nextInt(n);
			} while (exBookIds.contains(randNumber));
			return randNumber;
		}
		return 1;
	}

}
