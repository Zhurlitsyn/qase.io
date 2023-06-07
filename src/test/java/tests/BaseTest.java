package tests;

import adapters.BaseAdapter;
import adapters.CaseAdapter;
import adapters.ProjectAdapter;
import adapters.SuiteAdapter;
import com.codeborne.selenide.Configuration;
import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;
import tests.base.TestListener;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
@Log4j2
@Listeners({TestListener.class})
public class BaseTest {
    LoginPage loginPage;
    ProjectListPage projectListPage;
    ProjectSettingsPage projectSettingsPage;
    ProjectPage projectPage;
    BaseAdapter baseAdapter;
    ProjectAdapter projectAdapter;
    SuitePage suitePage;
    SuiteAdapter suiteAdapter;
    CasePage casePage;
    CaseAdapter caseAdapter;
    RepositoryPage repositoryPage;

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser, ITestContext testContext) {
        Configuration.timeout = 9000;
        Configuration.headless = true;
        Configuration.clickViaJs = false;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = PropertyReader.getProperty("base.url");
        if (browser.equals("chrome")) {
            Configuration.browser = "chrome";
        } else if (browser.equals("firefox")) {
            Configuration.browser = "firefox";
        }
        testContext.setAttribute("browser", browser);

        loginPage = new LoginPage();
        projectListPage = new ProjectListPage();
        projectPage = new ProjectPage();
        projectSettingsPage = new ProjectSettingsPage();
        baseAdapter = new BaseAdapter();
        projectAdapter = new ProjectAdapter();
        suitePage = new SuitePage();
        suiteAdapter = new SuiteAdapter();
        casePage = new CasePage();
        caseAdapter = new CaseAdapter();
        repositoryPage = new RepositoryPage();

    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        if (getWebDriver() != null) {
            getWebDriver().quit();
        }
    }
}
