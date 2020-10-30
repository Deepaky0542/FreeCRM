package com.crm.qa.testcases;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Loginpage;

public class LoginPageTest extends TestBase{
	Loginpage loginPage; 
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
 @BeforeClass
 public void setUp() {
	 initialiazation();
	 loginPage =new Loginpage();
 }
 
 @Test(priority = 1)
 public void loginPageTitleTest() {
	String title =	 loginPage.validateLoginPageTitle();
	Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
 }
 
 @Test(priority=2)
 public void crmLogoImageTest() {
	boolean flag = loginPage.validateCRMImage();
	
	Assert.assertTrue(flag);
 }
 @Test(priority=3)
 public void loginPage() {
	 homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
 }
 
 @AfterClass
 public void tearDown() {
	 driver.quit();
 }

 
 
 
}
