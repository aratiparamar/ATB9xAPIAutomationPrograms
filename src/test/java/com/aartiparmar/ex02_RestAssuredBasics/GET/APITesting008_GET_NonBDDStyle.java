package com.aartiparmar.ex02_RestAssuredBasics.GET;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting008_GET_NonBDDStyle {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Description ("Verify the GET req positive")
    @Test
    public void test_GET_NonBDDStyle(){
        String pin_code="560016";
        //Rest Assured interfaces
        r=new RestAssured().given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+pin_code);

        response=  r.when().log().all().get();

        vr=response.then().log().all().statusCode(200);
    }

    @Description ("Verify the GET req negative: -1 Invalid input") // added to allure report
    @Test
    public void test_GET_NonBDDStyle_Negative(){
        String pin_code="-1";
        //Rest Assured interfaces
        r=new RestAssured().given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+pin_code);

        response=  r.when().log().all().get();

        vr=response.then().log().all().statusCode(404);
    }



}
