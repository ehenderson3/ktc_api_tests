package com.ktc.api.tests;

import com.ktc.RestAssuredConfig;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
//import jdk.internal.jline.internal.TestAccessible;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;


public class ScriptsTest extends RestAssuredConfig {




    @Test
    public void getAllScripts(){

      String accessToken = auth_CorrectCreds_ReturnToken("preauthadmin@knowthecosts.com", "knowthecost", "ktc-client",  "ktc-secret");

      given()
              .auth().oauth2(accessToken)
              .contentType(ContentType.JSON)
              .when()
              .get("/scripts")
              .prettyPeek()
              .then()
              .statusCode(200)
              .statusLine("HTTP/1.1 200 ")
              .body("id[0]",equalTo(52))
              .body("language[0]",equalTo(0));
    }

    @Test
    public void getAllEnglishScripts(){

        String accessToken = auth_CorrectCreds_ReturnToken("preauthadmin@knowthecosts.com", "knowthecost", "ktc-client",  "ktc-secret");

        given()
                .auth().oauth2(accessToken)
                .contentType(ContentType.JSON)
                .when()
                .get("/scripts")
                .prettyPeek()
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 ")
                .body("id[0]",equalTo(52))
                .body("language[0]",equalTo(0));
    }


}
