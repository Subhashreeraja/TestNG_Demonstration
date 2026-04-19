package com.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class groupdemo {
	public WebDriver driver;

	  
	  @BeforeMethod(groups="smoketest")
	  public void beforeTest() {
		
		  ChromeOptions options=new ChromeOptions();
		  options.addArguments("--start -maximized");
		  options.addArguments("--headless");
		  driver=new ChromeDriver(options);
		  driver.get("https://www.demoblaze.com/");
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  
	  }
	  @Test(groups="smoketest")
	  public void login() {
		  driver.findElement(By.xpath("//a[@id='login2']")).click();
		  driver.findElement(By.id("loginusername")).click();
		  driver.findElement(By.id("loginpassword")).click();
		  driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
		  System.out.println(" Smoke test");
		  
	  }
	  
	  @Test(groups="regressiontest")
	  public void logininvalid() {
		  driver.findElement(By.xpath("//a[@id='login2']")).click();
		  driver.findElement(By.id("loginusername")).sendKeys("admin");
		  driver.findElement(By.id("loginpassword")).sendKeys("admin");;
		  driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
		  System.out.println(" Regression test");
		  
		  
	  }
	  @Test(groups="regressiontest")
	  public void logininvalid2() {
		  driver.findElement(By.xpath("//a[@id='login2']")).click();
		  driver.findElement(By.id("loginusername")).sendKeys("Admin");
		  driver.findElement(By.id("loginpassword")).sendKeys("admin12");;
		  driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
		  System.out.println("  Regression test");
		  
	  }
	  @Test(dependsOnGroups="smoketest")
		 public void demo() {
		  System.out.println("Running the dependent test");
	  }
	  
	  @AfterMethod
	  public void afterTest() {
		  driver.quit();
	  }
}
