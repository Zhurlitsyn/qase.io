package pages;

import com.codeborne.selenide.Condition;
import dto.Project;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class ProjectPage extends BasePage {

    public static final String PROJECT_NAME_CSS = "#project-name";
    public static final String PROJECT_CODE_CSS = "#project-code";
    public static final String DESCRIPTION_CSS = "#description-area";
    public static final String PUBLIC_CHECK_CSS = "public";
    public static final String PRIVATE_CHECK_CSS = "private";
    public static final String ADD_ALL_CHECK_CSS = "Add all members to this project";
    public static final String DONT_ALL_CHECK_CSS = "Don't add members";
    public static final String CREATE_BUTTON_CSS = "button[type='submit']";

    public ProjectPage isPageOpened() {
        $(CREATE_BUTTON_CSS).shouldBe(Condition.visible);
        return this;
    }

    @Step("Filling new Project data with random values")
    public ProjectPage fillIn(Project project) {
        log.info("Filling new Account data {}", project);
        $(PROJECT_NAME_CSS).clear();
        $(PROJECT_NAME_CSS).setValue(project.getTitle());
        $(PROJECT_CODE_CSS).clear();
        $(PROJECT_CODE_CSS).setValue(project.getCode());
        $(DESCRIPTION_CSS).clear();
        $(DESCRIPTION_CSS).setValue(project.getDescription());
        $x("//input[@value='" + project.getAccess() + "']").click();
        return this;
    }

    @Step("Setting Project access with random values")
    public ProjectPage setRandomAccess(Project project) {
        log.info("Setting Project access with random values {}", project.getAccess());
        $x("//input[@value='" + project.getAccess() + "']").click();
        return this;
    }

    @Step("Setting new Project data with Private access (Add All)")
    public ProjectPage setPrivateAll(Project project) {
        log.info("Filling new Account data {}", project);
        $(byText(PRIVATE_CHECK_CSS)).click();
        $(byText(ADD_ALL_CHECK_CSS)).click();
        return this;
    }

    @Step("Setting new Project data with Private access (Don't All)")
    public ProjectPage setPrivate(Project project) {
        log.info("Filling new Account data {}", project);
        $(byText(PRIVATE_CHECK_CSS)).click();
        $(byText(DONT_ALL_CHECK_CSS)).click();
        return this;
    }

    @Step("Click Create Button")
    public ProjectListPage createProjectButtonClick() {
        $(CREATE_BUTTON_CSS).click();
        return new ProjectListPage();
    }

}

