package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	Loginpage loginPage; 
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}
 @BeforeClass
 public void setUp() {
	 initialiazation();
	 loginPage =new Loginpage();
	 testUtil = new TestUtil();
	 contactsPage=  new ContactsPage();
homePage	= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
 }
 
 @Test(priority = 1)
 public void verifyHomePageTitleTest() {
	String HomePageTitle= homePage.verifyHomePageTitle();
	Assert.assertEquals(HomePageTitle, "CRMPRO", "Home Page Title not Matched");
 }
 @Test(priority = 2)
 public void verifyUserNAmeTest() {
	 testUtil.switchToFrame();
	 Assert.assertTrue(homePage.verifyCorrectUSerName());
 }
 
 @Test(priority = 3)
 public void verifyContactsLinkTest() {
	 driver.switchTo().defaultContent();
	 testUtil.switchToFrame();
	contactsPage = homePage.clickOnContactsList();
 }
 
 
 
 
 
 @AfterClass
 public void tearDown() {
	 driver.quit();
 }

}
