package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import utils.PropertyReader;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class LoginPage extends BasePage {
    public static final String USERNAME_INPUT = "email";
    public static final String PASSWORD_INPUT = "password";
    public static final String LOGIN_BUTTON_CSS = "button[type='submit']";
    public static final String REMEMBER_CHECKBOX = "remember";

    @Step("Opening Login Page")
    public LoginPage openPage() {
        log.info("Opening Login Page");
        open("/login");
        return this;
    }

    public LoginPage isPageOpened() {
        $(LOGIN_BUTTON_CSS).shouldBe(Condition.visible);
        return this;
    }

    @Step("Login user")
    public ProjectListPage login() {
        log.info("Login user by positive data");
        String logUser = System.getProperty("username", PropertyReader.getProperty("username"));
        String logPswrd = System.getProperty("password", PropertyReader.getProperty("password"));
        $(byName(USERNAME_INPUT)).setValue(logUser);
        $(byName(PASSWORD_INPUT)).setValue(logPswrd);
        $(byName(REMEMBER_CHECKBOX)).click();
        $(LOGIN_BUTTON_CSS).click();
        return new ProjectListPage();
    }
}

