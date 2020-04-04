package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGTests {
    @BeforeSuite
    public void beforeTest() {
        System.out.println("Before TEST");
    }

    @AfterSuite
    public void afterTest() {
        System.out.println("After Test");
    }

    //runs before every test automatically
    //works as pre-condition or setup
    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After class");
    }

    @BeforeMethod
    public void setup() {
        System.out.println("Before  Method");
    }

    //runs automatically after vey test
    @AfterMethod
    public void teardown() {
        System.out.println("After method");
    }

    @Test(description = "To verify is test reverse String works")
    public void test1() {
        System.out.println("Test 1");
        String expected = "apple";
        String actual = "apple";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void test2() {
        System.out.println("Test 2");
        int num1 = 15;
        int num2 = 10;
        Assert.assertTrue(num1 > num2);
    }
}
