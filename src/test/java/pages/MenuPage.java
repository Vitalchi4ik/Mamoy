package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class MenuPage extends Page {

    @CacheLookup
    @FindBy(xpath = "//li/a[contains(text(),'Бронирование')]")
    private WebElement booking;

    public MenuPage(final WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public BookingPage clickBookingButton() {
        getWait().until(visibilityOf(booking));
        log("Click \"Booking\" button");
        booking.click();
        return PageFactory.initElements(getDriver(), BookingPage.class);
    }

}
