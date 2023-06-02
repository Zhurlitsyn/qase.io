package tests;

import adapters.ProjectAdapter;
import com.codeborne.selenide.Condition;
import dto.Project;
import dto.ProjectFactory;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class ProjectApiTests extends ApiBaseTest {
    @Test(description = "Create project by API")
    public void createProjectApi() {
        Project project = new ProjectFactory().getRandomApi();
        new ProjectAdapter().create(project);
    }

    @Test(description = "Delete project data by API")
    public void deleteProjectApi() {
        Project project = new ProjectFactory().getRandomApi();
        new ProjectAdapter().create(project);
        ProjectAdapter.delete(project.getCode());
    }

    @Test(description = "Get project data by API")
    public void getProjectApi() {
        log.info("Create new project with random data");
        Project project = new ProjectFactory().getRandomApi();
        new ProjectAdapter().create(project);
        log.info("Get project data and check the 'Title'");
        ProjectAdapter.get(project.getCode(), project.getTitle());
    }
}
