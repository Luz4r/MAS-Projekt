package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Embeddable
public class InstructorTypeClass {
	
	private long id;
	
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	public long getId(){
		return id;
	}
	
	private void setId(long id){
		this.id = id;
	}
	
	private String name;
	
	public InstructorTypeClass(){}
	
	public InstructorTypeClass(String name){
		this.name = name;
	}
	
	@Basic
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	@Override
	public String toString() {
		return getName();
	}
}
