package com.aartiparmar.ex01_SampleCheck;

public class APITesting004_BuilderPatternDesignPattern {
    public APITesting004_BuilderPatternDesignPattern step1() {
        System.out.println("Step 1");
        return this;
    }

    public APITesting004_BuilderPatternDesignPattern step2() {
        System.out.println("Step 2");
        return this;
    }

    public APITesting004_BuilderPatternDesignPattern step3(String param1) {
        System.out.println("Step 3");
        return this;
    }

    public static void main(String[] args) {
        APITesting004_BuilderPatternDesignPattern np = new APITesting004_BuilderPatternDesignPattern();
        np.step1().step2().step3("Aarti");
    }
}
