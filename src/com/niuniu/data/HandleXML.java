package com.niuniu.data;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.niuniu.practice.BigCar;
import com.niuniu.practice.Car;
import com.niuniu.practice.CarRegistrationNumber;
import com.niuniu.practice.DrivingLicence;
import com.niuniu.practice.Person;
import com.niuniu.practice.SmalCar;
/**
 * directly operate xml data
 * @author air
 *
 */
public class HandleXML {

	static HandleXML handlXml;
	
	private HandleXML(){
		
	}
	/**
	 * only one instance provided
	 * @return
	 */
	public static HandleXML getInstance(){
		if(handlXml == null){
			handlXml = new HandleXML();
		}
		return handlXml;
	}
	/**
	 * read a xml file
	 * @return
	 */
	private static Document loadFile(){
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db=dbf.newDocumentBuilder();    
            File file=new File("Cars.xml");
            Document doc=db.parse(file);
            return doc;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * read all information from xml
	 * @return
	 */
	public List<Car> readAll(){
		Document doc = loadFile();
		NodeList nl=doc.getElementsByTagName("car");
        List<Car> cars = new ArrayList<Car>();
        int len=nl.getLength();
        for(int i=0;i<len;i++){
        	Element element=(Element)nl.item(i);
        	Node numberN = element.getElementsByTagName("number").item(0);
        	Node typeN = element.getElementsByTagName("type").item(0);
        	Node capacityN = element.getElementsByTagName("capacity").item(0);
        	Node currentN = element.getElementsByTagName("current").item(0);
        	Node licenceN = element.getElementsByTagName("licence").item(0);
        	Node nameN = element.getElementsByTagName("name").item(0);
        	
        	String number=numberN.getFirstChild().getNodeValue();
        	String type = typeN.getFirstChild().getNodeValue();
        	String capacity = capacityN.getFirstChild().getNodeValue();
        	String current = currentN.getFirstChild().getNodeValue();
        	String name = nameN.getFirstChild().getNodeValue();
        	String licence = licenceN.getFirstChild().getNodeValue();
        	
        	Car car;
        	
        	String[] a = number.split(" ");
    		CarRegistrationNumber crn = new CarRegistrationNumber();
    		crn.setFirstPart(a[0]);
    		crn.setSecondPart(a[1]);
    		
    		Person person = new Person();
    		if(name.equals("0")){
    			person = null;
    		}else{
    			String[] names = name.split(" ");
    			person.setFirstName(names[0]);
    			person.setLastName(names[1]);
    		}
    		
    		DrivingLicence dl = new DrivingLicence();
    		if(licence.equals("0")){
    			dl = null;
    		}else{
    			String[] b = licence.split("-");
    			dl.setFirstPart(b[0]);
    			dl.setSecondPart(b[1]);
    			dl.setThirdPart(b[2]);
    			person.setDl(dl);
    		}
    		
        	if(type.equals("small")){
        		car = new SmalCar();
        	}else{
        		car = new BigCar();
        	}
        	car.setRegistrationNumber(crn);
        	car.setCapacity(Integer.parseInt(capacity));
        	car.setCurrent(Integer.parseInt(current));
        	car.setPerson(person);
        	cars.add(car);
        }
		return cars;
	}
	/**
	 * read particular type information
	 * @param carType
	 * @return
	 */
	public List<Car> readList(String carType){
		Document doc = loadFile();
		NodeList nl=doc.getElementsByTagName("car");
        List<Car> cars = new ArrayList<Car>();
        int len=nl.getLength();
        for(int i=0;i<len;i++){
        	Element element=(Element)nl.item(i);
        	Node numberN = element.getElementsByTagName("number").item(0);
        	Node typeN = element.getElementsByTagName("type").item(0);
        	Node capacityN = element.getElementsByTagName("capacity").item(0);
        	Node currentN = element.getElementsByTagName("current").item(0);
        	Node licenceN = element.getElementsByTagName("licence").item(0);
        	Node nameN = element.getElementsByTagName("name").item(0);
        	
        	String type = typeN.getFirstChild().getNodeValue();
        	if(type.equals(carType)){
        		String number=numberN.getFirstChild().getNodeValue();
            	String capacity = capacityN.getFirstChild().getNodeValue();
            	String current = currentN.getFirstChild().getNodeValue();
            	String licence = licenceN.getFirstChild().getNodeValue();
            	String name = nameN.getFirstChild().getNodeValue();
            	
            	Car car;
            	
            	String[] a = number.split(" ");
        		CarRegistrationNumber crn = new CarRegistrationNumber();
        		crn.setFirstPart(a[0]);
        		crn.setSecondPart(a[1]);
        		
        		Person person = new Person();
        		if(name.equals("0")){
        			person = null;
        		}else{
        			String[] names = name.split(" ");
        			person.setFirstName(names[0]);
        			person.setLastName(names[1]);
        		}
        		
        		DrivingLicence dl = new DrivingLicence();
        		if(licence.equals("0")){
        			dl = null;
        		}else{
        			String[] b = licence.split("-");
        			dl.setFirstPart(b[0]);
        			dl.setSecondPart(b[1]);
        			dl.setThirdPart(b[2]);
        			person.setDl(dl);
        		}
        		
            	if(carType.equals("small")){
            		car = new SmalCar();
            	}else{
            		car = new BigCar();
            	}
            	car.setRegistrationNumber(crn);
            	car.setCapacity(Integer.parseInt(capacity));
            	car.setCurrent(Integer.parseInt(current));
            	car.setPerson(person);
            	cars.add(car);

        	}
        }
		return cars;
	}
	/**
	 * issue Update,to update name and licence
	 * @param person
	 * @param crn
	 * @return
	 */
	 public boolean issueUpdate(Person person,CarRegistrationNumber crn){
		Document doc = loadFile();
		NodeList nl=doc.getElementsByTagName("car");
        int len=nl.getLength();
        String crNumber = crn.toString();
        for(int i=0;i<len;i++){
        	Element element=(Element)nl.item(i);
        	Node numberN = element.getElementsByTagName("number").item(0);
        	String number=numberN.getFirstChild().getNodeValue();
        	if(crNumber.equals(number)){
        		element.getElementsByTagName("name").item(0).getFirstChild().setNodeValue(person.toString());
        		element.getElementsByTagName("licence").item(0).getFirstChild().setNodeValue(person.getDl().toString());
        		saveXML(doc);
        		return true;
        	}
        }
		return false;
	}
	/**
	 * terminate update,to update name and licence to "0"
	 * @param person
	 */
	public void terminateUpdate(Person person){
		Document doc = loadFile();
		NodeList nl=doc.getElementsByTagName("car");
        int len=nl.getLength();
		for(int i = 0 ; i < len ; i++){
			Element element=(Element)nl.item(i);
        	Node licenceN = element.getElementsByTagName("licence").item(0);
        	Node nameN = element.getElementsByTagName("name").item(0);
        	
        	String name = nameN.getFirstChild().getNodeValue();
        	String licence = licenceN.getFirstChild().getNodeValue();

			if(name.equals(person.toString())
					&& licence.equals(person.getDl().toString())){
				element.getElementsByTagName("name").item(0).getFirstChild().setNodeValue(0+"");
        		element.getElementsByTagName("licence").item(0).getFirstChild().setNodeValue(0+"");
        		saveXML(doc);
			}
		}
		
	}
	/**
	 * to update current fuel in tank
	 * @param crn
	 * @param fuel
	 */
	public  void change(CarRegistrationNumber crn,int fuel){
		Document doc = loadFile();
		NodeList nl=doc.getElementsByTagName("car");
        int len=nl.getLength();
        String crNumber = crn.toString();
        for(int i=0;i<len;i++){
        	Element element=(Element)nl.item(i);
        	Node numberN = element.getElementsByTagName("number").item(0);
        	String number=numberN.getFirstChild().getNodeValue();
        	if(crNumber.equals(number)){
        		element.getElementsByTagName("current").item(0).getFirstChild().setNodeValue(fuel+"");
        		saveXML(doc);
        	}
        }
	}
	
	/**
	 * save file after update data
	 * @param document
	 * @return
	 */
	public static boolean saveXML(Document document){
	        try{
	            TransformerFactory tFactory = TransformerFactory.newInstance();
	            Transformer transformer = tFactory.newTransformer();
	            
	            DOMSource source = new DOMSource(document);
	            StreamResult result = new StreamResult(new File("Cars.xml"));
	            transformer.transform(source, result);
	            return true;
	        }catch(Exception e){
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	            return false;
	        }
	    }
	
    public static void main(String[] args) 
    {
//    	Calendar calendar = Calendar.getInstance();
//    	Date currentTime = calendar.getTime();
//    	System.out.println(currentTime.getYear());
//    	List<Car> carList = readList("small");
//    	for(int i = 0 ; i< carList.size() ;i++){
//    		System.out.println(carList.get(i));
//    	}
//    	CarRegistrationNumber crn = new CarRegistrationNumber();
//    	crn.setFirstPart("NG57");
//    	crn.setSecondPart("HXE");
//    	System.out.println(crn.toString());
//    	
//    	change(crn, 30);
//    
    	int a = -10;
		String b = a +"";
		int c = Integer.parseInt(b);
		System.out.println("+++"+c);
    }
}
