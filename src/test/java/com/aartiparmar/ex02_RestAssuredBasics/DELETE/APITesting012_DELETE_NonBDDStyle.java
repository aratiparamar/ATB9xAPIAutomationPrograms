package com.aartiparmar.ex02_RestAssuredBasics.DELETE;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting012_DELETE_NonBDDStyle {
    RequestSpecification requestSpecification;

    //token, booking id

    //public void get_token(){}
    //public void get_booking_id(){}

    @Description("Verify the Delete request restful booker")
    @Test
    public void test_PATCH_NonBDDStyle(){
        String token="139691f62e69ddf";
        //String token="abc";
        String bookingId="2307";


        RequestSpecification r=RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingId);
        r.contentType(ContentType.JSON);
        r.cookie("token",token);

        Response response1=r.when().log().all().delete();
        ValidatableResponse vr=response1.then().log().all();
        vr.statusCode(201);
    }




}
