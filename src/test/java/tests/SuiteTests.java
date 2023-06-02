package tests;

import adapters.ProjectAdapter;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import dto.Project;
import dto.ProjectFactory;
import dto.Suite;
import dto.SuiteFactory;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;
import static pages.ProjectListPage.PROJECTS_CODES;

@Log4j2
public class SuiteTests extends BaseTest {
    @Test(description = "Create project by UI")
    public void createSuite() {
        Project project = new ProjectFactory().getRandomApi();
        Suite suite = new SuiteFactory().getRandom();
        projectAdapter.create(project);
        log.info("Login user");
        loginPage
                .openPage()
                .isPageOpened()
                .login()
                .isPageOpened();
        log.info("Opening project page and create suite");
        suitePage
                .openPage(project.getCode())
                .createNewSuiteButtonClick()
                .fillIn(suite)
                .createButtonClick();

        log.info("Checking suite");
        $(byText(suite.getTitle())).shouldBe(Condition.visible);
        projectListPage.openPage();
        projectAdapter.delete(project.getCode());
    }

    @Test(description = "Update suite by UI")
    public void updateSuite() {
        Project project = new ProjectFactory().getRandomApi();
        Suite suite = new SuiteFactory().getRandom();
        Suite suiteNew = new SuiteFactory().getRandom();
        log.info("Creating new project and suite");
        projectAdapter.create(project);
        suiteAdapter.create(suite, project.getCode());
        log.info("Updating suite data");
        loginPage
                .openPage()
                .isPageOpened()
                .login()
                .isPageOpened();
        suitePage
                .openPage(project.getCode())
                .createNewSuiteButtonClick()
                .fillIn(suite);


    }

}
