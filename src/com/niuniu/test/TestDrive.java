package com.niuniu.test;

import com.niuniu.data.HandleXML;
import com.niuniu.practice.BigCar;
import com.niuniu.practice.Car;
import com.niuniu.practice.CarRegistrationNumber;

import junit.framework.TestCase;

public class TestDrive extends TestCase{

	public void testChange(){
//		CarRegistrationNumber crn = new CarRegistrationNumber();
//		crn.setFirstPart("NG57");
//		crn.setSecondPart("HXE");
//		HandleXML hXml = HandleXML.getInstance();
//		hXml.change(crn, -10);
		int a = -10;
		String b = a +"";
		int c = Integer.parseInt(b);
		assertEquals(c, -10);
//		Car car = new BigCar();
//		int a = car.drive(40);
//		assertEquals(3, a,4);
	}
	
}
