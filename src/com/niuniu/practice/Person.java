package com.niuniu.practice;

import java.util.Date;
/**
 * renter
 * @author air
 *
 */
public class Person {

	//one person to one driving licence
	DrivingLicence dl;
	String firstName;
	String lastName;
	//birth day
	Date date;
	/**
	 * set or return DrivingLicence
	 * @return
	 */
	public DrivingLicence getDl() {
		return dl;
	}
	public void setDl(DrivingLicence dl) {
		this.dl = dl;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String toString(){
		
		return firstName+" "+lastName;
	}
	
	
}
