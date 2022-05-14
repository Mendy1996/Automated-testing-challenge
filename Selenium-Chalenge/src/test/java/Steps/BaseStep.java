package Steps;

import org.openqa.selenium.WebDriver;



import io.cucumber.java.en.Given;
import utilities.DriverManagerFactory;
import utilities.PropertiesReader;


public class BaseStep {
	DriverManagerFactory driverManager = new DriverManagerFactory();
	public WebDriver lewebDriver = driverManager.getDriver();
}
