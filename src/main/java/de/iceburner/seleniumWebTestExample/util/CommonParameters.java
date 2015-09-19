package de.iceburner.seleniumWebTestExample.util;

/**
 * Contains the common parameters needed for the test classes
 *
 * @author Thomas Eisbrenner
 *
 */
public class CommonParameters {

	public static final String USERNAME_CORRECT = "thomas.eisbrenner@gmail.com";
	public static final String PASSWORD_CORRECT = "correctLogin.banana";
	public static final String LOGIN_PANEL_LOCATOR_XPATH = "//legend[text()='Welcome to SimScale!']";
	public static final String NAME_PROJECT_1 = "Tutorial-01: Connecting rod stress analysis";
	public static final String NAME_PROJECT_2 = "Tutorial-02: Pipe junction flow";
	public static final String NAME_PROJECT_3 = "Tutorial-03: Differential casing thermal analysis";
	public static final int TIMEOUT_PAGE_LOAD = 5;
	public static final int TIMEOUT_ELEMENT_LOAD = 5;

}
