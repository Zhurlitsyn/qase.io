package pages;

import com.codeborne.selenide.Condition;
import dto.Project;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import wrappers.*;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class NewProjectPage extends BasePage {

    public static final String CREATE_PROJECT_BUTTON_CSS = "button[type='submit']";
    public static final String PROJECT_NAME_CSS = "#project-name";
    public static final String PROJECT_CODE_CSS = "#project-code";
    public static final String DESCRIPTION_CSS = "#description-area";
    public static final String PUBLIC_CHECK_CSS = "Public";
    public static final String PRIVATE_CHECK_CSS = "Private";
    public static final String ADD_ALL_CHECK_CSS = "Add all members to this project";
    public static final String DONT_ALL_CHECK_CSS = "Don't add members";



    public NewProjectPage isPageOpened() {
        $(CREATE_PROJECT_BUTTON_CSS).shouldBe(Condition.visible);
        return this;
    }

    @Step("Filling new Account data with Public access")
    public NewProjectPage fillIn(Project project) {
        log.info("Filling new Account data {}", project);
        $(byText(PUBLIC_CHECK_CSS)).click();
        $(PROJECT_NAME_CSS).setValue(project.getTitle());
        $(PROJECT_CODE_CSS).setValue(project.getCode());
        $(DESCRIPTION_CSS).setValue(project.getDescription());
        return this;
    }

    @Step("Filling new Account data with Private access")
    public NewProjectPage fillInPrivate(Project project) {
        log.info("Filling new Account data {}", project);
        $(byText(PRIVATE_CHECK_CSS)).click();
        $(byText(ADD_ALL_CHECK_CSS)).click();
        $(PROJECT_NAME_CSS).setValue(project.getTitle());
        $(PROJECT_CODE_CSS).setValue(project.getCode());
        $(DESCRIPTION_CSS).setValue(project.getDescription());
        return this;
    }

    @Step("Click Create Button")
    public ProjectListPage createProjectButtonClick() {
        $(CREATE_PROJECT_BUTTON_CSS).click();
        return new ProjectListPage();
    }

}

