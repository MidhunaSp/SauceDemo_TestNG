package com.pom;

import org.openqa.selenium.support.PageFactory;

import com.utils.DriverUtils;

public class BasePage {
    public BasePage(){
    	      PageFactory.initElements(DriverUtils.createDriver(),this);
    }
}
