package pages;

import com.codeborne.selenide.Condition;
import dto.Project;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import wrappers.*;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Log4j2
public class NewProjectPage extends BasePage {

    public static final String CREATE_PROJECT_BUTTON = "//*[@type='submit']";


    public NewProjectPage isPageOpened() {
        $x(CREATE_PROJECT_BUTTON).shouldBe(Condition.visible);
        return this;
    }

    @Step("Filling new Account data")
    public NewProjectPage fillIn(Project project) {
        log.info("Filling new Account data {}", project);
        $(byText("Public")).click();
        $("#project-name").setValue(project.getTitle());
        $("#project-code").setValue(project.getCode());
        $("#description-area").setValue(project.getDescription());
        return this;
    }

    @Step("Click Create Button")
    public ProjectListPage createProjectButtonClick() {
        $x(CREATE_PROJECT_BUTTON).click();
        return new ProjectListPage();
    }

}

