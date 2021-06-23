package model;

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
	
	public void addInstructor(Instructor instructor){
		this.instructor = instructor;
		instructor.addTrip(this);
	}
	
	public void removeInstructor(Instructor instructor){
		if(this.instructor != null) {
			this.instructor.removeTrip(this);
			this.instructor = null;
		}
	}
	
	@ManyToOne
	public Trainee getTrainee() {
		return trainee;
	}
	
	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}
	
	public void removeTrainee(Trainee trainee){
		if(this.trainee != null) {
			this.trainee.removeTrip(this);
			this.trainee = null;
		}
	}
	
	public void addTrainee(Trainee trainee){
		this.trainee = trainee;
		trainee.addTrip(this);
	}
}
