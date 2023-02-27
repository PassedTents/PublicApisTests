package com.passedtents;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
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
        given().log().all().
        when().
            get("/entries").
        then().log().all().
            statusCode(200);
    }
}
