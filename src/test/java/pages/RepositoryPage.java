package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import utils.SleepSomeTime;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static pages.ProjectSettingsPage.DELETE_MODAL_BUTTON_XPATH;

@Log4j2
public class RepositoryPage extends BasePage {

    public static final String CODE_REPOSITORY = "//h1[contains(@text(), '%s')]";
    public static final String CREATE_SUITE_BUTTON = "#create-suite-button";
    public static final String EDIT_SUITE_BUTTON = "//h3/span[text()='%s']/..//i[contains(@class, 'fa-pencil')]";
    public static final String DELETE_SUITE_BUTTON = "//h3/span[text()='%s']/..//i[contains(@class, 'fa-trash')]";
    public static final String CREATE_CASE_BUTTON = "#create-case-button";
    public static final String DELETE_BUTTON_SUITE_MODAL = "//button[@type='submit']";



    public RepositoryPage isPageOpened(String code) {
        $x(String.format(CODE_REPOSITORY, code)).shouldBe(Condition.visible);
        waitForPageLoaded();
        return this;
    }

    @Step("Waits opening Project page")
    public RepositoryPage openPage(String code) {
        log.info("Wait opening Project page");
        open("/projects/" + code);
        waitForPageLoaded();
        return this;
    }

    @Step("Click Create Suite Button")
    public SuitePage createSuiteButtonClick() {
        $(CREATE_SUITE_BUTTON).click();
        return new SuitePage();
    }

    @Step("Click Create Case Button")
    public CasePage createCaseButtonClick() {
        $(CREATE_CASE_BUTTON).click();
        return new CasePage();
    }

    @Step("Suite edit button click on repository page")
    public SuitePage editButtonClickRepository(String title) {
        $x(String.format(EDIT_SUITE_BUTTON, title)).click();
        return new SuitePage();
    }

    @Step("Deleting Suite on RepositoryPage")
    public void deleteSuiteButtonRepository(String title) {
        log.info("Deleting Suite by 'Delete' button on repository page with all cases");
        $x(String.format(DELETE_SUITE_BUTTON, title)).click();
        $x(DELETE_BUTTON_SUITE_MODAL).click();
        SleepSomeTime.delay(3000);
        $x(DELETE_MODAL_BUTTON_XPATH).click();
    }

}

