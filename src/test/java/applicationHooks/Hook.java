package applicationHooks;

import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import utility.textReader;

public class Hook {
	private DriverFactory df;
	private WebDriver driver;
	private textReader cr;
	public static Properties prop;
	public static Scenario scn;

	@Before(order = 0)
	public void getProperty() {
		cr = new textReader();
		prop = cr.init_prop();
	}

	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		df = new DriverFactory(); // like baseUtility class
		driver = df.init_driver(browserName); // like startup method
	}

	@BeforeStep
	public void getScenarioInstance(Scenario scenario) {
		Hook.scn = scenario;
	}

	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void takeScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//			String sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
			scenario.attach(sourcePath, "image/png", screenshotName);
			/*
			 * try { //code for taking screenshot File scn =
			 * ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 * FileHandler.copy(scn, new File(System.getProperty("user.dir")
			 * +"\\screenshots\\screenshotName_DateTimeStamp.png")); } catch (IOException e)
			 * { e.printStackTrace(); }
			 */
		}
	}
}
