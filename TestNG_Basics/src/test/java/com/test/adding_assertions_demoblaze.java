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

public class adding_assertions_demoblaze {

	public WebDriver driver;
	  @BeforeMethod
	  public void beforeTest() {
		  ChromeOptions options=new ChromeOptions();
		  options.addArguments("---start-maximized--");
		  options.addArguments("--headless");//non-GUI mode
		  driver = new ChromeDriver(options);
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		  driver.get("https://demoblaze.com/");
	  }

	 @Test
		public void validation() {
			  driver.findElement(By.id("login2")).click();
			driver.findElement(By.id("loginusername")).sendKeys("Admin");
			driver.findElement(By.id("loginpassword")).sendKeys("admin");
			driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
			WebElement message=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
			String msg=message.getText();
			String msg1="Welcome Admin";
			Assert.assertEquals(msg1, msg,"Login successful");
			}
		  @Test
		  public void invalidusername() {
			  driver.findElement(By.id("login2")).click();
			driver.findElement(By.id("loginusername")).sendKeys("Sho");
			driver.findElement(By.id("loginpassword")).sendKeys("admin");
			driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert=driver.switchTo().alert();
			String msg=alert.getText();
			String msg1="User does not exist.";
			alert.accept();
			Assert.assertEquals(msg1, msg,"Login failed");
			}
		  
		  @Test
		  public void invalidpassword() {
			  driver.findElement(By.id("login2")).click();
			driver.findElement(By.id("loginusername")).sendKeys("Admin");
			driver.findElement(By.id("loginpassword")).sendKeys("sho");
			driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert=driver.switchTo().alert();
			String msg=alert.getText();
			String msg1="Wrong password.";
			alert.accept();
			Assert.assertEquals(msg1, msg,"Login failed");
			}
		 
		  
		
		  @AfterMethod
		  public void afterTest() {
			  driver.quit();
		  }
	}

