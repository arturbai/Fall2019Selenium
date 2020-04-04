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
        driver.manage().window().maximize(); // to maximize browser
        Thread.sleep(3000); // to wait 3 seconds
        String title = driver.getTitle(); // returns <title> Some title</title>
        System.out.println("Title is: " + title);
        String expectedTitle = "Google";
        if (expectedTitle.equals(title)) {
            System.out.println("Test PASSED!");
        } else {
            System.out.println("Test FAILED!");
        }
        //go to another website within the same window
        driver.navigate().to("http://amazon.com");
        Thread.sleep(3000); // for demo wait 3 sec
        if (driver.getTitle().toLowerCase().contains("amazon")) {
            System.out.println("TEST PASSED!");
        } else {
            System.out.println("FAILED!");
        }

        //come back to google
        driver.navigate().back();
        Thread.sleep(3000); // for demo wait 3 sec

        // checking if page title is equal to Google
        // .getTitle() - returns page title
        verifyEquals(driver.getTitle(), "Google");
        //move forward in the browser history
        //again, going to amazon
        driver.navigate().forward();
        Thread.sleep(3000); // for demo wait 3 sec

        System.out.println("Title: " + driver.getTitle());
        //driver.getTitle() - returns page title of the page that is currently opened
        //to get URL
        System.out.println("URL: " + driver.getCurrentUrl());
        driver.navigate().refresh(); // to reload page
        Thread.sleep(3000); // for demo wait 3 sec

        //driver.navigate().to() = driver.get()
        //must be at the end
        driver.close(); // to close browser
        //browser cannot close itself
    }
    /**
     * Check if to strings are same. If print TEST PASSED! message.
     * Otherwise, print TEST FAILED message
     * @param arg1
     * @param arg2
     */

    public static void verifyEquals(String arg1, String arg2) {
        if (arg1.equals(arg2)) {
            System.out.println("TEST PASSED!");
        } else {
            System.out.println("TEST FAILED!");
        }
    }
}