package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Exam.
 */
@Entity(name = "Exam")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Exam {
	
	private long id;
	
	//Attributes
	private LocalDateTime date;
	
	//Associations
	private List<ExamResult> results = new ArrayList<>();
	private Instructor instructor;
	
	/**
	 * The constant maxScore.
	 */
//TODO static attribute
	public static int maxScore;
	
	/**
	 * Instantiates a new Exam.
	 */
	public Exam(){}
	
	/**
	 * Instantiates a new Exam.
	 *
	 * @param date the date of when exam is happening
	 */
	public Exam(LocalDateTime date){
		this.date = date;
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
	 * Gets date.
	 *
	 * @return the date
	 */
	@Basic
	public LocalDateTime getDate() {
		return date;
	}
	
	/**
	 * Sets date.
	 *
	 * @param date the date
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	/**
	 * Gets results.
	 *
	 * @return the results
	 */
	@OneToMany
	public List<ExamResult> getResults() {
		return results;
	}
	
	/**
	 * Sets results.
	 *
	 * @param results the results
	 */
	public void setResults(List<ExamResult> results) {
		this.results = results;
	}
	
	/**
	 * Add result.
	 *
	 * @param result the result
	 */
	public void addResult(ExamResult result){
		if(!getResults().contains(result)){
			getResults().add(result);
			result.addExam(this);
		}
	}
	
	/**
	 * Remove results.
	 *
	 * @param result the result
	 */
	public void removeResults(ExamResult result){
		if(getResults().contains(result)){
			getResults().remove(result);
			result.removeExam(this);
		}
	}
	
	/**
	 * Gets instructor.
	 *
	 * @return the managing instructor
	 */
	@ManyToOne
	public Instructor getInstructor() {
		return instructor;
	}
	
	/**
	 * Sets instructor.
	 *
	 * @param instructor the managing instructor
	 */
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	/**
	 * Add instructor.
	 *
	 * @param instructor the managing instructor
	 */
	public void addInstructor(Instructor instructor){
		if(this.instructor != instructor) {
			removeInstructor(this.instructor); //TODO do this on every 1-* association
			this.instructor = instructor;
			instructor.addExam(this);
		}
	}
	
	/**
	 * Remove instructor.
	 *
	 * @param instructor the managing instructor
	 */
	public void removeInstructor(Instructor instructor){
		if(this.instructor != null){
			this.instructor = null;
			instructor.removeExam(this);
		}
	}
}
