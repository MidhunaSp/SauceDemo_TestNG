package com.utils;

import java.time.Duration;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverUtils {
  private static WebDriver driver;
  
  public static WebDriver createDriver() {
	  if(driver==null) {
		  WebDriverManager.chromedriver().setup();
		  ChromeOptions options=new ChromeOptions();
	      options.addArguments("--guest");
		  driver=new ChromeDriver(options);
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  }
	  return driver;
  }
  
  public static void quitDriver() {
	  if(driver!=null) {
		  driver.quit();
		  driver=null;
	  }
  }
  
  // conditional wait for the elements to appear in the webpage
  public static void waitForElement(WebElement element) {
	  new WebDriverWait(createDriver(),Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
  }

}
