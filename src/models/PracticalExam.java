package models;

import javax.persistence.Entity;

@Entity(name = "PracticalExam")
public class PracticalExam extends Exam {
	
	public static int maxScore = 20;
	
	public PracticalExam(){}
}
