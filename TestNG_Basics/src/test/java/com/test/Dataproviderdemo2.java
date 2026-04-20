package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Dataproviderdemo2 {
	WebDriver driver;
	 @BeforeMethod
	  public void Setup() {
		  System.out.println("Start the test");
		  driver=new ChromeDriver();
		  driver.get("https://www.bing.com/");
		  driver.manage().window().maximize();
	  }
	  
	  @Test(dataProvider="testData",dataProviderClass=DPClass.class)
	  public void search(String keyword) {
		  WebElement box=driver.findElement(By.id("sb_form_q"));
		  box.sendKeys(keyword);
		  System.out.println("Keyword entered is:"+keyword);
		  box.sendKeys(Keys.ENTER);
		  System.out.println("Search result is displayed");
	  }
	  
	  @AfterMethod
	  public void tearDown() {
		  driver.quit();
	  }
}
