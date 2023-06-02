package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class LoginTest extends BaseTest {
    @Test(description = "Login user by")
    public void login() {
        log.info("Login user by positive data");
        loginPage.openPage()
                .isPageOpened()
                .login()
                .isPageOpened();
    }
}
