package validators;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.path.json.JsonPath;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Unit tests for PostResponseValidator class.
 * Uses Mockito to mock REST Assured Response object and verify behavior.
 */
public class PostResponseValidatorTest {

    private Response mockResponse;
    private ResponseBody mockBody;
    private ValidatableResponse mockValidatableResponse;

    @Before
    public void setUp() {
        mockResponse = mock(Response.class);
        mockBody = mock(ResponseBody.class);
        mockValidatableResponse = mock(ValidatableResponse.class);

        // Simulated JSON structure
        String mockedJson = "{\n" +
                "  \"parsedBody\": {\n" +
                "    \"order_id\": \"12345\",\n" +
                "    \"customer\": {\n" +
                "      \"name\": \"Jane Smith\",\n" +
                "      \"email\": \"janesmith@example.com\"\n" +
                "    },\n" +
                "    \"payment\": {\n" +
                "      \"transaction_id\": \"txn_67890\"\n" +
                "    },\n" +
                "    \"items\": [\n" +
                "      {\"product_id\": \"A101\"},\n" +
                "      {\"name\": \"Smartphone Case\"}\n" +
                "    ],\n" +
                "    \"order_status\": \"processing\"\n" +
                "  }\n" +
                "}";

        // Mock JSON body and status code
        when(mockResponse.getBody()).thenReturn(mockBody);
        when(mockBody.asString()).thenReturn(mockedJson);
        when(mockResponse.jsonPath()).thenReturn(new JsonPath(mockedJson));

        // 🔥 This is important to fix your error
        when(mockResponse.then()).thenReturn(mockValidatableResponse);
        when(mockValidatableResponse.statusCode(200)).thenReturn(mockValidatableResponse);

        when(mockResponse.getStatusCode()).thenReturn(200);
    }

    @Test
    public void testValidateShouldPass() {
        try {
            PostResponseValidator.validate(mockResponse);
        } catch (AssertionError e) {
            fail("Validation should pass, but failed with: " + e.getMessage());
        }
    }
}
