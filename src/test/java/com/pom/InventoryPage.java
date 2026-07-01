package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage extends BasePage {
    
    // Standard locator for the sort dropdown
    @FindBy(className = "product_sort_container") 
    private WebElement sortDropdown;

    // ID for the 'Sauce Labs Fleece Jacket' (Highest price item)
    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket") 
    private WebElement addJacketBtn;

    @FindBy(className = "shopping_cart_link") 
    private WebElement cartBtn;
    
    @FindBy(xpath = "//span[@data-test='title']") 
    private WebElement pageTitle;

    public void sortAndAddProduct() {
        // sorting by Price (high to low)
        Select select = new Select(sortDropdown);
        select.selectByValue("hilo"); 

        // add the highest priced item directly using ID
        addJacketBtn.click();
        
        cartBtn.click();
    }
}