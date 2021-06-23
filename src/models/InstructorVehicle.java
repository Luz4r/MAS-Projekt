package models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "InstructorVehicle")
public class InstructorVehicle {
	
	private long id;
	
	//Attributes
	private LocalDate assignDate;
	private int tripCount;
	
	//Associations
	private Instructor instructor;
	private Vehicle vehicle;
	
	public InstructorVehicle(){}
	public InstructorVehicle(LocalDate assignDate){
		this.assignDate = assignDate;
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
	public LocalDate getAssignDate() {
		return assignDate;
	}
	
	public void setAssignDate(LocalDate assignDate) {
		this.assignDate = assignDate;
	}
	
	@Basic
	public int getTripCount() {
		return tripCount;
	}
	
	public void setTripCount(int tripCount) {
		this.tripCount = tripCount;
	}
	
	@ManyToOne
	public Instructor getInstructor() {
		return instructor;
	}
	
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	public void addInstructor(Instructor instructor){
		this.instructor = instructor;
		instructor.addVehicle(this);
	}
	
	public void removeInstructor(Instructor instructor){
		if(this.instructor != null) {
			this.instructor = null;
			instructor.removeVehicle(this);
		}
	}
	
	@ManyToOne
	public Vehicle getVehicle() {
		return vehicle;
	}
	
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public void addVehicle(Vehicle vehicle){
		this.vehicle = vehicle;
		vehicle.addInstructor(this);
	}
	
	public void removeVehicle(Vehicle vehicle){
		if(this.vehicle != null){
			this.vehicle = null;
			vehicle.removeInstructor(this);
		}
	}
}
