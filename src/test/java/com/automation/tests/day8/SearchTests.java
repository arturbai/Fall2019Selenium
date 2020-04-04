package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests {
    private WebDriver driver;

    @Test
    public void googleSearchTest() {
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
        BrowserUtils.wait(3);
        List<WebElement> searchItems = driver.findElements(By.tagName("h3"));
        for (WebElement eachJava : searchItems) {
            String var = eachJava.getText();
            //if there is a text - print it
            if (!var.isEmpty()) {
                System.out.println(var);
                //verify that every search result contains java
                Assert.assertTrue(var.toLowerCase().contains("java"));
                System.out.println(var.toLowerCase());
                System.out.println();
            }

        }
    }
    /**
     * Given user is on the amazon.com page
     * When user enters "java" as a search item
     * Then user clicks on the search button
     * And user clicks on the first search item
     * And user verifies that title of the search item contains "Java"
     */
    @Test(description = "Search for Java book on Amazon")
    public void amazonSearchTest(){
        driver.get("http://amazon.com");
        BrowserUtils.wait(3);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        BrowserUtils.wait(3);
        //find all links inside h2 elements
        List<WebElement> searchItems = driver.findElements(By.xpath("//h2//a"));
        // click on the first item
        for(WebElement searchItem : searchItems){
            System.out.println(searchItem.getText());
        }
        searchItems.get(0).click();
        BrowserUtils.wait(3);
        WebElement productTitle = driver.findElement(By.id("productTitle"));
        String productTitleString = productTitle.getText();
        System.out.println(productTitleString);
        Assert.assertTrue(productTitleString.contains("Java"));

        //so h2 elements are not clickable, even though they contain links
        //that's why, instead of collection all h2 elements
        //we collected all hyperlinks
        //every hyperlink represent some search item


    }

    @BeforeMethod
    public void setup() {
        //setup WebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown() {
        // close browser amd destroy webDrvier object
        driver.quit();
    }
}
