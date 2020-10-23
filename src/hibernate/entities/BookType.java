package hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bookType")
public class BookType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookTypeId;

	@Column(name = "bookTypeName")
	private String bookTypeName;

	public BookType() {
		super();
	}

	public BookType(int bookTypeId, String bookTypeName) {
		super();
		this.bookTypeId = bookTypeId;
		this.bookTypeName = bookTypeName;
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
}
