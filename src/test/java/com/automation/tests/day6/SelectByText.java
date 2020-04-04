package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        //create a webElement object for drop-down first
        WebElement simpleDropDown = driver.findElement(By.id("dropdown"));
        // provide webElement object into constructor
        Select selectSimpleDropDown = new Select(simpleDropDown);
        // select by visible text
        selectSimpleDropDown.selectByVisibleText("Option 2");
        BrowserUtils.wait(3);
        // and select Option 1
        selectSimpleDropDown.selectByVisibleText("Option 1");

        // select your DOB
        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMoth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));

        selectDay.selectByVisibleText("1");
        selectMoth.selectByVisibleText("April");
        selectYear.selectByVisibleText("1990");

        BrowserUtils.wait(5);

        // select all month one by one
        // .getOptions(); - returns all options from dropdown as List<WebElement>
        List<WebElement> months = selectMoth.getOptions();
        for (WebElement eachMonth : months) {
            // get the month name and select based on that
            String monthName = eachMonth.getText();
            selectMoth.selectByVisibleText(monthName);
            BrowserUtils.wait(1);
        }

        BrowserUtils.wait(3);

        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByVisibleText("Texas");

        //option that is currently selected
        // getFirstSelectedOption() -- returns a webElement, that 's why we need to call getText
        // getText() retrieves visible text from the webElement
        String selected = stateSelect.getFirstSelectedOption().getText();
        if (selected.equals("Texas")) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test failed!!");
        }
        BrowserUtils.wait(2);

        List<WebElement> states = stateSelect.getOptions();
        for(WebElement eachS : states){
            System.out.println(eachS.getText());
        }

        driver.quit();

    }
}
