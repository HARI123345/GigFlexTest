package com.gigflex.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gigflex.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//page factory -
	@FindBy(xpath="//img[@class='ng-tns-c34-6']")
	WebElement logoimage;
	
	@FindBy(xpath="//input[@formcontrolname='username']")
	WebElement user;
	
	
	@FindBy(xpath="//input[@formcontrolname='password']")
	WebElement pwd;
	
	@FindBy(xpath="//button[@class='submit-button mat-raised-button mat-accent']")
	WebElement loginbtn;
	
	//dashboard title
	@FindBy(xpath="//*[@id=\"dashboard-project\"]/div/div[1]/div/span")
	WebElement message;
	
	@FindBy(xpath="//div[@class='message-box error mb-16 ng-tns-c34-6 ng-star-inserted']")
	WebElement errormsg;

	//title
	@FindBy(xpath="//*[@id=\"login-form\"]/div[2]")
	WebElement title;
	
	
	//Initializing the page method
		public LoginPage() {
			PageFactory.initElements(driver, this);
		}
		
		//actions or methods
		
		public boolean validateGigFlexLogoImage() {
			return logoimage.isDisplayed();
		}
		
		public HomePage login(String name, String password) throws InterruptedException {
			user.sendKeys(name);
			Thread.sleep(1000);
			pwd.sendKeys(password);
			Thread.sleep(1000);
			loginbtn.click();
			//message.isDisplayed();
			return new HomePage();
		}
		
		  
		}
		


