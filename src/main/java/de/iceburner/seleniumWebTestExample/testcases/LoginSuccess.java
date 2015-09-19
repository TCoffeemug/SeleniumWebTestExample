package de.iceburner.seleniumWebTestExample.testcases;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import de.iceburner.seleniumWebTestExample.pages.LoginPage;
import de.iceburner.seleniumWebTestExample.pages.ProjectPage;
import de.iceburner.seleniumWebTestExample.util.CommonParameters;

/**
 * Test: Successful logging in: -The login panel must disappear and the list of
 * project must be populated with a few projects.
 *
 *
 * @author Thomas Eisbrenner
 *
 */
public class LoginSuccess {

	private static final String USERNAME = CommonParameters.USERNAME_CORRECT;
	private static final String PASSWORD = CommonParameters.PASSWORD_CORRECT;
	private LoginPage mLoginPage;
	private ProjectPage mProjectPage;

	@Before
	public void setup() {
		mLoginPage = PageFactory.initElements(new FirefoxDriver(), LoginPage.class);
	}

	@After
	public void teardown() {
		mLoginPage.teardown();
	}

	@Test
	public void testLoginSuccess() {
		mLoginPage.open();
		mProjectPage = mLoginPage.loginUsingCorrectCredentials(USERNAME, PASSWORD);
		assertTrue("Login failed , but should have succeeded!", mProjectPage.loginSuceeded());
	}

}
