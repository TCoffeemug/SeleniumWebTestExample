package de.iceburner.seleniumWebTestExample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import de.iceburner.seleniumWebTestExample.util.CommonParameters;
import de.iceburner.seleniumWebTestExample.util.LoopHelper;

/**
 * Parent class of all web pages. Contains common functionality.
 *
 * @author Thomas Eisbrenner
 *
 */
public class WebPage {

	protected WebDriver mDriver;
	protected String mPageUrl;

	public WebPage(WebDriver driver) {
		mDriver = driver;
		mPageUrl = mDriver.getCurrentUrl();
	}

	/**
	 * checks if the Element specified by the locator is present
	 *
	 * @param locator
	 * @return boolean
	 */
	protected boolean isElementPresent(By locator) {
		try {
			mDriver.findElement(locator);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * waits for the element to be present. Exception is thrown if timeout
	 * occurs.
	 *
	 * @param locator
	 */
	protected void waitForElement(final By locator) {
		LoopHelper<Boolean> elementPresentLoop = new LoopHelper<Boolean>(CommonParameters.TIMEOUT_ELEMENT_LOAD, true,
				new LoopHelper.ICheck<Boolean>() {
					public Boolean getCurrentState() {
						return isElementPresent(locator);
					}
				});
		elementPresentLoop.run();
	}

	/**
	 * method waits for page to load correctly. Throws exception after timeout
	 * occurs
	 *
	 */
	protected void waitForPageLoadedCorrectly() {
		// TODO: implement specific logic in child page, if needed
		LoopHelper<Boolean> pageLoadLoop = new LoopHelper<Boolean>(CommonParameters.TIMEOUT_PAGE_LOAD, true,
				new LoopHelper.ICheck<Boolean>() {
					public Boolean getCurrentState() {
						return mDriver.getCurrentUrl() == mPageUrl;
					}
				});
		pageLoadLoop.run();
	}

}
