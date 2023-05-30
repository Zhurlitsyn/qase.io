package tests;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

@Log4j2
public class DeleteLastProjectTest extends BaseTest {
    @Test(description = "Deleting last project")
    public void deleteLast() {
        loginPage.openPage()
                .isPageOpened()
                .login()
                .isPageOpened();

        List<WebElement> list = projectListPage.createProjectList();
        String lastCode = projectListPage.getProjectName(list, 1);
        String nextLastCode = projectListPage.getProjectName(list, 2);
        int size = projectListPage.getListSize(list);

        projectSettingsPage.openSettingsPage(lastCode)
                .isPageOpened()
                .deleteButtonClick();
        list.clear();
        list = projectListPage.createProjectList();
        lastCode = projectListPage.getProjectName(list, 1);
        assertEquals(nextLastCode, lastCode, "Names not equals");

    }
}
