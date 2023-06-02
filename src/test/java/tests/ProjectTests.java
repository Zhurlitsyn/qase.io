package tests;

import adapters.ProjectAdapter;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import dto.Project;
import dto.ProjectFactory;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;
import static pages.ProjectListPage.PROJECTS_CODES;

@Log4j2
public class ProjectTests extends BaseTest {
    @Test(description = "Create project by UI")
    public void createProjectUI() {
        Project project = new ProjectFactory().getRandomUI();
        log.info("Login user");
        loginPage
                .openPage()
                .isPageOpened()
                .login()
                .isPageOpened()
                .createButtonClick();
        log.info("Filling project data");
        projectPage
                .isPageOpened()
                .fillIn(project)
                .createProjectButtonClick();
        $(byText("Create project")).should(Condition.disappear);
        log.info("Checking project data");
        projectSettingsPage
                .openSettingsPage(project.getCode())
                .checkProjectDataUI(project);
        log.info("Deleting project");
        projectListPage.openPage();
        projectAdapter.delete(project.getCode());
    }

    @Test(description = "Update project settings by new data")
    public void updateProject() {
        Project project = new ProjectFactory().getRandomApi();
        Project projectNew = new ProjectFactory().getRandomUI();
        log.info("Creating new project by API");
        new ProjectAdapter().create(project);
        log.info("Login user");
        loginPage
                .openPage()
                .isPageOpened()
                .login()
                .isPageOpened();
        log.info("Filling & checking project with new data {}", project);
        projectSettingsPage
                .openSettingsPage(project.getCode())
                .updateProjectData(projectNew)
                .updateButtonClick()
                .checkProjectDataUI(projectNew);
        log.info("Deleting project");
        projectListPage.openPage();
        projectAdapter.delete(projectNew.getCode());
    }

    @Test(description = "Delete project from Setting Page")
    public void deleteProjectOnSettingsPage() {
        Project project = new ProjectFactory().getRandomUI();
        projectAdapter.create(project);
        int start = 0;
        log.info("Login user");
        loginPage
                .openPage()
                .isPageOpened()
                .login()
                .isPageOpened();
        start = projectListPage.getCountOfProjects();

        log.info("Opening Settings page & Deleting project");
        projectSettingsPage
                .openSettingsPage(project.getCode())
                .deleteButtonClick();

        projectListPage.isPageOpened();
        $$x(PROJECTS_CODES).shouldHave(CollectionCondition.size(start));
    }

    @Test(description = "Delete project from Project list page")
    public void deleteProjectFromList() {
        Project project = new ProjectFactory().getRandomUI();
        projectAdapter.create(project);
        int start = 0;
        log.info("Login user");
        loginPage
                .openPage()
                .isPageOpened()
                .login()
                .isPageOpened();
        start = projectListPage.getCountOfProjects();

        log.info("Opening Project list page & Deleting project");
        projectListPage
                .openPage()
                .deleteProject(project.getTitle());
        $$x(PROJECTS_CODES).shouldHave(CollectionCondition.size(start));
    }

}
