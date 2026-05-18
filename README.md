# Open Brewery API Automation

## API Used

Open Brewery DB API

Base URL:
https://api.openbrewerydb.org/v1/breweries

### Endpoints used:

- GET /v1/breweries → Get all breweries
- GET /v1/breweries?by_city={city} → Filter breweries by city

## Test Execution

Below GIF shows test execution:
![OpenBrewery Test Execution](https://github.com/user-attachments/assets/3e5b6bd4-e45d-45da-8daa-1b3dea737da6)


API automation framework built using Java, REST Assured, TestNG, and Maven.

## Tech Stack

- Java
- REST Assured
- TestNG
- Maven

---

## Project Structure

```text
src/test/java
│
├── base
│   └── BaseTest.java
├── tests
│   └── BreweryApiTests.java
├── utils
│   └── ConfigReader.java
```

---

## Test Scenarios Covered

| TC ID | Test Case | API Endpoint | Validation | Expected Result |
|------|------|------|------|------|
| TC01 | Get all breweries | GET /breweries | Status code validation | 200 OK |
| TC02 | Get breweries by city | GET /breweries?by_city={city} | Status code validation | 200 OK |
| TC03 | Validate response is not empty | GET /breweries?by_city=san_diego | Response size validation | Response contains breweries |
| TC04 | Validate invalid city returns empty list | GET /breweries?by_city=invalid_city_xyz | Empty response validation | Empty list returned |

---

## Validation Strategy

The following validations were implemented in this framework:

### 1. Status Code Validation
Ensures that all API endpoints return expected HTTP status codes (e.g., 200 OK), confirming successful request execution.

### 2. Response Body Validation
Validates that the API response contains meaningful data and matches expected structure (e.g., list of breweries is returned).

### 3. Data Validation
Ensures query-based filtering works correctly (e.g., breweries filtered by city return relevant results or empty list for invalid input).

### 4. Negative Testing
Verifies system behavior for invalid inputs such as incorrect city names, ensuring graceful handling instead of failures.

### 5. Data-Driven Testing
Implemented using TestNG DataProvider to test multiple input sets (cities) without code duplication, improving scalability and maintainability.

---

## How To Run

Run the following command:

```bash
mvn clean test
```

---

## Framework Design Highlights

- Reusable REST Assured request structure
- Data-driven testing using TestNG DataProvider
- Scalable Maven project structure
- Clear separation of test scenarios
