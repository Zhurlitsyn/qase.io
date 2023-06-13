package tests;

import adapters.BaseAdapter;
import adapters.CaseAdapter;
import adapters.ProjectAdapter;
import adapters.SuiteAdapter;
import com.codeborne.selenide.Configuration;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.*;
import pages.CasePage;
import pages.SuitePage;
import tests.base.TestListener;
import utils.PropertyReader;

@Log4j2
@Listeners({TestListener.class})
public class ApiBaseTest {
    BaseAdapter baseAdapter;
    ProjectAdapter projectAdapter;
    CaseAdapter caseAdapter;
    SuiteAdapter suiteAdapter;

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        Configuration.baseUrl = PropertyReader.getProperty("base.api.url");
        if (browser.equals("chrome")) {
            Configuration.browser = "chrome";
        } else if (browser.equals("firefox")) {
            Configuration.browser = "firefox";
        }
        baseAdapter = new BaseAdapter();
        projectAdapter = new ProjectAdapter();
        caseAdapter = new CaseAdapter();
        suiteAdapter = new SuiteAdapter();
    }

}
