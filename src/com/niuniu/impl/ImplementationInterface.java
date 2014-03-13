package com.niuniu.impl;

import java.util.List;

import com.niuniu.practice.Car;
import com.niuniu.practice.Person;
/**
 * the interface of Implementation
 * @author air
 *
 */
public interface ImplementationInterface {

	/**
	 * cars of the specified type that are available to rent
	 * @param carType
	 * @return
	 */
	List<Car> availableCars(String carType);
	/**
	 * all the cars rented out
	 * 
	 * @return
	 */
	List<Car> getTentedCars();
	/**
	 * the car the person renting
	 * @param person
	 * @return
	 */
	Car getCar(Person person);
	/**
	 * to rent a car
	 * @param person
	 * @param carType
	 * @return
	 */
	boolean issueCar(Person person,String carType);
	/**
	 * to return a car
	 * @param person
	 * @return
	 */
	int terminateRental(Person person);
}
