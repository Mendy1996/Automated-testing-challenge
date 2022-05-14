package utilities;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverManagerFactory {
	PropertiesReader properties = new PropertiesReader();
	String navigateur = properties.getValue("browser");
	private WebDriver webDriver;
	String driverPath;		
	
	public DriverManagerFactory() {
		
	}

	public WebDriver getDriver() {		

		switch (navigateur.toLowerCase().trim()) {
		case "chrome":
			driverPath= properties.getValue("chromeDriver");
			System.setProperty("webdriver.chrome.driver", new File(driverPath).getAbsolutePath());
			webDriver= new ChromeDriver();
			webDriver.manage().deleteAllCookies();
			webDriver.manage().window().maximize();
			
			
			break;
		case "firefox":
			driverPath= properties.getValue("firefoxDriver");
			System.setProperty("webdriver.gecko.driver", new File(driverPath).getAbsolutePath());

			webDriver = new FirefoxDriver();
			webDriver.manage().window().maximize();
			webDriver.manage().deleteAllCookies();
			System.out.println("firefox is starting....");
			break;
			
		case "ie":
			driverPath= properties.getValue("IEDriver");
			System.setProperty("webdriver.ie.driver", new File(driverPath).getAbsolutePath());

			webDriver = new InternetExplorerDriver();
			webDriver.manage().deleteAllCookies();
			webDriver.manage().window().maximize();
			System.out.println("ie is starting....");
			break;
		default:
			driverPath= properties.getValue("chromeDriver");
			webDriver= new ChromeDriver();
			webDriver.manage().window().maximize();
			break;
		}
		return webDriver;

	}

}
