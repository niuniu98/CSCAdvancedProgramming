package com.niuniu.practice;
/**
 * a driving licence,unique
 * @author air
 *
 */
public class DrivingLicence {

	String firstPart = "";
	String secondPart = "";
	String thirdPart ="";
	
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
	public String getThirdPart() {
		return thirdPart;
	}
	public void setThirdPart(String thirdPart) {
		this.thirdPart = thirdPart;
	}
	public String toString(){
		return firstPart+"-"+secondPart+"-"+thirdPart;
	}
	
}
