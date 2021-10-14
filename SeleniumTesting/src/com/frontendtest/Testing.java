package com.frontendtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testing {
	public static void main(String[] args)
	{
		//Firefox Browser
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Prasanna\\Downloads\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();//
		//Chrome Browser
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Prasanna\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//C:\Users\Prasanna\Downloads
		String baseUrl = "http://localhost:4200/";
				
		String expectedTitle = "";
		String actualTitle = "";
		String tagName ="";
		
		//Launch firefox browser and openup the baseUrl above.
		driver.get(baseUrl);
		actualTitle = driver.getTitle();
		
		
	
	tagName = driver.findElement(By.id("name")).getTagName();
	System.out.println(tagName);
	System.out.println("2.) "+driver.findElement(By.className("price")).getTagName());
	System.out.println("3.) "+driver.findElement(By.id("CreditCard")).getTagName());
	System.out.println("4.) "+driver.findElement(By.className("col-50")).getTagName());
	}
}
