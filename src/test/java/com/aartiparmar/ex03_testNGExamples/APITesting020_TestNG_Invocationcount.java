package com.aartiparmar.ex03_testNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting020_TestNG_Invocationcount {

    @Test(invocationCount = 5)
    public void test01() {
        Assert.assertTrue(true);
    }
}
