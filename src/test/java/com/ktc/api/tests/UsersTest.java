package com.ktc.api.tests;

import com.ktc.ProviderModel;
import com.ktc.RestAssuredConfig;
import com.ktc.UserModel;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;

public class UsersTest extends RestAssuredConfig {


    @Test
    public void getAllUsers(){

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
                .body("firstName",equalTo("Administrative"))
                .body("lastName",equalTo("User"))
                .body("role",equalTo(4))
                .body("id",equalTo(1));
    }
    int providerId = 0;

    @Test
    public void PostUser_ValidRequiredProviderInput_ProviderRecordIsCreated200() {

        String accessToken = auth_CorrectCreds_ReturnToken("preauthadmin@knowthecosts.com", "knowthecost", "ktc-client",  "ktc-secret");

        String addy = "123" + randomNumericString(2)+" W. Ford Dr";
        String zip = "852" + randomNumericString(3);;
        String email = "email"+ randomString(5)+"@internet.com";
        String name = "Provider" + randomNumericString(3);

        UserModel user = new UserModel("12345678",email,"James",name,true,1);

        int id = given()
                .auth().oauth2(accessToken)
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("/users")
                .prettyPeek()
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 ")
                .extract()
                .path("id");

        given()

                .pathParam("id", id)
                .auth().oauth2(accessToken)
                .contentType(ContentType.JSON)
                .when()
                .get("/users/{id}")
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 ")

        ;

    }



}
