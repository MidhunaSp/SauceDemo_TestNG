package com.test;

import com.pom.*;
import com.utils.DriverUtils;
import org.testng.Assert;
import org.testng.annotations.*;

public class SauceTest {

	@BeforeClass
	public void setup() {
		DriverUtils.createDriver().get("https://www.saucedemo.com/");
	}
	
	@Test(priority=1)
	@Parameters({"username","password"})
	public void loginTest(String user,String pass) {
		LoginPage l = new LoginPage();
		l.login(user,pass);
		// to verify the successful login
		Assert.assertTrue(DriverUtils.createDriver().getCurrentUrl().contains("inventory"),"Login failed! Current URL: "+DriverUtils.createDriver().getCurrentUrl());
	}
	
	//setting up priority and dependsonmethods for a proper test flow
	@Test(priority=2,dependsOnMethods="loginTest")
	public void purchaseTest() {
		InventoryPage i = new InventoryPage();
		i.sortAndAddProduct();
		
		CheckoutPage c = new CheckoutPage();
		c.completeCheckout("Midhuna", "Varshini", "600001");
		
		// to check for the confirmation of order
		String actualTitle = c.getPageTitle();
	    System.out.println("Detected Page Title: " + actualTitle);
	    
	    Assert.assertEquals(actualTitle, "Checkout: Complete!", "The page title did not match!");
	
	}
	
	@AfterClass
	public void tearDown() {
		DriverUtils.quitDriver();
	}
}
