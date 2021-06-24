package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * The enum Vehicle state.
 */
enum VehicleState{
	/**
	 * Not assigned vehicle state.
	 */
	NotAssigned,
	/**
	 * Waiting vehicle state.
	 */
	Waiting,
	/**
	 * On trip vehicle state.
	 */
	OnTrip,
	/**
	 * On inspection vehicle state.
	 */
	OnInspection}

/**
 * The type Vehicle.
 */
@Entity(name = "Vehicle")
public class Vehicle {
	
	private long id;
	
	//Attributes
	private String brand;
	private String registration;
	private LocalDate production;
	private LocalDate nextInspection;
	private VehicleState state;
	
	//Associations
	private List<InstructorVehicle> instructors = new ArrayList<>();
	private List<Inspection> inspections = new ArrayList<>();
	
	/**
	 * Instantiates a new Vehicle.
	 */
	public Vehicle(){}
	
	/**
	 * Instantiates a new Vehicle.
	 *
	 * @param brand          the brand
	 * @param registration   the registration
	 * @param production     the production
	 * @param nextInspection the next inspection
	 */
	public Vehicle(String brand, String registration, LocalDate production, LocalDate nextInspection){
		this.brand = brand;
		this.registration = registration;
		this.production = production;
		this.nextInspection = nextInspection;
		state = VehicleState.NotAssigned;
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
	 * Gets brand.
	 *
	 * @return the brand
	 */
	@Basic
	public String getBrand() {
		return brand;
	}
	
	/**
	 * Sets brand.
	 *
	 * @param brand the brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * Gets registration.
	 *
	 * @return the registration
	 */
	@Column(unique = true)
	@Basic
	public String getRegistration() {
		return registration;
	}
	
	/**
	 * Sets registration.
	 *
	 * @param registration the registration
	 */
	public void setRegistration(String registration) {
		this.registration = registration;
	}
	
	/**
	 * Gets production.
	 *
	 * @return the production
	 */
	@Basic
	public LocalDate getProduction() {
		return production;
	}
	
	/**
	 * Sets production.
	 *
	 * @param production the production
	 */
	public void setProduction(LocalDate production) {
		this.production = production;
	}
	
	/**
	 * Gets next inspection.
	 *
	 * @return the next inspection
	 */
	@Basic
	public LocalDate getNextInspection() {
		return nextInspection;
	}
	
	/**
	 * Sets next inspection.
	 *
	 * @param nextInspection the next inspection
	 */
	public void setNextInspection(LocalDate nextInspection) {
		this.nextInspection = nextInspection;
	}
	
	/**
	 * Gets state.
	 *
	 * @return the state
	 */
	@Enumerated(EnumType.STRING)
	public VehicleState getState() {
		return state;
	}
	
	/**
	 * Sets state.
	 *
	 * @param state the state
	 */
	public void setState(VehicleState state) {
		this.state = state;
	}
	
	/**
	 * Gets instructors.
	 *
	 * @return the instructors
	 */
	@OneToMany
	public List<InstructorVehicle> getInstructors() {
		return instructors;
	}
	
	/**
	 * Sets instructors.
	 *
	 * @param instructors the instructors
	 */
	public void setInstructors(List<InstructorVehicle> instructors) {
		this.instructors = instructors;
	}
	
	/**
	 * Add instructor.
	 *
	 * @param instructorVehicle the instructor vehicle
	 */
	public void addInstructor(InstructorVehicle instructorVehicle){
		if(!getInstructors().contains(instructorVehicle)) {
			getInstructors().add(instructorVehicle);
			setState(VehicleState.Waiting);
			instructorVehicle.addVehicle(this);
		}
	}
	
	/**
	 * Remove instructor.
	 *
	 * @param instructorVehicle the instructor vehicle
	 */
	public void removeInstructor(InstructorVehicle instructorVehicle){
		if(getInstructors().contains(instructorVehicle)){
			getInstructors().remove(instructorVehicle);
			if(getInstructors().isEmpty()){
				setState(VehicleState.NotAssigned);
			}
			instructorVehicle.removeVehicle(this);
		}
	}
	
	/**
	 * Gets inspections.
	 *
	 * @return the inspections
	 */
	@OneToMany
	public List<Inspection> getInspections() {
		return inspections;
	}
	
	/**
	 * Sets inspections.
	 *
	 * @param inspections the inspections
	 */
	public void setInspections(List<Inspection> inspections) {
		this.inspections = inspections;
	}
	
	/**
	 * Add inspection.
	 *
	 * @param inspection the inspection
	 */
	public void addInspection(Inspection inspection){
		if(!getInspections().contains(inspection)){
			getInspections().add(inspection);
			inspection.addVehicle(this);
		}
	}
	
	/**
	 * Remove inspection.
	 *
	 * @param inspection the inspection
	 */
	public void removeInspection(Inspection inspection){
		if(getInspections().contains(inspection)){
			getInspections().remove(inspection);
			inspection.removeVehicle(this);
		}
	}
	
	@Override
	public String toString() {
		return getBrand() + " (" + getRegistration() + ") " + "[nr " + getId() + "]";
	}
}

