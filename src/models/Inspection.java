package models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Inspection {
	
	private long id;
	
	private LocalDate date;
	private String station;
	
	public Inspection(){}
	public Inspection(LocalDate date, String station){
		this.date = date;
		this.station = station;
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
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	@Basic
	public String getStation() {
		return station;
	}
	
	public void setStation(String station) {
		this.station = station;
	}
}
