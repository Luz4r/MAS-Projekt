package models;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Trainee")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Trainee extends Person {
	
	//Attributes
	private String login;
	private String password;
	
	//Associations
	private List<TrainingTrip> trips = new ArrayList<>();
	private List<Payment> payments = new ArrayList<>();
	private List<ExamResult> results = new ArrayList<>();
	
	public Trainee(){}
	public Trainee(String login, String password){
		this.login = login;
		this.password = password;
	}
	
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
	
	@OneToMany
	public List<TrainingTrip> getTrips() {
		return trips;
	}
	
	public void setTrips(List<TrainingTrip> trips) {
		this.trips = trips;
	}
	
	@OneToMany
	public List<Payment> getPayments() {
		return payments;
	}
	
	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}
	
	@OneToMany
	public List<ExamResult> getResults() {
		return results;
	}
	
	public void setResults(List<ExamResult> results) {
		this.results = results;
	}
}
