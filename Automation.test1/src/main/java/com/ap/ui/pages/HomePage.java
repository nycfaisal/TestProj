package com.ap.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.ui.base.TestBase;

public class HomePage extends TestBase {
	
	//all the information for login button
	@FindBy (css ="['class=login']")
	WebElement signInButton;
	
	@FindBy (id ="contact-link")
	WebElement contactLink;
	
	@FindBy (id = "search_query_top")
	WebElement searchInputbox;
	
	@FindBy (css = "[name='submit_search']")
	WebElement submitSearch;
	
	@FindBy (css = "[class='logout']")
	WebElement logoutButton;
	
	public HomePage ()
	{
		PageFactory.initElements(driver, this);
	}
	// methods to call action
public SearchPage searchProduct(String productName)
{
	searchInputbox.sendKeys(productName);
	submitSearch.click();
	return new SearchPage();
}
public void clickonSignIn()
{
signInButton.click();	
}
public void clickOnContactLink()
{
	contactLink.click();
}
public void logOut()
{
	logoutButton.click();
}









}
