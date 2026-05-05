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

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class demoblazeDataprovider {

    public WebDriver driver;

  
    @DataProvider(name="validData")
    public Object[][] validData(){
        return new Object[][] {
            {"Admin","admin"}
        };
    }

    @DataProvider(name="invalidData")
    public Object[][] invalidData(){
        return new Object[][] {
            {"Admin","asdf"}
        };
    }

    @BeforeMethod
    @Parameters({"browser","url"})
    public void beforeTest(String browser,String url) {

        if(browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized"); 
            driver = new ChromeDriver(options);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(url);
        System.out.println("Browser started: " + browser);
    }

    
    @Test(dataProvider="validData")
    public void validLoginTest(String username,String password) {

        SoftAssert sa = new SoftAssert();

        driver.findElement(By.id("login2")).click();
        driver.findElement(By.id("loginusername")).sendKeys(username);
        driver.findElement(By.id("loginpassword")).sendKeys(password);
        driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement message = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser"))
        );

        String actual = message.getText();
        String expected = "Welcome Admin";

        sa.assertEquals(actual, expected, "Valid login failed");
        sa.assertAll();

        System.out.println("Valid login successful");
    }

    @Test(dataProvider="invalidData")
    public void invalidLoginTest(String username,String password) {

        SoftAssert sa = new SoftAssert();

        driver.findElement(By.id("login2")).click();
        driver.findElement(By.id("loginusername")).sendKeys(username);
        driver.findElement(By.id("loginpassword")).sendKeys(password);
        driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        String actual = alert.getText();
        String expected = "Wrong password.";

        alert.accept();

        sa.assertEquals(actual, expected, "Invalid login test failed");
        sa.assertAll();

        System.out.println("Invalid login verified");
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}