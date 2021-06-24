package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * The type Inspection.
 */
@Entity(name = "Inspection")
public class Inspection {
	
	private long id;
	
	//Attributes
	private LocalDate date;
	private String station;
	
	//Associations
	private Vehicle vehicle;
	
	/**
	 * Instantiates a new Inspection.
	 */
	public Inspection(){}
	
	/**
	 * Instantiates a new Inspection.
	 *
	 * @param date    the date
	 * @param station the station
	 */
	public Inspection(LocalDate date, String station){
		this.date = date;
		this.station = station;
	}
	
	/**
	 * Gets id.
	 *
	 * @return the id
	 */
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	public long getId() {
		return id;
	}
	
	/**
	 * Sets id.
	 *
	 * @param id the id
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * Gets date.
	 *
	 * @return the date
	 */
	@Basic
	public LocalDate getDate() {
		return date;
	}
	
	/**
	 * Sets date.
	 *
	 * @param date the date
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	/**
	 * Gets station.
	 *
	 * @return the station
	 */
	@Basic
	public String getStation() {
		return station;
	}
	
	/**
	 * Sets station.
	 *
	 * @param station the station
	 */
	public void setStation(String station) {
		this.station = station;
	}
	
	/**
	 * Gets vehicle.
	 *
	 * @return the vehicle
	 */
	@ManyToOne
	public Vehicle getVehicle() {
		return vehicle;
	}
	
	/**
	 * Sets vehicle.
	 *
	 * @param vehicle the vehicle
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	/**
	 * Add vehicle.
	 *
	 * @param vehicle the vehicle
	 */
	public void addVehicle(Vehicle vehicle){
		this.vehicle = vehicle;
		vehicle.addInspection(this);
	}
	
	/**
	 * Remove vehicle.
	 *
	 * @param vehicle the vehicle
	 */
	public void removeVehicle(Vehicle vehicle){
		if(this.vehicle != null){
			this.vehicle = null;
			vehicle.removeInspection(this);
		}
	}
}
