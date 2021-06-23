package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "ExamResult")
public class ExamResult {
	
	private long id;
	
	//Attributes
	private int score;
	
	//Associations
	private Exam exam;
	private Trainee trainee;
	
	public ExamResult(){}
	public ExamResult(int score){
		this.score = score;
	}
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	public long getId(){
		return id;
	}
	
	private void setId(long id){
		this.id = id;
	}
	
	@Basic
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	@Transient
	public boolean isPassed(){
		return score >= Exam.maxScore;
	}
	
	@ManyToOne
	public Exam getExam() {
		return exam;
	}
	
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	
	public void addExam(Exam exam){
		this.exam = exam;
		exam.addResult(this);
	}
	
	public void removeExam(Exam exam){
		if(this.exam != null){
			this.exam = null;
			exam.removeResults(this);
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
			this.trainee = null;
			trainee.removeResult(this);
		}
	}
	
	public void addTrainee(Trainee trainee){
		this.trainee = trainee;
		trainee.addResult(this);
	}
}