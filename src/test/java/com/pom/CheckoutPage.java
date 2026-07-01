package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage{

	@FindBy(id="checkout")
	private WebElement checkoutBtn;
	
	@FindBy(id="first-name")
	private WebElement firstName;
	
	@FindBy(id="last-name")
	private WebElement lastName;
	
	@FindBy(id="postal-code")
	private WebElement zipCode;
	
	@FindBy(id="continue")
	private WebElement continueBtn;
	
	@FindBy(id="finish")
	private WebElement finishBtn;
	
	@FindBy(id="complete-header")
	private WebElement successMsg;
	
	@FindBy(xpath = "//span[@data-test='title']") 
	private WebElement pageTitle;

	@FindBy(className = "complete-header") 
	private WebElement completeHeader;
	
	public void completeCheckout(String f,String l,String z) {
		checkoutBtn.click();
		firstName.sendKeys(f);
		lastName.sendKeys(l);
		zipCode.sendKeys(z);
		continueBtn.click();
		finishBtn.click();
	}
	
	public String getPageTitle() {
	    return pageTitle.getText();
	}

	public String getSuccessMessage() {
	    return completeHeader.getText(); 
	}
}
