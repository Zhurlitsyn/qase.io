package tests;

import com.codeborne.selenide.Configuration;
import dto.Project;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.LoginPage;
import pages.NewProjectPage;
import pages.ProjectListPage;
import pages.ProjectSettingsPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
@Log4j2
@Listeners({TestListener.class})
public class BaseTest {
    LoginPage loginPage;
    ProjectListPage projectListPage;
    ProjectSettingsPage projectSettingsPage;
    NewProjectPage newProjectPage;
    @BeforeMethod
    public void setUp(ITestContext testContext) {
        Configuration.timeout = 4000;
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.clickViaJs = false;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://app.qase.io";

       // testContext.setAttribute("driver", getWebDriver());

        loginPage = new LoginPage();
        projectListPage = new ProjectListPage();
        newProjectPage = new NewProjectPage();
        projectSettingsPage = new ProjectSettingsPage();
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        if (getWebDriver() != null) {
            getWebDriver().quit();
        }
    }
}
