package de.iceburner.seleniumWebTestExample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import de.iceburner.seleniumWebTestExample.util.CommonParameters;
import de.iceburner.seleniumWebTestExample.util.LoopHelper;

/**
 * Class representing the project page, providing its functionality
 *
 * @author Thomas Eisbrenner
 *
 */
public class ProjectPage extends WebPage {

	private static final String PROJECT_CONTAINER_XPATH = "//div[@class=\"GKXRPOKCCP projectCellList\"]";

	@FindBy(xpath = PROJECT_CONTAINER_XPATH)
	private WebElement projectContainer;

	public ProjectPage(WebDriver driver) {
		super(driver);
		mPageUrl = mDriver.getCurrentUrl();
		waitForPageLoadedCorrectly();
	}

	@Override
	protected void waitForPageLoadedCorrectly() {
		LoopHelper<Boolean> pageLoadLoop = new LoopHelper<Boolean>(CommonParameters.TIMEOUT_PAGE_LOAD, true,
				new LoopHelper.ICheck<Boolean>() {
					public Boolean getCurrentState() {
						return isElementPresent(By.xpath(PROJECT_CONTAINER_XPATH));
					}
				});
		pageLoadLoop.run();
	}

	/**
	 * a successful login is defined as the disappearance of the login panel and
	 * the appearance of the project list populated with projects
	 *
	 * @return - boolean - true, fi login was successful
	 */
	public boolean loginSuceeded() {
		if (!isLoginPanelPresent() && isProjectListPopulated()) {
			return true;
		}
		return false;
	}

	private boolean doesProjectExist(String name) {
		if (projectContainer.getText().contains(name)) {
			return true;
		}
		return false;
	}

	private boolean isLoginPanelPresent() {
		By loginPanelLocator = By.xpath(CommonParameters.LOGIN_PANEL_LOCATOR_XPATH);
		if (isElementPresent(loginPanelLocator)) {
			return true;
		}
		return false;
	}

	private boolean isProjectListPopulated() {
		if (doesProjectExist(CommonParameters.NAME_PROJECT_1) && doesProjectExist(CommonParameters.NAME_PROJECT_2)
				&& doesProjectExist(CommonParameters.NAME_PROJECT_3)) {
			return true;
		}
		return false;
	}

}
