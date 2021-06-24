package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Exam result.
 */
@Entity(name = "ExamResult")
public class ExamResult {
	
	private long id;
	
	//Attributes
	private int score;
	
	//Associations
	private Exam exam;
	private Trainee trainee;
	
	/**
	 * Instantiates a new Exam result.
	 */
	public ExamResult(){}
	
	/**
	 * Instantiates a new Exam result.
	 *
	 * @param score the score
	 */
	public ExamResult(int score){
		this.score = score;
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
	
	private void setId(long id){
		this.id = id;
	}
	
	/**
	 * Gets score.
	 *
	 * @return the score
	 */
	@Basic
	public int getScore() {
		return score;
	}
	
	/**
	 * Sets score.
	 *
	 * @param score the score
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	/**
	 * Is passed boolean.
	 *
	 * @return the boolean
	 */
	@Transient
	public boolean isPassed(){
		return score >= Exam.maxScore;
	}
	
	/**
	 * Gets exam.
	 *
	 * @return the exam
	 */
	@ManyToOne
	public Exam getExam() {
		return exam;
	}
	
	/**
	 * Sets exam.
	 *
	 * @param exam the exam
	 */
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	
	/**
	 * Add exam.
	 *
	 * @param exam the exam
	 */
	public void addExam(Exam exam){
		if(this.exam != exam) {
			removeExam(this.exam);
			this.exam = exam;
			exam.addResult(this);
		}
	}
	
	/**
	 * Remove exam.
	 *
	 * @param exam the exam
	 */
	public void removeExam(Exam exam){
		if(this.exam != null){
			this.exam = null;
			exam.removeResults(this);
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
			this.trainee = null;
			trainee.removeResult(this);
		}
	}
	
	/**
	 * Add trainee.
	 *
	 * @param trainee the trainee
	 */
	public void addTrainee(Trainee trainee){
		if(this.trainee != trainee) {
			removeTrainee(trainee);
			this.trainee = trainee;
			trainee.addResult(this);
		}
	}
}
