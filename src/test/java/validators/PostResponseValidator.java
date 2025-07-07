package validators;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import utils.TestLogger;

import static org.junit.Assert.fail;

/**
 * Contains reusable validations for validating POST API responses.
 * Specifically targets fields under the 'parsedBody' object in the JSON structure.
 */
public class PostResponseValidator {

    /**
     * Validates key fields within the parsed body of the POST response.
     *
     * @param response The REST Assured response object received from the POST request
     */
    public static void validate(Response response) {
        TestLogger.log("Validating POST response fields under 'parsedBody'...");

        try {
            response.then().statusCode(200);
        } catch (AssertionError e) {
            TestLogger.log("❌ Status code mismatch: " + e.getMessage());
            fail("Expected status code 200, got " + response.getStatusCode());
        }

        assertField(response, "parsedBody.customer.name", "Jane Smith");
        assertField(response, "parsedBody.customer.email", "janesmith@example.com");
        assertField(response, "parsedBody.payment.transaction_id", "txn_67890");
        assertField(response, "parsedBody.items[0].product_id", "A101");
        assertField(response, "parsedBody.items[1].name", "Smartphone Case");
        assertField(response, "parsedBody.order_id", "12345");
        assertField(response, "parsedBody.order_status", "processing");

        TestLogger.log("✅ All POST fields under 'parsedBody' validated successfully.");
    }

    /**
     * Helper method to validate individual JSON fields and log outcome.
     *
     * @param response  The API response object
     * @param jsonPath  The JSON path to validate (e.g., "parsedBody.customer.name")
     * @param expected  The expected value at that path
     */
    private static void assertField(Response response, String jsonPath, Object expected) {
        try {
            response.then().body(jsonPath, Matchers.equalTo(expected));
            TestLogger.log("✅ " + jsonPath + " == " + expected);
        } catch (AssertionError e) {
            TestLogger.log("❌ Mismatch in '" + jsonPath + "': " + e.getMessage());
            fail("Field '" + jsonPath + "' did not match expected value: " + expected);
        }
    }
}
