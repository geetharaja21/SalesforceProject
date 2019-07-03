package com.salesforce.maybatch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
		//DeveloperConsole();
		//CreateAccount();
		//CreateNewView();
		//EditView();
		//MergeAccounts();
		//CreateAccountReport();
		//Opportunities();
		//NewOpportunity();
		//Test_OpportunityPipeline_Report();
		//Test_StuckOpportunities_Report();
		//Test_QuarterlySummary_Report();
		//Leads_Tab();
		//Leads_SelectView();
		// Default_View();
		 //Todays_Lead();
		//Check_New_OnLeads();
		//Create_New_Contact();
		// Create_NewView_ContactsPage();
		//Check_Recent_Contacts();
		//Check_MyContacts_View();
		//View_A_Contact();
		//Check_Error_Message();
		//Check_Cancel_Button();
		Check_SaveNew_ContactPage();
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
				
		WebElement save1=driver.findElement(By.xpath("//input[@name='save']"));
		save1.click();
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
	
	public static void CreateAccount() throws InterruptedException {

		WebElement AccountsLink=driver.findElement(By.id("Account_Tab"));
		AccountsLink.click();
		System.out.println("Accounts link clicked successfully");
		Thread.sleep(3000);		
		
		WebElement New=driver.findElement(By.xpath("//input[@name='new']"));
		New.click();
		
		WebElement AccountName=driver.findElement(By.id("acc2"));
		AccountName.sendKeys("Hema");
		Thread.sleep(4000);
		
		WebElement Save=driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@name='save']"));
		Save.click();
		System.out.println("New Account Page is displayed with account details successfully");
	}
	
	public static void CreateNewView() throws InterruptedException {
		WebElement AccountsLink=driver.findElement(By.id("Account_Tab"));
		AccountsLink.click();
		System.out.println("Accounts link clicked successfully");
		Thread.sleep(3000);
			
		WebElement NewViewLink=driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		NewViewLink.click();
		
		WebElement ViewName=driver.findElement(By.id("fname"));
		ViewName.clear();
		ViewName.sendKeys("Hema");
		Thread.sleep(4000);
		
		WebElement ViewUniqueName=driver.findElement(By.id("devname"));
		ViewUniqueName.clear();
		ViewUniqueName.sendKeys("SalesForceDevelopment_Team1");
		
		WebElement Save1=driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='save']"));
		Save1.click();
		System.out.println("Newly added view should be displayed successfully in the account view list");
		Thread.sleep(5000);
	}
	
	public static void EditView() throws InterruptedException {
		WebElement AccountsLink=driver.findElement(By.id("Account_Tab"));
		AccountsLink.click();
		System.out.println("Accounts link clicked successfully");
			
		WebElement viewDropdown=driver.findElement(By.xpath("//select[@id='fcf']"));
		Select selectView=new Select(viewDropdown);
		selectView.selectByIndex(2);
		Thread.sleep(5000);
		
		WebElement Edit=driver.findElement(By.xpath("//a[contains(text(),'Edit')]"));
		Edit.click();
		System.out.println("View name selected and Edit page has been displayed");
		Thread.sleep(4000);
			
		WebElement viewName=driver.findElement(By.xpath("//input[@id='fname']"));
		viewName.sendKeys("Haripriya");
		
		WebElement Field=driver.findElement(By.xpath("//select[@id='fcol1']"));
		Select selectField=new Select(Field);
		selectField.selectByValue("ACCOUNT.NAME");;
		Thread.sleep(3000);
		
		WebElement Operator=driver.findElement(By.xpath("//select[@id='fop1']"));
		Select selectOperator=new Select(Operator);
		selectOperator.selectByValue("c");;
		
		WebElement Value=driver.findElement(By.xpath("//input[@id='fval1']"));
		Value.clear();
		Value.sendKeys("a");
		Thread.sleep(3000);
		
		WebElement AvailableFields=driver.findElement(By.xpath("//select[@id='colselector_select_0']"));
		Select selectAvailFields=new Select(AvailableFields);
		selectAvailFields.selectByVisibleText("Last Activity");
		
		WebElement Add=driver.findElement(By.xpath("//img[@class='rightArrowIcon']"));
		Add.click();
		Thread.sleep(3000);
		
		WebElement Save2=driver.findElement(By.xpath("//input[@class='btn primary']"));
		Save2.click();
		System.out.println("View will have Last activity column added and the data has been displayed successfully");
		Thread.sleep(5000);
	}
	
	public static void MergeAccounts() throws InterruptedException {
		WebElement AccountsLink=driver.findElement(By.id("Account_Tab"));
		AccountsLink.click();
		System.out.println("Accounts link clicked successfully");
			
		WebElement MergeAccounts=driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]"));
		MergeAccounts.click();
		Thread.sleep(3000);
		
		WebElement EnterAccts=driver.findElement(By.id("srch"));
		EnterAccts.sendKeys("Hema");
		
		WebElement FindAccts=driver.findElement(By.xpath("//input[@name='srchbutton']"));
		FindAccts.click();
		
		Thread.sleep(3000);
		
		WebElement next=driver.findElement(By.xpath("//div[@class='pbTopButtons']//input[@name='goNext']"));
		next.click();
		System.out.println("Accounts selected successfully and clicked next button");
		Thread.sleep(3000);
				
		WebElement Merge=driver.findElement(By.xpath("//div[@class='pbTopButtons']//input[@name='save']"));
		Merge.click();
		Thread.sleep(5000);
		
		Alert alert=driver.switchTo().alert();
		alert.accept();
		System.out.println("Accounts merged successfully and pop up displayed");
	}
	
	public static void CreateAccountReport() throws InterruptedException {
		WebElement AccountsLink=driver.findElement(By.id("Account_Tab"));
		AccountsLink.click();
		System.out.println("Accounts link clicked successfully");
	
		WebElement LastActivity=driver.findElement(By.xpath("//a[contains(text(),'Accounts with last activity > 30 days')]"));
		LastActivity.click();
		System.out.println("Unsaved Report page is displayed successfully");
				
		WebElement DateField=driver.findElement(By.id("ext-gen20"));
		Actions action=new Actions(driver);
		action.moveToElement(DateField).click().build().perform();		
		Thread.sleep(5000);
		DateField.sendKeys(Keys.ARROW_DOWN);
		DateField.sendKeys(Keys.ENTER);
		
	
		WebElement From=driver.findElement(By.xpath("//img[@id='ext-gen152']"));
		Actions action1=new Actions(driver);
		action1.moveToElement(From).click().build().perform();
		Thread.sleep(3000);
		//From.sendKeys(Keys.ENTER);
		//.sendKeys(driver.findElement(By.xpath("//button[@id='ext-gen253']")));
		
		WebElement Today=driver.findElement(By.xpath("//table[@id='ext-comp-1112']"));
		Today.click();
		
		WebElement save2=driver.findElement(By.xpath("//button[@id='ext-gen49']"));
		save2.click();
		Thread.sleep(4000);
		
		WebElement ReportName=driver.findElement(By.xpath("//input[@id='saveReportDlg_reportNameField']"));
		ReportName.sendKeys("Hema");
		
		WebElement ReportUniqueName=driver.findElement(By.xpath("//input[@id='saveReportDlg_DeveloperName']"));
		ReportUniqueName.sendKeys("SFDCReport_Hema1new");
		Thread.sleep(10000);
		
		WebElement SaveRun=driver.findElement(By.xpath("//button[@id='ext-gen276']"));
		SaveRun.click();
		System.out.println("Report has been saved successfully");
		Thread.sleep(10000);
		
		System.out.println("Report generated successfully");
	}
	
	public static void Opportunities() throws InterruptedException {
		WebElement Opportunities=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]"));
		Opportunities.click();
		Thread.sleep(3000);
		
		WebElement View=driver.findElement(By.xpath("//select[@id='fcf']"));
		Actions action=new Actions(driver);
		action.moveToElement(View).click().build().perform();
		Thread.sleep(3000);
		System.out.println("Dropdown with all Opportunities displayed successfully");
	}
	
	public static void NewOpportunity() throws InterruptedException {
		WebElement Opportunities=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]"));
		Opportunities.click();
				
		WebElement NewOpp=driver.findElement(By.xpath("//input[@name='new']"));
		NewOpp.click();
		
		WebElement OName=driver.findElement(By.xpath("//input[@id='opp3']"));
		OName.sendKeys("Hema Raja");
		Thread.sleep(5000);
		
		WebElement AName=driver.findElement(By.xpath("//input[@id='opp4']"));
		AName.sendKeys("Hema");
		
		WebElement CloseDate=driver.findElement(By.xpath("//input[@id='opp9']"));
		Actions action=new Actions(driver);
		action.moveToElement(CloseDate).click().build().perform();
		
		WebElement Today=driver.findElement(By.xpath("//a[@class='calToday']"));
		Today.click();
		Thread.sleep(4000);
		
		WebElement Stage=driver.findElement(By.xpath("//select[@id='opp11']"));
		Select selectStage=new Select(Stage);
		selectStage.selectByIndex(1);
		
		WebElement Probability=driver.findElement(By.xpath("//input[@id='opp12']"));
		Probability.clear();
		Probability.sendKeys("10");
		Thread.sleep(3000);
		
		WebElement PrimaryCampaign=driver.findElement(By.xpath("//input[@id='opp17']"));
		PrimaryCampaign.sendKeys("Widgets Webinar(Sample)");
		Thread.sleep(3000);
		
		WebElement LeadSource=driver.findElement(By.xpath("//select[@id='opp6']"));
		Select selectLead=new Select(LeadSource);
		selectLead.selectByIndex(2);
		
		WebElement SaveOpp=driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@name='save']"));
		SaveOpp.click();
		Thread.sleep(3000);
		System.out.println("New Opportunity page is displayed with details");
	}
	
	public static void Test_OpportunityPipeline_Report() throws InterruptedException {
		WebElement Opportunities=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]"));
		Opportunities.click();
		Thread.sleep(3000);
		
		WebElement OPipeline=driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]"));
		OPipeline.click();
		System.out.println("Report Page with Opportunities that are pipelined will be displayed");
		Thread.sleep(3000);
	}
	
	public static void Test_StuckOpportunities_Report() throws InterruptedException {
		WebElement Opportunities=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]"));
		Opportunities.click();
		Thread.sleep(3000);
		
		WebElement StuckOpp=driver.findElement(By.xpath("//a[contains(text(),'Stuck Opportunities')]"));
		StuckOpp.click();
		System.out.println("Report Page with the Opportunities that are Stuck will be displayed.");
	}
	
	public static void Test_QuarterlySummary_Report() throws InterruptedException {
		WebElement Opportunities=driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]"));
		Opportunities.click();
			
		WebElement Interval=driver.findElement(By.xpath("//select[@id='quarter_q']"));
		Select selectInt=new Select(Interval);
		selectInt.selectByValue("curnext3");
		Thread.sleep(4000);
		
		WebElement Include=driver.findElement(By.xpath("//select[@id='open']"));
		Select selectInclude=new Select(Include);
		selectInclude.selectByValue("open");;
		
		WebElement RunReport=driver.findElement(By.xpath("//table[@class='opportunitySummary']//input[@name='go']"));
		RunReport.click();
		System.out.println("Respective Report page has been displayed successfully");
		Thread.sleep(3000);
		
	}
	
	public static void Leads_Tab() throws InterruptedException {
		
		WebElement LeadsTab=driver.findElement(By.xpath("//a[contains(text(),'Leads')]"));
		LeadsTab.click();
		Thread.sleep(3000);
		System.out.println("Link Navigated to the Leads Home Page Successfully");
	}
	
	public static void Leads_SelectView() throws InterruptedException {

		WebElement LeadsTab=driver.findElement(By.xpath("//a[contains(text(),'Leads')]"));
		LeadsTab.click();
		Thread.sleep(3000);
		System.out.println("Link Navigated to the Leads Home Page Successfully");
		
		WebElement LeadView=driver.findElement(By.xpath("//select[@id='fcf']"));
		Actions action1=new Actions(driver);
		action1.moveToElement(LeadView).click().build().perform();
		Thread.sleep(3000);
		System.out.println("Dropdown with all Lead contents displayed successfully");
		
		WebElement UserMenuChk=driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
		Actions act=new Actions(driver);
		act.moveToElement(UserMenuChk).click().build().perform();
		System.out.println("Checked for UserMenu DropDown");
				
		Thread.sleep(5000);
		
		WebElement logOut=driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		logOut.click();
		System.out.println("Logout done sucessfully");
				
	}
	
	public static void Default_View() throws InterruptedException {
		
		WebElement LeadsTab=driver.findElement(By.xpath("//a[contains(text(),'Leads')]"));
		LeadsTab.click();
		Thread.sleep(3000);
		System.out.println("Link Navigated to the Leads Home Page Successfully");
		
		WebElement LeadView=driver.findElement(By.xpath("//select[@id='fcf']"));
		Select selView=new Select(LeadView);
		selView.selectByIndex(2);
		Thread.sleep(3000);
		System.out.println("Today's Lead selected successfully");
		
		WebElement UserMenuChk=driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
		Actions act=new Actions(driver);
		act.moveToElement(UserMenuChk).click().build().perform();
		System.out.println("Checked for UserMenu DropDown");
				
		Thread.sleep(5000);
		
		WebElement logOut=driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		logOut.click();
		System.out.println("Logout done sucessfully");
		Thread.sleep(10000);
		
		WebElement pwd=driver.findElement(By.xpath("//input[@id='password']"));
		pwd.sendKeys("Metropcs21");
		Thread.sleep(3000);
		
		WebElement loginButton=driver.findElement(By.xpath("//input[@id='Login']"));
		loginButton.click();
		Thread.sleep(3000);
		
		WebElement LeadsTab1=driver.findElement(By.xpath("//a[contains(text(),'Leads')]"));
		LeadsTab1.click();
		Thread.sleep(2000);
		
		WebElement Go=driver.findElement(By.xpath("//span[@class='fBody']//input[@name='go']"));
		Go.click();
		System.out.println("Lead View's Page displayed successfully");
		Thread.sleep(3000);
	}
	
	public static void Todays_Lead() throws InterruptedException {
		
		WebElement LeadsTab=driver.findElement(By.xpath("//a[contains(text(),'Leads')]"));
		LeadsTab.click();
		Thread.sleep(3000);
		System.out.println("Link Navigated to the Leads Home Page Successfully");
		
		WebElement LeadView=driver.findElement(By.xpath("//select[@id='fcf']"));
		Select selView=new Select(LeadView);
		selView.selectByIndex(2);
		Thread.sleep(3000);
		System.out.println("Today's Lead selected successfully");
		
		WebElement Go=driver.findElement(By.xpath("//span[@class='fBody']//input[@name='go']"));
		Go.click();
		System.out.println("Lead View's Page displayed successfully");
		Thread.sleep(3000);
		
		WebElement UserMenuChk=driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
		Actions act=new Actions(driver);
		act.moveToElement(UserMenuChk).click().build().perform();
		System.out.println("Checked for UserMenu DropDown");
				
		Thread.sleep(5000);
		
		WebElement logOut=driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		logOut.click();
		System.out.println("Logout done sucessfully");
		Thread.sleep(10000);
		
		driver.quit();
		System.out.println("Application closed successfully");
	}
	
	public static void Check_New_OnLeads() throws InterruptedException {
		
		WebElement LeadsTab=driver.findElement(By.xpath("//a[contains(text(),'Leads')]"));
		LeadsTab.click();
		Thread.sleep(3000);
		System.out.println("Link Navigated to the Leads Home Page Successfully");
		
		WebElement NewLead=driver.findElement(By.xpath("//input[@name='new']"));
		NewLead.click();
		System.out.println("New Lead Creation page opened successfully");
		Thread.sleep(3000);
		
		WebElement LName=driver.findElement(By.xpath("//input[@id='name_lastlea2']"));
		LName.sendKeys("ABCD");
		
		WebElement Company=driver.findElement(By.xpath("//input[@id='lea3']"));
		Company.sendKeys("ABCD");
		Thread.sleep(3000);
		
		WebElement SaveLead=driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@name='save']"));
		SaveLead.click();
		Thread.sleep(4000);
		System.out.println("Newly created lead view page should be opened successfully");
		
	}
	
	public static void Create_New_Contact() throws InterruptedException {
		
		WebElement ContactsTab=driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		ContactsTab.click();
		Thread.sleep(2000);
		System.out.println("Contacts Home page displayed successfully");
		
		WebElement NewContact=driver.findElement(By.xpath("//input[@name='new']"));
		NewContact.click();
		System.out.println("New Contact HomePage displayed successfully");
		
		WebElement ContactsLName=driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
		ContactsLName.sendKeys("Govind");
		
		WebElement AcctName=driver.findElement(By.xpath("//input[@id='con4']"));
		AcctName.sendKeys("Hema");
		Thread.sleep(3000);
		
		WebElement SaveContact=driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@name='save']"));
		SaveContact.click();
		Thread.sleep(3000);
		System.out.println("New Contact created successfully");
	}
	
	public static void Create_NewView_ContactsPage() throws InterruptedException {
		
		WebElement ContactsTab1=driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		ContactsTab1.click();
		Thread.sleep(2000);
		System.out.println("Contacts Home page displayed successfully");
		
		WebElement CreateNewView=driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		CreateNewView.click();
		Thread.sleep(3000);
		System.out.println("New View Page displayed successfully");
		
		WebElement ViewNameCont=driver.findElement(By.xpath("//input[@id='fname']"));
		ViewNameCont.sendKeys("Raj");
		
		WebElement ViewUName=driver.findElement(By.xpath("//input[@id='devname']"));
		ViewUName.clear();
		ViewUName.sendKeys("Varma");
		Thread.sleep(2000);
		
		WebElement SaveView=driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='save']"));
		SaveView.click();
		Thread.sleep(5000);
		System.out.println("Created View name is displayed in drop down in that page by defalut");
	}
	
	public static void Check_Recent_Contacts() throws InterruptedException {

		WebElement ContactsTab2=driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		ContactsTab2.click();
		Thread.sleep(2000);
		System.out.println("Contacts Home page displayed successfully");
		
		WebElement ContactsMode=driver.findElement(By.xpath("//select[@id='hotlist_mode']"));
		Select selMode=new Select(ContactsMode);
		selMode.selectByValue("2");
		Thread.sleep(4000);
		System.out.println("Recently created contacts should be displayed");
	}
	
	public static void Check_MyContacts_View() throws InterruptedException {
		WebElement ContactsTab3=driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		ContactsTab3.click();
		Thread.sleep(2000);
		System.out.println("Contacts Home page displayed successfully");
		
		WebElement ContactView=driver.findElement(By.xpath("//select[@id='fcf']"));
		Select selcontact=new Select(ContactView);
		selcontact.selectByVisibleText("My Contacts");
		Thread.sleep(3000);
		System.out.println("My contacts view displayed successfully");
	}
	
	public static void View_A_Contact() throws InterruptedException {
		
		WebElement ContactsTab4=driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		ContactsTab4.click();
		Thread.sleep(2000);
		System.out.println("Contacts Home page displayed successfully");
		
		WebElement ContactsName=driver.findElement(By.xpath("//tr[contains(@class,'dataRow even first')]//a[contains(text(),'Govind')]"));
		ContactsName.click();
		Thread.sleep(2000);
		System.out.println("Related Contact page displayed successfully");
	}
	
	public static void Check_Error_Message() throws InterruptedException {
		
		WebElement ContactsTab5=driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		ContactsTab5.click();
		Thread.sleep(2000);
		System.out.println("Contacts Home page displayed successfully");
		
		WebElement CreateNewView1=driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		CreateNewView1.click();
		Thread.sleep(3000);
		System.out.println("New View Page displayed successfully");
		
		WebElement ViewUName1=driver.findElement(By.xpath("//input[@id='devname']"));
		ViewUName1.clear();
		ViewUName1.sendKeys("EFGH");
		Thread.sleep(2000);
		
		WebElement SaveView1=driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='save']"));
		SaveView1.click();
		Thread.sleep(5000);
		System.out.println("Error message is appeared under the View Name field.The Error message appears as \"Error: You must enter a value\"");
	}
	
	public static void Check_Cancel_Button() throws InterruptedException {
		
		WebElement ContactsTab6=driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		ContactsTab6.click();
		Thread.sleep(2000);
		System.out.println("Contacts Home page displayed successfully");
		
		WebElement CreateNewView2=driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		CreateNewView2.click();
		Thread.sleep(3000);
		System.out.println("New View Page displayed successfully");
		
		WebElement ViewNameCont2=driver.findElement(By.xpath("//input[@id='fname']"));
		ViewNameCont2.sendKeys("ABCD");
		
		WebElement ViewUName2=driver.findElement(By.xpath("//input[@id='devname']"));
		ViewUName2.clear();
		Thread.sleep(2000);
		ViewUName2.sendKeys("EFGH");
		Thread.sleep(2000);
		System.out.println("View name and Unique name entered successfully");
		
		WebElement ViewCancel=driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='cancel']"));
		ViewCancel.click();
		System.out.println("Contacts Home page is displayed and the View ABCD should not be created.");
	}
	
	public static void Check_SaveNew_ContactPage() throws InterruptedException {
		WebElement ContactsTab7=driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		ContactsTab7.click();
		Thread.sleep(2000);
		System.out.println("Contacts Home page displayed successfully");
		
		WebElement NewContact1=driver.findElement(By.xpath("//input[@name='new']"));
		NewContact1.click();
		System.out.println("New Contact HomePage displayed successfully");
		
		WebElement ContactsLName1=driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
		ContactsLName1.sendKeys("Indian");
		
		WebElement AcctName1=driver.findElement(By.xpath("//input[@id='con4']"));
		AcctName1.sendKeys("Global Media");
		Thread.sleep(3000);
		
		WebElement SaveNewContact=driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@name='save_new']"));
		SaveNewContact.click();
		Thread.sleep(2000);
		System.out.println("New contact is created. Contact Edit:New Contact Page is dispalyed");
		
	}
}
