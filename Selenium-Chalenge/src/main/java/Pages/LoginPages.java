package Pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class LoginPages extends BasePage{
	
	@FindBy(name ="username")
	private WebElement champLogin;
	@FindBy(name = "password")
	private WebElement champPassword;
	@FindBy(xpath = "//div[@type='submit' and contains(text(),'Connexion')]")
	private WebElement boutonConnexion;    
 

    public LoginPages(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    public void toLogin(String login, String mdp){    	
        setText(champLogin, login);
        setText(champPassword, mdp);
        clickElement(boutonConnexion);         
    }

}
