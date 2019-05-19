package com.ap.ui.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.ap.ui.pages.HomePage;
import com.ap.ui.pages.LoginPage;

public class LoginTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginTest()
	{
		super();
	}

	@BeforeMethod
	public void setUpdriver()
	{
		intialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest()
	{
		String title = loginPage.verifyPageTitle();
		Assert.assertEquals(title, "");//assertequal in testng allows to capture value and see if it is true or not.
	}
	
	@Test(priority = 2)
	public void apLogoTest()
	{
		boolean value = loginPage.validateAPImage();
		Assert.assertTrue(value); 
	}
	
	@Test(priority = 3)
	public void loginTest()
	{
		homePage = loginPage.login(propt.getProperty("username"), propt.getProperty("password"));
	}
	
	@AfterMethod
	public void closeBrowser(){
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
}
