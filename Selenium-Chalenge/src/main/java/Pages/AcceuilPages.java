package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AcceuilPages extends BasePage{
	@FindBy(xpath = "//input[@placeholder=\"Search in alert history\"]")
	private WebElement barreDerecherche;

	public AcceuilPages(WebDriver driver) {
		super(driver);
		PageFactory.initElements(getDriver(), this);
	}
	
	public Boolean checkThatThisAlertExist(String alertName) {
		WebElement lenovoAlert = getDriver().findElement(By.xpath("//h4[@class=\"SidebarAlertItemName__DescriptionTooltip-sc-17w4p33-5 gZsvtu\" and contains(text(),'"+alertName+"')]"));
		return lenovoAlert.isDisplayed();
	}
	
	public Boolean checkThatIcanSeeMentionWithContent(String mentionContent) {
		WebElement mention = getDriver().findElement(By.xpath("//div[@class=\"mnt-FeedMentionDescription\" and contains(.,'"+mentionContent+"')]"));
		return mention.isDisplayed();
	}
	
	
	
	public void enterAKeyWordInSearchBar(String keyWord) throws InterruptedException {
		Thread.sleep(3000);
		setText(barreDerecherche, keyWord);		
		barreDerecherche.sendKeys(Keys.ENTER);
	}

}
