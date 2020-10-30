package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class Loginpage extends TestBase{
	
	//Page Factory Object Repository
	
	@FindBy(xpath="//form[@id='loginForm']//input[@name='username']")
	WebElement usename;
	@FindBy(xpath="//form[@id='loginForm']//input[@name='password']")
	WebElement password;
	@FindBy(xpath="//input[@type='submit']")
	WebElement LoginBtn;
	@FindBy(xpath="//button[contains(text(), 'Sign Up')]")
	WebElement signupBtn;
	@FindBy(xpath="//img[contains(@class, 'img-responsive')]")
	WebElement crlLogo;
	
	//Initializaing the page Object
    public Loginpage() {
    	PageFactory.initElements(driver, this);
    }
    
    //Actions
    
    public String validateLoginPageTitle() {
    	 return driver.getTitle();
    }
     public boolean validateCRMImage() {
    	return crlLogo.isDisplayed();
     }
     public HomePage login(String un, String pwd) {
    	 usename.sendKeys(un);
    	 password.sendKeys(pwd);
    	 LoginBtn.click();
    	 return new HomePage();
     }
    
} 
