package com.niuniu.practice;
/**
 * Car-interface to smallcar and bigcar
 * @author air
 *
 */
public interface Car {

	/**
	 * set or return the Car registration number
	 * @param crn
	 */
	void setRegistrationNumber(CarRegistrationNumber crn);
	CarRegistrationNumber getRegistrationNumber();
	/**
	 * set or return the capacity of tank
	 * @param cap
	 */
	void setCapacity(int cap);
	int getCapacity();
	/**
	 * set or return the current fuel
	 * @param current
	 */
	void setCurrent(int current);
	int getCurrent();
	/**
	 * get the current tank is full
	 * @return
	 */
	boolean ifFull();
	
	/**
	 * to add fuel to the tank
	 * @param fuel
	 */
	void addFuel(int fuel);
	/**
	 * the comsum fuel in a particular journey
	 * @param kilometres
	 * @return
	 */
	int drive(int kilometres);
	/**
	 * set or return person
	 * @param person
	 */
	void setPerson(Person person);
	Person getPerson();
	
}
