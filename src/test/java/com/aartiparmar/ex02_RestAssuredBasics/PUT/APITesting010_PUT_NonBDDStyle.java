package com.aartiparmar.ex02_RestAssuredBasics.PUT;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting010_PUT_NonBDDStyle {
    RequestSpecification requestSpecification;

    //token, booking id

    //public void get_token(){}
    //public void get_booking_id(){}

    @Description("Verify the put request restful booker")
    @Test
    public void test_PUT_NonBDDStyle(){
        String token="1c084890ed9e2fc";
        //String token="abc";
        String bookingId="1337";
        String Payload="{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        RequestSpecification r=RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingId);
        r.contentType(ContentType.JSON);
        r.cookie("token",token);
        r.body(Payload);

        Response response1=r.when().log().all().put();
        ValidatableResponse vr=response1.then().log().all();
        vr.statusCode(200);
    }




}
