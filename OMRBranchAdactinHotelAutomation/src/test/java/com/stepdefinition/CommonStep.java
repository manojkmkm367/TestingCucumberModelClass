package com.stepdefinition;

import org.junit.Assert;

import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;

/**
 * 
 * @author manoj
 * @Description User can maintain common steps for all scenario
 *
 */

public class CommonStep {
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @Description User should verify after login with valid credential
	 * @param Expected WelcomeMessage
	 */

	@Then("User should verify after login {string}")
	public void user_should_verify_after_login(String message) {
		String textSuccess = pom.getLoginPage().getTextSuccessLogin();
		Assert.assertTrue("Verify Login Success Message", textSuccess.contains(message));

	}

}
