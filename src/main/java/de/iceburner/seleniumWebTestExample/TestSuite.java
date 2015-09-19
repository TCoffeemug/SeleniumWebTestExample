package de.iceburner.seleniumWebTestExample;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import de.iceburner.seleniumWebTestExample.testcases.LoginSuccess;

@RunWith(Suite.class)
@Suite.SuiteClasses({ LoginSuccess.class, })
public class TestSuite {

}
