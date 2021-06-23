package models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "TrainingTrip")
public class TrainingTrip {
	
	private long id;
	
	//Attributes
	private LocalDateTime date;
	
	//Associations
	private Instructor instructor;
	private Trainee trainee;
	
	public TrainingTrip(){}
	public TrainingTrip(LocalDateTime date){
		this.date = date;
	}
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	public long getId(){
		return id;
	}
	
	@Basic
	public LocalDateTime getDateOfTraining() {
		return date;
	}
	
	public void setDateOfTraining(LocalDateTime date) {
		this.date = date;
	}
	
	private void setId(long id){
		this.id = id;
	}
	
	@ManyToOne
	public Instructor getInstructor() {
		return instructor;
	}
	
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	@ManyToOne
	public Trainee getTrainee() {
		return trainee;
	}
	
	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}
}
