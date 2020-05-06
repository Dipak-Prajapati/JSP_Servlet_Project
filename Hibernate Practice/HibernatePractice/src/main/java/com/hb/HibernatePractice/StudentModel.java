package com.hb.HibernatePractice;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentModel {

	@Id
	private int stdId;
	private String firstName;
	private String lastName;
	
	public StudentModel(int stdId, String firstName, String lastName) {
		super();
		this.stdId = stdId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public StudentModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getStdId() {
		return stdId;
	}
	public void setStdId(int stdId) {
		this.stdId = stdId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "StudentModel [stdId=" + stdId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
	
	
}
