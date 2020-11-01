package ces.springmvc.bookmanagementspringmvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
public class AuthorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long authorId;

	@Column(name = "authorName")
	private String authorName;

	@Column(name = "authorAge")
	private Long age;

	@Column(name = "authorEmail")
	private String email;

	public AuthorEntity() {
		super();
	}

	public AuthorEntity(Long authorId, String authorName, Long age, String email) {
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
