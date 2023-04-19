package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wrappers.DropDown;
import wrappers.Input;
import wrappers.TextArea;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class NewProjectPage extends BasePage {
    public static final By alertMessageText = By.className("toastMessage");

    //public NewProjectPage(WebDriver driver) {super(driver);}

    public NewProjectPage isPageOpened() {
        $("#createButton").shouldBe(Condition.visible);
        return this;
    }

    @Step("Wait opening Project page")
    public NewProjectPage openPP() {
        log.info("Wait opening Project page");
        open("/projects");
        waitForPageLoaded();
        return this;
    }

  /*  @Step("Filling new Account data")
    public NewProjectPage fillIn(Account account) {
        log.info("Filling new Account data {}", account);
        new Input(driver, "Account Name").write(account.getAccountName());
        new Input(driver, "Account Number").write(account.getAccountNumber());
        new DropDown(driver, "Rating").getDrop(account.getRating());
        new Input(driver, "Account Site").write(account.getAccountSite());
        //new Input(driver, "Parent Account").write(account.getParentAcc());
        new Input(driver, "Annual Revenue").write(account.getAnnualRevenue());
        new Input(driver, "Phone").write(account.getPhone());
        new Input(driver, "Fax").write(account.getFax());
        new Input(driver, "Website").write(account.getWebsite());
        new Input(driver, "Ticker Symbol").write(account.getTicketSymbol());
        new Input(driver, "SIC Code").write(account.getSicCode());
        new Input(driver, "Employees").write(account.getEmployees());
        new DropDown(driver, "Type").getDrop(account.getType());
        new DropDown(driver, "Industry").getDrop(account.getIndustry());
        new DropDown(driver, "Ownership").getDrop(account.getOwnership());

        new TextArea(driver, "Billing Street").write(account.getBillStreet());
        new Input(driver, "Billing City").writeAddress(account.getBillCity());
        new Input(driver, "Billing State/Province").writeAddress(account.getBillState());
        new Input(driver, "Billing Zip/Postal Code").writeAddress(account.getBillZip());
        new Input(driver, "Billing Country").writeAddress(account.getBillCountry());

        new TextArea(driver, "Shipping Street").write(account.getShipStreet());
        new Input(driver, "Shipping City").writeAddress(account.getShipCity());
        new Input(driver, "Shipping State/Province").writeAddress(account.getShipState());
        new Input(driver, "Shipping Zip/Postal Code").writeAddress(account.getShipZip());
        new Input(driver, "Shipping Country").writeAddress(account.getShipCountry());

        new Input(driver, "Number of Locations").write(account.getNumberOfLocation());
        new DropDown(driver, "Customer Priority").getDrop(account.getCustomerPriority());
        new DropDown(driver, "SLA").getDrop(account.getSla());
        new DropDown(driver, "Upsell Opportunity").getDrop(account.getUpsellOpportunity());
        //new DropDown(driver, "Active").getDrop(account.getActive());
        new Input(driver, "SLA Expiration Date").writeDay(account.getSlaExpirationDate());
        new Input(driver, "SLA Serial Number").write(account.getSlaSerialNumber());
        new TextArea(driver, "Description").write(account.getDescription());


        return this;
    }

    @Step("Click Save button")
    public void save() {
        log.info("Clicking Save button");
        driver.findElement(By.xpath("//button[text()='Save']")).click();
        SleepSomeTime.delay(200);

    }

    @Step("Check text alert Message")
    public String getMessage() {
        return driver.findElement(alertMessageText).getText();
    }*/
}

