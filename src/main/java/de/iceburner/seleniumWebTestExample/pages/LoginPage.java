package de.iceburner.seleniumWebTestExample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import de.iceburner.seleniumWebTestExample.util.CommonParameters;
import de.iceburner.seleniumWebTestExample.util.LoopHelper;

/**
 * Class representing the login page, providing its functionality
 *
 * @author Thomas Eisbrenner
 *
 */
public class LoginPage extends WebPage {

	private static final String LOGIN_PAGE_URL = "https://platform.simscale.com//#authentication";

	@FindBy(id = "nameTextBox")
	private WebElement nameTextBox;

	@FindBy(id = "passwordTextBox")
	private WebElement passwordTextBox;

	@FindBy(id = "loginButton")
	private WebElement loginButton;

	public LoginPage(WebDriver driver) {
		super(driver);
		mPageUrl = LOGIN_PAGE_URL;
	}

	@Override
	protected void waitForPageLoadedCorrectly() {
		LoopHelper<Boolean> pageLoadLoop = new LoopHelper<Boolean>(CommonParameters.TIMEOUT_PAGE_LOAD, true,
				new LoopHelper.ICheck<Boolean>() {
					public Boolean getCurrentState() {
						return isLoginPanelPresent();
					}
				});
		pageLoadLoop.run();
	}

	/**
	 * login method using the correct credentials
	 *
	 * @param username
	 * @param password
	 * @return - ProjectPage - the instance of the page appearing after
	 *         successful login
	 */
	public ProjectPage loginUsingCorrectCredentials(String username, String password) {
		enterCredentialsAndSubmit(username, password);
		return PageFactory.initElements(mDriver, ProjectPage.class);
	}

	/**
	 * opens the login page and waits for the page to be loaded.
	 */
	public void open() {
		mDriver.get(LOGIN_PAGE_URL);
		waitForPageLoadedCorrectly();
	}

	/**
	 * closes the web page
	 */
	public void teardown() {
		mDriver.close();
	}

	private void enterCredentialsAndSubmit(String username, String password) {
		nameTextBox.clear();
		nameTextBox.sendKeys(username);
		passwordTextBox.clear();
		passwordTextBox.sendKeys(password);
		loginButton.click();
	}

	private boolean isLoginPanelPresent() {
		By loginPanelLocator = By.xpath(CommonParameters.LOGIN_PANEL_LOCATOR_XPATH);
		if (isElementPresent(loginPanelLocator)) {
			return true;
		}
		return false;
	}

}
