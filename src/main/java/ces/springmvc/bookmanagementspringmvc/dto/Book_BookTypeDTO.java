package ces.springmvc.bookmanagementspringmvc.dto;

public class Book_BookTypeDTO {

	private Long id;

	private BookDTO book;

	private BookTypeDTO bookType;

	public Book_BookTypeDTO() {
		super();
	}

	public Book_BookTypeDTO(Long id, BookDTO book, BookTypeDTO bookType) {
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

	public BookDTO getBook() {
		return book;
	}

	public void setBook(BookDTO book) {
		this.book = book;
	}

	public BookTypeDTO getBookType() {
		return bookType;
	}

	public void setBookType(BookTypeDTO bookType) {
		this.bookType = bookType;
	}

}
