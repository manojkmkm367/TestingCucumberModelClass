package com.stepdefinition;

import java.io.IOException;
import java.time.Duration;

import com.baseclass.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * 
 * @author manoj
 * @Description User can maintain common steps to perform before and after each
 *              Scenario
 */
public class HooksClass extends BaseClass {

	/**
	 * @Description used to perform login function
	 * @throws IOException
	 */
	@Before
	public void beforeScenario() throws IOException {
		getDriver(getPropertyFileValue("browser"));
		url(getPropertyFileValue("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	/**
	 * @Description used to perform screenshot and quite window after each Scenario
	 * @param scenario
	 */
	@After
	public void afterScenario(Scenario scenario) {
		scenario.attach(getScreenshot(), "images/png", "Every scenario");
		quit();
	}

}
