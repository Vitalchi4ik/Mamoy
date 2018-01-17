package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Properties;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class MainPage extends Page {

    @CacheLookup
    @FindBy(id = "nav-icon4")
    private WebElement menuBtn;

    public MainPage(final WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainPage open() {
        log("Open page " + Properties.getBaseUrl());
        getDriver().get(Properties.getBaseUrl());
        return this;
    }

    public MenuPage clickMenuBtn(){
        getWait().until(visibilityOf(menuBtn));
        log("Click \"Menu\" button");
        menuBtn.click();
        return PageFactory.initElements(getDriver(), MenuPage.class);
    }


}
