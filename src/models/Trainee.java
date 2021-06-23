package models;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity(name = "Trainee")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Trainee extends Person {
	
	private String login;
	private String password;
	
	public Trainee(){}
	
	@Basic
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	@Basic
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Transient
	public int getAge(){
		return Period.between(getBirthDate(), LocalDate.now()).getYears();
	}
}
