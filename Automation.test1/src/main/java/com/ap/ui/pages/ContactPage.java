package com.ap.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ap.ui.base.TestBase;

public class ContactPage extends TestBase {
	
	
@FindBy (id = "id_contact")
WebElement headingDropdown;

@FindBy (id ="id_order")
WebElement emailInput;

@FindBy (id ="")
WebElement OrderReference;

@FindBy (id ="message")
WebElement messageTextBox;

@FindBy (id ="submitMessage")
WebElement submitMessageButton;

@FindBy (css = "[class='alert alert-success']")
WebElement successMsg;

public ContactPage()
{
	PageFactory.initElements(driver, this);
}

public ContactPage fillContactForm(String heading, String email, String reference, String message)
{
	Select select = new Select (headingDropdown);
	select.selectByVisibleText(heading);
	emailInput.sendKeys(email);
	OrderReference.sendKeys(reference);
	messageTextBox.sendKeys(message);
	return this;
}

public void submitMessage()
{
	submitMessageButton.click();
}
public String getMessage()
{
	return successMsg.getText();
}
}
