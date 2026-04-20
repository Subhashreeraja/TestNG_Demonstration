package com.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class practice_softassert {
	WebDriver driver;
	
	
  @BeforeMethod
  public void beforemethod() {
	  ChromeOptions options=new ChromeOptions();
	  options.addArguments("---start -maximized--");
	  options.addArguments("--headless");
	  driver=new ChromeDriver(options);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://demoblaze.com/");	  
  }
  
  
  @Test
  public void verifyTitle() {
	  SoftAssert sa = new SoftAssert();
	String actualTitle=  driver.getTitle();
	String expectedlTitle="STORE";
	
	sa.assertEquals(expectedlTitle,actualTitle);
	sa.assertAll();
  }
  
  @Test
  
  public void verifyNavigationMenu() {
	  SoftAssert sa = new SoftAssert();
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("//div[@id='navbarExample']//a[text()='Home']")));

		    boolean home = driver.findElement(
		        By.xpath("//div[@id='navbarExample']//a[text()='Home']")).isDisplayed();
		    sa.assertTrue(home, "Home is not visible");

	  sa.assertAll();
  }
  
@Test
  
  public void verifybutton() {
	  SoftAssert sa = new SoftAssert();
	  boolean login=driver.findElement(By.xpath("//a[@id='login2']")).isDisplayed();
	  sa.assertTrue(login, "login is not visible");
	  sa.assertAll();
  }
  
  
  
  
  @AfterMethod
  public void aftermethod() {
	  driver.quit();
  }
}
