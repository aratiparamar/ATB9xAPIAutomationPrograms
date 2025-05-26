package com.aartiparmar.ex01_SampleCheck;

import io.restassured.RestAssured;

public class APITesting002 {
    public static void main(String[] args) {
        //Gherkin Syntax
        //Given() - Precondition-> URL,Headers, Auth, Body...
        //When() - Action-> HTTP Method- GET/POST/PUT/PATCH/DELETE...
        //Then() - Assertion/validation-> 200 ok, firstname==aarti

        //Full URL: https://api.zippopotam.us/IN/560003
        //Base URI: https://api.zippopotam.us
        //Base Path: /IN/560003
        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/560003")
                .when()
                    .get()
                .then()
                    .log().all().statusCode(200);
                    //.log().all();
    }
}
