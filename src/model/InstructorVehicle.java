package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * The type Instructor vehicle.
 */
@Entity(name = "InstructorVehicle")
public class InstructorVehicle {
	
	private long id;
	
	//Attributes
	private LocalDate assignDate;
	private int tripCount;
	
	//Associations
	private Instructor instructor;
	private Vehicle vehicle;
	
	/**
	 * Instantiates a new Instructor vehicle.
	 */
	public InstructorVehicle(){}
	
	/**
	 * Instantiates a new Instructor vehicle.
	 *
	 * @param assignDate the assign date
	 */
	public InstructorVehicle(LocalDate assignDate){
		this.assignDate = assignDate;
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
	 * Gets assign date.
	 *
	 * @return the assign date
	 */
	@Basic
	public LocalDate getAssignDate() {
		return assignDate;
	}
	
	/**
	 * Sets assign date.
	 *
	 * @param assignDate the assign date
	 */
	public void setAssignDate(LocalDate assignDate) {
		this.assignDate = assignDate;
	}
	
	/**
	 * Gets trip count.
	 *
	 * @return the trip count
	 */
	@Basic
	public int getTripCount() {
		return tripCount;
	}
	
	/**
	 * Sets trip count.
	 *
	 * @param tripCount the trip count
	 */
	public void setTripCount(int tripCount) {
		this.tripCount = tripCount;
	}
	
	/**
	 * Gets instructor.
	 *
	 * @return the instructor
	 */
	@ManyToOne
	public Instructor getInstructor() {
		return instructor;
	}
	
	/**
	 * Sets instructor.
	 *
	 * @param instructor the instructor
	 */
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	/**
	 * Add instructor.
	 *
	 * @param instructor the instructor
	 */
	public void addInstructor(Instructor instructor){
		if(this.instructor != instructor) {
			removeInstructor(this.instructor);
			this.instructor = instructor;
			instructor.addVehicle(this);
		}
	}
	
	/**
	 * Remove instructor.
	 *
	 * @param instructor the instructor
	 */
	public void removeInstructor(Instructor instructor){
		if(this.instructor != null) {
			this.instructor = null;
			instructor.removeVehicle(this);
		}
	}
	
	/**
	 * Gets vehicle.
	 *
	 * @return the vehicle
	 */
	@ManyToOne
	public Vehicle getVehicle() {
		return vehicle;
	}
	
	/**
	 * Sets vehicle.
	 *
	 * @param vehicle the vehicle
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	/**
	 * Add vehicle.
	 *
	 * @param vehicle the vehicle
	 */
	public void addVehicle(Vehicle vehicle){
		if(this.vehicle != vehicle) {
			removeVehicle(this.vehicle);
			this.vehicle = vehicle;
			vehicle.addInstructor(this);
		}
	}
	
	/**
	 * Remove vehicle.
	 *
	 * @param vehicle the vehicle
	 */
	public void removeVehicle(Vehicle vehicle){
		if(this.vehicle != null){
			this.vehicle = null;
			vehicle.removeInstructor(this);
		}
	}
}
