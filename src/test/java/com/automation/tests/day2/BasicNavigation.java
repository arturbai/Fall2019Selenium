package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) {
        // to start selenium script we need
        // setup WebDriver (browser driver) and create WebDriver object
        WebDriverManager.chromedriver().setup();
      //  ChromeDriver driver = new ChromeDriver();
        WebDriver driver = new ChromeDriver(); // this applies to all browsers
        // in selenium everything starts from WebDriver interface
        driver.get("http://google.com"); // to open Google Chrome
    }
}
