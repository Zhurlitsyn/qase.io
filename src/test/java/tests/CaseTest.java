package tests;

import com.codeborne.selenide.Condition;
import dto.*;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import tests.base.Retry;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class CaseTest extends BaseTest {
    @Test(description = "Create project by UI", retryAnalyzer = Retry.class)
    public void createCase() {
        Project project = new ProjectFactory().getRandom();
        project.setAccess(ProjectFactory.getRandomAccessApi());
        Suite suite = new SuiteFactory().getRandom();
        CaseApi caseApi = new CaseFactoryApi().getRandom();
        projectAdapter.create(project);
        suiteAdapter.create(suite, project.getCode());
        log.info("Login user");
        loginPage
                .openPage()
                .isPageOpened()
                .login()
                .isPageOpened();
        log.info("Opening project page and create Case");
        repositoryPage
                .openPage(project.getCode())
                .createCaseButtonClick()
                .isPageOpened()
                .fillInInputs(caseApi)
                .setDropDowns(caseApi)
                .saveButtonClick();
        log.info("Checking case title on repository page");
        $(byText(project.getCode()+"-1")).shouldBe(Condition.visible);
        projectListPage.openPage();
        projectAdapter.delete(project.getCode());
    }

    @Test(description = "Update case by UI")
    public void updateCase() {
        log.info("Creating new random data for Project");
        Project project = new ProjectFactory().getRandom();
        project.setAccess(ProjectFactory.getRandomAccessApi());
        log.info("Creating new random data for Suite");
        Suite suite = new SuiteFactory().getRandom();
        log.info("Creating new random data for CaseOne & CaseNew");
        CaseApi caseOne = new CaseFactoryApi().getRandom();
        CaseApi caseNew = new CaseFactoryApi().getRandom();
        log.info("Creating new project by API");
        projectAdapter.create(project);
        log.info("Creating new suite by API");
        suiteAdapter.create(suite, project.getCode());
        log.info("Creating new caseOne by API");
        caseAdapter.create(caseOne, project.getCode());
        log.info("Log in");
        loginPage
                .openPage()
                .isPageOpened()
                .login()
                .isPageOpened();
        log.info("Opening case and filling with new data");
        repositoryPage
                .openPage(project.getCode())
                .caseButtonClick(project.getCode())
                .isEditPageOpened(project.getCode())
                .editButtonClick()
                .editInputsData(caseNew)
                .setDropDowns(caseNew)
                .saveButtonClick();
    }
}
