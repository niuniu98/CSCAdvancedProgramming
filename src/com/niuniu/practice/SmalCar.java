package com.niuniu.practice;

/**
 * @see Com.niuniu.practice.Car
 * @author air
 *
 */

public class SmalCar implements Car {

	CarRegistrationNumber crn = null;
	int capacity = 49;
	int current = 49;
	Person person = null;
	@Override
	public void setRegistrationNumber(CarRegistrationNumber crn) {
		// TODO Auto-generated method stub
		this.crn = crn;
	}

	@Override
	public CarRegistrationNumber getRegistrationNumber() {
		// TODO Auto-generated method stub
		return crn;
	}

	@Override
	public void setCapacity(int cap) {
		// TODO Auto-generated method stub
		this.capacity = cap;
	}

	@Override
	public int getCapacity() {
		// TODO Auto-generated method stub
		return capacity;
	}

	@Override
	public void setCurrent(int current) {
		// TODO Auto-generated method stub
		this.current = current;
	}

	@Override
	public int getCurrent() {
		// TODO Auto-generated method stub
		return current;
	}

	@Override
	public boolean ifFull() {
		// TODO Auto-generated method stub
		if(capacity == current){
			return true;
		}
		return false;
	}

	@Override
	public void addFuel(int fuel) {
		// TODO Auto-generated method stub
		if((current + fuel)> capacity){
			current = capacity;
		}else{
			current = current+fuel;
		}
	}

	@Override
	public int drive(int kilometres) {
		// TODO Auto-generated method stub
		int comsumFuel = 0;
		//small car
		comsumFuel = kilometres/20;
		current = current - comsumFuel;
		//if the car cannot be driven
		if(current <=  0){
			System.out.println("no journey has been undertaken");
		}
		return comsumFuel;
	}

	@Override
	public void setPerson(Person person) {
		// TODO Auto-generated method stub
		this.person = person;
	}

	@Override
	public Person getPerson() {
		// TODO Auto-generated method stub
		return person;
	}

	
}
