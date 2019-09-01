package com.ktc.api.tests;

import com.ktc.ProviderModel;
import com.ktc.RestAssuredConfig;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.Random;

import static com.ktc.RestAssuredConfig.auth_CorrectCreds_ReturnToken;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class ProviderTest extends RestAssuredConfig {

    //String providerId = null;
    private Random rndNum = new Random();
    private int randomNumber1 = rndNum.nextInt(1000);

    @Test
    public void PostProvider_ValidRequiredProviderInput_ProviderRecordIsCreated200() {

        String accessToken = auth_CorrectCreds_ReturnToken("preauthadmin@knowthecosts.com", "knowthecost", "ktc-client", "ktc-secret");

        String addy = "123" + randomNumericString(2) + " W. Ford Dr";
        String zip = "852" + randomNumericString(3);
        ;
        String email = "email" + randomString(5) + "@internet.com";
        String name = "Provider" + randomNumericString(3);
        String npi = "Prov" + randomString(5);
        String phone = "480696" + randomNumericString(4);
        String state = "AZ";

        ProviderModel project = new ProviderModel("Mesa", email, name, npi, phone, true, "AZ", npi, "", "", "");

        int id = given()
                .auth().oauth2(accessToken)
                .contentType(ContentType.JSON)
                .body(project)
                .when()
                .post("/providers")
                .prettyPeek()
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 ")
                .body("city", is(project.getCity()))
                .body("email", is(project.getEmail()))
                .extract()
                .path("id");

        given()

                .pathParam("id", id)
                .auth().oauth2(accessToken)
                .contentType(ContentType.JSON)
                .when()
                .get("/providers/{id}")
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 ")
                .body("city", is(project.getCity()))
                .body("email", is(project.getEmail()))
                .body("phoneNumber", is(project.getPhoneNumber()))

        ;

    }

    @Test
    public void getSingleSiteSearch_SearchCriteriaSiteNameuniqueSite100_ResultsetContainsSiteNameuniqueSite100() {
        String addy = "123" + randomNumericString(2) + " W. Ford Dr";
        String zip = "852" + randomNumericString(3);
        ;
        String email = "email" + randomString(5) + "@internet.com";
        String name = "Provider" + randomNumericString(3);
        String npi = "Prov" + randomString(5);
        String phone = "480696" + randomNumericString(4);
        String state = "AZ";


        ProviderModel project = new ProviderModel("Mesa", email, name, npi, phone, true, "AZ", npi, "", "", "");

       /* projectId = given()
                .contentType(ContentType.JSON)
                .body(project)
                .when()
                .put("/projects")
                .then()
                .statusCode(201)
                .body("entity.projectName", Matchers.is(project.getProjectName()))
                .body("entity.projectType", equalTo(project.getProjectType()))
                .extract()
                .path("entity.projectId");

        JSONObject pathDetailsJson = new JSONObject();
        JSONArray segmentsArray = new JSONArray();
        JSONArray segmentEndsArray = new JSONArray();
        JSONObject segmentEndJson1 = new JSONObject();
        JSONObject segmentEndJson2 = new JSONObject();
        JSONObject segment = new JSONObject();

        try {
            segmentEndJson1.put("callSign", "KA2071");
            segmentEndJson1.put("elevation", 11.11);
            segmentEndJson1.put("latitude", 71);
            segmentEndJson1.put("longitude", 22.22);
            segmentEndJson1.put("siteName", "uniqueSite100");

            segmentEndJson2.put("asr", "1000037");
            segmentEndJson2.put("elevation", 12.12);
            segmentEndJson2.put("latitude", 80);
            segmentEndJson2.put("longitude", 23.23);
            segmentEndJson2.put("siteName", "uniqueSite101");

            pathDetailsJson.put("projectId", projectId);
            pathDetailsJson.put("bandId", 2);
            pathDetailsJson.put("pathName", "Test Path 1");

            segmentEndsArray.put(segmentEndJson1);
            segmentEndsArray.put(segmentEndJson2);

            segment.put("segmentEnds", segmentEndsArray);
            segmentsArray.put(segment);
            pathDetailsJson.put("segments", segmentsArray);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.out.println("jsonPath = " + pathDetailsJson);

        pathId = given()
                .contentType(ContentType.JSON)
                .body(pathDetailsJson.toString())
                .when()
                .post("/paths")
                .prettyPeek()
                .then()
                .extract()
                .path("entity.pathId");

        String valueVal = "uniqueSite100";
        String fieldVal = "siteName";
        String operatorVal = "EQ";

        given().urlEncodingEnabled(false)
                .when()
                .log().all()
                .get("/sites?search=%5B%7B" +
                        "%22value%22%3A%20%22"+ valueVal + "%22%2C%20" +
                        "%22field%22%3A%20%22"+ fieldVal + "%22%2C%20" +
                        "%22operator%22%3A%20%22" + operatorVal + "%22%7D%5D")
                .prettyPeek()
                .then()
                .body("entities.siteName", hasItem("uniqueSite100"))
                .body("entities.callSign", hasItem("KA2071"))
                .body("entities.latitude", hasItem(71.0f))
                .body("entities.longitude", hasItem(22.22f))
                .body("entities.elevation", hasItem(11.11f))
                .body("entities.elevationUS", hasItem(36.45f));

        deletePathCleanUp(pathId);

    }*/

    }
}