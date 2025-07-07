package unit;

import org.json.JSONObject;
import org.junit.Test;
import utils.PayloadBuilder;

/**
 * Unit tests for PayloadBuilder to ensure correct JSON generation for POST payload.
 */
public class PayloadBuilderTest {

    @Test
    public void testOrderPayloadStructure() {
        String payload = PayloadBuilder.loadJson("order_payload.json");

        JSONObject json = new JSONObject(payload);

        assert json.getString("order_id").equals("12345");
        assert json.getJSONObject("customer").getString("name").equals("Jane Smith");
        assert json.getJSONObject("payment").getDouble("amount") == 111.97;
        assert json.getJSONArray("items").length() == 2;
    }

    @Test
    public void testContainsShippingDetails() {
        String payload = PayloadBuilder.loadJson("order_payload.json");
        JSONObject json = new JSONObject(payload);

        assert json.has("shipping");
        assert json.getJSONObject("shipping").getString("method").equals("standard");
    }
}
