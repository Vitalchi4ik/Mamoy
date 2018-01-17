package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class BookingPage extends Page {

    public BookingPage(final WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(name = "userName")
    private WebElement nameField;

    @CacheLookup
    @FindBy(name = "userPhone")
    private WebElement phoneField;

    @CacheLookup
    @FindBy(name = "date")
    private WebElement dateBtn;

    @CacheLookup
    @FindBy(xpath = "//a/span[contains(text(),'Next')]")
    private WebElement nextDate;

    @CacheLookup
    @FindBy(xpath = "//td/a[contains(text(),'27')]")
    private WebElement date27OfFebruary;

    @CacheLookup
    @FindBy(xpath = "//div/b[@class = 'button' and contains(text(),'▾')]")
    private WebElement timeButton;

    @CacheLookup
    @FindBy(xpath = "//*[@id='mCSB_5_container']/ul/li[contains(text(),'18:00')]")
    private WebElement time1800;

    @CacheLookup
    @FindBy(xpath = "//a/span[contains(text(),'▲')]")
    private WebElement countOfPeople;

    @CacheLookup
    @FindBy(className = "submit-but")
    private WebElement booikingBtn;

    public BookingPage sendKeysIntoNameField(String name) {
        getWait().until(visibilityOf(nameField));
        log("Send keys into \"Name field\" " + name);
        nameField.sendKeys(name);
        return this;
    }

    public BookingPage sendKeysIntoPhoneField(String phone) {
        getWait().until(visibilityOf(phoneField));
        log("Send keys into \"Phone field\" " + phone);
        phoneField.sendKeys(phone);
        return this;
    }

    public BookingPage clickDateBtn() {
        getWait().until(visibilityOf(dateBtn));
        log("Click \"Date\" button");
        dateBtn.click();
        return this;
    }

    public BookingPage clickNextDateBtn() {
        getWait().until(visibilityOf(nextDate));
        log("Click \"Next Date\" button");
        nextDate.click();
        return this;
    }

    public BookingPage clickDate27ofFebruaryBtn() {
        getWait().until(visibilityOf(date27OfFebruary));
        log("Click \"27 of February\" button");
        date27OfFebruary.click();
        return this;
    }

    public BookingPage clickTimeBtn() {
        getWait().until(visibilityOf(timeButton));
        log("Click \"Time\" button");
        timeButton.click();
        return this;
    }

    public BookingPage clickTime1800Btn() {
        log("Click \"18:00\" button");
        clickWithJS(time1800);
        return this;
    }

    public BookingPage clickCountOfPeople() {
        getWait().until(visibilityOf(countOfPeople));
        log("Click \">\" button count of people");
        countOfPeople.click();
        return this;
    }

    public BookingPage clickSubmitButton() {
        getWait().until(visibilityOf(booikingBtn));
        log("Click \"Booking\" button");
        booikingBtn.click();
        return this;
    }

    public String getAlertText() {
        Alert alert = getDriver().switchTo().alert();
        log("Get alert text message");
        return alert.getText();
    }

}
