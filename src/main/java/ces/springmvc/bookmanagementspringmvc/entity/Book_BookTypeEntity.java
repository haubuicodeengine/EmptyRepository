package ces.springmvc.bookmanagementspringmvc.entity;

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
public class Book_BookTypeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@ManyToOne(cascade = {CascadeType.DETACH})
	@JoinColumn(name = "bookId")
	BookEntity book;

	@ManyToOne(cascade = {CascadeType.DETACH})
	@JoinColumn(name = "bookTypeId")
	BookTypeEntity bookType;

	public Book_BookTypeEntity() {
		super();
	}
	
	public Book_BookTypeEntity(BookEntity book, BookTypeEntity bookType) {
		super();
		this.book = book;
		this.bookType = bookType;
	}
	
	public Book_BookTypeEntity(Long id, BookEntity book, BookTypeEntity bookType) {
		super();
		this.id = id;
		this.book = book;
		this.bookType = bookType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BookEntity getBook() {
		return book;
	}

	public void setBook(BookEntity book) {
		this.book = book;
	}

	public BookTypeEntity getBookType() {
		return bookType;
	}

	public void setBookType(BookTypeEntity bookType) {
		this.bookType = bookType;
	}

}
