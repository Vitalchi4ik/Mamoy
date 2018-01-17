package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public abstract class Page {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public Page(final WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        Reporter.setEscapeHtml(false);
        PageFactory.initElements(driver, this);
    }

    protected static void log(String message){
        Reporter.log(message + "<br>");
    }

    protected void clickWithJS(final WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    protected WebDriver getDriver(){
        return driver;
    }

    protected WebDriverWait getWait(){
        return wait;
    }
}
