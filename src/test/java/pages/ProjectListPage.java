package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.DelayTime;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static pages.ProjectSettingsPage.DELETE_MODAL_BUTTON_XPATH;

@Log4j2
public class ProjectListPage extends BasePage {

    public static final By CREATE_BUTTON_CSS = By.id("createButton");
    public static final String PROJECTS_H1_CSS = "//span[text()='Create new project']";
    public static final String PROJECTS_CODES =
            "//*[@class='project-row']//a[@class='defect-title' and text()='%s']";
    public static final String DROPDOWN_PROJECT_BUTTON =
            "//*[text()='%s']/ancestor::tr//a[@class='btn btn-dropdown']";
    public static final String DROPDOWN_DELETE_BUTTON =
            "//*[@class='defect-title'][text()='%s']/ancestor::tr//button[text()='Delete']";


    public ProjectListPage isPageOpenedClear() {
       log.info("Waiting visibility of 'Create new project button'");
        waitForPageLoaded();
        $x(PROJECTS_H1_CSS).shouldBe(Condition.visible);
        return this;
    }
    public ProjectListPage isPageOpened(String name) {
       log.info("Waiting visibility of 'Project' list");
        waitForPageLoaded();
        $x(String.format(PROJECTS_CODES, name)).shouldBe(Condition.visible);
        return this;
    }

    @Step("Waits opening Project page")
    public ProjectListPage openPage() {
       log.info("Wait opening Project page");
        open("/projects");
        waitForPageLoaded();
        return this;
    }

    @Step("Click Create Button")
    public ProjectPage createButtonClick() {
        $(CREATE_BUTTON_CSS).click();
        return new ProjectPage();
    }

    @Step("Create List of Project Names")
    public Integer getCountOfProjects() {
       log.info("Get count of Projects");
        return $$x(PROJECTS_CODES).size();
    }

    @Step("Deleting project from ProjectListPage")
    public void deleteProject(String name) {
       log.info("Deleting project by 'Delete' modal button");
        $x(String.format(DROPDOWN_PROJECT_BUTTON, name)).shouldBe(Condition.visible);
        $x(String.format(DROPDOWN_PROJECT_BUTTON, name)).click();
        $x(String.format(DROPDOWN_DELETE_BUTTON, name)).click();
        $x(DELETE_MODAL_BUTTON_XPATH).shouldBe(Condition.visible);
        $x(DELETE_MODAL_BUTTON_XPATH).click();
    }
}

