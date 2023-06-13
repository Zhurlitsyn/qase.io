package adapters;

import dto.TestCase;


import static adapters.BaseAdapter.BASE_API_URL;
import static io.restassured.RestAssured.requestSpecification;

public class CaseAdapter {
    private static final String POSTFIX = "/v1/case/";

public void create(TestCase caseApi, String code) {

        requestSpecification.
                body(caseApi).
        when().
                post(BASE_API_URL + POSTFIX + code).
        then().
                log().body().
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

 public static void update(TestCase caseApi, String code, int id) {

        requestSpecification.
                body(caseApi).
        when().
                patch(BASE_API_URL + POSTFIX + code + "/" + id).
        then().
                log().body().
                statusCode(200);
    }
}
