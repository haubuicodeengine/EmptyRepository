package servletTutorial.manage;

import java.util.ArrayList;
import java.util.List;

import servletTutorial.entities.Book;

public class BookManagement {

	private static List<Book> listBooks = new ArrayList<>();

	public static List<Book> getBooks() {
		return listBooks;
	}

	public static void addBook(int bookId, String bookName, String author) {

		Book book = new Book();
		book.setBookId(bookId);
		book.setBookName(bookName);
		book.setAuthor(author);

		listBooks.add(book);
	}

	public static Book showEditBook(int bookId) {

		for (Book book : listBooks) {
			if (book.getBookId() == bookId) {
				return book;
			}
		}
		return null;
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
}
