package com.niuniu.test;

import com.niuniu.impl.Implementation;
import com.niuniu.impl.ImplementationInterface;
import com.niuniu.practice.DrivingLicence;
import com.niuniu.practice.Person;

public class terminateRentalTest {

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
		imp.terminateRental(person);
	}
}
