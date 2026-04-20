package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DataproviderParalleldemo {
	private static final ThreadLocal <WebDriver> driver=new ThreadLocal <WebDriver>();
	
	 @BeforeMethod
	  public void Setup() {
		 
		  System.out.println("Start the test");
		  driver.set(new ChromeDriver());
	  }
	  
	  @Test(dataProvider="testData",dataProviderClass=DPClass.class)
	  public void search(String keyword1) throws InterruptedException {
		  
		  WebDriver driver1=driver.get();
		  driver1.get("https://www.bing.com");
		  WebElement box=driver1.findElement(By.id("sb_form_q"));
		  box.sendKeys(keyword1);
		  System.out.println("Keyword entered is: "+keyword1);
		  box.sendKeys(Keys.ENTER);
		  System.out.println("Search result is displayed");
	  }
	  
	  @AfterMethod
	  public void tearDown() {
		 WebDriver driver1=driver.get();
		 System.out.println("After method Thread ID:"+Thread.currentThread());
		 if(driver1!=null) {
			 driver1.quit();
		 }
	  }
}
