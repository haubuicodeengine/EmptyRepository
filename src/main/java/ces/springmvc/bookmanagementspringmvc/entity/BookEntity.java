package ces.springmvc.bookmanagementspringmvc.entity;

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
public class BookEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookId;

	@Column(name = "bookName")
	private String bookName;

	@ManyToOne(cascade = { CascadeType.DETACH })
	@JoinColumn(name = "authorId", referencedColumnName = "authorId")
	private AuthorEntity author;

	public BookEntity() {
		super();
	}

	public BookEntity(Long bookId, String bookName, AuthorEntity author) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
	}

	public BookEntity(String bookName, AuthorEntity author) {
		super();
		this.bookName = bookName;
		this.author = author;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public AuthorEntity getAuthor() {
		return author;
	}

	public void setAuthor(AuthorEntity author) {
		this.author = author;
	}

}
