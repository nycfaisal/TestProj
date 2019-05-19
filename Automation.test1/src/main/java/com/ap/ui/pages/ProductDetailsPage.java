package com.ap.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.ap.ui.base.TestBase;



public class ProductDetailsPage extends TestBase{

	@FindBy(id="header_logo")
	WebElement tshirtButton;
	
	@FindBy(css="[class='quick-view']")
	WebElement quickViewButton;
	
	@FindBy(id="quantity_wanted")
	WebElement quantityInput;
	
	@FindBy(css="[class='form-control attribute_select no-print']")
	WebElement sizeDropDown;
	
	@FindBy(css="[class='submit']")
	WebElement addCartButton;
	
	@FindBy(css="[class='btn btn-default button button-medium']")
	WebElement proceedCheckOut;
	
	@FindBy(id="wishlist_button")
	WebElement addToWishListButton;
	
	@FindBy(css="[class='fancybox-error']")
	WebElement addWishListMsg;
	
	@FindBy(css="[class='fancybox-item fancybox-close']")
	WebElement addWishListMsgCloseButton;
	
	public ProductDetailsPage(){
		PageFactory.initElements(driver, this);
	}
	public void verifyAddwishListMsg(){
		Assert.assertEquals(addWishListMsg.getText(), "Added to your wishlist.");
		addWishListMsgCloseButton.click();
	}
	public ProductDetailsPage selectroductColor(String color){
		String locator ="[name='"+color+"']";
		driver.findElement(By.cssSelector(locator)).click();
		return this;
	}
	public ProductDetailsPage inputQuantity(String quantity){
		quantityInput.clear();
		quantityInput.sendKeys(quantity);
		return this;
	}
	public ProductDetailsPage selectSize(String size){
		Select select=new Select(sizeDropDown);
		select.selectByVisibleText(size);
		return this;
	}
	public ProductDetailsPage clickAddCart(){
		addCartButton.click();
		return this;		
	}
	public ProductDetailsPage clickAddWishListButton(){
		addToWishListButton.click();
		return this;
	}
	// this method will take it to next landing page. return new classname() will take it to that class? new is new generating page
	public OrderSummaryPage proceedCheckOut(){
		proceedCheckOut.click();
		return new OrderSummaryPage();
	}

}