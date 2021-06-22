package models;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity(name = "Instructor")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Instructor extends Person{
	
	private Set<InstructorTypeClass> instructorKind = Stream.of(new InstructorTypeClass("Instructor")).collect(Collectors.toSet());
	private double salary;
	private Set<String> workingHours;
	
	
	public Instructor(){
	
	}
	
	public Instructor(String firstName, String lastName, String phoneNumber, String eMail, LocalDate birthDate, double salary, Set<String> workingHours, boolean isManager){
		super(firstName, lastName, phoneNumber, eMail, birthDate);
		this.salary = salary;
		this.workingHours = workingHours;
		if(isManager){
			instructorKind.add(new InstructorTypeClass("Manager"));
		}
	}
	
	@ElementCollection
	public Set<InstructorTypeClass> getInstructorType(){
		return instructorKind;
	}
	
	public void setInstructorType(Set<InstructorTypeClass> instructorKind){
		this.instructorKind = instructorKind;
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
}
