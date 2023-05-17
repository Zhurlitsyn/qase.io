package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginTest extends BaseTest {
    @Test(description = "Try login user")
    public void login() {
        log.info("Try login user");
        loginPage.openLP()
                .isPageOpened()
                .login()
                .isPageOpened();
    }
}
