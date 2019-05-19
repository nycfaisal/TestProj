package com.ap.ui.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.ap.ui.pages.ContactPage;
import com.ap.ui.pages.HomePage;

public class ContactTest extends TestBase{
	
	ContactPage contactspage;
	HomePage homepage;
	
	public ContactTest()
	{
		super();//learn about super action
	}
	
	@BeforeMethod
	public void setUpdriver()
	{
		intialization();
		contactspage = new ContactPage();
		homepage = new HomePage();
	}

	@Test
	public void testContact()
	{
		homepage.clickOnContactLink();
		contactspage = contactspage.fillContactForm("Customer service", "Random@test.com","Testing","This is test Purpose");
		
		contactspage.submitMessage();
		String successMsg = contactspage.getMessage();
		Assert.assertEquals(successMsg, "will check the message on the site later");
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	
}
