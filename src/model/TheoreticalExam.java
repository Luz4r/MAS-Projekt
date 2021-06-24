package model;

import javax.persistence.Entity;

/**
 * The type Theoretical exam.
 */
@Entity(name = "TheoreticalExam")
public class TheoreticalExam extends Exam{
	
	/**
	 * The constant maxScore.
	 */
	public static int maxScore = 74;
	/**
	 * The constant maxSlots.
	 */
	public static int maxSlots = 5;
	
	/**
	 * Instantiates a new Theoretical exam.
	 */
	public TheoreticalExam(){}
}
