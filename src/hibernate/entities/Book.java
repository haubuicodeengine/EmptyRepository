package hibernate.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;

	@Column(name = "name")
	private String bookName;

	@ManyToOne(cascade = {CascadeType.DETACH})
	@JoinColumn(name = "authorId", referencedColumnName = "authorId")
	private Author author;

	public Book() {
		super();
	}

	public Book(int bookId, String bookName, Author author) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
	}

	public Book(String bookName, Author author) {
		super();
		this.bookName = bookName;
		this.author = author;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}
