package com.ktc.api.tests;

import com.ktc.RestAssuredConfig;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

//PRTR-155 As system I want to validate if procedure codes (CPT) are KTC accepted so I can confirm it meets our codes criteria set within administration

public class ProcedureCodesTest extends RestAssuredConfig {
    @Test
    public void getAllConversions() {

        String accessToken = auth_CorrectCreds_ReturnToken("preauthadmin@knowthecosts.com", "knowthecost", "ktc-client",  "ktc-secret");

        given()
                .auth().oauth2(accessToken)
                .contentType(ContentType.JSON)
                .when()
                .get("/procedures")
                .prettyPeek()
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 ");
    }
}