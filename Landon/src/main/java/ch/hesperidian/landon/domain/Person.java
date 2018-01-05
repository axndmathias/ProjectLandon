package ch.hesperidian.landon.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Person extends GenericDomain {
	@Column(length = 50, nullable = false)
	private String name;

	@Column(length = 13, nullable = false)
	private String phone;

	@Column(length = 100, nullable = false)
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
