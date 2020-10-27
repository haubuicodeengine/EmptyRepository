package com.codeenginestudio.bookManagement.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeenginestudio.bookManagement.dao.AuthorDao;
import com.codeenginestudio.bookManagement.dao.BookAndBookTypeDao;
import com.codeenginestudio.bookManagement.dao.BookDao;
import com.codeenginestudio.bookManagement.dao.BookTypeDao;
import com.codeenginestudio.bookManagement.model.Author;
import com.codeenginestudio.bookManagement.model.Book;
import com.codeenginestudio.bookManagement.model.BookAndBookType;
import com.codeenginestudio.bookManagement.model.BookType;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private BookDao bookDao;
	private BookAndBookTypeDao bookAndBookTypeDao;
	private BookTypeDao bookTypeDao;
	private AuthorDao authorDao;

	public void init() {
		bookDao = new BookDao();
		bookAndBookTypeDao = new BookAndBookTypeDao();
		authorDao = new AuthorDao();
		bookTypeDao = new BookTypeDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
	        case "/book/add":
	            addForm(request, response);
	            break;
            case "/book/insert":
                insertBook(request, response);
                break;
            case "/book/delete":
                deleteBook(request, response);
                break;
            case "/book/edit":
                editForm(request, response);
                break;
            case "/book/update":
                updateBook(request, response);
                break;
            case "/book/":
            	listBook(request, response);
                break;
            default:
                listBook(request, response);
                break;
        }
    }

	private void insertBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bookName = request.getParameter("bookName");
		String[] bookTypeIds = request.getParameterValues("bookTypeId");
		int authorId = Integer.parseInt(request.getParameter("bookAuthorId"));
		Author bookAuthor = authorDao.getOneAuthor(authorId);

		if(bookName.equals("")) {

			request.setAttribute("book", new Book(bookName, bookAuthor));
			request.setAttribute("bookNameErr", "Name of book could not be blank");
			request.setAttribute("url", "/book/insert");
			request.setAttribute("bookTypes", bookTypeDao.getAllBookType());
			displayView(request, response, "/view/AddOrEditBook.jsp");

		} else {

			Book newBook = new Book(bookName, bookAuthor);
			bookDao.saveBook(newBook);

			for (int i = 0; i < bookTypeIds.length; i++) {
				int idType = Integer.parseInt(bookTypeIds[i].toString());
				BookType bookType = bookTypeDao.getOneBookType(idType);
				bookAndBookTypeDao.saveBookAndBookType(new BookAndBookType(newBook, bookType));
			}

			request.setAttribute("listBooks", bookDao.getAllBook());
			request.setAttribute("listBookAndtype", bookAndBookTypeDao.getAllBookAndBookType());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Home.jsp");
	        dispatcher.forward(request, response);
		}
	}

	private void listBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("listBooks", bookDao.getAllBook());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Home.jsp");
        dispatcher.forward(request, response);
	}

	private void updateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int bookId = Integer.parseInt(request.getParameter("bookId"));
		int authorId = Integer.parseInt(request.getParameter("bookAuthorId"));
		String[] bookTypeIds = request.getParameterValues("bookTypeId");
		List<String> newListIdType = Arrays.asList(bookTypeIds);
		String bookName = request.getParameter("bookName");
		Author bookAuthor = authorDao.getOneAuthor(authorId);

		if(bookName.equals("")) {

			request.setAttribute("book", new Book(bookId, bookName, bookAuthor));
			request.setAttribute("bookNameErr", "Name of book could not be blank");
			request.setAttribute("url", "/book/update");
			request.setAttribute("bookTypes", bookAndBookTypeDao.getAllBookAndBookType());
			displayView(request, response, "/view/AddOrEditBook.jsp");

		}else {
			// update Book
			Book book = bookDao.getOneBook(bookId);
        	book.setBookName(bookName);
        	book.setBookAuthor(bookAuthor);
        	bookDao.updateBook(book);
        	
        	//update type of the book
			List<BookAndBookType> bookAndType = bookAndBookTypeDao.getAllBookAndBooksTypeByBookId(bookId);
			
			int maxFor = _findMax(bookTypeIds.length, bookAndType.size());

			for(int i = 0; i < maxFor; i++) {
				
				int typeId = Integer.parseInt(bookTypeIds[i].toString());

				if(!_checkDuplicateBooktype(bookAndType, typeId)) {
					
					BookType newBookType = bookTypeDao.getOneBookType(typeId);
					BookAndBookType newBookAndBookType = new BookAndBookType(book, newBookType);
					bookAndBookTypeDao.saveBookAndBookType(newBookAndBookType);
				}
			}

			for(int i = 0; i < maxFor; i++) {
				
				
				int typeId = Integer.parseInt(bookTypeIds[i].toString());

				if(!newListIdType.contains(bookAndType.get(i).getBookType().getBookTypeId())) {
					
					bookAndBookTypeDao.deleteBookAndBookType(bookAndType.get(i).getBookAndBookTypeId());
				}
			}

			request.setAttribute("listBooks", bookDao.getAllBook());
			displayView(request, response, "/view/Home.jsp");
		}
	}

	public static int _findMax(int size1, int size2) {
		
		int max;

		if(size1 >= size2) {

			max = size1;

		}else {

			max = size2;

		}

		return max;
	}

	private Boolean _checkDuplicateBooktype(List<BookAndBookType> bookAndType, int typeId) {
		
		BookType newBookType = bookTypeDao.getOneBookType(typeId);

		if (bookAndType.contains(newBookType.getBookTypeId())) {
			return true;
		}

		return false;
	}
	
	private void editForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int bookId = Integer.parseInt(request.getParameter("bookId"));
		request.setAttribute("url", "/book/update");
		request.setAttribute("book", bookDao.getOneBook(bookId));
		request.setAttribute("bookTypes", bookTypeDao.getAllBookType());
		request.setAttribute("authors", authorDao.getAllAuthor());
		displayView(request, response, "/view/AddOrEditBook.jsp");
	}

	private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int bookId = Integer.parseInt(request.getParameter("bookId"));
		bookDao.deleteBook(bookId);
		request.setAttribute("listBooks", bookDao.getAllBook());
		displayView(request, response, "/view/Home.jsp");
	}

	private void addForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("url", "/book/insert");
		request.setAttribute("bookTypes", bookTypeDao.getAllBookType());
		request.setAttribute("authors", authorDao.getAllAuthor());
		displayView(request, response, "/view/AddOrEditBook.jsp");
	}

    public void displayView(HttpServletRequest request, HttpServletResponse response, String fileName)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(fileName);
		dispatcher.forward(request, response);
	}

}
