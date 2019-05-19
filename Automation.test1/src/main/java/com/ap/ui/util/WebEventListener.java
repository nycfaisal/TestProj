/*
we have created this class WebDriverEventListner in order to implement interface 
is to overridden all the methods and define certain helpful log actions which would
be displayed/logged as the app under test is being executed. These method will be invoked 
by itself automatically when certain action are performed. Ex: click, submit, screenshot, findby, etc
 */


package com.ap.ui.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.ap.ui.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener{
	
	// ***will allows you capture events like what is happening and what is not happening***
	public void beforeNavigate(String url, WebDriver driver)
	{
		System.out.println("Before navi to: " + url + "'");
	}
	
	public void afterNavigate(String url, WebDriver driver)
	{
		System.out.println("After navi to: '" + url + "'");
	}
	
	public void beforeChangeValueof(WebElement element, WebDriver driver)
	{
		System.out.println("Value of " + element.toString() + "before making any change"	);
	}
	
	public void afterChangeValueof(WebElement element, WebDriver driver)
	{
		System.out.println("Element value changed to " + element.toString());
	}
	
	public void beforeClickingOn(WebElement element, WebDriver driver)
	{
		System.out.println("Attemptingto Click on: "	 + element.toString());
	}
	
	public void afterClickingOn(WebElement element, WebDriver driver)
	{
		System.out.println("Successfuly Clicked on: "	 + element.toString());
	}
	public void beforeNavigatingback(WebDriver driver)
	{
		System.out.println("Navigating back to previous page");
	}
	
	public void afterNavigatingback(WebDriver driver)
	{
		System.out.println("Navigating to current page");
	}
	
	public void beforeNavigatingforward(WebDriver driver)
	{
		System.out.println("Attempting Navigating forward to next page");
	}
	
	public void afterNavigatingforward(WebDriver driver)
	{
		System.out.println("Attempting Navigating forward to next page");
	}
	
	public void dueToException(Throwable error, WebDriver driver)
	{
		System.out.println("Exceptional occured" + error);
		try
		{
			TestUtil.takeScreenshotAt();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void beforeFindBy(By by, WebElement element, WebDriver driver)
	{
		System.out.println("Attempting find the element" + by.toString());
	}
	
	public void afterFindBy(By by, WebElement element, WebDriver driver)
	{
		System.out.println("successfully found the element" + by.toString());
	}
	
	//These are non overridden methods of the WebListener class
	//actions will only be performed once not multiple times that's why its not overridden 
	//why we need to record this event if we don't need to track them? 
	
	public void beforeScript(String script, WebDriver driver)
	{
		
	}
	
	public void afterScript(String script, WebDriver driver)
	{
		
	}
	
	public void beforeAcceptingAlert(WebDriver driver)
	{
		
	}
	
	public void afterAcceptingAlert(WebDriver driver)
	{
		
	}
	
	public void beforeDismissingAlert(WebDriver driver)
	{
		
	}
	
	public void afterDismissingAlert(WebDriver driver)
	{
		
	}
	
	public void beforeNavigatingRefresh(WebDriver driver)
	{
		
	}
	
	public void afterNavigatingReresh(WebDriver driver)
	{
		
	}

	public void beforeChangevalueof(WebElement element, WebDriver driver, CharSequence [] keysToSend)
	{
		
	}
	
	public void afterChangeValueof(WebElement element, WebDriver driver, CharSequence [] KeysToSend)
	{
		
	}
	
	public <X> void beforeGetScreenshotAs(OutputType<X> arg0)
	{
		
	}
	
	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1)
	{
		
	}
	
	public void beforeGetText(WebElement arg0, WebDriver arg1)
	{
		
	}
	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2)
	{
		
	}
	
	public void beforeSwitchToWindow(String argo0, WebDriver arg1)
	{
		
	}
	public void afterSwitchToWindow(String argo0, WebDriver arg1)
	{
		
	}

	public void afterAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	

	
	
	
	
	
	
	
}
