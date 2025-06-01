package com.aartiparmar.ex04_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITesting022_TestNG_Assertions {
        @Test

        public void test_hardAssertExample() {
                System.out.println("Start of the program");
                Boolean is_neeru_male=false;
                Assert.assertTrue(is_neeru_male);
                System.out.println("End of the program");

                Assert.assertEquals("Aarti","Aarti");
                Assert.assertEquals("Aarti","aarti");
        }

        @Test
        public void test_softAssertExample() {
                SoftAssert softAssert = new SoftAssert();
                softAssert.assertTrue(false);
                System.out.println("This line will be executed");
                softAssert.assertAll();
        }
}
