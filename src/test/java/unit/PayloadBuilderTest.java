package unit;

import org.json.JSONObject;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.PayloadBuilder;

/**
 * Unit tests for PayloadBuilder to ensure correct JSON generation for POST payload.
 */
public class PayloadBuilderTest {

    @Test
    public void testOrderPayloadStructure() {
        String payload = PayloadBuilder.loadJson("order_payload.json");

        JSONObject json = new JSONObject(payload);

        assertEquals("12345", json.getString("order_id"));
        assertEquals("Jane Smith", json.getJSONObject("customer").getString("name"));
        assertEquals(111.97, json.getJSONObject("payment").getDouble("amount"), 0.0);
        assertEquals(2, json.getJSONArray("items").length());
    }

    @Test
    public void testContainsShippingDetails() {
        String payload = PayloadBuilder.loadJson("order_payload.json");
        JSONObject json = new JSONObject(payload);

        assertTrue(json.has("shipping"));
        assertEquals("standard", json.getJSONObject("shipping").getString("method"));
    }
}
