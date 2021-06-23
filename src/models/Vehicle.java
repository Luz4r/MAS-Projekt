package models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Vehicle")
public class Vehicle {
	
	private long id;
	
	private String brand;
	private String registration;
	private LocalDate production;
	private LocalDate nextInspection;
	
	public Vehicle(){}
	public Vehicle(String brand, String registration, LocalDate production, LocalDate nextInspection){
		this.brand = brand;
		this.registration = registration;
		this.production = production;
		this.nextInspection = nextInspection;
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
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	@Column(unique = true)
	@Basic
	public String getRegistration() {
		return registration;
	}
	
	public void setRegistration(String registration) {
		this.registration = registration;
	}
	
	@Basic
	public LocalDate getProduction() {
		return production;
	}
	
	public void setProduction(LocalDate production) {
		this.production = production;
	}
	
	@Basic
	public LocalDate getNextInspection() {
		return nextInspection;
	}
	
	public void setNextInspection(LocalDate nextInspection) {
		this.nextInspection = nextInspection;
	}
}
