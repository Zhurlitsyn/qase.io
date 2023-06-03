package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.SleepSomeTime;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Log4j2
public class Input {
    String label;
    String BASE_LOCATOR_XPATH = "//*[text()='%s']/ancestor::div[contains(@class, 'form-group')]//p";
    String BASE_LOCATOR_SUITE_XPATH = "//*[text()='%s']/../..//p";

    public Input(String label) {
        this.label = label;
    }
    public void writeCase(String text) {
        log.info("Writing {} into {}", text, label);
        $x((String.format(BASE_LOCATOR_XPATH, label))).click();
        $x((String.format(BASE_LOCATOR_XPATH, label))).clear();
        $x((String.format(BASE_LOCATOR_XPATH, label))).setValue(text);
        SleepSomeTime.delay(300);
    }

    public void writeSuite(String text) {
        log.info("Writing {} into {}", text, label);
        $x((String.format(BASE_LOCATOR_SUITE_XPATH, label))).click();
        $x((String.format(BASE_LOCATOR_SUITE_XPATH, label))).clear();
        $x((String.format(BASE_LOCATOR_SUITE_XPATH, label))).setValue(text);
        SleepSomeTime.delay(300);
    }

}
