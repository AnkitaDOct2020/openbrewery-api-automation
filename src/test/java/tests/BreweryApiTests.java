package tests;

import base.BaseTest;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BreweryApiTests extends BaseTest {

    // 1. Test: Get all breweries
    @Test
    public void getAllBreweriesTest() {

        int statusCode =
                given()
                .when()
                    .get(BASE_URL)
                .then()
                    .extract().statusCode();

        Assert.assertEquals(statusCode, 200);
    }

    // 2. Test: Get breweries by city (Data-driven)
    @DataProvider(name = "cities")
    public Object[][] cities() {
        return new Object[][]{
                {"san_diego"},
                {"new_york"},
                {"chicago"}
        };
    }

    @Test(dataProvider = "cities")
    public void getBreweriesByCityTest(String city) {

        int statusCode =
                given()
                    .queryParam("by_city", city)
                .when()
                    .get(BASE_URL)
                .then()
                    .extract().statusCode();

        Assert.assertEquals(statusCode, 200);
    }

    // 3. Test: Validate response is not empty for valid city
    @Test
    public void validateResponseNotEmpty() {

        int size =
                given()
                    .queryParam("by_city", "san_diego")
                .when()
                    .get(BASE_URL)
                .then()
                    .extract()
                    .jsonPath().getList("$").size();

        Assert.assertTrue(size > 0);
    }

    // 4. Test: Invalid city should still return 200 but empty list
    @Test
    public void invalidCityTest() {

        int size =
                given()
                    .queryParam("by_city", "invalid_city_xyz")
                .when()
                    .get(BASE_URL)
                .then()
                    .extract()
                    .jsonPath().getList("$").size();

        Assert.assertEquals(size, 0);
    }
}