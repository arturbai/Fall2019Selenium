package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.*;

public class FindElementByID {
    public static void main(String[] args) throws Exception {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");
        Thread.sleep(1000);
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        Thread.sleep(1000);
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        // or
        //   WebElement password = driver.findElement(By.name("password"));
        //   password.sendKeys("SuperSecretPassword");
        Thread.sleep(1000);
        WebElement login = driver.findElement(By.id("wooden_spoon"));
        login.click();
        // or
        //   driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(2000);
        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        // WebElement message = driver.findElement(By.className("subheader"));
        String actual = driver.findElement(By.tagName("h4")).getText();
        if (expected.equals(actual)) {
            System.out.println("Test PASSED!");
        } else {
            System.out.println("Test FAILED!!");
        }
        // driver.findElement(By.linkText("Logout")).click();
        
        //let's click on Logout button. It looks like a button, but it's actually a link
        //every element with <a> tag is a link
        //if you have couple spaces in the text, just use partialLinkText instead of linkText
        //linkText - equals()
        //partialLinkText - contains() - complete match doesn't required
        //don't put space
        WebElement logout = driver.findElement(By.partialLinkText("Logout"));
        String href = logout.getAttribute("href");
        String className = logout.getAttribute("class");
        System.out.println(href);
        System.out.println(className);
        logout.click();
        Thread.sleep(2000);
        //let's enter invalid credentials
        driver.findElement(By.name("username")).sendKeys("wrong");
        driver.findElement(By.name("password")).sendKeys("wrong");
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(2000);
        WebElement errorMessage = driver.findElement(By.id("flash-messages"));
        System.out.println(errorMessage.getText());
        Thread.sleep(2000);
        driver.quit();
    }
}
