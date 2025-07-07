Feature: GET Request API Validation

  Scenario: Validate GET request response fields
    Given I perform a GET request to the sample endpoint
    Then the response should contain "path", "ip", and "headers"
