# Open Brewery API Automation

## API Used

Open Brewery DB API

Base URL:
https://api.openbrewerydb.org/v1/breweries

### Endpoints used:

- GET /v1/breweries → Get all breweries
- GET /v1/breweries?by_city={city} → Filter breweries by city

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

### 1. Status Code Validation
Ensures API is reachable and responding successfully.

### 2. Response Body Validation
Ensures API returns meaningful and expected data.

### 3. Negative Testing
Ensures invalid inputs are handled gracefully.

### 4. Data-Driven Testing
Implemented using TestNG DataProvider to reduce duplicate code and improve scalability.

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
