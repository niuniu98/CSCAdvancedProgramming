package com.niuniu.test;

import java.util.Date;

import com.niuniu.impl.Implementation;
import com.niuniu.impl.ImplementationInterface;
import com.niuniu.practice.Car;
import com.niuniu.practice.DrivingLicence;
import com.niuniu.practice.Person;

public class getCarTest {

	public static void main(String[] args) {
		Person person = new Person();
		person.setFirstName("123");
		person.setLastName("456");
		DrivingLicence dl = new DrivingLicence();
		dl.setFirstPart("MS");
		dl.setSecondPart("1990");
		dl.setThirdPart("10");
		person.setDl(dl);
		
		ImplementationInterface imp = new Implementation();
		Car car = imp.getCar(person);
		System.out.println(car);
	}
}
