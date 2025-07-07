# 🧪 REST Cucumber API Test Framework
A Java-based BDD API testing framework using **Rest Assured**, **Cucumber**, and **JUnit 4**.  
This project demonstrates structured API testing with Gherkin syntax, mocking, data validation, and HTML reporting.

---

## 🚀 Features
- ✅ BDD-style API testing using Gherkin feature files
- ✅ Uses **Cucumber 7**, **RestAssured 5**, and **JUnit 4**
- ✅ Parameterized GET/POST requests with dynamic payloads
- ✅ Validations for response codes, headers, and body fields
- ✅ Organized step definitions and validators
- ✅ Detailed HTML + XML + JSON reports with Surefire + Cucumber
- ✅ Mocked unit tests using Mockito
- ✅ Maven-based build and test execution

---

## 🗂️ Project Structure
rest-cucumber-api-test/
├── src/
│ ├── test/java/
│ │ ├── config/ # API endpoints
│ │ ├── hooks/ # Cucumber hooks (setup/teardown)
│ │ ├── runners/ # Test runners
│ │ ├── stepdefinitions/ # Step definition logic
│ │ ├── utils/ # Utility classes like payload builders
│ │ ├── validators/ # Response validators
│ │ └── unit/ # Unit tests using JUnit + Mockito
│ └── test/resources/
│ ├── features/ # Cucumber feature files
│ └── testdata/ # JSON payloads for POST requests
├── target/ # Build output and reports (ignored in git)
├── test-logs/ # Runtime test logs
├── pom.xml # Maven configuration
└── README.md # Project documentation


---

## 📦 Tech Stack
| Tool              | Purpose                           |
|------------------|-----------------------------------|
| Java 11+         | Programming Language              |
| Maven            | Build Tool                        |
| Cucumber         | BDD Framework                     |
| Rest Assured     | API Testing Library               |
| JUnit 4          | Test Runner                       |
| Mockito          | Mocking Framework for Unit Tests |
| Surefire Plugin  | Test Execution + Reporting        |

---

## 🧪 How to Run the Tests
1. **Install dependencies**  
   Make sure Maven is installed (`mvn -v`)

2. **Run all tests**
   ```bash
   mvn clean test

3. **Run specific Cucumber tag**
   mvn test -Dcucumber.filter.tags="@get"

📄 Reports
After test execution:

HTML report → target/cucumber-reports/report.html
JUnit XML → target/cucumber-reports/report.xml
Surefire logs → target/surefire-reports/

🧾 Test Logs

Each test execution generates a timestamped log file under the test-logs/ directory:

test-logs/
├── test_log_20250707_193052.txt
├── test_log_20250707_200703.txt
...
These logs are created by the custom utility TestLogger.java.
They record the test scenario names, execution time, status, and any custom debug messages.
Useful for auditing and debugging test runs, especially in CI/CD pipelines.

🔧 Sample Feature File
Feature: GET request verification

Scenario: Verify API response for sample GET request
Given I send a GET request to "sample-endpoint"
Then the status code should be 200
And response should contain field "ip"
And response should contain field "headers"

✅ Validations Performed

GET Response
    Status code = 200
    Presence of: path, ip, headers
POST Response
Status code = 200
JSON fields under parsedBody including:
    order_id
    customer.name, customer.email
    payment.transaction_id
    Item validation inside items[]
    order_status

🧪 Unit Testing with Mockito
Unit tests under src/test/java/unit mock Rest Assured Response objects to test validator behavior independently.
@Test
public void testFieldsPresence() {
    Response mockResponse = mock(Response.class);
    when(mockResponse.getBody().asString()).thenReturn("{...}");
    
    PostResponseValidator.validate(mockResponse);
}

@Test
public void testFieldsPresence() {
Response mockResponse = mock(Response.class);
when(mockResponse.getBody().asString()).thenReturn("{...}");

    PostResponseValidator.validate(mockResponse);
}

💡 To-Do / Future Enhancements
CI/CD Integration (GitHub Actions or Jenkins)
Add DELETE/PUT request handling
Extend JSON schema validation
Generate Allure Reports
Dockerize test execution

👤 Author
Apurv Mishra
Senior QA Automation Engineer
GitHub • LinkedIn

📝 License
This project is licensed under the MIT License.




