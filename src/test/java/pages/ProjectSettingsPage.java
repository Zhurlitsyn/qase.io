package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import dto.Project;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.xml.xpath.XPath;
import java.util.List;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static pages.ProjectPage.*;

@Log4j2
public class ProjectSettingsPage extends BasePage {

    public static final String DELETE_BUTTON = "//*[text()=' Delete project']";
    public static final String UPDATE_BUTTON = "[type='submit']";
    public static final By TITLE_SET = By.tagName("h1");
    public static final String PROJECT_URI = "/project/%s/settings/general";
    public static final String CREATE_NEW_SUITE_BUTTON = "Create new suite";



    public ProjectSettingsPage isPageOpened() {
        $(TITLE_SET).shouldBe(Condition.visible);
        return this;
    }

    @Step("Wait opening Project Settings page")
    public ProjectSettingsPage openSettingsPage(String code) {
        log.info("Wait opening Project Settings page");
        open(String.format(PROJECT_URI, code));
        waitForPageLoaded();
        return this;
    }

    @Step("Click Delete Project Button")
    public ProjectListPage deleteButtonClick() {
        $x(DELETE_BUTTON).click();
        $x(DELETE_MODAL_BUTTON).click();
        return new ProjectListPage();
    }

    public ProjectSettingsPage updateProjectData(Project project) {
        log.info("Filling new Account data {}", project);
        $(PROJECT_NAME_CSS).clear();
        $(PROJECT_NAME_CSS).setValue(project.getTitle());
        $(PROJECT_CODE_CSS).clear();
        $(PROJECT_CODE_CSS).setValue(project.getCode());
        $(DESCRIPTION_CSS).clear();
        $(DESCRIPTION_CSS).setValue(project.getDescription());
        if (project.getAccess().equals("private")) {
            project.setAccess("public");
            radioAccessClick(project);
        } else {
            project.setAccess("private");
            radioAccessClick(project);

        }
        return this;
    }

    @Step("Clicking Access radiobutton")
    public ProjectSettingsPage radioAccessClick(Project project) {
        $x("//input[@value='" + project.getAccess() + "']").click();
        return this;
    }
    @Step("Click Update Project Button")
    public ProjectSettingsPage updateButtonClick() {
        $(UPDATE_BUTTON).click();
        return this;
    }

    @Step("Check project data")
    public ProjectSettingsPage checkProjectDataUI (Project project) {
        $("#project-name").shouldBe(value(project.getTitle()));
        $("#project-code").shouldHave(value(project.getCode()));
        $("#description-area").shouldHave(value(project.getDescription()));
        $x("//input[@value='" + project.getAccess() + "']").shouldBe(checked);
        return this;
    }



}

