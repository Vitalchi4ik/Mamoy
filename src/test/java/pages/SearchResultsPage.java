package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class SearchResultsPage extends Page{

    public SearchResultsPage(final WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    private static WebElement errorMesgNameInPage;

    @CacheLookup
    private static WebElement errorMesgPhoneInPage;

    @CacheLookup
    private static WebElement errorMesgWrongPhoneInPage;



    public static boolean containsEmptyNameField(String errorMessageNameField, WebDriver driver) {
        String expr = String.format("//div[@class = 'formErrorContent' and contains(text(),'%s')]",
                errorMessageNameField);
        log("Looking for error message of empty field of name");
        errorMesgNameInPage = driver.findElement(By.xpath(expr));
        return errorMesgNameInPage.isDisplayed();
    }

    public static boolean containsEmptyPhoneField(String errorMessagePhoneField, WebDriver driver) {
        String expr = String.format("//div[contains(text(),'%s')]", errorMessagePhoneField);
        log("Looking for error message of empty field of phone");
        errorMesgPhoneInPage = driver.findElement(By.xpath(expr));
        return errorMesgPhoneInPage.isDisplayed();
    }

    public static boolean containsWrongPhoneField(String errorMessageEmptyField, String errorMessageWrongPhoneField,
                                                  WebDriver driver) {
        String expr = String.format("//div[contains(text(),'%s')]", errorMessageEmptyField,
                "/br[contains(text(),'%s')]", errorMessageWrongPhoneField);
        log("Looking for error message wrong field of phone");
        errorMesgWrongPhoneInPage = driver.findElement(By.xpath(expr));
        return errorMesgWrongPhoneInPage.isDisplayed();
    }






}