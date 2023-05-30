package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.SleepSomeTime;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class ProjectListPage extends BasePage {

    public static final String CREATE_BUTTON = "#createButton";
    public static final By PROJECTS_CODES = By.xpath("//*[@class='project-row']//a[@class='defect-title']");
    public static List<WebElement> listOfProjects;
    public int listSize;
    public String lastProjectCode;


    public ProjectListPage isPageOpened() {
        $(CREATE_BUTTON).shouldBe(Condition.visible);
        SleepSomeTime.delay(10000);
        return this;
    }

    @Step("Wait opening Project page")
    public ProjectListPage openPage() {
        log.info("Wait opening Project page");
        open("/projects");
        waitForPageLoaded();
        return this;
    }

    @Step("Click Create Button")
    public NewProjectPage createButtonClick() {
        $(CREATE_BUTTON).click();
        return new NewProjectPage();
    }

    @Step("Create List of Project Names")
    public List<WebElement> createProjectList() {
        log.info("Create List of Projects");
        if (listOfProjects != null) {
            listOfProjects.clear();
        }
        return listOfProjects = WebDriverRunner.getWebDriver().findElements(PROJECTS_CODES);
    }

    @Step("Getting size of List")
    public Integer getListSize(List<WebElement> list) {
        return list.size();
    }

    @Step("Getting last name of Project from List")
    public String getProjectName(List<WebElement> list, Integer i) {
        return lastProjectCode = list.get(list.size() - i).getAttribute("href");
    }

}

