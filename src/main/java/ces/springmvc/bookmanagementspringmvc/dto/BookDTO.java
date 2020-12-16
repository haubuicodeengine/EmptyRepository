package ces.springmvc.bookmanagementspringmvc.dto;

public class BookDTO {

	private Long bookId;

	private String bookName;

	private AuthorDTO author;

	public BookDTO() {
		super();
	}

	public BookDTO(Long bookId, String bookName, AuthorDTO author) {
		super();
		this.bookId = bookId;
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

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

}
