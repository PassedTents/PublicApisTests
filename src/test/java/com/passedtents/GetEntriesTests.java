package com.passedtents;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GetEntriesTests {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "http://api.publicapis.org";
    }

    @Test
    public void happyPathGetEntries() {
       Response response =  given().log().all().
        when().
            get("/entries").
        then().log().all().
        extract().response();
       
       assertEquals(response.statusCode(), 200);
       assertNotNull(response.getBody());
    }
}
