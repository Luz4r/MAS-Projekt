package models;


import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity(name = "Trainee")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Trainee extends Person{

	public Trainee(){}
	
}
