package adapters;

import dto.Project;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;

public class ProjectAdapter {

    public void create(Project project) {
        given().
                body(project).
                header("content-type", "application/json").
                header("Token", PropertyReader.getProperty("TOKEN")).
                log().all().
        when().
                post("https://api.qase.io/v1/project").
        then().
                log().all().
                statusCode(200);

    }
}
