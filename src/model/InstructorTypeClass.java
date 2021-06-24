package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Instructor type class.
 */
@Embeddable
public class InstructorTypeClass {
	
	private long id;
	
	/**
	 * Get id long.
	 *
	 * @return the long
	 */
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	public long getId(){
		return id;
	}
	
	private void setId(long id){
		this.id = id;
	}
	
	private String name;
	
	/**
	 * Instantiates a new Instructor type class.
	 */
	public InstructorTypeClass(){}
	
	/**
	 * Instantiates a new Instructor type class.
	 *
	 * @param name the name
	 */
	public InstructorTypeClass(String name){
		this.name = name;
	}
	
	/**
	 * Get name string.
	 *
	 * @return the string
	 */
	@Basic
	public String getName(){
		return name;
	}
	
	/**
	 * Set name.
	 *
	 * @param name the name
	 */
	public void setName(String name){
		this.name = name;
	}
	
	@Override
	public String toString() {
		return getName();
	}
}
