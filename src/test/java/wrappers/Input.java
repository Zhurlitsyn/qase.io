package wrappers;

import lombok.extern.log4j.Log4j2;
import utils.DelayTime;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class Input {
    String label;
    String BASE_LOCATOR_SUITE_XPATH = "//*[text()='%s']/../..//p";
    String BASE_LOCATOR_CASE_XPATH = "//*[text()='%s']/..//p";

    public Input(String label) {
        this.label = label;
    }

    public void writeCase(String text) {
        log.info("Writing {} into {}", text, label);
        $x((String.format(BASE_LOCATOR_CASE_XPATH, label))).click();
        DelayTime.delay(500);
        $x((String.format(BASE_LOCATOR_CASE_XPATH, label))).setValue(text);
        DelayTime.delay(300);

    }

    public void editCase(String text) {
        log.info("Writing {} into {}", text, label);
        $x((String.format(BASE_LOCATOR_CASE_XPATH + "[@class='']", label))).click();
        DelayTime.delay(500);
        $x((String.format(BASE_LOCATOR_CASE_XPATH + "[@class='']", label))).setValue(text);
        DelayTime.delay(300);

    }

    public void write(String text) {
        log.info("Writing {} into {}", text, label);
        $x((String.format(BASE_LOCATOR_SUITE_XPATH, label))).click();
        DelayTime.delay(300);

        $x((String.format(BASE_LOCATOR_SUITE_XPATH, label))).clear();
        $x((String.format(BASE_LOCATOR_SUITE_XPATH, label))).setValue(text);
        DelayTime.delay(300);
    }

    public void edit(String text) {
        log.info("Writing new {} into {}", text, label);
        $x((String.format(BASE_LOCATOR_SUITE_XPATH + "[@class='']", label))).click();
        DelayTime.delay(300);
        $x((String.format(BASE_LOCATOR_SUITE_XPATH + "[@class='']", label))).setValue(text);
        DelayTime.delay(2000);
    }

    public void edit(String text) {
        log.info("Writing new {} into {}", text, label);
        $x((String.format(BASE_LOCATOR_SUITE_XPATH + "[@class='']", label))).click();
        SleepSomeTime.delay(300);
        $x((String.format(BASE_LOCATOR_SUITE_XPATH + "[@class='']", label))).clear();
        $x((String.format(BASE_LOCATOR_SUITE_XPATH + "[@class='']", label))).setValue(text);
        SleepSomeTime.delay(2000);
    }

}
