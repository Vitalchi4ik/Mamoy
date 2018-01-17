package properties;

import data.EditData;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import pages.BookingPage;
import pages.MenuPage;
import pages.SearchResultsPage;

public class GeneralActions {
    private final WebDriver driver;
    private MenuPage menuPage;
    private BookingPage bookingPage;
    private static SearchResultsPage searchResultsPage;

    public GeneralActions(final WebDriver driver){
        this.driver = driver;
    }

    public void fillTheBookingForm(final String name, final String telephone){
        MainPage mainPage = new MainPage(driver);

            this.menuPage = mainPage.open()
                    .clickMenuBtn();
                    this.bookingPage = menuPage.clickBookingButton()
                            .sendKeysIntoNameField(name)
                            .sendKeysIntoPhoneField(telephone)
                            .clickDateBtn()
                            .clickNextDateBtn()
                            .clickDate27ofFebruaryBtn()
                            .clickTimeBtn()
                            .clickTime1800Btn()
                            .clickCountOfPeople()
                            .clickSubmitButton();
    }

    public String getAllertTextMessage(){
        bookingPage = new BookingPage(driver);
        return bookingPage.getAlertText();
    }

    public void fillEmptyTheBookingForm(){
        MainPage mainPage = new MainPage(driver);

        this.menuPage = mainPage.open()
                .clickMenuBtn();
        this.bookingPage = menuPage.clickBookingButton()
                .clickSubmitButton();
    }

    public boolean findErrorMessageEmptyName(EditData editData)
    {
        return SearchResultsPage.containsEmptyNameField(editData.getErrorMsgEmptyName(), this.driver);
    }

    public boolean findErrorMessageEmptyPhone(EditData editData)
    {
        return SearchResultsPage.containsEmptyPhoneField(editData.getErrorMsgEmptyPhone(), this.driver);
    }

    public boolean findErrorMessageWrongPhone(EditData editData)
    {
        return SearchResultsPage.containsWrongPhoneField( editData.getErrorMsgEmptyPhone(),
                editData.getErrorMsgWrongFormatPhone(), this.driver);
    }

}
