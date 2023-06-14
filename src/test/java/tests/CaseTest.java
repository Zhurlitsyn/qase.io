package tests;

import com.codeborne.selenide.Condition;
import dto.*;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import tests.base.Retry;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static pages.SuitePage.MODAL_SUCCESS_DELETE_XPATH;
import static pages.SuitePage.MODAL_SUCCESS_XPATH;

@Log4j2
public class CaseTest extends BaseTest {
    @Test(description = "Create project by UI", retryAnalyzer = Retry.class)

    public void createCase() {
        Project project = new ProjectFactory().getRandom();
        project.setAccess(ProjectFactory.getRandomAccessApi());
        Suite suite = new SuiteFactory().getRandom();
        TestCase caseApi = new TestCaseFactory().getRandom();
        projectAdapter.create(project);
        suiteAdapter.create(suite, project.getCode());

        loginPage
                .openPage()
                .isPageOpened()
                .login()
                .isPageOpened(project.getTitle());

        repositoryPage
                .openPage(project.getCode())
                .createCaseButtonClick()
                .isPageOpened()
                .fillInInputs(caseApi)
                .setDropDowns(caseApi)
                .saveButtonClick();

        $(byText(project.getCode() + "-1")).shouldBe(Condition.visible);
        projectAdapter.delete(project.getCode());
    }

    @Test(description = "Update case by UI")
    public void updateCase() {
        Project project = new ProjectFactory().getRandom();
        project.setAccess(ProjectFactory.getRandomAccessApi());
        Suite suite = new SuiteFactory().getRandom();
        TestCase caseOne = new TestCaseFactory().getRandom();
        TestCase caseNew = new TestCaseFactory().getRandom();
        projectAdapter.create(project);
        suiteAdapter.create(suite, project.getCode());
        caseAdapter.create(caseOne, project.getCode());

        loginPage
                .openPage()
                .isPageOpened()
                .login()
                .isPageOpened(project.getTitle());

        repositoryPage
                .openPage(project.getCode())
                .caseButtonClick(project.getCode())
                .isEditPageOpened(project.getCode())
                .editButtonClick()
                .editInputsData(caseNew)
                .setDropDowns(caseNew)
                .saveButtonClick();
        projectAdapter.delete(project.getCode());
    }

    @Test(description = "Delete case by UI")
    public void deleteCase() {
        Project project = new ProjectFactory().getRandom();
        project.setAccess(ProjectFactory.getRandomAccessApi());
        Suite suite = new SuiteFactory().getRandom();
        TestCase caseOne = new TestCaseFactory().getRandom();
        projectAdapter.create(project);
        suiteAdapter.create(suite, project.getCode());
        caseAdapter.create(caseOne, project.getCode());
        loginPage
                .openPage()
                .isPageOpened()
                .login()
                .isPageOpened(project.getTitle());
        repositoryPage
                .openPage(project.getCode())
                .caseButtonClick(project.getCode())
                .isEditPageOpened(project.getCode())
                .deleteCase(project.getCode());
        $x(MODAL_SUCCESS_XPATH).shouldBe(Condition.visible);
        $x(MODAL_SUCCESS_DELETE_XPATH).shouldBe(Condition.visible);
        projectAdapter.delete(project.getCode());
    }
}
