package com.niuniu.test;

import java.util.List;

import com.niuniu.impl.Implementation;
import com.niuniu.impl.ImplementationInterface;
import com.niuniu.practice.Car;

public class getRentedCarTest {

	public static void main(String[] args) {
		ImplementationInterface imp = new Implementation();
		List<Car> carList = imp.getTentedCars();
		System.out.println(carList.size());
		for(int i = 0 ; i < carList.size() ; i++){
			System.out.println(carList.get(i));
		}
	}
}
