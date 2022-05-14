package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

import java.sql.Driver;
import java.time.Duration;

public class BasePage {
    private WebDriver driver;
    private Wait<WebDriver> wait;
    

    public BasePage(WebDriver webDriver) {
    	this.driver = webDriver;
    	this.wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(UnhandledAlertException.class);
    }

   
    void setText(WebElement we, String text) {
    	waitForElementToBeDisplayed(we).sendKeys(text);
    }


    void clickElement(WebElement we) {
        we.click();
    }
    
    WebElement waitForElementToBeDisplayed(WebElement we) {
        wait.until(ExpectedConditions.visibilityOf(we));
        return we ;
    }
    
    public WebDriver getDriver() {
    	return driver;
    }
    
    public Boolean verifierQueElementEstAffiché(WebElement we) {
        return waitForElementToBeDisplayed(we).isDisplayed();
    }
   
    
    
    

}
