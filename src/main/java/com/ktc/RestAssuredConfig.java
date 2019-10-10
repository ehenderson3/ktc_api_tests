package com.ktc;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeSuite;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class RestAssuredConfig {

    @BeforeSuite(alwaysRun = true)
    public static void init(){
        RestAssured.baseURI = "http://staging-api.thriveglobal.com/v1/analytics";
    }

    public static String auth_CorrectCreds_ReturnToken(String userName,String password,String clientId,String clientSecret) {

        String response = given()
                .params("username", userName, "password", password,
                        "grant_type", "password", "scope", "read",
                        "client_id", clientId, "client_secret", clientSecret)
                .auth()
                .preemptive()
                .basic("ktc-client","ktc-secret")
                .when()
                .when()
                .post("/oauth/token")
                .asString();

        JsonPath jsonPath = new JsonPath(response);
        String accessToken = jsonPath.getString("access_token");
        return accessToken;

    }


    public static String randomString(int i) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < i) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    public static String randomNumericString(int i) {
        String SALTCHARS = "1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < i) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }


}
