package stepdefinitions;

import config.Endpoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import validators.GetResponseValidator;

import static io.restassured.RestAssured.given;

/**
 * Step definitions for handling GET API requests using Cucumber BDD format.
 * This class performs an HTTP GET request and validates the presence of key fields
 * such as `path`, `ip`, and `headers` in the response.
 */
public class GetSteps {

    private Response response;

    /**
     * Sends a GET request to the configured sample endpoint.
     */
    @Given("I perform a GET request to the sample endpoint")
    public void i_perform_get_request_to_sample_endpoint() {
        response = given()
                .when()
                .get(Endpoints.GET_SAMPLE_ENDPOINT)
                .then()
                .extract()
                .response();
    }

    /**
     * Validates that the response JSON contains the specified fields.
     *
     * @param key1 First expected key (e.g., "path")
     * @param key2 Second expected key (e.g., "ip")
     * @param key3 Third expected key (e.g., "headers")
     */
    @Then("the response should contain {string}, {string}, and {string}")
    public void the_response_should_contain_fields(String key1, String key2, String key3) {
        GetResponseValidator.validate(response, key1, key2, key3);
    }
}
