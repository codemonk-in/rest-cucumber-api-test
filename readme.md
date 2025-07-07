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
src/test/java/
├── config/ # API endpoint URLs
├── hooks/ # Cucumber hooks
├── runners/ # Cucumber test runner
├── stepdefinitions/ # Step implementation (BDD steps)
├── utils/ # Utility classes (logger, payload builder)
├── validators/ # Response validation logic
├── unit/ # Unit tests for validators & utils

src/test/resources/
├── features/ # Cucumber .feature files
└── testdata/ # JSON request payloads


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

🔧 Sample Feature File
Feature: GET request verification

Scenario: Verify API response for sample GET request
Given I send a GET request to "sample-endpoint"
Then the status code should be 200
And response should contain field "ip"
And response should contain field "headers"

🔍 Sample Validator Snippet
public class GetResponseValidator {
    public static void validate(Response response) {
        response.then().statusCode(200);
        JsonPath json = response.jsonPath();
        assertNotNull(json.get("ip"));
        assertNotNull(json.get("headers"));
    }
}

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




