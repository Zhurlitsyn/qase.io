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
        Project project = new ProjectFactory().getRandom();
        project.setAccess(ProjectFactory.getRandomAccessApi());
        projectAdapter.create(project);
    }

    @Test(description = "Delete project data by API")
    public void deleteProjectApi() {
        Project project = new ProjectFactory().getRandom();
        project.setAccess(ProjectFactory.getRandomAccessApi());
        projectAdapter.create(project);
        projectAdapter.delete(project.getCode());
    }

    @Test(description = "Get project data by API")
    public void getProjectApi() {
        Project project = new ProjectFactory().getRandom();
        project.setAccess(ProjectFactory.getRandomAccessApi());
        projectAdapter.create(project);
        projectAdapter.get(project.getCode(), project.getTitle());
        projectAdapter.delete(project.getCode());
    }
}
