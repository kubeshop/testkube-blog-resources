package testkube;

import org.junit.jupiter.api.Test;

import static  io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class TestkubeAPITest {

    @Test 
    void hasAtLeastOneLabel() {
        given()
            .baseUri("https://demo.testkube.io/results/v1")
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
            .baseUri("https://demo.testkube.io/results/v1")
        .when()
            .get("/executions")
        .then()
            .assertThat()
            .body("results.size()", greaterThan(1)) 
            .body("totals.results", greaterThan(1)) 
            ;

    }


}
