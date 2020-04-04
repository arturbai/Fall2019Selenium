package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NoSelectOptions {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        driver.findElement(By.id("dropdownMenuLink")).click(); // to expand dropDown
        BrowserUtils.wait(2);


        //to call all links
        List<WebElement> allLinks = driver.findElements(By.className("dropdown-item"));
        for (WebElement eachLink : allLinks) {
            System.out.println(eachLink.getText() + " : " + eachLink.getAttribute("href"));
        }
        BrowserUtils.wait(3);
        driver.findElement(By.linkText("Yahoo")).click(); // click on selected option
        BrowserUtils.wait(4);
        driver.quit();
    }
}
