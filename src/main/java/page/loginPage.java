package page;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import factory.DriverFactory;
import utility.ElementUtil;

public class loginPage {
	private WebDriver driver;

	@FindBy(xpath = "//input[@id='username']")
	private WebElement userName;

	@FindBy(xpath = "//input[@name='pwd']")
	private WebElement password;

	@FindBy(xpath = "//a[@id='loginButton']/div")
	private WebElement loginButton;

	@FindBy(xpath = "//input[@id='keepLoggedInCheckBox']")
	private WebElement keepMeLoggedInCheckbox;

	/*
	 * private By userName = By.xpath("//input[@id='username']"); private By
	 * password = By.xpath("//input[@name='pwd']"); private By loginButton =
	 * By.xpath("//a[@id='loginButton']/div"); private By keepMeLoggedInCheckbox =
	 * By.xpath("//input[@id='keepLoggedInCheckBox']");
	 */

	public loginPage(WebDriver driver) // constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isKeepMeLoggedInCheckBoxDisplayed() {
		return keepMeLoggedInCheckbox.isDisplayed();
	}

	public void enterUserName(String username) {
		userName.sendKeys(username);
	}

	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public TasksPage doLogin(String username, String pwd) {
		System.out.println("Login creds: " + username + " and " + pwd);
		userName.sendKeys(username);
		password.sendKeys(pwd);
		loginButton.click();
		ElementUtil.eu.waitForPageLoad(DriverFactory.getDriver());
		return new TasksPage(driver);
	}
}