package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Exam")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Exam {
	
	private long id;
	
	//Attributes
	private LocalDateTime date;
	
	//Associations
	private List<ExamResult> results = new ArrayList<>();
	private Instructor instructor;
	
	//TODO static attribute
	public static int maxScore;
	
	public Exam(){}
	public Exam(LocalDateTime date){
		this.date = date;
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
	public LocalDateTime getDate() {
		return date;
	}
	
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	@OneToMany
	public List<ExamResult> getResults() {
		return results;
	}
	
	public void setResults(List<ExamResult> results) {
		this.results = results;
	}
	
	public void addResult(ExamResult result){
		if(!getResults().contains(result)){
			getResults().add(result);
			result.addExam(this);
		}
	}
	
	public void removeResults(ExamResult result){
		if(getResults().contains(result)){
			getResults().remove(result);
			result.removeExam(this);
		}
	}
	
	@ManyToOne
	public Instructor getInstructor() {
		return instructor;
	}
	
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	public void addInstructor(Instructor instructor){
		if(this.instructor != instructor) {
			removeInstructor(this.instructor); //TODO do this on every 1-* association
			this.instructor = instructor;
			instructor.addExam(this);
		}
	}
	
	public void removeInstructor(Instructor instructor){
		if(this.instructor != null){
			this.instructor = null;
			instructor.removeExam(this);
		}
	}
}
