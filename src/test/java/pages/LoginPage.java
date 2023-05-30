package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class LoginPage extends BasePage {
    public static final String USERNAME_INPUT = "#inputEmail";
    public static final String PASSWORD_INPUT = "#inputPassword";
    public static final String LOGIN_BUTTON = "#btnLogin";

    @Step("Opening Login Page")
    public LoginPage openLP() {
        log.info("Opening Login Page");
        open("/login");
        return this;
    }

    public LoginPage isPageOpened() {
        $(LOGIN_BUTTON).shouldBe(Condition.visible);
        return this;
    }

    @Step("Login by user")
    public ProjectListPage login() {
        log.info("Login by user");
        String logUser = System.getProperty("username", PropertyReader.getProperty("USERNAME"));
        String logPswrd = System.getProperty("password", PropertyReader.getProperty("PASSWORD"));
        $(USERNAME_INPUT).setValue(logUser);
        $(PASSWORD_INPUT).setValue(logPswrd);
        $(LOGIN_BUTTON).click();
        return new ProjectListPage();
    }
}

