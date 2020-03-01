package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws Exception {
        // to start selenium script we need
        // setup WebDriver (browser driver) and create WebDriver object
        WebDriverManager.chromedriver().setup();
        //  ChromeDriver driver = new ChromeDriver();
        WebDriver driver = new ChromeDriver(); // this applies to all browsers
        // in selenium everything starts from WebDriver interface
        driver.get("http://google.com"); // to open Google Chrome
        Thread.sleep(3000); // to wait 3 seconds
        String title = driver.getTitle(); // returns <title> Some title</title>
        System.out.println("Title is: " + title);
        String expectedTitle = "Google";
        if (expectedTitle.equals(title)) {
            System.out.println("Test PASSED!");
        } else {
            System.out.println("Test FAILED!");
        }

        driver.close(); // to close browser
    }
}
