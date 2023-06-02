package adapters;

import dto.Project;

import static adapters.BaseAdapter.*;
import static io.restassured.RestAssured.requestSpecification;
import static org.hamcrest.Matchers.equalTo;

public class ProjectAdapter {
    private static final String POSTFIX = "/v1/project/";

    public void create(Project project) {
        requestSpecification.
                body(project).
        when().
                post(BASE_API + POSTFIX).
        then().
                log().body().
                statusCode(200);
    }

    public static void delete(String code) {
        requestSpecification.
        when().
                delete(BASE_API + POSTFIX + code).
        then().
                log().all().
                statusCode(200);
    }

    public static void get(String code, String title) {
        requestSpecification.
        when().
                get(BASE_API + POSTFIX + code).
        then().
                log().body().
                statusCode(200).
                body("result.title", equalTo(title));
    }

}
