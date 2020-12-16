package ces.springmvc.bookmanagementspringmvc.dto;

public class BookTypeDTO {

	private Long bookTypeId;

	private String bookTypeName;

	public BookTypeDTO() {
		super();
	}

	public BookTypeDTO(Long bookTypeId, String bookTypeName) {
		super();
		this.bookTypeId = bookTypeId;
		this.bookTypeName = bookTypeName;
	}

	public Long getBookTypeId() {
		return bookTypeId;
	}

	public void setBookTypeId(Long bookTypeId) {
		this.bookTypeId = bookTypeId;
	}

	public String getBookTypeName() {
		return bookTypeName;
	}

	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}

}
