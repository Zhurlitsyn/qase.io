package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.selector.ByText;
import dto.Suite;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import wrappers.Input;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class SuitePage extends BasePage {

    public static final String SUITE_TITLE_CSS = "#title";
    public static final String SUITE_INPUT_XPATH = "//*[text()='%s']/../..//p[@class]";
    public static final String SUITE_URI = "/project/%s";
    public static final String CREATE_BUTTON_CSS = "button[type='submit']";
    public static final String MODAL_SUCCESS_XPATH = "//div[@class='nlvny_']";
    public static final String MODAL_SUCCESS_CREATE_XPATH = "//*[contains(text(), 'successfully created')]";
    public static final String MODAL_SUCCESS_DELETE_XPATH = "//*[contains(text(), 'successfully deleted')]";


    public SuitePage isPageOpened() {
        $(CREATE_BUTTON_CSS).shouldBe(Condition.visible);
        return this;
    }

    @Step("Opening Project repository page")
    public RepositoryPage openPage(String code) {
        log.info("Opening Project repository page");
        open(String.format(SUITE_URI, code));
        return new RepositoryPage();
    }

    @Step("Filling new Suite data with random values")
    public SuitePage fillIn(Suite suite) {
        log.info("Filling new Suite data {}", suite);
        $(SUITE_TITLE_CSS).clear();
        $(SUITE_TITLE_CSS).setValue(suite.getTitle());
        log.info("Filling Description field {}", suite.getDescription());
        new Input("Description").write(suite.getDescription());
        log.info("Filling Preconditions field {}", suite.getPreconditions());
        new Input("Preconditions").write(suite.getPreconditions());
        return this;
    }

    @Step("Filling new Project data with random values")
    public SuitePage fillInEdit(Suite suite) {
        log.info("Filling new Suite data {}", suite);
        $(SUITE_TITLE_CSS).clear();
        $(SUITE_TITLE_CSS).setValue(suite.getTitle());
        log.info("Filling Description field {}", suite.getDescription());
        new Input("Description").edit(suite.getDescription());
        log.info("Filling Preconditions field {}", suite.getPreconditions());
        new Input("Preconditions").edit(suite.getPreconditions());
        return this;
    }

    @Step("Check project data")
    public SuitePage checkSuiteData(Suite suite) {
        $(SUITE_TITLE_CSS).shouldBe(value(suite.getTitle()));
        $x(String.format(SUITE_INPUT_XPATH, "Description")).shouldHave(text(suite.getDescription()));
        $x(String.format(SUITE_INPUT_XPATH, "Preconditions")).shouldHave(text(suite.getPreconditions()));
        return this;
    }

    @Step("Click Save Button")
    public RepositoryPage saveButtonClick() {
        $(CREATE_BUTTON_CSS).click();
        return new RepositoryPage();
    }



}

