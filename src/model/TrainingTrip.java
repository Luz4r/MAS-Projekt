package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * The type Training trip.
 */
@Entity(name = "TrainingTrip")
public class TrainingTrip {
	
	private long id;
	
	//Attributes
	private LocalDateTime date;
	
	//Associations
	private Instructor instructor;
	private Trainee trainee;
	
	/**
	 * Instantiates a new Training trip.
	 */
	public TrainingTrip(){}
	
	/**
	 * Instantiates a new Training trip.
	 *
	 * @param date the date
	 */
	public TrainingTrip(LocalDateTime date){
		this.date = date;
	}
	
	/**
	 * Get id long.
	 *
	 * @return the long
	 */
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	public long getId(){
		return id;
	}
	
	/**
	 * Gets date of training.
	 *
	 * @return the date of training
	 */
	@Basic
	public LocalDateTime getDateOfTraining() {
		return date;
	}
	
	/**
	 * Sets date of training.
	 *
	 * @param date the date
	 */
	public void setDateOfTraining(LocalDateTime date) {
		this.date = date;
	}
	
	private void setId(long id){
		this.id = id;
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
		this.instructor = instructor;
		instructor.addTrip(this);
	}
	
	/**
	 * Remove instructor.
	 *
	 * @param instructor the instructor
	 */
	public void removeInstructor(Instructor instructor){
		if(this.instructor != null) {
			this.instructor.removeTrip(this);
			this.instructor = null;
		}
	}
	
	/**
	 * Gets trainee.
	 *
	 * @return the trainee
	 */
	@ManyToOne
	public Trainee getTrainee() {
		return trainee;
	}
	
	/**
	 * Sets trainee.
	 *
	 * @param trainee the trainee
	 */
	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}
	
	/**
	 * Remove trainee.
	 *
	 * @param trainee the trainee
	 */
	public void removeTrainee(Trainee trainee){
		if(this.trainee != null) {
			this.trainee.removeTrip(this);
			this.trainee = null;
		}
	}
	
	/**
	 * Add trainee.
	 *
	 * @param trainee the trainee
	 */
	public void addTrainee(Trainee trainee){
		this.trainee = trainee;
		trainee.addTrip(this);
	}
}
