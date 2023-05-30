package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.SleepSomeTime;

import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class TextArea {
    String label;
    WebDriver driver;
    String baseLocator = "//*[text()='%s']/../..//textarea";
    public TextArea(String label) {
        this.label = label;
    }
    public void write(String text) {
        log.info("Writing {} into {}", text, label);
        $x((String.format(baseLocator, label))).setValue(text);
        SleepSomeTime.delay(300);
    }
}
