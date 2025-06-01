package com.aartiparmar.ex03_testNGExamples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITesting017_TestNG_Parameters {

    @Parameters("browser")
    @Test
    public void demo1(String value){
        System.out.println("Browser is:"+value);
        //Open browser and select dadsa
        if(value.equalsIgnoreCase("chrome")){
            System.out.println("Start my testing chrome");
        }
        if(value.equalsIgnoreCase("firefox")){
            System.out.println("Start my Firefox");
        }
    }
}
