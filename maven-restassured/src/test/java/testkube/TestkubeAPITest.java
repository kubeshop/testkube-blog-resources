package testkube;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

import static  io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class TestkubeAPITest {

    private static final String apiURI = "https://demo.testkube.io/results/v1";


    @Test 
    void hasAtLeastOneLabel() {
        given()
            .baseUri(apiURI)
        .when()
            .get("/labels")
        .then()
            .assertThat()
            .body("app.size()", greaterThan(1)) 
            ;

    }


    @Test 
    void hasSomeExecutions() {
        given()
            .baseUri(apiURI)
        .when()
            .get("/executions")
        .then()
            .assertThat()
            .body("results.size()", greaterThan(1)) 
            .body("totals.results", greaterThan(1)) 
            ;

    }

    @Test 
    @Disabled("Disabled until we'll speed up Testkube /executions endpoint a little bit!")
    void apiIsBlazinglyFast() {
        given()
            .baseUri(apiURI)
        .when()
            .get("/executions")
        .then()
            .assertThat()
            .time(lessThan(10L)) 
            ;

    }


}
