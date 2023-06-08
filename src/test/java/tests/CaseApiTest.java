package tests;

import adapters.CaseAdapter;
import adapters.ProjectAdapter;
import adapters.SuiteAdapter;
import dto.*;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class CaseApiTest extends ApiBaseTest {
    @Test(description = "Create case by API")
    public void createCaseApi() {
        log.info("Creating random data");
        Project project = new ProjectFactory().getRandom();
        project.setAccess(ProjectFactory.getRandomAccessApi());
        log.info("Creating new random data for Suite");
        Suite suite = new SuiteFactory().getRandom();
        log.info("Creating new random data for CaseOne");
        CaseApi caseOne = new CaseFactoryApi().getRandom();
        log.info("Creating project with random data");
        new ProjectAdapter().create(project);
        new SuiteAdapter().create(suite, project.getCode());
        new CaseAdapter().create(caseOne, project.getCode());
        ProjectAdapter.delete(project.getCode());
    }

    @Test(description = "Delete project data by API")
    public void deleteCaseApi() {
        log.info("Creating random data");
        Project project = new ProjectFactory().getRandom();
        project.setAccess(ProjectFactory.getRandomAccessApi());
        log.info("Creating new random data for Suite");
        Suite suite = new SuiteFactory().getRandom();
        log.info("Creating new random data for CaseOne");
        CaseApi caseOne = new CaseFactoryApi().getRandom();
        log.info("Creating project with random data");
        new ProjectAdapter().create(project);
        new SuiteAdapter().create(suite, project.getCode());
        new CaseAdapter().create(caseOne, project.getCode());
        CaseAdapter.delete(project.getCode(), 1);
        ProjectAdapter.delete(project.getCode());
    }

    @Test(description = "Delete project data by API")
    public void updateCaseApi() {
        log.info("Creating random data");
        Project project = new ProjectFactory().getRandom();
        project.setAccess(ProjectFactory.getRandomAccessApi());
        log.info("Creating new random data for Suite");
        Suite suite = new SuiteFactory().getRandom();
        log.info("Creating new random data for CaseOne & CaseNew");
        CaseApi caseOne = new CaseFactoryApi().getRandom();
        CaseApi caseNew = new CaseFactoryApi().getRandom();
        log.info("Creating project with random data");
        new ProjectAdapter().create(project);
        new SuiteAdapter().create(suite, project.getCode());
        new CaseAdapter().create(caseOne, project.getCode());
        CaseAdapter.update(caseNew, project.getCode(), 1);
        ProjectAdapter.delete(project.getCode());
    }
}
