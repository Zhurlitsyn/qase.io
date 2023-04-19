package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.SleepSomeTime;
@Log4j2
public class TextArea {
    String label;
    WebDriver driver;
    String baseLocator = "//*[text()='%s']/../..//textarea";
    public TextArea(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }
    public void write(String text) {
        log.info("Writing {} into {}", text, label);
        driver.findElement(By.xpath(String.format(baseLocator, label))).sendKeys(text);
        SleepSomeTime.delay(300);
    }
}
