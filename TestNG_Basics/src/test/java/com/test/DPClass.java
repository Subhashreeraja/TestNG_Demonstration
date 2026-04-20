package com.test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DPClass {
	
	
	@DataProvider(name="testData",parallel=true)
	public Object[][] dataprovfunc(){
		return new Object[][] {{"Selenium"},{"TestNG"},{"Automation"}};
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
