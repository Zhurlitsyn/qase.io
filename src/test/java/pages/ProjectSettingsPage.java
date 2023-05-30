package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.xml.xpath.XPath;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class ProjectSettingsPage extends BasePage {

    public static final By DELETE_BUTTON = By.xpath("//*[text()=' Delete project']");
    public static final By DELETE_MODAL_BUTTON = By.xpath("//button/span[text()='Delete project']");
    public static final String UPDATE_BUTTON = "[type='submit']";
    public static final By TITLE_SET = By.tagName("h1");


    public ProjectSettingsPage isPageOpened() {
        $(TITLE_SET).shouldBe(Condition.visible);
        return this;
    }

    @Step("Wait opening Project Settings page")
    public ProjectSettingsPage openSettingsPage(String name) {
        log.info("Wait opening Project Settings page");
        open(String.format("%s/settings/general", name));
        waitForPageLoaded();
        return this;
    }

    @Step("Click Delete Project Button")
    public ProjectListPage deleteButtonClick() {
        $(DELETE_BUTTON).click();
        $(DELETE_MODAL_BUTTON).click();
        return new ProjectListPage();
    }


    @Step("Click Delete Project Button")
    public ProjectSettingsPage updateButtonClick() {
        $(UPDATE_BUTTON).click();
        return this;
    }
}

