package model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * The type Person.
 */
@MappedSuperclass
public abstract class Person {
	
	private long id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String eMail;
	private LocalDate birthDate;
	
	/**
	 * Instantiates a new Person.
	 */
	public Person() {}
	
	/**
	 * Instantiates a new Person.
	 *
	 * @param firstName   the first name
	 * @param lastName    the last name
	 * @param phoneNumber the phone number
	 * @param eMail       the e mail
	 * @param birthDate   the birth date
	 */
	public Person(String firstName, String lastName, String phoneNumber, String eMail, LocalDate birthDate){
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.eMail = eMail;
		this.birthDate = birthDate;
	}
	
	/**
	 * Get id long.
	 *
	 * @return the long
	 */
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	public long getId(){
		return id;
	}
	
	private void setId(long id){
		this.id = id;
	}
	
	
	/**
	 * Gets phone number.
	 *
	 * @return the phone number
	 */
	@Basic
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	/**
	 * Sets phone number.
	 *
	 * @param phoneNumber the phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * Gets first name.
	 *
	 * @return the first name
	 */
	@Basic
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets first name.
	 *
	 * @param firstName the first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Gets last name.
	 *
	 * @return the last name
	 */
	@Basic
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets last name.
	 *
	 * @param lastName the last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Gets e mail.
	 *
	 * @return the e mail
	 */
	@Basic
	public String getEMail() {
		return eMail;
	}
	
	/**
	 * Sets e mail.
	 *
	 * @param eMail the e mail
	 */
	public void setEMail(String eMail) {
		this.eMail = eMail;
	}
	
	/**
	 * Gets birth date.
	 *
	 * @return the birth date
	 */
	@Basic
	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	/**
	 * Sets birth date.
	 *
	 * @param birthDate the birth date
	 */
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
}
