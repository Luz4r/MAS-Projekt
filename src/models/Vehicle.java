package models;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

enum VehicleState{NotAssigned, Waiting, OnTrip, OnInspection}

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
	
	public Vehicle(){}
	public Vehicle(String brand, String registration, LocalDate production, LocalDate nextInspection){
		this.brand = brand;
		this.registration = registration;
		this.production = production;
		this.nextInspection = nextInspection;
		state = VehicleState.NotAssigned;
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
	
	@Enumerated(EnumType.STRING)
	public VehicleState getState() {
		return state;
	}
	
	public void setState(VehicleState state) {
		this.state = state;
	}
	
	@OneToMany
	public List<InstructorVehicle> getInstructors() {
		return instructors;
	}
	
	public void setInstructors(List<InstructorVehicle> instructors) {
		this.instructors = instructors;
	}
	
	public void addInstructor(InstructorVehicle instructorVehicle){
		if(!getInstructors().contains(instructorVehicle)) {
			getInstructors().add(instructorVehicle);
			instructorVehicle.addVehicle(this);
		}
	}
	
	public void removeInstructor(InstructorVehicle instructorVehicle){
		if(getInstructors().contains(instructorVehicle)){
			getInstructors().remove(instructorVehicle);
			instructorVehicle.removeVehicle(this);
		}
	}
	
	@OneToMany
	public List<Inspection> getInspections() {
		return inspections;
	}
	
	public void setInspections(List<Inspection> inspections) {
		this.inspections = inspections;
	}
	
	public void addInspection(Inspection inspection){
		if(!getInspections().contains(inspection)){
			getInspections().add(inspection);
			inspection.addVehicle(this);
		}
	}
	
	public void removeInspection(Inspection inspection){
		if(getInspections().contains(inspection)){
			getInspections().remove(inspection);
			inspection.removeVehicle(this);
		}
	}
}

