package validators;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Unit test for GetResponseValidator.
 * Ensures presence of required fields and correct status code.
 */
public class GetResponseValidatorTest {

    private Response mockResponse;
    private ValidatableResponse mockValidatableResponse;
    private JsonPath mockJsonPath;

    @Before
    public void setUp() {
        mockResponse = mock(Response.class);
        mockValidatableResponse = mock(ValidatableResponse.class);
        mockJsonPath = mock(JsonPath.class);

        // Mocking status code check
        when(mockResponse.then()).thenReturn(mockValidatableResponse);
        when(mockValidatableResponse.statusCode(200)).thenReturn(mockValidatableResponse);

        // Mocking jsonPath and field checks
        when(mockResponse.jsonPath()).thenReturn(mockJsonPath);
        when(mockJsonPath.get("path")).thenReturn("/sample-request");
        when(mockJsonPath.get("ip")).thenReturn("127.0.0.1");
        when(mockJsonPath.get("headers")).thenReturn(new Object()); // Could be Map<String, String> if needed
    }

    @Test
    public void testFieldsPresence() {
        try {
            GetResponseValidator.validate(mockResponse, "path", "ip", "headers");
        } catch (AssertionError e) {
            fail("Validation failed: " + e.getMessage());
        }
    }
}
