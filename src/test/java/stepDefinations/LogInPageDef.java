package stepDefinations;

import org.testng.Assert;

import applicationHooks.Hook;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.loginPage;

public class LogInPageDef {

	private static String title;
	private loginPage lp = new loginPage(DriverFactory.getDriver());

	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
		DriverFactory.getDriver().get(Hook.prop.getProperty("url"));
	}

	@When("User gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = lp.getLoginPageTitle();
		System.out.println("Login page title is : " + title);
	}

	@Then("Title of login page should be {string}")
	public void title_of_login_page_should_be(String expectedTitle) {
		Assert.assertTrue(title.contains(expectedTitle));
	}

}