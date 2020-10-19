package hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;

	@Column(name = "name")
	private String bookName;

	@Column(name = "price")
	private float price;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "author")
	private String author;

	public Book() {
		super();
	}

	public Book(int bookId, String bookName, float price, int quantity, String author) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.price = price;
		this.quantity = quantity;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
