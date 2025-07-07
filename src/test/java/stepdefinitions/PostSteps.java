package stepdefinitions;

import config.Endpoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.PayloadBuilder;
import validators.PostResponseValidator;

import static io.restassured.RestAssured.given;

/**
 * Step definitions for handling POST API requests using Cucumber BDD.
 * This class sends a sample order payload and verifies the response structure and values.
 */
public class PostSteps {

    private Response response;

    /**
     * Sends a POST request with predefined order data to the sample endpoint.
     */
    @Given("I perform a POST request with valid order data")
    public void i_perform_post_request_with_order_payload() {
        response = given()
                .contentType(ContentType.JSON)
                .body(PayloadBuilder.loadJson("order_payload.json"))
                .when()
                .post(Endpoints.POST_SAMPLE_ENDPOINT)
                .then()
                .extract()
                .response();
    }

    /**
     * Validates that the response contains expected customer, payment, item, and order fields.
     */
    @Then("the response should contain expected customer, payment, and item details")
    public void validate_response_fields() {
        PostResponseValidator.validate(response);
    }
}
