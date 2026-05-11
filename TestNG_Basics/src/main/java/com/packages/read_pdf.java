package com.packages;


import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class read_pdf {

public static void main(String[] arg)
	
	{
		String down_path = System.getProperty("user.dir") + File.separator + "downloads";

		ChromeOptions options = new ChromeOptions();

		Map<String, Object> prefs = new HashMap<>();

		prefs.put("plugins.always_open_directory", true);

		prefs.put("download.default_directory", down_path);

		options.setExperimentalOption("prefs", prefs);

		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get("https://demo.automationtesting.in/FileDownload.html?utm_source=chatgpt.com");

		WebElement downLink = driver
				.findElement(By.xpath("//div[@style=\"text-align: center;\"]/a[text()=\"Download\"]"));

		downLink.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		

		File downFile = new File(down_path + "/samplefile.pdf");
		
		wait.until((ExpectedCondition<Boolean>) wd -> downFile.exists());
		
		if (downFile.exists()) 
		
		{
			System.out.println("File downloaded successfully: " + downFile.getAbsolutePath());
		} else 
		
		{
			System.out.println("File download failed.");
		}
		
		driver.quit();
		
		
		PDDocument document = null;
		
		try
		{
			document = Loader.loadPDF(downFile);
			PDFTextStripper stripper = new PDFTextStripper();
			String pdfText = stripper.getText(document);
			document.close();
			
			System.out.println("Extracted text from PDF:");
			System.out.println(pdfText);
			
		}
		catch (Exception e) 
		{
			System.out.println("An error occurred while reading the PDF file."+ e.getMessage());
			e.printStackTrace();
		}

	}
}