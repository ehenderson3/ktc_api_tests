package com.ktc.api.tests;

import com.ktc.ProviderModel;
import com.ktc.RestAssuredConfig;
import com.ktc.ThirdPartyAdminModel;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;

public class ThridPartyAdministratorsTest extends RestAssuredConfig {

    @Test
    public void PostThirdPartyAdministrators_ValidRequiredTPAInput_ProviderRecordIsCreated200() {

        String accessToken = auth_CorrectCreds_ReturnToken("preauthadmin@knowthecosts.com", "knowthecost", "ktc-client",  "ktc-secret");

        ThirdPartyAdminModel tpa = new ThirdPartyAdminModel("","","","",12345,"","","","","",true);

        int id = given()
                .auth().oauth2(accessToken)
                .contentType(ContentType.JSON)
                .body(tpa)
                .when()
                .post("/thirdPartyAdministrators")
                .prettyPeek()
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 ")
                .body("city", is(tpa.getCity()))
                .body("email", is(tpa.getPrimaryEmail()))
                .extract()
                .path("id");

        given()

                .pathParam("id", id)
                .auth().oauth2(accessToken)
                .contentType(ContentType.JSON)
                .when()
                .get("/thirdPartyAdministrators/{id}")
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 ")
                .body("city", is(tpa.getCity()))
                .body("email", is(tpa.getPrimaryEmail()))
        ;

    }

    // PRTR-290  (Back-End) As admin I would like to CRUD a TPA contact
    @Test
    public void getAllThirdPartyAdministrators(){

        String accessToken = auth_CorrectCreds_ReturnToken("preauthadmin@knowthecosts.com", "knowthecost", "ktc-client",  "ktc-secret");

        given()
                .auth().oauth2(accessToken)
                .contentType(ContentType.JSON)
                .when()
                .get("/thirdPartyAdministrators")
                .prettyPeek()
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 ")
                .body("id[0]",equalTo(1))
                .body("language[0]",equalTo(1));
    }

}
