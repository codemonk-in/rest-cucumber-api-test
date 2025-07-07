package validators;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import utils.TestLogger;

import static org.junit.Assert.fail;

public class GetResponseValidator {

    public static void validate(Response response, String key1, String key2, String key3) {
        TestLogger.log("Validating presence of fields: " + key1 + ", " + key2 + ", " + key3);

        try {
            response.then().statusCode(200);
        } catch (AssertionError e) {
            TestLogger.log("❌ Status code validation failed: " + e.getMessage());
            fail("Expected status code 200, but got: " + response.getStatusCode());
        }

        validateField(response, key1);
        validateField(response, key2);
        validateField(response, key3);

        TestLogger.log("✅ All required fields validated successfully.");
    }

    private static void validateField(Response response, String key) {
        try {
            response.then().body("$", Matchers.hasKey(key));
            TestLogger.log("✅ Field '" + key + "' found in response.");
        } catch (AssertionError e) {
            TestLogger.log("❌ Field '" + key + "' missing in response.");
            fail("Expected field '" + key + "' not found in response JSON.");
        }
    }
}
