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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class demoblazeDataprovider {
	
	@DataProvider(name="testData")
	public Object[][] dataprovfunc(){
		return new Object[][] {{"Admin","admin"},{"Admin","asdf"}};
	}
	public WebDriver driver;
	  @BeforeMethod
	  @Parameters({"browser","url"})
	  public void beforeTest(String browser,String url) {
		  if(browser.equalsIgnoreCase("chrome")) {
			  ChromeOptions options=new ChromeOptions();
			  options.addArguments("---start-maximized--");
			 // options.addArguments("--headless");
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

	 @Test(dataProvider="testData")
		public void validation(String username,String password) {
		 SoftAssert sa=new SoftAssert();
			  driver.findElement(By.id("login2")).click();
			driver.findElement(By.id("loginusername")).sendKeys(username);
			driver.findElement(By.id("loginpassword")).sendKeys(password);
			driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));

		        String msg = message.getText();
		        String msg1 = "Welcome Admin";

		        sa.assertEquals(msg1, msg, "Login failed"); 
		        sa.assertAll();      
			 System.out.println("login successful");
			
			
			}
		  @Test (dataProvider="testData")
		  public void invalidusername(String invalidusername,String password) {
			  SoftAssert sa=new SoftAssert();
			  driver.findElement(By.id("login2")).click();
			driver.findElement(By.id("loginusername")).sendKeys(invalidusername);
			driver.findElement(By.id("loginpassword")).sendKeys(password);
			driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
			
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		        wait.until(ExpectedConditions.alertIsPresent());
		        Alert alert = driver.switchTo().alert();

		        String msg = alert.getText();
		        String msg1 = "Wrong password.";
		        alert.accept();

		        sa.assertEquals(msg1, msg, "Login failed");
		        sa.assertAll();    
			
			}
		  		  
		
		  @AfterMethod
		  public void afterTest() {
			  driver.quit();
		  }
}
