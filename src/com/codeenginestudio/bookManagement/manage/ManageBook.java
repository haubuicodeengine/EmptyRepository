package com.codeenginestudio.bookManagement.manage;

import java.util.ArrayList;
import java.util.List;

import com.codeenginestudio.bookManagement.models.Book;

public class ManageBook {

	public static List<Book> getListBooks() {

		return _books;
	}

	public static void addNewBook(String bookName, String bookAuthor) {

		Book book = new Book(_bookId, bookName, bookAuthor);
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

	public static void editBook(int bookId, String bookName, String bookAuthor) {

		Book book = getOneBook(bookId);
		book.setBookName(bookName);
		book.setBookAuthor(bookAuthor);
	}

	public static Book getOneBook(int bookId) {

		for (Book book : _books) {

			if (bookId == book.getBookId()) {
				return book;
			}
		}

		return null;
	}

	private static List<Book> _books = new ArrayList();
	private static int _bookId = 1;
}
