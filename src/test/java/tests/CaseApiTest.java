package tests;

import dto.*;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class CaseApiTest extends ApiBaseTest {
    @Test(description = "Create case by API")
    public void createCaseApi() {
        Project project = new ProjectFactory().getRandom();
        project.setAccess(ProjectFactory.getRandomAccessApi());
        Suite suite = new SuiteFactory().getRandom();
        TestCase caseOne = new TestCaseFactory().getRandom();
        projectAdapter.create(project);
        suiteAdapter.create(suite, project.getCode());
        caseAdapter.create(caseOne, project.getCode());
        projectAdapter.delete(project.getCode());

    }

    @Test(description = "Delete project data by API")
    public void deleteCaseApi() {
        Project project = new ProjectFactory().getRandom();
        project.setAccess(ProjectFactory.getRandomAccessApi());
        Suite suite = new SuiteFactory().getRandom();
        TestCase caseOne = new TestCaseFactory().getRandom();
        projectAdapter.create(project);
        suiteAdapter.create(suite, project.getCode());
        caseAdapter.create(caseOne, project.getCode());
        caseAdapter.delete(project.getCode(), 1);
        projectAdapter.delete(project.getCode());
    }

    @Test(description = "Delete project data by API")
    public void updateCaseApi() {
        Project project = new ProjectFactory().getRandom();
        project.setAccess(ProjectFactory.getRandomAccessApi());
        Suite suite = new SuiteFactory().getRandom();
        TestCase caseOne = new TestCaseFactory().getRandom();
        TestCase caseNew = new TestCaseFactory().getRandom();
        projectAdapter.create(project);
        suiteAdapter.create(suite, project.getCode());
        caseAdapter.create(caseOne, project.getCode());
        caseAdapter.update(caseNew, project.getCode(), 1);
        projectAdapter.delete(project.getCode());

    }
}
