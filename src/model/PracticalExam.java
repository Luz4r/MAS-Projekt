package model;

import javax.persistence.Entity;

/**
 * The type Practical exam.
 */
@Entity(name = "PracticalExam")
public class PracticalExam extends Exam {
	
	/**
	 * The constant maxScore.
	 */
	public static int maxScore = 20;
	
	/**
	 * Instantiates a new Practical exam.
	 */
	public PracticalExam(){}
}
