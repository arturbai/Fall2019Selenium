package com.automation.tests.day10;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsIntro {
    private WebDriver driver;
    private Actions actions;
    private By viewProfile3 = By.xpath("//h5[text()='name: user3']");

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        actions = new Actions(driver);
    }

    @Test
    public void hoverOnImage() throws Exception {
        driver.get("http://practice.cybertekschool.com/hovers");
        Thread.sleep(3000);
        driver.manage().window().maximize();
        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));

        //build() is needed when you have couple of actions
        //always end with perform()  ---- perform is action, it is not a CLICK!!!!
        actions.moveToElement(img1).
                pause(1000).
                moveToElement(img2).
                pause(1000).
                moveToElement(img3).
                build().perform();
        Thread.sleep(3000);
        //hover on the third img and verify that "name: user" is displayed
        //hover over image to make text visible use action first
        actions.moveToElement(img3).perform();
        WebElement imgText1 = driver.findElement(viewProfile3);
        //verify that WEbElement contains the text is visible
        Assert.assertTrue(imgText1.isDisplayed());

        //move to thee second image
        actions.moveToElement(img2).perform();
        WebElement imgText2 = driver.findElement(By.xpath("//h5[text()='name: user2']"));
        Assert.assertTrue(imgText2.isDisplayed());
    }

    @Test
    public void jqueryMenuTest() throws Exception {
        driver.get("http://practice.cybertekschool.com/jqueryui/menu#");
        /**
         * Task
         * hover on ENABLE > Downloads > click on PDF
         */
        Thread.sleep(3000);
        driver.manage().window().maximize();
        WebElement enable = driver.findElement(By.id("ui-id-3"));
        WebElement downloads = driver.findElement(By.id("ui-id-4"));
        WebElement pdf = driver.findElement(By.id("ui-id-6"));
        actions.moveToElement(enable).
                pause(1000).
                moveToElement(downloads).
                pause(1000).
                moveToElement(pdf).
                build().perform();
        Thread.sleep(3000);
    }

    @Test
    public void dragAndDropTest() throws Exception {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement earth = driver.findElement(By.id("droptarget"));
        WebElement moon = driver.findElement(By.id("draggable"));
        actions.dragAndDrop(moon, earth).perform();
        Thread.sleep(2000);

        String expected = "You did great!";
        String actual = earth.getText();
        Assert.assertEquals(actual, expected);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
