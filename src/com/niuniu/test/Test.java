package com.niuniu.test;

import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class Test extends TestSuite{

	public static junit.framework.Test suite(){
		TestSuite suite = new TestSuite("TestSuite Test"); 
        suite.addTestSuite(TestDrive.class); 
        return suite; 

	}
	public static void main(String[] args) {
		 TestRunner.run(suite());
	}
}
