package com.aartiparmar.ex04_Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class APITesting024_RestAssured_TestNG_AssertJ_Assertions {
    @Test
    public void test_POST() {
        System.out.println("Test01");

        String payload_POST="{\n" +
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

        RequestSpecification r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking");
        r.contentType(ContentType.JSON).log().all();
        r.body(payload_POST);

        Response response1=r.when().log().all().post();

        //Get validatable response to perform validation
        ValidatableResponse validatableResponse=response1.then().log().all();
        validatableResponse.statusCode(200);

        //Rest assured-> import org.hamcrest.Matchers;
        //Matchers.equalTo
        validatableResponse.body("bookingid", Matchers.notNullValue()); //https://jsonpathfinder.com/
        validatableResponse.body("booking.firstname", Matchers.equalTo("Jim"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("Brown"));
        validatableResponse.body("booking.depositpaid", Matchers.equalTo(true));

        Integer bookingid = response1.then().extract().path("bookingid");
        String firstname = response1.then().extract().path("booking.firstname");
        String lastname = response1.then().extract().path("booking.lastname");

        //TestNG Assertions
        Assert.assertNotNull(bookingid);
        Assert.assertEquals(firstname,"Jim");
        Assert.assertEquals(lastname, "Brown");

        //AssertJ Assertions- 3rd party library
        assertThat(bookingid).isNotNull().isNotZero().isPositive();
        assertThat(firstname).isEqualTo("Jim").isNotEmpty().isNotNull().isAlphanumeric().isNotBlank();
        
    }
}
