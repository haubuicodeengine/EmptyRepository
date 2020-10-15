package com.codeenginestudio.bookManagement.manage;

import java.util.ArrayList;
import java.util.List;

import com.codeenginestudio.bookManagement.models.Book;

public class ManageBook {
	private static List<Book> books = new ArrayList();
	private static int bookId = 1;

	public List<Book> getListBooks() {
		return books;
	}

	public void addNewBook(String bookName, String bookAuthor) {

		books.add(new Book(bookId, bookName, bookAuthor));
		bookId ++;
	}

	public void editBook(int bookId, String bookName, String bookAuthor) {

		Book changableBook = getOneBook(bookId);
		changableBook.setBookName(bookName);
		changableBook.setBookAuthor(bookAuthor);
	}

	public Book getOneBook (int bookId) {

		for (Book book : books) {

			if(bookId == book.getBookId()) {
				return book;
			}
		}

		return null;
	}

	public void deleteBook(int bookId) {
		
		for (Book book : books) {

			if(bookId == book.getBookId()) {
				books.remove(book);
				break;
			}
		}
	}
}
