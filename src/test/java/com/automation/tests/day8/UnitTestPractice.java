package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestPractice {
    public static void main(String[] args) {
        // unit test
        // to check if our method wor
        //
        //
        String expected = "cba";
        String toReverse = "abc";
        String actual = reverseString(toReverse);
    }

    // annotation
    @Test(description = "Verify of method can reverse a string")
    public void test() {
        String expected = "elpopa";
        String actual = reverseString("apple");
        //it;s coming from TestNG, JUnit also has this class
        //you can compare any data types: string, primitives, arrays, objects
        //to verify is expected result equals to actual
        Assert.assertEquals(actual, expected);
    }

    @Test(description = "Verify of method can reverse a string")
    public void test2(){
        String expected = "rimA";
        String actual = reverseString("Amir");
        Assert.assertEquals(actual, expected);
    }

    public boolean verifyEquals(String expected, String actual) {
        if (expected.equals(actual)) {
            System.out.println("Test passed!");
            return true;
        } else {
            System.out.println("Test FAILED!!");
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
            return false;
        }
    }

    /**
     * This method stands for reversing strings.
     *
     * @param str to reverse
     * @return reversed string
     */
    public static String reverseString(String str) {
        String reversed = "";
        for (int x = str.length() - 1; x >= 0; x--) {
            reversed += str.charAt(x);
        }
        return reversed;
    }
}
