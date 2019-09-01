package com.ktc.api.tests;

import com.ktc.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AuthTest extends RestAssuredConfig {

    @Test
    public void getAllUser(){

        String accessToken = auth_CorrectCreds_ReturnToken("preauthadmin@knowthecosts.com", "knowthecost", "ktc-client",  "ktc-secret");

        given()
                .auth().oauth2(accessToken)
                .contentType(ContentType.JSON)
                .when()
                .get("/user")
                .prettyPeek()
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 ")
                .body("active",equalTo(true))
                .body("email",equalTo("preauthadmin@knowthecosts.com"))
                .body("firstName",equalTo("Administrative"));
    }

    @Test
    public void getFirstUsers(){

        String accessToken = auth_CorrectCreds_ReturnToken("preauthadmin@knowthecosts.com", "knowthecost", "ktc-client",  "ktc-secret");

        given()
                .auth().oauth2(accessToken)
                .contentType(ContentType.JSON)
                .when()
                .pathParam("id","1")
                .get("/users/{id}")
                .prettyPeek()
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 ")
                .body("active",equalTo(true))
                .body("email",equalTo("preauthadmin@knowthecosts.com"))
                .body("firstName",equalTo("Administrative"));
    }
}