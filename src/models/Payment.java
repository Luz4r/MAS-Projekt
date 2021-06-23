package models;

import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Payment")
public class Payment {
	
	private long id;
	
	//Attributes
	private double amount;
	private LocalDate period;
	
	//Associations
	private Trainee trainee;
	
	public Payment(){}
	public Payment(double amount, LocalDate period){
		this.amount = amount;
		this.period = period;
	}
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@Basic
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Basic
	public LocalDate getPeriod() {
		return period;
	}
	
	public void setPeriod(LocalDate period) {
		this.period = period;
	}
	
	@ManyToOne
	public Trainee getTrainee() {
		return trainee;
	}
	
	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}
	
	public void removeTrainee(Trainee trainee){
		if(this.trainee != null) {
			this.trainee = null;
			trainee.removePayment(this);
		}
	}
	
	public void addTrainee(Trainee trainee){
		this.trainee = trainee;
		trainee.addPayment(this);
	}
}
