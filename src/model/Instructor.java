package model;


import database.Database;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The type Instructor.
 */
@Entity(name = "Instructor")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Instructor extends Person {
	
	//Attributes
	private Set<InstructorTypeClass> instructorType = Stream.of(new InstructorTypeClass("Instructor")).collect(Collectors.toSet());
	private double salary;
	private Set<String> workingHours;
	
	//Associations
	private List<InstructorVehicle> vehicles = new ArrayList<>();
	private List<TrainingTrip> trips = new ArrayList<>();
	private List<Exam> exams = new ArrayList<>();
	
	/**
	 * Instantiates a new Instructor.
	 */
	public Instructor(){
	
	}
	
	/**
	 * Instantiates a new Instructor.
	 *
	 * @param firstName    the first name
	 * @param lastName     the last name
	 * @param phoneNumber  the phone number
	 * @param eMail        the e mail
	 * @param birthDate    the birth date
	 * @param salary       the salary
	 * @param workingHours the working hours
	 * @param isManager    the is manager
	 */
	public Instructor(String firstName, String lastName, String phoneNumber, String eMail, LocalDate birthDate, double salary, Set<String> workingHours, boolean isManager){
		super(firstName, lastName, phoneNumber, eMail, birthDate);
		this.salary = salary;
		this.workingHours = workingHours;
		if(isManager){
			instructorType.add(new InstructorTypeClass("Manager"));
		}
	}
	
	/**
	 * Get instructor type set.
	 *
	 * @return the set
	 */
	@ElementCollection
	public Set<InstructorTypeClass> getInstructorType(){
		return instructorType;
	}
	
	/**
	 * Set instructor type.
	 *
	 * @param instructorKind the instructor kind
	 */
	public void setInstructorType(Set<InstructorTypeClass> instructorKind){
		this.instructorType = instructorKind;
	}
	
	/**
	 * Get working hours set.
	 *
	 * @return the set
	 */
	@ElementCollection
	public Set<String> getWorkingHours(){
		return workingHours;
	}
	
	/**
	 * Set working hours.
	 *
	 * @param workingHours the working hours
	 */
	public void setWorkingHours(Set<String> workingHours){
		this.workingHours = workingHours;
	}
	
	/**
	 * Gets salary.
	 *
	 * @return the salary
	 */
	@Basic
	public double getSalary() {
		return salary;
	}
	
	/**
	 * Set salary.
	 *
	 * @param salary the salary
	 */
	public void setSalary(double salary){
		this.salary = salary;
	}
	
	/**
	 * Gets vehicles.
	 *
	 * @return the vehicles
	 */
	@OneToMany
	public List<InstructorVehicle> getVehicles() {
		return vehicles;
	}
	
	/**
	 * Sets vehicles.
	 *
	 * @param vehicles the vehicles
	 */
	public void setVehicles(List<InstructorVehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	/**
	 * Add vehicle.
	 *
	 * @param instructorVehicle the instructor vehicle
	 */
	public void addVehicle(InstructorVehicle instructorVehicle){
		if(!getVehicles().contains(instructorVehicle)) {
			getVehicles().add(instructorVehicle);
			instructorVehicle.addInstructor(this);
		}
	}
	
	/**
	 * Remove vehicle.
	 *
	 * @param instructorVehicle the instructor vehicle
	 */
	public void removeVehicle(InstructorVehicle instructorVehicle){
		if(getVehicles().contains(instructorVehicle)){
			getVehicles().remove(instructorVehicle);
			instructorVehicle.removeInstructor(this);
		}
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
		if(!getTrips().contains(trip)){
			getTrips().add(trip);
			trip.addInstructor(this);
		}
	}
	
	/**
	 * Remove trip.
	 *
	 * @param trip the trip
	 */
	public void removeTrip(TrainingTrip trip){
		if(getTrips().contains(trip)){
			getTrips().remove(trip);
			trip.removeInstructor(this);
		}
	}
	
	/**
	 * Gets exams.
	 *
	 * @return the exams
	 */
	@OneToMany
	public List<Exam> getExams() {
		return exams;
	}
	
	/**
	 * Sets exams.
	 *
	 * @param exams the exams
	 */
	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}
	
	/**
	 * Add exam.
	 *
	 * @param exam the exam
	 */
	public void addExam(Exam exam){
		if(!getExams().contains(exam)){
			getExams().add(exam);
			exam.addInstructor(this);
		}
	}
	
	/**
	 * Remove exam.
	 *
	 * @param exam the exam
	 */
	public void removeExam(Exam exam){
		if(getExams().contains(exam)){
			getExams().remove(exam);
			exam.removeInstructor(this);
		}
	}
	
	/**
	 * Assign new vehicle to instructor.
	 *
	 * @param selectedVehicle the selected vehicle
	 */
	public void assignToVehicle(Vehicle selectedVehicle){
		Database db = Database.getInstance();
		
		InstructorVehicle insVeh = new InstructorVehicle(LocalDate.now());
		insVeh.addInstructor(this);
		insVeh.addVehicle(selectedVehicle);
		
		db.save(insVeh);
		db.save(this);
		db.save(selectedVehicle);
	}
	
	@Override
	public String toString() {
		return getFirstName() + " " + getLastName();
	}
}
