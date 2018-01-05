package ch.hesperidian.landon.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class User extends GenericDomain{
	@Column(length = 32, nullable = false)
	private String password;
	
	@Column(nullable = false)
	private Character type;
	
	@Column(nullable = false)
	private Boolean Status;
	
	@OneToOne
	private Person person;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Character getType() {
		return type;
	}

	public void setType(Character type) {
		this.type = type;
	}

	public Boolean getStatus() {
		return Status;
	}

	public void setStatus(Boolean status) {
		Status = status;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}
