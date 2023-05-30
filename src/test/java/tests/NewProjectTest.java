package tests;

import adapters.ProjectAdapter;
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
public class NewProjectTest extends BaseTest {
    @Test
    public void createNewProject() {

        log.info("Login user");
        loginPage.openPage()
                .isPageOpened()
                .login()
                .isPageOpened()
                .createButtonClick();
        newProjectPage.isPageOpened();
        Project project = new ProjectFactory().getRandom();
        newProjectPage.fillIn(project)
                .createProjectButtonClick();
        $(byText("Create project")).should(Condition.disappear);
        open(String.format("/project/%s/settings/general", project.getCode()));

        $("#project-name").shouldBe(value(project.getTitle()));
        $("#project-code").shouldHave(value(project.getCode()));
        $("#description-area").shouldHave(value(project.getDescription()));

    }

    @Test
    public void createQProject() {
        Project project = new ProjectFactory().getRandom();
        new ProjectAdapter().create(project);
    }
}
