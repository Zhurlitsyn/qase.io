package adapters;

import utils.PropertyReader;

import static io.restassured.RestAssured.*;

public class BaseAdapter {
    public static final String BASE_API = PropertyReader.getProperty("BASE_API");

    public BaseAdapter() {
        requestSpecification = given().
                header("content-type", "application/json").
                header("Token", PropertyReader.getProperty("TOKEN")).
                log().all();
    }
}
