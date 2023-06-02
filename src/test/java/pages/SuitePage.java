package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.selector.ByText;
import dto.Project;
import dto.Suite;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class SuitePage extends BasePage {

    public static final String SUITE_TITLE = "#title";
    public static final String SUITE_INPUT = "//*[text()='%s']/../..//p";
    public static final String SUITE_URI = "/project/%s";
    public static final String CREATE_NEW_SUITE_BUTTON = "Create new suite";

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
        $(SUITE_TITLE).clear();
        $(SUITE_TITLE).setValue(suite.getTitle());
        $x(String.format(SUITE_INPUT, "Description")).click();
        $x(String.format(SUITE_INPUT, "Description")).clear();
        $x(String.format(SUITE_INPUT, "Description")).setValue(suite.getDescription());
        $x(String.format(SUITE_INPUT, "Preconditions")).click();
        $x(String.format(SUITE_INPUT, "Preconditions")).clear();
        $x(String.format(SUITE_INPUT, "Preconditions")).setValue(suite.getPrecondition());
        return this;
    }

    @Step("Check project data")
    public SuitePage checkSuiteData(Suite suite) {
        $(SUITE_TITLE).shouldBe(value(suite.getTitle()));
        $x(String.format(SUITE_INPUT, "Description")).shouldHave(value(suite.getDescription()));
        $x(String.format(SUITE_INPUT, "Preconditions")).shouldHave(value(suite.getPrecondition()));
        return this;
    }



    @Step("Click Create Button")
    public SuitePage createButtonClick() {
        $(CREATE_BUTTON_CSS).click();
        return this;
    }


}

