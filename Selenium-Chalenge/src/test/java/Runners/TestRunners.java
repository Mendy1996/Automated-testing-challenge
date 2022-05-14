package Runners;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	plugin= {"pretty",
			"html:target/cucumber-reports/cucumber.html",
			"json:target/cucumber-reports/cucumber.json"
	},
	features= {"src/test/ressources/Feature"},
	glue= {"Steps"}
	
)
public class TestRunners extends AbstractTestNGCucumberTests{
	


}
