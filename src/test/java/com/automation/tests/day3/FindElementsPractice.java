package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsPractice {
    public static void main(String[] args) throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
        // this above is the same as below, just created in different class and called under DriverFactory
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");
        // we need to use locater of Name and Email field from the above url
        Thread.sleep(1000);
        WebElement fullName = driver.findElement(By.name("full_name"));
        fullName.sendKeys("Chick-fil-A");
        Thread.sleep(2000);
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("chicken@fil.a");
        Thread.sleep(2000);
        WebElement signUp = driver.findElement(By.name("wooden_spoon"));
        // when you see type="submit", you can use submit() instead of click()
        // it makes sense to use when click() method doesn't work
        //signUp.click();
        signUp.submit();
        Thread.sleep(2000);
        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        WebElement message = driver.findElement(By.className("subheader"));
        String actual = message.getText();
        if(actual.equals(expected)){
            System.out.println("Test Passed!");
        }else{
            System.out.println("Test FAILED!");
        }
        driver.quit(); // to close Chrome
    }
}
