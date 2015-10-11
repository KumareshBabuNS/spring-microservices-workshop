package info.novatec.server.person.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.AbstractPersistable;

@SuppressWarnings("serial")
@Entity
public class Person extends AbstractPersistable<Long> {
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	@NotNull
	private Date birthDay;
	
	public Person() {
		super();
	}
	
	public Person(String firstName, String lastName, Date birthDay) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
	}
	
	public Date getBirthDay() {
		return birthDay;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	
	
}
