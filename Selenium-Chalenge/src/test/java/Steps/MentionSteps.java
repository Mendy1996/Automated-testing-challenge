package Steps;

import java.util.concurrent.TimeUnit;

//import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.AcceuilPages;
import Pages.LoginPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.fr.Etantdonné;
import io.cucumber.java.fr.Lorsque;
import utilities.PropertiesReader;

public class MentionSteps extends BaseStep{
	
	LoginPages loginPage = new LoginPages(lewebDriver);
	AcceuilPages acceuilPages = new AcceuilPages(lewebDriver);
	
	public MentionSteps() {
		super();		
	}

	@Given("^As a user, I open Mention website$")
    public void beforeTest() throws InterruptedException
    {
		lewebDriver.get(PropertiesReader.getValue("url"));
		lewebDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   
    } 
	
	@Etantdonné("^I login with the username \\\"(.*)\\\" and password \\\"(.*)\\\"$")
    public void iLogWithTheUsernameAndThePassword(String login, String mdp) {
		
		loginPage.toLogin(login, mdp);
    }
	
	@When("^I check that I can see an alert named \\\"(.*)\\\" in the sidebar$")
    public void checkThatIcanSeeThisAlert(String alertName) {
        Assert.assertTrue(acceuilPages.checkThatThisAlertExist(alertName),"I can see the alert named \""+alertName+"\"");
    }
    
	@And("^I enter the keyword \\\"(.*)\\\" in the search field and submit the search$")
    public void searchForAnAlert(String keyword) throws InterruptedException {
		acceuilPages.enterAKeyWordInSearchBar(keyword);
	}
	
	@Then("^I check that I can see a mention with content \\\"(.*)\\\"$")
	public void checkMentionWithContent(String content) {
	    // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(acceuilPages.checkThatIcanSeeMentionWithContent(content),"then mention with the content \""+content+"\" is visible");
	}
	
	


}
