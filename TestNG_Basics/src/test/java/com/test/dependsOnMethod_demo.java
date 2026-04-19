package com.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class dependsOnMethod_demo {
	public WebDriver driver;

	  
	  @BeforeMethod
	  public void beforeTest() {
		
		  ChromeOptions options=new ChromeOptions();
		  options.addArguments("--start -maximized");
		  options.addArguments("--headless");
		  driver=new ChromeDriver(options);
		  driver.get("https://www.demoblaze.com/");
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  
	  }
	  @Test
	  public void login() {
		  driver.findElement(By.xpath("//a[@id='login2']")).click();
		  driver.findElement(By.id("loginusername")).click();
		  driver.findElement(By.id("login")).click();
		  driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
		  
		  
	  }
	  
	  @Test(dependsOnMethods="login")
	  public void logininvalid() {
		  driver.findElement(By.xpath("//a[@id='login2']")).click();
		  driver.findElement(By.id("loginusername")).sendKeys("admin");
		  driver.findElement(By.id("loginpassword")).sendKeys("admin");;
		  driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
		 
		  
		  
	  }
	  @Test
	  public void logininvalid2() {
		  driver.findElement(By.xpath("//a[@id='login2']")).click();
		  driver.findElement(By.id("loginusername")).sendKeys("Admin");
		  driver.findElement(By.id("loginpassword")).sendKeys("admin12");;
		  driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
		  
		  
	  }
	  @AfterMethod
	  public void afterTest() {
		  driver.quit();
	  }
  
  
  
}
