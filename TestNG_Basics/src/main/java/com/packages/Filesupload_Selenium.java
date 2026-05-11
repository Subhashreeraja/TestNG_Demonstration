package com.packages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Filesupload_Selenium {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://pdf2doc.com/");
		WebElement file=driver.findElement(By.id("fileInput"));
		Thread.sleep(5000);
		file.sendKeys("C:\\\\Users\\\\Subha Shree\\\\Downloads\\\\conference.pdf");
		
	}

}
