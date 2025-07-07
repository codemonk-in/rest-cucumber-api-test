Feature: POST Request API Validation

  Scenario: Validate POST request response payload
    Given I perform a POST request with valid order data
    Then the response should contain expected customer, payment, and item details
