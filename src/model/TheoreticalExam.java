package model;

import javax.persistence.Entity;

@Entity(name = "TheoreticalExam")
public class TheoreticalExam extends Exam{
	
	public static int maxScore = 74;
	public static int maxSlots = 5;
	
	public TheoreticalExam(){}
}
