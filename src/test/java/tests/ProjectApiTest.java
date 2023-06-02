package tests;

import adapters.ProjectAdapter;
import dto.Project;
import dto.ProjectFactory;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class ProjectApiTest extends ApiBaseTest {
    @Test(description = "Create project by API")
    public void createProjectApi() {
        log.info("Creating random data");
        Project project = new ProjectFactory().getRandom();
        project.setAccess(ProjectFactory.getRandomAccessApi());
        log.info("Creating project with random data");
        new ProjectAdapter().create(project);
    }

    @Test(description = "Delete project data by API")
    public void deleteProjectApi() {
        log.info("Creating random data");
        Project project = new ProjectFactory().getRandom();
        project.setAccess(ProjectFactory.getRandomAccessApi());
        log.info("Creating project with random data");
        new ProjectAdapter().create(project);
        log.info("Deleting project");
        ProjectAdapter.delete(project.getCode());
    }

    @Test(description = "Get project data by API")
    public void getProjectApi() {
        log.info("Create new project with random data");
        Project project = new ProjectFactory().getRandom();
        project.setAccess(ProjectFactory.getRandomAccessApi());
        new ProjectAdapter().create(project);
        log.info("Get project data and check the 'Title'");
        ProjectAdapter.get(project.getCode(), project.getTitle());
    }
}
