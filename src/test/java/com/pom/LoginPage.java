package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	@FindBy(id="user-name")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="login-button") 
	private WebElement loginBtn;
	
	public void login(String user,String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		loginBtn.click();
	}
}
