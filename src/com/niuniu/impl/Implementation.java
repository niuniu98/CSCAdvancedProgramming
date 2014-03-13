package com.niuniu.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.niuniu.data.HandleXML;
import com.niuniu.practice.Car;
import com.niuniu.practice.DrivingLicence;
import com.niuniu.practice.Person;
/**
 * @see com.niuniu.impl.ImplementationInterface
 * @author air
 *
 */
public class Implementation implements ImplementationInterface {

	@Override
	public List<Car> availableCars(String carType) {
		// TODO Auto-generated method stub
		HandleXML hXml = HandleXML.getInstance();
		List<Car> carList = hXml.readList(carType);
		List<Car> rentList = new ArrayList<Car>();
		for(int i = 0 ; i< carList.size() ; i++){
			if(carList.get(i).getPerson() == null && carList.get(i).getCurrent() >0){
				rentList.add(carList.get(i));
			}
		}
		return carList;
	}

	@Override
	public List<Car> getTentedCars() {
		// TODO Auto-generated method stub
		HandleXML hXml = HandleXML.getInstance();
		List<Car> carList = hXml.readAll();
		List<Car> rentList = new ArrayList<Car>();
		for(int i = 0 ; i< carList.size() ; i++){
			if(carList.get(i).getPerson() != null){
				rentList.add(carList.get(i));
			}
		}
		return rentList;
	}

	@Override
	public Car getCar(Person person) {
		// TODO Auto-generated method stub
		//HandleXML hXml = HandleXML.getInstance();
		List<Car> carList = getTentedCars();
		for(int i = 0 ; i< carList.size() ; i++){
			if(carList.get(i).getPerson().toString().equals(person.toString())
					&& carList.get(i).getPerson().getDl().toString().equals(person.getDl().toString())){
				return carList.get(i);
			}
		}
		return null;
	}

	@Override
	public boolean issueCar(Person person, String carType) {
		// TODO Auto-generated method stub
		if(checkLicence(person, carType) && checkCar(carType)!= null){
			HandleXML hXml = HandleXML.getInstance();
			return hXml.issueUpdate(person, checkCar(carType).getRegistrationNumber());
		}else{
			System.out.println("can not issue this renting");
		}
		return false;
	}

	@Override
	public int terminateRental(Person person) {
		// TODO Auto-generated method stub
		if(getCar(person)==null){
			return 0;
		}else{
			if(getCar(person).getCurrent()<getCar(person).getCapacity()){
				return getCar(person).getCapacity() - getCar(person).getCurrent();
			}else{
				HandleXML hXml = HandleXML.getInstance();
				hXml.terminateUpdate(person);
				return 0;
			}
		}
	}

	// has car of one type can be rented
	public Car checkCar(String carType){
		List<Car> carList = availableCars(carType);
		if(carList.size() !=0){
			return carList.get(0);
		}
		return null;
	}
	//check the licence can be used
	public boolean checkLicence(Person person,String carType){
		DrivingLicence dl = person.getDl();
		if(dl.getFirstPart() != "" && dl.getSecondPart() != "" && dl.getThirdPart() != ""){
			List<Car> carList = getTentedCars();
			for(int i = 0; i < carList.size() ; i++){
				if(carList.get(i).getPerson().getDl().toString().equals(dl.toString())){
					return false;
				}
			}
			if(checkAge(person.getDate()) >= 25 
					&& checkTime(person.getDl())>=5
					&& carType.equals("big")){
				return true;
			}else if(checkAge(person.getDate()) >= 20 
					&& checkTime(person.getDl())>=1
					&& carType.equals("small")){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
	//check driving licence vilidation
	public int checkTime(DrivingLicence dl){
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		return year-Integer.parseInt(dl.getSecondPart());
	}
	//check age
	public int checkAge(Date date){
		
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		return year-date.getYear();
	}
}
