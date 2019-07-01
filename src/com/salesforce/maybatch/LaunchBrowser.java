package com.salesforce.maybatch;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class LaunchBrowser {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		LoginToSFDC();
	}
	public static void LoginToSFDC() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Venkat\\drivers\\chromedriver.exe");
		
		//Initialize browser
		WebDriver driver=new ChromeDriver();
		
		//Open SalesForce
		driver.get("https://login.salesforce.com/");
		
		//Maximize browser
		driver.manage().window().maximize();
		
		//Get Username
		WebElement userName=driver.findElement(By.name("username"));
		userName.sendKeys("p.r.geetha-mbav@force.com");
		System.out.println("Enter username passed successfully");
	
		//Enter password
		WebElement passWord=driver.findElement(By.cssSelector("#password"));
		passWord.sendKeys("Metropcs21");
		
		//Click Login button
		WebElement loginButton=driver.findElement(By.xpath("//input[@id='Login']"));
		loginButton.click();
		System.out.println("Enter login Button passed successfully");
		
		Thread.sleep(5000);
		driver.quit();
	}
}
