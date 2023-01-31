package com.stepdefinition;

import java.awt.AWTException;
import java.io.IOException;
import org.junit.Assert;
import com.baseclass.BaseClass;
import com.pagemanager.PageObjectManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 * @author manoj
 * @Description User can maintain step to validate Login feature
 * @Date 21-09-2022
 */

public class TC1_LoginStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	/**
	 * @Description User is in Login page
	 * @throws IOException
	 */

	@Given("User is in Login page")
	public void user_is_in_login_page() throws IOException {

		// System.out.println(getPropertyFileValue("username")+getPropertyFileValue("password"));
	}

	/**
	 * @Description User login with valid username and password
	 * @param username
	 * @param password
	 */
	@When("User login with valid {string}, {string}")
	public void user_login_with_valid(String username, String password) {

		pom.getLoginPage().login(username, password);

	}

	/**
	 * @Description user login with valid username and password with using enter key
	 * @param username
	 * @param password
	 * @throws AWTException
	 */

	@When("User login with valid {string}, {string} with enter key")
	public void user_login_with_valid_with_enter_key(String username, String password) throws AWTException {
		pom.getLoginPage().loginUsingEnter(username, password);
	}

	/**
	 * @Description User should verify after login with invalid credential
	 * @param Expected Error Message
	 */

	@Then("User should verify after login with invalid credeential error message contains {string}")
	public void invalid_credeential_error_message_contains(String message) {

		String errorMessage = pom.getLoginPage().getTextErrorLogin();
		Assert.assertTrue("Verify Login Error Message", errorMessage.contains(message));

	}

}
