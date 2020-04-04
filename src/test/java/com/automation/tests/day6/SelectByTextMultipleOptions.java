package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByTextMultipleOptions {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);
        Select languagesSelect = new Select(driver.findElement(By.name("Languages")));
        // Whether this select element support selecting multiple options at the same time
        // This is done by checking the value of the "multiple" attribute.
        boolean isMultiple = languagesSelect.isMultiple();
        System.out.println(isMultiple);
        languagesSelect.selectByVisibleText("Java");
        languagesSelect.selectByVisibleText("C#");
        languagesSelect.selectByVisibleText("C");
        // how we can verify if all above options were selected?
        // get all selected options
        List<WebElement> selectedLanguages = languagesSelect.getAllSelectedOptions();
        for (WebElement eachSelectedLang : selectedLanguages) {
            System.out.println(eachSelectedLang.getText());
        }
        BrowserUtils.wait(3);

        languagesSelect.deselectByVisibleText("Java"); // to unselect one element
        languagesSelect.deselectAll(); // to deselect all

        BrowserUtils.wait(3);
        driver.quit();
    }
}
