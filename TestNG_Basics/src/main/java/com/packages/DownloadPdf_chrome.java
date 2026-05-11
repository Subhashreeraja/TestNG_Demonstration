package com.packages;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DownloadPdf_chrome{

	public static void main(String[] args) throws InterruptedException {
		String downloadFilePath=System.getProperty("user.dir") + File.separator + "downloads";
		ChromeOptions options=new ChromeOptions();
		Map<String,Object> prefs=new HashMap<>();
		prefs.put("plugins.always_open_pdf_externally", true);
		prefs.put("download.default_directory", downloadFilePath);
		options.setExperimentalOption("prefs", prefs);
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/upload-download");
		WebElement downloadlink= driver.findElement(By.xpath("//a[@id='downloadButton']"));
		downloadlink.click();
		Thread.sleep(5000);
		File downloadFile = new File(downloadFilePath + File.separator + "sampleFile.jpeg");
		if(downloadFile.exists()) {
			System.out.println("File is downloaded!");
		}
		else {
			System.out.println("File is not downloaded");
		}
		driver.quit();
	}

}