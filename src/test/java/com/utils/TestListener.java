package com.utils;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
	
	// this method automatically runs whenever test fails
    public void onTestFailure(ITestResult result) {
        File src = ((TakesScreenshot) DriverUtils.createDriver()).getScreenshotAs(OutputType.FILE);
        try {
            String fileName = result.getName() + "_" + System.currentTimeMillis() + ".png";
            FileUtils.copyFile(src, new File("./screenshots/" + fileName));
            System.out.println("Screenshot captured on failure: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // runs immediately when a test method begins execution
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
    }

    // runs only if method executed successfully
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
    }
}