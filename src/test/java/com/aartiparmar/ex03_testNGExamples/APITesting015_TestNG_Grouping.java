package com.aartiparmar.ex03_testNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting015_TestNG_Grouping {

        @Test(groups={"sanity","QA","prod","P0"})
        public void sanityRun(){
            System.out.println("Sanity");
            System.out.println("QA");
            Assert.assertTrue(true);
        }
        @Test(groups={"Reg","P1"})
         public void RegRun(){
            System.out.println("Reg");
            Assert.assertTrue(false );
         }
        @Test(groups={"QA","P0"})
        public void SmokeRun(){
            System.out.println("Smoke");
            Assert.assertTrue(false );
        }

}
