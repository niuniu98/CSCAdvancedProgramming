package com.niuniu.test;

import com.niuniu.impl.Implementation;
import com.niuniu.impl.ImplementationInterface;

public class availableCarsTest {

	public static void main(String[] args) {
		ImplementationInterface imp = new Implementation();
		int number = imp.availableCars("small").size();
		System.out.println(number+" available to rent");
	}
}
