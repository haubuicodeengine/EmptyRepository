package hibernate.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bookType")
public class BookType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookTypeId;

	@Column(name = "bookTypeName")
	private String bookTypeName;

	@ManyToMany(mappedBy = "bookType")
	private List<Book> books = new ArrayList<>();

	public BookType() {
		super();
	}

	public BookType(int bookTypeId, String bookTypeName, List<Book> books) {
		super();
		this.bookTypeId = bookTypeId;
		this.bookTypeName = bookTypeName;
		this.books = books;
	}

	public int getBookTypeId() {
		return bookTypeId;
	}

	public void setBookTypeId(int bookTypeId) {
		this.bookTypeId = bookTypeId;
	}

	public String getBookTypeName() {
		return bookTypeName;
	}

	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
