package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {".\\src\\test\\resources\\configerdFiles\\featuresFiles"},
		glue= {"stepDefinations", "applicationHooks"},
		monochrome=true,
		dryRun=false,
		plugin= {
				
				"pretty",
				"html:target/html_report/cucumber_reports.html",
				"junit:target/junit_report/junit_reports.xml",
				"json:target/json_report/json_reports.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		
		}
		)
public class MyRunner {

}
