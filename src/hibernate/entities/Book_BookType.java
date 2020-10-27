package hibernate.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book_bookType")
public class Book_BookType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@ManyToOne(cascade = {CascadeType.DETACH})
	@JoinColumn(name = "bookId")
	Book book;

	@ManyToOne(cascade = {CascadeType.DETACH})
	@JoinColumn(name = "bookTypeId")
	BookType bookType;

	public Book_BookType() {
		super();
	}
	
	public Book_BookType(Book book, BookType bookType) {
		super();
		this.book = book;
		this.bookType = bookType;
	}
	
	public Book_BookType(int id, Book book, BookType bookType) {
		super();
		this.id = id;
		this.book = book;
		this.bookType = bookType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public BookType getBookType() {
		return bookType;
	}

	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}

}
