package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByIndex {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByIndex(33);

        List<WebElement> stateIndex = stateSelect.getOptions();
        int count = 0;
        for (WebElement eachIndexState : stateIndex) {
            count++;
            System.out.println(count + " = " + eachIndexState.getText());
        }

        //select last option
        stateSelect.selectByIndex(stateSelect.getOptions().size() - 1);

        BrowserUtils.wait(3);
        driver.quit();
    }
}
