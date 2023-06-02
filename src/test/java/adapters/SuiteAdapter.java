package adapters;

import dto.Suite;
import static adapters.BaseAdapter.*;


import static io.restassured.RestAssured.requestSpecification;

public class SuiteAdapter {
    private static final String POSTFIX = "/v1/suite/";

    public void create(Suite suite, String code) {
        requestSpecification.
                body(suite).
        when().
                post(BASE_API_URL + POSTFIX + code).
        then().
                log().all().
                statusCode(200);
    }

    public static void delete(String code, Integer id) {
        requestSpecification.
        when().
                delete(BASE_API_URL + POSTFIX + code + "/" + id).
        then().
                log().all().
                statusCode(200);
    }

}
