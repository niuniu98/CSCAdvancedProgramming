package com.niuniu.practice;
/**
 * car registration number,unique
 * @author air
 *
 */
public class CarRegistrationNumber {

	String firstPart="";
	String secondPart="";
	
	public String getFirstPart() {
		return firstPart;
	}
	public void setFirstPart(String firstPart) {
		this.firstPart = firstPart;
	}
	public String getSecondPart() {
		return secondPart;
	}
	public void setSecondPart(String secondPart) {
		this.secondPart = secondPart;
	}
	public String toString(){
		return firstPart+" "+secondPart;
	}
	
}
