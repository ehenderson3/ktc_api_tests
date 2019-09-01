package com.ktc.api.tests;

import com.ktc.RestAssuredConfig;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ConversionsTest extends RestAssuredConfig {
    @Test
    public void getAllConversions(){

        String accessToken = auth_CorrectCreds_ReturnToken("preauthadmin@knowthecosts.com", "knowthecost", "ktc-client",  "ktc-secret");

        given()
                .auth().oauth2(accessToken)
                .contentType(ContentType.JSON)
                .when()
                .get("/conversions")
                .prettyPeek()
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 ")
                .body("id[0]",equalTo(1))
                .body("appointment.id[0]",equalTo(1))
                .body("appointment.patient.id[0]",equalTo(1))
                .body("appointment.patient.first_name[0]",equalTo("Bob"));


    }


}
