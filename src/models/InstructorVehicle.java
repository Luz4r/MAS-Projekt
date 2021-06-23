package models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity(name = "InstructorVehicle")
public class InstructorVehicle {
	
	private long id;
	
	private LocalDate assignDate;
	private int tripCount;
	
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
}
