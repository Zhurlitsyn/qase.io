package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.selector.ByText;
import dto.Suite;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import wrappers.Input;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class SuitePage extends BasePage {

    public static final String SUITE_TITLE_CSS = "#title";
    public static final String SUITE_INPUT_XPATH = "//*[text()='%s']/../..//p";
    public static final String SUITE_URI = "/project/%s";
    public static final String CREATE_NEW_SUITE_BUTTON = "Create new suite";
    public static final String CREATE_SUITE_BUTTON_CSS = "#create-suite-button";
    public static final String CREATE_BUTTON_CSS = "button[type='submit']";


    public SuitePage isPageOpened() {
        $(CREATE_BUTTON_CSS).shouldBe(Condition.visible);
        return this;
    }

    @Step("Opening Project page")
    public SuitePage openPage(String code) {
        log.info("Opening Project page");
        open(String.format(SUITE_URI, code));
        return this;
    }

    @Step("Click 'Create new suite' button")
    public SuitePage createNewSuiteButtonClick() {
        $(byText(CREATE_NEW_SUITE_BUTTON)).click();
        return this;
    }

    @Step("Filling new Project data with random values")
    public SuitePage fillIn(Suite suite) {
        log.info("Filling new Suite data {}", suite);
        $(SUITE_TITLE_CSS).clear();
        $(SUITE_TITLE_CSS).setValue(suite.getTitle());
        log.info("Filling Description field {}", suite.getDescription());
        new Input("Description").writeSuite(suite.getDescription());
        log.info("Filling Preconditions field {}", suite.getPrecondition());
        new Input("Preconditions").writeSuite(suite.getPrecondition());
        /*$x(String.format(SUITE_INPUT_XPATH, "Description")).click();
        $x(String.format(SUITE_INPUT_XPATH, "Description")).clear();
        $x(String.format(SUITE_INPUT_XPATH, "Description")).setValue(suite.getDescription());
        $x(String.format(SUITE_INPUT_XPATH, "Preconditions")).click();
        $x(String.format(SUITE_INPUT_XPATH, "Preconditions")).clear();
        $x(String.format(SUITE_INPUT_XPATH, "Preconditions")).setValue(suite.getPrecondition());*/
        return this;
    }

    @Step("Check project data")
    public SuitePage checkSuiteData(Suite suite) {
        $(SUITE_TITLE_CSS).shouldBe(value(suite.getTitle()));
        $x(String.format(SUITE_INPUT_XPATH, "Description")).shouldHave(value(suite.getDescription()));
        $x(String.format(SUITE_INPUT_XPATH, "Preconditions")).shouldHave(value(suite.getPrecondition()));
        return this;
    }

    @Step("Click Create Button")
    public SuitePage createSuiteButtonClick() {
        $(CREATE_SUITE_BUTTON_CSS).click();
        return this;
    }
}

