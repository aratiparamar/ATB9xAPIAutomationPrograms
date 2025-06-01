package com.aartiparmar.ex03_testNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting016_TestNG_DependsOnMethod {

    @Test
    public void serverStartedOk() {
        System.out.println("Server started ok");
        System.out.println("I will run first");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "serverStartedOk")
    public void method1() {
        System.out.println("Method1");
        Assert.assertTrue(true);
    }
    @Test(dependsOnMethods = "serverStartedOk")
    public void method2() {
        System.out.println("Method2");
        Assert.assertTrue(true);
    }
}
