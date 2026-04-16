package com.test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class NewTest {
	public WebDriver driver;
  
  @BeforeTest
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
	  driver.findElement(By.id("loginpassword")).click();
	  driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
	  
	  
  }
  
  
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
