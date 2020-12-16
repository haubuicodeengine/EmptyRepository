package ces.springmvc.bookmanagementspringmvc.dto;

public class AuthorDTO {

	private Long authorId;

	private String authorName;

	private Long age;

	private String email;

	public AuthorDTO() {
		super();
	}

	public AuthorDTO(Long authorId, String authorName, Long age, String email) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.age = age;
		this.email = email;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
