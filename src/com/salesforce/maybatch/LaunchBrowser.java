package com.salesforce.maybatch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class LaunchBrowser {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		LoginToSFDC();
		//MyProfile();
		//MySettings();
		DeveloperConsole();
	}
	public static void LoginToSFDC() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Venkat\\drivers\\chromedriver.exe");
		
		//Initialize browser
		driver=new ChromeDriver();
		
		//Open SalesForce
		driver.get("https://login.salesforce.com/");
		
		//Maximize browser
		driver.manage().window().maximize();
		System.out.println("Application launched successfully");
		
		//delete all cookies
		driver.manage().deleteAllCookies();
		
		//Get Username
		WebElement userName=driver.findElement(By.name("username"));
		userName.sendKeys("p.r.geetha-mbav@force.com");
		System.out.println("Enter username passed successfully");
	
		//Enter password
		WebElement passWord=driver.findElement(By.cssSelector("#password"));
		passWord.sendKeys("Metropcs21");
		
		//Check rememberMe button
		WebElement rememberMe=driver.findElement(By.xpath("//input[@id='rememberUn']"));
		rememberMe.click();
		
		//Click Login button
		WebElement loginButton=driver.findElement(By.xpath("//input[@id='Login']"));
		loginButton.click();
		System.out.println("Enter login Button passed successfully");
		
		Thread.sleep(5000);
		
	}
	
	public static void MyProfile() throws InterruptedException {
		
		WebElement UserMenuChk = driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
		Actions act = new Actions(driver);
		act.moveToElement(UserMenuChk).click().build().perform();
		System.out.println("Checked for UserMenu DropDown");
		Thread.sleep(5000);
		
		WebElement MyProfile = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		MyProfile.click();
		System.out.println("Clicked on MyProfile Option Successfully");
		
		WebElement EditLink = driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']//img"));
		EditLink.click();
		System.out.println("Clicked on edit button successfully");
				
		driver.switchTo().frame("contactInfoContentId");
		System.out.println("Switched to frame:");
		Thread.sleep(3000);
		
		WebElement AboutTab = driver.findElement(By.xpath("//a[contains(text(),'About')]"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(AboutTab).click().build().perform();
		System.out.println("Clicked on AboutTab Successfully");
				
		WebElement LastName=driver.findElement(By.id("lastName"));
		LastName.clear();
		LastName.sendKeys("RajaSrinivasan");
		
		WebElement saveAll=driver.findElement(By.xpath("//input[@class='zen-btn zen-primaryBtn zen-pas']"));
		saveAll.click();
		System.out.println("Save All done successfully");
		Thread.sleep(5000);
		
		driver.switchTo().defaultContent();
		
		
		WebElement post=driver.findElement(By.xpath("//a[@id='publisherAttachTextPost']"));
		post.click();
		Thread.sleep(5000);
		
		WebElement frame=driver.findElement(By.xpath("//iframe[@title='Rich Text Editor, publisherRichTextEditor']"));
		driver.switchTo().frame(frame);
		Thread.sleep(3000);
		
		String text="This is my first Post";
		WebElement postBody=driver.findElement(By.xpath("/html[1]/body[1]"));
		postBody.sendKeys(text);
		
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		
		WebElement Share=driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
		Share.click();
		System.out.println("Posted successfully and the text entrered is displayed");
		Thread.sleep(3000);
		
		WebElement File=driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'File')]"));
		File.click();
		Thread.sleep(4000);
		
		WebElement UploadAFile=driver.findElement(By.id("chatterUploadFileAction"));
		UploadAFile.click();
		
		WebElement ChooseFile=driver.findElement(By.id("chatterFile"));
		ChooseFile.sendKeys("C:\\Users\\Venkat\\eclipse-workspace\\TestNGDemo\\src\\Demo1.java");
				
		WebElement ShareFile=driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
		ShareFile.click();
		System.out.println("Selected file posted successfully");
		
		WebElement profilepic=driver.findElement(By.xpath("//span[@id='displayBadge']"));
		Actions action=new Actions(driver);
		action.moveToElement(profilepic).build().perform();
		
		WebElement AddPhoto=driver.findElement(By.xpath("//a[@id='uploadLink']"));
		AddPhoto.click();
		Thread.sleep(3000);
		
		driver.switchTo().frame("uploadPhotoContentId");
		WebElement choosefile=driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:uploadInputFile']"));
		choosefile.sendKeys("C:\\Users\\Venkat\\Pictures\\bird.jpg");
		
		Thread.sleep(4000);		
		WebElement SaveButton=driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:uploadBtn']"));
		SaveButton.click();
		Thread.sleep(30000);
		System.out.println("selected pic successfully");
				
		WebElement save=driver.findElement(By.xpath("//input[@id='j_id0:j_id7:save']"));
		save.click();
		System.out.println("Photo has been uploaded successfully");
	}
	
	public static void MySettings() throws InterruptedException {
		WebElement UserMenuChk=driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
		Actions act=new Actions(driver);
		act.moveToElement(UserMenuChk).click().build().perform();
		System.out.println("Checked for UserMenu DropDown");
		Thread.sleep(5000);
		
		WebElement MySettings=driver.findElement(By.xpath("//a[contains(text(),'My Settings')]"));
		MySettings.click();
		System.out.println("Clicked on My Settings Option Successfully");
				
		WebElement Personal=driver.findElement(By.xpath("//span[@id='PersonalInfo_font']"));
		Personal.click();
		System.out.println("Personal Link clicked successfully");
				
		WebElement LoginHistory=driver.findElement(By.xpath("//span[@id='LoginHistory_font']"));
		LoginHistory.click();
		System.out.println("Login History has been clicked Successfully");
		
		
		WebElement DownloadLoginHistory=driver.findElement(By.xpath("//a[contains(text(),'Download login history for last six months, includ')]"));
		DownloadLoginHistory.click();
		System.out.println("Downloaded login History successfully");
		Thread.sleep(5000);
		
		WebElement DisplayAndLayout=driver.findElement(By.xpath("//span[@id='DisplayAndLayout_font']"));
		DisplayAndLayout.click();
		System.out.println("Display and Layout link clicked Successfully");
				
		WebElement CustomizeMyTabs=driver.findElement(By.xpath("//span[@id='CustomizeTabs_font']"));
		CustomizeMyTabs.click();
		System.out.println("Customize My Tabs Link Clicked Successfully");
				
		WebElement CustomApp=driver.findElement(By.xpath("//select[@id='p4']"));
		Select custom=new Select(CustomApp);
		custom.selectByIndex(1);
		
		WebElement AvailableTabs=driver.findElement(By.xpath("//select[@id='duel_select_0']"));
		Select selectTabs=new Select(AvailableTabs);
		selectTabs.selectByValue("report");
		
		WebElement Add=driver.findElement(By.xpath("//img[@class='rightArrowIcon']"));
		Add.click();
		System.out.println("Reports field has been added to Selected Tab List Successfully and also added on the links top");
				
		WebElement save=driver.findElement(By.xpath("//input[@name='save']"));
		save.click();
		Thread.sleep(5000);
		
		WebElement Email=driver.findElement(By.id("EmailSetup_font"));
		Email.click();
		System.out.println("Email Link Clicked Successfully");
				
		WebElement MyEmailSettings=driver.findElement(By.xpath("//span[@id='EmailSettings_font']"));
		MyEmailSettings.click();
		Thread.sleep(5000);
		
		WebElement sendThrough=driver.findElement(By.xpath("//input[@id='use_external_email1']"));
		sendThrough.click();
		
		WebElement EmailName=driver.findElement(By.id("sender_name"));
		EmailName.clear();
		EmailName.sendKeys("HemaRaja");
		
		WebElement EmailAddr=driver.findElement(By.id("sender_email"));
		EmailAddr.clear();
		EmailAddr.sendKeys("abc123@gmail.com");
		Thread.sleep(5000);
		
		WebElement Bcc=driver.findElement(By.xpath("//input[@id='auto_bcc1']"));
		Bcc.click();
		
		WebElement SaveButton=driver.findElement(By.xpath("//input[@name='save']"));
		SaveButton.click();
		System.out.println("Email Settings saved successfully");
		
		WebElement CalendarAndReminders=driver.findElement(By.id("CalendarAndReminders_font"));
		CalendarAndReminders.click();
		
		WebElement ActivityReminder=driver.findElement(By.xpath("//span[@id='Reminders_font']"));
		ActivityReminder.click();
		
		WebElement OpenReminder=driver.findElement(By.id("testbtn"));
		OpenReminder.click();
		System.out.println("PopUP displayed successfully");
		Thread.sleep(15000);
			
//		WebElement DismissAll=driver.findElement(By.xpath("//input[@id='dismiss_all']"));
//		DismissAll.click();
	}
	
	public static void DeveloperConsole() throws InterruptedException {
		WebElement UserMenuChk=driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
		Actions act=new Actions(driver);
		act.moveToElement(UserMenuChk).click().build().perform();
		System.out.println("Checked for UserMenu DropDown");
				
		WebElement DeveloperConsole=driver.findElement(By.xpath("//a[@class='debugLogLink menuButtonMenuLink']"));
		DeveloperConsole.click();
		System.out.println("Clicked on Developer Console Option Successfully");
		Thread.sleep(5000);
		
		String oldWindow=driver.getWindowHandle();
		Set<String> getAllWindows=driver.getWindowHandles();
		String[] getWindow=getAllWindows.toArray(new String[getAllWindows.size()]);
		Thread.sleep(3000);
		driver.switchTo().window(getWindow[1]).close();
	}
}
