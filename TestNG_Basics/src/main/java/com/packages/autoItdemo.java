package com.packages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class autoItdemo {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://pdf2doc.com/");
		WebElement file=driver.findElement(By.xpath("//label[@id='uploadBtn']"));
		file.click();
		Thread.sleep(5000);
		Runtime.getRuntime().exec("\"D:\\demoautoIt.exe\"");
		

	}

}
