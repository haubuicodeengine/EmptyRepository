package com.codeenginestudio.management.book.repository;

import java.util.ArrayList;
import java.util.List;

import com.codeenginestudio.management.book.models.Book;

public class BookRepository {

	public static void addNewBook(Book book) {

		book.setBookId(_bookId);
		_books.add(book);
		_bookId++;
	}

	public static void deleteBook(int bookId) {

		for (Book book : _books) {

			if (bookId == book.getBookId()) {

				_books.remove(book);
				break;
			}
		}
	}

	public static void editBook(Book theBook) throws Exception {

		Book book = getBook(theBook.getBookId());
		book = theBook;
	}

	@SuppressWarnings("unused")
	public static Book getBook(int bookId) throws Exception {

		Book theBook = new Book();

		for (Book book : _books) {

			if (bookId == book.getBookId()) {
				theBook = book;
				return theBook;
			}
		}

		if (theBook == null) {
			throw new Exception("Book not found with id=" + bookId);
		}

		return theBook;
	}

	public static List<Book> getBooks() {

		return _books;
	}

	private static List<Book> _books = new ArrayList<>();
	private static int _bookId = 1;
}
