package model;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Trainee.
 */
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
	
	/**
	 * Instantiates a new Trainee.
	 */
	public Trainee(){}
	
	/**
	 * Instantiates a new Trainee.
	 *
	 * @param login    the login
	 * @param password the password
	 */
	public Trainee(String login, String password){
		this.login = login;
		this.password = password;
	}
	
	/**
	 * Gets login.
	 *
	 * @return the login
	 */
	@Basic
	public String getLogin() {
		return login;
	}
	
	/**
	 * Sets login.
	 *
	 * @param login the login
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	
	/**
	 * Gets password.
	 *
	 * @return the password
	 */
	@Basic
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets password.
	 *
	 * @param password the password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Get age int.
	 *
	 * @return the int
	 */
	@Transient
	public int getAge(){
		return Period.between(getBirthDate(), LocalDate.now()).getYears();
	}
	
	/**
	 * Gets trips.
	 *
	 * @return the trips
	 */
	@OneToMany
	public List<TrainingTrip> getTrips() {
		return trips;
	}
	
	/**
	 * Sets trips.
	 *
	 * @param trips the trips
	 */
	public void setTrips(List<TrainingTrip> trips) {
		this.trips = trips;
	}
	
	/**
	 * Add trip.
	 *
	 * @param trip the trip
	 */
	public void addTrip(TrainingTrip trip){
		if(!getTrips().contains(trip)) {
			getTrips().add(trip);
			trip.addTrainee(this);
		}
	}
	
	/**
	 * Remove trip.
	 *
	 * @param trip the trip
	 */
	public void removeTrip(TrainingTrip trip){
		if(getTrips().contains(trip)) {
			getTrips().remove(trip);
			trip.removeTrainee(this);
		}
	}
	
	/**
	 * Gets payments.
	 *
	 * @return the payments
	 */
	@OneToMany
	public List<Payment> getPayments() {
		return payments;
	}
	
	/**
	 * Sets payments.
	 *
	 * @param payments the payments
	 */
	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}
	
	/**
	 * Add payment.
	 *
	 * @param payment the payment
	 */
	public void addPayment(Payment payment){
		if(!getPayments().contains(payment)) {
			getPayments().add(payment);
			payment.addTrainee(this);
		}
	}
	
	/**
	 * Remove payment.
	 *
	 * @param payment the payment
	 */
	public void removePayment(Payment payment){
		if(getPayments().contains(payment)) {
			getPayments().remove(payment);
			payment.removeTrainee(this);
		}
	}
	
	/**
	 * Gets results.
	 *
	 * @return the results
	 */
	@OneToMany
	public List<ExamResult> getResults() {
		return results;
	}
	
	/**
	 * Sets results.
	 *
	 * @param results the results
	 */
	public void setResults(List<ExamResult> results) {
		this.results = results;
	}
	
	/**
	 * Add result.
	 *
	 * @param result the result
	 */
	public void addResult(ExamResult result){
		if(!getResults().contains(result)){
			getResults().add(result);
			result.addTrainee(this);
		}
	}
	
	/**
	 * Remove result.
	 *
	 * @param result the result
	 */
	public void removeResult(ExamResult result){
		if(getResults().contains(result)){
			getResults().remove(result);
			result.removeTrainee(this);
		}
	}
}
