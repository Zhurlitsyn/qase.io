package adapters;

import utils.PropertyReader;

import static io.restassured.RestAssured.*;

public class BaseAdapter {
    public static final String BASE_API_URL = PropertyReader.getProperty("base.api.url");

    public BaseAdapter() {
        requestSpecification = given().
                header("content-type", "application/json").
                header("Token", System.getProperty("api.token", PropertyReader.getProperty("api.token"))).
                log().all();
    }
}
