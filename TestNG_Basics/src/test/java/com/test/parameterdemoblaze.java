package com.test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parameterdemoblaze {    
	public WebDriver driver;
	  @BeforeMethod
	  @Parameters({"browser","url"})
	  public void beforeTest(String browser,String url) {
		  if(browser.equalsIgnoreCase("chrome")) {
			  ChromeOptions options=new ChromeOptions();
			  options.addArguments("---start-maximized--");
			  options.addArguments("--headless");
			  driver = new ChromeDriver(options);
			  System.out.println("Browser started: "+browser);
		  }
		  else if (browser.equalsIgnoreCase("firefox")) {
			  FirefoxOptions options=new FirefoxOptions();
			  options.addArguments("---start-maximized--");
			  options.addArguments("--headless");
			  driver = new FirefoxDriver(options);
		  }
		
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		  driver.get(url);
	  }

	 @Test
	 @Parameters({"username","password"})
		public void validation(String username,String password) {
			  driver.findElement(By.id("login2")).click();
			driver.findElement(By.id("loginusername")).sendKeys(username);
			driver.findElement(By.id("loginpassword")).sendKeys(password);
			driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
			 System.out.println("login successful");
			
			
			}
		  @Test
		  @Parameters({"invalidusername","password"})
		  public void invalidusername(String invalidusername,String password) {
			  driver.findElement(By.id("login2")).click();
			driver.findElement(By.id("loginusername")).sendKeys(invalidusername);
			driver.findElement(By.id("loginpassword")).sendKeys(password);
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
		  @Parameters({"username","invalidpassword"})
		  public void invalidpassword(String username,String invalidpassword) {
			  driver.findElement(By.id("login2")).click();
			driver.findElement(By.id("loginusername")).sendKeys(username);
			driver.findElement(By.id("loginpassword")).sendKeys(invalidpassword);
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
