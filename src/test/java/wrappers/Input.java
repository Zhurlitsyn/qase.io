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
    String baseLocator = "//*[text()='%s']/../..//input";

    public Input(String label) {
        getWebDriver();
        this.label = label;
    }
    public void write(String text) {
        log.info("Writing {} into {}", text, label);
        $x((String.format(baseLocator, label))).setValue(text);
        SleepSomeTime.delay(300);
    }

}
