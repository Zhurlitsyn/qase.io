package pages;

import com.codeborne.selenide.Condition;
import dto.TestCase;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import wrappers.DropDown;
import wrappers.Input;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class CasePage extends BasePage {

    public static final String CASE_URI = "/case/%s/create";
    public static final String EDIT_BUTTON_XPATH = "//span[text()=' Edit']";
    public static final String SAVE_BUTTON_CSS = "button[type='submit']";
    public static final String CASE_TITLE_CSS = "#title";

    public CasePage open(String code) {
        log.info("Opening Case page");
        open(String.format(CASE_URI, code));
        return this;
    }

    public CasePage isPageOpened() {
        $(SAVE_BUTTON_CSS).shouldBe(Condition.visible);
        return this;
    }
@Step("Waiting opening edit Case page")
    public CasePage isEditPageOpened(String code) {
        $x(EDIT_BUTTON_XPATH).shouldBe(Condition.visible);
        return this;
    }

    @Step("Click Save Button")
    public RepositoryPage saveButtonClick() {
        $(SAVE_BUTTON_CSS).click();
        return new RepositoryPage();
    }
    @Step("Click Edit Button on Case page")
    public CasePage editButtonClick() {
        log.info("Clicking Edit button");
        $x(EDIT_BUTTON_XPATH).click();
        return this;
    }

    @Step("Filling Inputs by new Case data with random values")
    public CasePage fillInInputs(TestCase caseOne) {
        log.info("Filling new Case data {}", caseOne);
        $(CASE_TITLE_CSS).clear();
        $(CASE_TITLE_CSS).setValue(caseOne.getTitle());
        log.info("Filling Description field {}", caseOne.getDescription());
        new Input("Description").writeCase(caseOne.getDescription());
        log.info("Filling Pre-conditions field {}", caseOne.getPreconditions());
        new Input("Pre-conditions").writeCase(caseOne.getPreconditions());
        log.info("Filling Post-conditions field {}", caseOne.getPostconditions());
        new Input("Post-conditions").writeCase(caseOne.getPostconditions());
        return this;
    }

    @Step("Selecting Drops by new Case data with random values")
    public CasePage setDropDowns(TestCase caseOne) {
        log.info("Set Status dropdown {}", caseOne.getStatus());
        new DropDown("Status").setDrop(caseOne.getStatus());
        log.info("Set Severity dropdown {}", caseOne.getSeverity());
        new DropDown("Severity").setDrop(caseOne.getSeverity());
        log.info("Set Priority dropdown {}", caseOne.getPriority());
        new DropDown("Priority").setDrop(caseOne.getPriority());
        log.info("Set Layer dropdown {}", caseOne.getLayer());
        new DropDown("Layer").setDrop(caseOne.getLayer());
        log.info("Set Behavior dropdown {}", caseOne.getBehavior());
        new DropDown("Behavior").setDrop(caseOne.getBehavior());
        log.info("Set Type dropdown {}", caseOne.getType());
        new DropDown("Type").setDrop(caseOne.getType());
        //TODO index of none Suite choice???
        /*log.info("Set SuiteID dropdown {}", caseOne.getSuite_id());
        new DropDown("Suite").setDrop(caseOne.getSuite_id());*/
        return this;
    }

    @Step("Filling new Case data with random values")
    public CasePage editInputsData(TestCase caseOne) {
        log.info("Filling Title field {}", caseOne.getTitle());
        $(CASE_TITLE_CSS).clear();
        $(CASE_TITLE_CSS).setValue(caseOne.getTitle());
        log.info("Editing Inputs by new Case data {}", caseOne);
        log.info("Filling Description field {}", caseOne.getDescription());
        new Input("Description").editCase(caseOne.getDescription());
        log.info("Filling Pre-conditions field {}", caseOne.getPreconditions());
        new Input("Pre-conditions").editCase(caseOne.getPreconditions());
        log.info("Filling Post-conditions field {}", caseOne.getPostconditions());
        new Input("Post-conditions").editCase(caseOne.getPostconditions());
        return this;
    }


}
