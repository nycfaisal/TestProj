package com.ap.ui.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.ap.ui.util.TestUtil;
import com.ap.ui.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;//setting up property of class
	public static Properties propt;
	public static EventFiringWebDriver en_driver; // what does firing do? sends
													// the event that takes
													// place
	public static WebEventListener eventListener; // what does listener do?

	public TestBase() {
		try // 1. capturing any error that might occur 2. avoid the error during
			// interaction with other file
		{
			propt = new Properties(); // what is the user.dir for? and what does
										// it do?
			FileInputStream ipa = new FileInputStream(System.getProperty("user.dir")
					+ "//Automation.test1//src//main//java//com//ap/ui//config//config.properties");
			propt.load(ipa);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void intialization()
	{
		String browserName = propt.getProperty("browser");//***confusion about here***
		
		if (browserName.equalsIgnoreCase("chrome"))
		{
			//System.setProperty("user.dir") + "/src/main/resources/drivers");
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("ff"))
		{
			//driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "location of IE driver");
			//driver = new IE();
		}
		else if (browserName.equalsIgnoreCase("safari"))
		{
			//driver = new SafariDriver();
		}
	
		//creating object for action that's occurring and sharing with driver
	en_driver=new EventFiringWebDriver(driver); //why we create objects //create an object to call driver multiple times
	//create object of WebEventListener to register it with eventFiringWebdriver
	eventListener=new WebEventListener(); // 
	//event can be captured base on the method we create WebEventListener class
	en_driver.register(eventListener); //where does this register method coming from? from webeventlistener.java file
	//since we know driver object is for browser and en_driver is for event thats taking place. 
	//we declaring that they are equal to each when they are exchanging   the info
	driver=en_driver;

	driver.manage().window().maximize();driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.page_load,TimeUnit.SECONDS);
	
	driver.get(propt.getProperty("url"));

}
}
