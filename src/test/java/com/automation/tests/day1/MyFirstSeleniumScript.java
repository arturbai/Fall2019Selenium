package com.automation.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSeleniumScript {
    public static void main(String[] args) {
        // 1st we will set up chromeDriver
        WebDriverManager.chromedriver().setup();
        // create chromeDriver object
        ChromeDriver driver = new ChromeDriver();
        // open some website
        driver.get("http://google.com");
    }
}
