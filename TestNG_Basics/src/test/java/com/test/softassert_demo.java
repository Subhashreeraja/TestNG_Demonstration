package com.test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class softassert_demo {
		
		  public WebDriver driver;
		  @BeforeMethod
		  public void beforeTest() {
			  ChromeOptions options=new ChromeOptions();
			  options.addArguments("--start-maximized");
			  options.addArguments("--headless");  
			  driver = new ChromeDriver(options); 
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			  driver.get("https://www.demoblaze.com/");
			 
		  }
		    
		  @Test()
		  public void validation() {
			  driver.navigate().refresh(); 
			  driver.findElement(By.id("login2")).click();
			  driver.findElement(By.id("loginusername")).sendKeys("Admin");
			  driver.findElement(By.id("loginpassword")).sendKeys("admin");
			  driver.findElement(By.xpath("//button[text()='Log in']")).click();
			  
			  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
			  WebElement welcome=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
		      String expected="Welcome Admin";
		      String actual=welcome.getText();
			  Assert.assertEquals(actual,expected); 	  
		  }
		 

		  
		  @Test
		  public void logininvalid1() {
			  driver.navigate().refresh();
		      driver.findElement(By.id("login2")).click();
		      driver.findElement(By.id("loginusername")).sendKeys("");
		      driver.findElement(By.id("loginpassword")).sendKeys("admin");
		      driver.findElement(By.xpath("//button[text()='Log in']")).click();

		      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		      Alert alert = wait.until(ExpectedConditions.alertIsPresent());

		      String actual = alert.getText();
		      String expected = "Please fill out Username and Password.";

		      Assert.assertEquals(actual, expected);
		      alert.accept();
		  }
		  
		  
		  @Test
		  public void logininvalid2() {
			  driver.navigate().refresh(); 
		      driver.findElement(By.id("login2")).click();
		      driver.findElement(By.id("loginusername")).sendKeys("Admin");
		      driver.findElement(By.id("loginpassword")).sendKeys("1");
		      driver.findElement(By.xpath("//button[text()='Log in']")).click();

		      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		      Alert alert = wait.until(ExpectedConditions.alertIsPresent());

		      String actual = alert.getText();
		      String expected = "Wrong password."; 

		      Assert.assertEquals(actual, expected);

		      alert.accept();
		  }
			  
			  
			 
			
		  @AfterMethod
		  public void afterTest() {
			  driver.quit();
		  }
	
	}

