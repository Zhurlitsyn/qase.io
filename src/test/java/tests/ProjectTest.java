package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import dto.Project;
import dto.ProjectFactory;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static pages.ProjectListPage.PROJECTS_CODES;

@Log4j2
public class ProjectTest extends BaseTest {
    @Test(description = "Create project by UI with random access")
    public void createProjectRandomAccess() {
        Project project = new ProjectFactory().getRandom();
        project.setAccess(ProjectFactory.getRandomAccessUI());
        loginPage
                .openPage()
                .isPageOpened()
                .login()
                .isPageOpened()
                .createButtonClick();
        projectPage
                .isPageOpened()
                .fillIn(project)
                .createProjectButtonClick();
        $(byText("Create project")).should(Condition.disappear);
        projectSettingsPage
                .openSettingsPage(project.getCode())
                .checkProjectData(project);
        projectListPage.openPage();
        projectAdapter.delete(project.getCode());
    }

    @Test(description = "Update project settings by new data")
    public void updateProject() {
        Project project = new ProjectFactory().getRandom();
        project.setAccess(ProjectFactory.getRandomAccessApi());

        Project projectNew = new ProjectFactory().getRandom();
        projectNew.setAccess(ProjectFactory.getRandomAccessApi());

        projectAdapter.create(project);
        loginPage
                .openPage()
                .isPageOpened()
                .login()
                .isPageOpened();
        projectSettingsPage
                .openSettingsPage(project.getCode())
                .updateProjectData(projectNew)
                .updateButtonClick()
                .checkProjectData(projectNew);
        projectListPage.openPage();
        projectAdapter.delete(projectNew.getCode());
    }

    @Test(description = "Delete project from Setting Page")
    public void deleteProjectOnSettingsPage() {
        Project project = new ProjectFactory().getRandom();
        project.setAccess(ProjectFactory.getRandomAccessApi());
        projectAdapter.create(project);
        int start = 0;
        loginPage
                .openPage()
                .isPageOpened()
                .login()
                .isPageOpened();
        start = projectListPage.getCountOfProjects() - 1;

        projectSettingsPage
                .openSettingsPage(project.getCode())
                .deleteButtonClick();

        projectListPage.isPageOpened();
        $$x(PROJECTS_CODES).shouldHave(CollectionCondition.size(start));
    }

    @Test(description = "Delete project from Project list page")
    public void deleteProjectFromList() {
        Project project = new ProjectFactory().getRandom();
        project.setAccess(ProjectFactory.getRandomAccessApi());
        projectAdapter.create(project);
        int start = 0;
        loginPage
                .openPage()
                .isPageOpened()
                .login()
                .isPageOpened();
        start = projectListPage.getCountOfProjects() - 1;

        projectListPage
                .openPage()
                .deleteProject(project.getTitle());
        $$x(PROJECTS_CODES).shouldHave(CollectionCondition.size(start));
    }

}
