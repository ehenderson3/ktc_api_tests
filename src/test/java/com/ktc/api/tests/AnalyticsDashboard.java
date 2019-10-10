package com.ktc.api.tests;

import com.ktc.CompanyCategory;
import com.ktc.RestAssuredConfig;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;

public class AnalyticsDashboard extends RestAssuredConfig {

    @Test
    public void GetNumberOfUsersInterestedInACategory() {

        CompanyCategory project = new CompanyCategory("9f3b0117-88db-496a-b33c-37eb3b72ebe1", "7199c797-aaa8-4c3e-86e7-7b0113d0d326");

        given()
                .contentType(ContentType.JSON)
                .body(project)
                .when()
                .post("/get_category_interest_count")
                .prettyPeek()
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .body("count", equalTo(340))
        ;
    }

    @Test
    public void GetTotalNumberOfContentViews() {

        CompanyCategory project = new CompanyCategory("9f3b0117-88db-496a-b33c-37eb3b72ebe1", "7199c797-aaa8-4c3e-86e7-7b0113d0d326");

        given()
                .contentType(ContentType.JSON)
                .body(project)
                .when()
                .post("/get_content_view_count")
                .prettyPeek()
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .body("count", equalTo(102))
        ;
    }

    @Test
    public void InformationAboutThePercentageOfUsersViewingContent() {

        CompanyCategory project = new CompanyCategory("9f3b0117-88db-496a-b33c-37eb3b72ebe1", "7199c797-aaa8-4c3e-86e7-7b0113d0d326");

        given()
                .contentType(ContentType.JSON)
                .body(project)
                .when()
                .post("/get_content_view_rate")
                .prettyPeek()
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .body("rate", equalTo(0.08f))
        ;
    }

    @Test
    public void InformationAboutThePercentageOfUsersCompletingHabitAssessments() {

        CompanyCategory project = new CompanyCategory("9f3b0117-88db-496a-b33c-37eb3b72ebe1", "7199c797-aaa8-4c3e-86e7-7b0113d0d326");

        given()
                .contentType(ContentType.JSON)
                .body(project)
                .when()
                .post("/get_habit_assessment_activity_rate")
                .prettyPeek()
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .body("rate", equalTo(0.05f))
        ;
    }

    @Test
    public void GetNumberMicrostepCheckIns() {

        CompanyCategory project = new CompanyCategory("9f3b0117-88db-496a-b33c-37eb3b72ebe1", "7199c797-aaa8-4c3e-86e7-7b0113d0d326");

        given()
                .contentType(ContentType.JSON)
                .body(project)
                .when()
                .post("/get_microstep_check_in_count")
                .prettyPeek()
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .body("count", equalTo(174))
        ;
    }

    @Test
    public void GetNumberOfMicrostepsUsersExpressedInterestIn() {

        CompanyCategory project = new CompanyCategory("9f3b0117-88db-496a-b33c-37eb3b72ebe1", "7199c797-aaa8-4c3e-86e7-7b0113d0d326");

        given()
                .contentType(ContentType.JSON)
                .body(project)
                .when()
                .post("/get_microstep_interest_count")
                .prettyPeek()
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .body("count", equalTo(765))
        ;
    }

    @Test
    public void GetTopThreeCategoriesInMostCommittedOrder() {

        CompanyCategory project = new CompanyCategory("9f3b0117-88db-496a-b33c-37eb3b72ebe1", "7199c797-aaa8-4c3e-86e7-7b0113d0d326");

        given()
                .contentType(ContentType.JSON)
                .body(project)
                .when()
                .post("/get_most_committed_categories")
                .prettyPeek()
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .body("items.id[0]", equalTo("7199c797-aaa8-4c3e-86e7-7b0113d0d326"))
                .body("items.id[1]", equalTo("c646e65e-f714-4256-87dd-111786fc9c6d"))
                .body("items.id[2]", equalTo("47e1ca4e-7904-4f4b-93a4-d3f4d921a53a"))
                .body("items.name[0]", equalTo("Sleep"))
                .body("items.name[1]", equalTo("Focus and Prioritization"))
                .body("items.name[2]", equalTo("Mindful Communication"))

        ;
    }


    @Test
    public void GetTopThreeMicrostepsInMostCommittedOrder() {

        CompanyCategory project = new CompanyCategory("9f3b0117-88db-496a-b33c-37eb3b72ebe1", "7199c797-aaa8-4c3e-86e7-7b0113d0d326");

        given()
                .contentType(ContentType.JSON)
                .body(project)
                .when()
                .post("/get_most_committed_microsteps")
                .prettyPeek()
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .body("items.body[0]", equalTo("Instead, take at least one minute to breathe deeply or set your intentions for the day."))
                .body("items.body[1]", equalTo("If you’re stressed or rushed, you’re more likely to deliver feedback without compassion or empathy — even if that’s unintentional."))
                .body("items.body[2]", equalTo("Disconnecting from the digital world will help you sleep better, deeply recharge and reconnect to your wisdom and creativity."))
        ;
    }


    @Test
    public void GetTopThreeMostViewedPiecesOfContentInDescendingOrder() {

        CompanyCategory project = new CompanyCategory("9f3b0117-88db-496a-b33c-37eb3b72ebe1", "7199c797-aaa8-4c3e-86e7-7b0113d0d326");

        given()
                .contentType(ContentType.JSON)
                .body(project)
                .when()
                .post("/get_most_viewed_content")
                .prettyPeek()
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .body("items.id[0]", equalTo( "74cdcdf1-8e06-4344-819f-67b903f4ea09"))
                .body("items.id[1]", equalTo("2a5751ae-8cad-4350-841a-fe4b2119c0e3"))
                .body("items.id[2]", equalTo("0c04128a-4c07-44e8-bbde-68e71620059f"))
        ;
    }


    @Test
    public void GetStatisticsAboutACompanyUseOfTheThrivePlatform() {

        CompanyCategory project = new CompanyCategory("9f3b0117-88db-496a-b33c-37eb3b72ebe1", "7199c797-aaa8-4c3e-86e7-7b0113d0d326");

        given()
                .contentType(ContentType.JSON)
                .body(project)
                .when()
                .post("/get_company_data")
                .prettyPeek()
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .body("contentViewRate", equalTo( 0.08f))
                .body("habitAssessmentActivityRate", equalTo(0.05f))
                .body("microstepActivityRate", equalTo(0.65f))
                .body("seatsLicensed", equalTo(1031))
                .body("userCount", equalTo(798))

        ;
    }
}
