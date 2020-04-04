package com.automation.tests.warmup;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class March4 {
    static WebDriver driver;

    public static void main(String[] args) throws Exception {
        ebayTest();
        amazonTest();
        wikiTest();
    }

    public static void ebayTest() {
        /*
         *Go to ebay enter search term click on search button
         * print number of results
         */
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://www.ebay.com/");
        driver.findElement(By.id("gh-ac")).sendKeys("Java book");
        driver.findElement(By.id("gh-btn")).click();
        WebElement searchResults = driver.findElement(By.tagName("h1"));
        System.out.println(searchResults.getText().split(" ")[0]);
        driver.quit();
    }

    /**
     * go to amazon
     * Go to ebay
     * enter search term
     * click on search button
     * verify title contains search term
     */
    public static void amazonTest() {
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java book", Keys.ENTER);
        String title = driver.getTitle();
        if (title.contains("Java book")) {
            System.out.println("Amazon Test Passed!");
        } else {
            System.out.println("Amazon Test FAILED!!");
        }
        driver.quit();

    }

    /**
     * Go to wikipedia.org
     * enter search term `selenium webdriver`
     * click on search button
     * click on search result `Selenium (software)`
     * verify url ends with `Selenium_(software)`
     */
    public static void wikiTest() throws Exception {
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://wikipedia.org");
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver", Keys.ENTER);
        driver.findElement(By.linkText("Selenium (software)")).click();
        Thread.sleep(2000);
        String link = driver.getCurrentUrl();
        if (link.endsWith("Selenium_(software)")) {
            System.out.println("Wiki Test Passed!");
        } else {
            System.out.println("Wiki Test Failed!");
        }

        driver.quit();
    }
}
