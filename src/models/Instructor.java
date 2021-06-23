package models;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	
	public Instructor(){
	
	}
	public Instructor(String firstName, String lastName, String phoneNumber, String eMail, LocalDate birthDate, double salary, Set<String> workingHours, boolean isManager){
		super(firstName, lastName, phoneNumber, eMail, birthDate);
		this.salary = salary;
		this.workingHours = workingHours;
		if(isManager){
			instructorType.add(new InstructorTypeClass("Manager"));
		}
	}
	
	@ElementCollection
	public Set<InstructorTypeClass> getInstructorType(){
		return instructorType;
	}
	
	public void setInstructorType(Set<InstructorTypeClass> instructorKind){
		this.instructorType = instructorKind;
	}
	
	@ElementCollection
	public Set<String> getWorkingHours(){
		return workingHours;
	}
	
	public void setWorkingHours(Set<String> workingHours){
		this.workingHours = workingHours;
	}
	
	@Basic
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary){
		this.salary = salary;
	}
	
	@OneToMany
	public List<InstructorVehicle> getVehicles() {
		return vehicles;
	}
	
	public void setVehicles(List<InstructorVehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	public void addVehicle(InstructorVehicle instructorVehicle){
		if(!getVehicles().contains(instructorVehicle)) {
			getVehicles().add(instructorVehicle);
			instructorVehicle.addInstructor(this);
		}
	}
	
	public void removeVehicle(InstructorVehicle instructorVehicle){
		if(getVehicles().contains(instructorVehicle)){
			getVehicles().remove(instructorVehicle);
			instructorVehicle.removeInstructor(this);
		}
	}
	
	@OneToMany
	public List<TrainingTrip> getTrips() {
		return trips;
	}
	
	public void setTrips(List<TrainingTrip> trips) {
		this.trips = trips;
	}
	
	public void addTrip(TrainingTrip trip){
		if(!getTrips().contains(trip)){
			getTrips().add(trip);
			trip.addInstructor(this);
		}
	}
	
	public void removeTrip(TrainingTrip trip){
		if(getTrips().contains(trip)){
			getTrips().remove(trip);
			trip.removeInstructor(this);
		}
	}
	
	@OneToMany
	public List<Exam> getExams() {
		return exams;
	}
	
	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}
	
	public void addExam(Exam exam){
		if(!getExams().contains(exam)){
			getExams().add(exam);
			exam.addInstructor(this);
		}
	}
	
	public void removeExam(Exam exam){
		if(getExams().contains(exam)){
			getExams().remove(exam);
			exam.removeInstructor(this);
		}
	}
}
