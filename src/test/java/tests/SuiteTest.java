package tests;

import com.codeborne.selenide.Condition;
import dto.Project;
import dto.ProjectFactory;
import dto.Suite;
import dto.SuiteFactory;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static pages.SuitePage.*;

@Log4j2
public class SuiteTest extends BaseTest {
    @Test(description = "Create project by UI")
    public void createSuite() {
        Project project = new ProjectFactory().getRandom();
        project.setAccess(ProjectFactory.getRandomAccessApi());
        Suite suite = new SuiteFactory().getRandom();
        projectAdapter.create(project);

        loginPage
                .openPage()
                .isPageOpened()
                .login()
                .isPageOpened(project.getTitle());
        suitePage
                .openPage(project.getCode())
                .createSuiteButtonClick()
                .isPageOpened()
                .fillIn(suite)
                .saveButtonClick();
        $x(MODAL_SUCCESS_XPATH).shouldBe(Condition.visible);
        $x(MODAL_SUCCESS_CREATE_XPATH).shouldBe(Condition.visible);

        projectListPage.openPage();
        projectAdapter.delete(project.getCode());
    }

    @Test(description = "Update suite by UI")
    public void updateSuite() {
        Project project = new ProjectFactory().getRandom();
        project.setAccess(ProjectFactory.getRandomAccessApi());
        Suite suite = new SuiteFactory().getRandom();
        Suite suiteNew = new SuiteFactory().getRandom();
        projectAdapter.create(project);
        suiteAdapter.create(suite, project.getCode());
        loginPage
                .openPage()
                .isPageOpened()
                .login()
                .isPageOpened(project.getTitle());
        suitePage
                .openPage(project.getCode())
                .editButtonClickRepository(suite.getTitle())
                .fillInEdit(suiteNew)
                .saveButtonClick();
        suitePage
                .openPage(project.getCode())
                .editButtonClickRepository(suiteNew.getTitle())
                .checkSuiteData(suiteNew);
        projectListPage.openPage();
        projectAdapter.delete(project.getCode());
    }

    @Test(description = "Delete suite by UI")
    public void deleteSuite() {
        Project project = new ProjectFactory().getRandom();
        project.setAccess(ProjectFactory.getRandomAccessApi());
        Suite suite = new SuiteFactory().getRandom();
        projectAdapter.create(project);
        suiteAdapter.create(suite, project.getCode());
        loginPage
                .openPage()
                .isPageOpened()
                .login()
                .isPageOpened(project.getTitle());
        suitePage
                .openPage(project.getCode())
                .deleteSuiteButtonRepository(suite.getTitle());

        $x(MODAL_SUCCESS_XPATH).shouldBe(Condition.visible);
        $x(MODAL_SUCCESS_DELETE_XPATH).shouldBe(Condition.visible);

        projectListPage.openPage();
        projectAdapter.delete(project.getCode());
    }

}
