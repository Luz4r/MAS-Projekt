package models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity(name = "Payment")
public class Payment {
	
	private long id;
	
	private double amount;
	private LocalDate period;
	
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
}
