package models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "ExamResult")
public class ExamResult {
	
	private long id;
	
	private int score;
	
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
		return score >= Exam.maxScore; //TODO change to associatet exam
	}
}
