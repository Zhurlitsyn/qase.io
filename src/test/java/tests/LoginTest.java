package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginTest extends BaseTest {
    @Test(description = "Login user by")
    public void login() {
        log.info("Try login user");
        loginPage.openPage()
                .isPageOpened()
                .login()
                .isPageOpened();
    }
    /*
    *  @Test AI
    void testAuthorization() {
        open("/login");
        $("#login-form").shouldBe(visible);
        $("#login").setValue("test");
        $("#password").setValue("test");
        $("#remember").setSelected(true);
        $("#login-form button[type='submit']").click();
        $("body").shouldHave(url("https://qase.io/app"));
    }
    * */
}
