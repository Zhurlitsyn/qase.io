package tests;

import com.codeborne.selenide.Condition;
import dto.Project;
import dto.ProjectFactory;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class UpdateSettingsProjectTest extends BaseTest {
    @Test(description = "Try update settings of project")
    public void updateSettingsProject() {
        log.info("Login user");
        loginPage.openLP()
                .isPageOpened()
                .login()
                .isPageOpened()
                .createButtonClick();
        newProjectPage.isPageOpened();
        Project project = new ProjectFactory().getRandom();
        log.info("Filling project date");
        newProjectPage.fillIn(project)
                .createProjectButtonClick();
        $(byText("Create project")).should(Condition.disappear);
        open(String.format("/project/%s/settings/general", project.getCode()));
        log.info("Check data of settings");
        $("#project-name").shouldBe(value(project.getTitle()));
        $("#project-code").shouldHave(value(project.getCode()));
        $("#description-area").shouldHave(value(project.getDescription()));
        log.info("Filling with new data");
        projectListPage.openPage();
        open(String.format("/project/%s/settings/general", project.getCode()));
        project = new ProjectFactory().getRandom();
        newProjectPage.fillIn(project);
        projectSettingsPage.updateButtonClick();
        $("#project-name").shouldBe(value(project.getTitle()));
        $("#project-code").shouldHave(value(project.getCode()));
        $("#description-area").shouldHave(value(project.getDescription()));




    }
}
