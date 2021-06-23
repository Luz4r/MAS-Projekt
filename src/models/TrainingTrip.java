package models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "TrainingTrip")
public class TrainingTrip {
	
	private long id;
	
	private LocalDateTime date;
	
	public TrainingTrip(){}
	public TrainingTrip(LocalDateTime date){
		this.date = date;
	}
	
	@Basic
	public LocalDateTime getDateOfTraining() {
		return date;
	}
	
	public void setDateOfTraining(LocalDateTime date) {
		this.date = date;
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
}
