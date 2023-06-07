package wrappers;

import com.codeborne.selenide.*;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.SleepSomeTime;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class DropDown {
    String label;
    String dropdown = "//label[text()='%s']/../div";
    String baseLocator = "//div[contains(@data-popper-placement, 'bottom-start')]//div[contains(@class, 'pG08Lh')][%s]";

    public DropDown(String label) {
        this.label = label;
    }

    public void setDrop(int d) {
        log.info("Click field {}", label);
        $x(String.format(dropdown, label)).click();
        SleepSomeTime.delay(1000);
        log.info("Select value {}", label);
        WebElement se = $x(String.format(baseLocator, d));
        log.info("Checking visibility of  {}", d);
        ByVisibleElement(se);
        log.info("Click on {}", d);
        se.click();
        SleepSomeTime.delay(500);
    }

    public void ByVisibleElement(WebElement Element) {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }

}
