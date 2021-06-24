package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * The type Payment.
 */
@Entity(name = "Payment")
public class Payment {
	
	private long id;
	
	//Attributes
	private double amount;
	private LocalDate period;
	
	//Associations
	private Trainee trainee;
	
	/**
	 * Instantiates a new Payment.
	 */
	public Payment(){}
	
	/**
	 * Instantiates a new Payment.
	 *
	 * @param amount the amount
	 * @param period the period
	 */
	public Payment(double amount, LocalDate period){
		this.amount = amount;
		this.period = period;
	}
	
	/**
	 * Gets id.
	 *
	 * @return the id
	 */
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	public long getId() {
		return id;
	}
	
	/**
	 * Sets id.
	 *
	 * @param id the id
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * Gets amount.
	 *
	 * @return the amount
	 */
	@Basic
	public double getAmount() {
		return amount;
	}
	
	/**
	 * Sets amount.
	 *
	 * @param amount the amount
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	/**
	 * Gets period.
	 *
	 * @return the period
	 */
	@Basic
	public LocalDate getPeriod() {
		return period;
	}
	
	/**
	 * Sets period.
	 *
	 * @param period the period
	 */
	public void setPeriod(LocalDate period) {
		this.period = period;
	}
	
	/**
	 * Gets trainee.
	 *
	 * @return the trainee
	 */
	@ManyToOne
	public Trainee getTrainee() {
		return trainee;
	}
	
	/**
	 * Sets trainee.
	 *
	 * @param trainee the trainee
	 */
	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}
	
	/**
	 * Remove trainee.
	 *
	 * @param trainee the trainee
	 */
	public void removeTrainee(Trainee trainee){
		if(this.trainee != null) {
			this.trainee = null;
			trainee.removePayment(this);
		}
	}
	
	/**
	 * Add trainee.
	 *
	 * @param trainee the trainee
	 */
	public void addTrainee(Trainee trainee){
		if(this.trainee != trainee) {
			removeTrainee(this.trainee);
			this.trainee = trainee;
			trainee.addPayment(this);
		}
	}
}
