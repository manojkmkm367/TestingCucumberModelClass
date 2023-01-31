package com.stepdefinition;

import org.junit.Assert;
import com.pagemanager.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

/**
 * 
 * @author manoj
 * @Description User can maintain step to validate select hotel page
 * @Date 21-09-2022
 *
 */
public class TC3_SelectHotelStep {
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @Description User should select Hotel Name from list
	 */
	@And("User should select Hotel Name")
	public void user_should_select_hotel_name() {
		pom.getSelectHotelPage().selectHotel();
	}

	/**
	 * @Description User should Verify after Select Hotel success message
	 * @param expeted success message
	 */
	@Then("User should Verify after Select Hotel success message  {string}")
	public void user_should_verify_after_select_hotel_success_message(String string) {
		String successLoginMessage = pom.getSelectHotelPage().getSuccessLoginMessage();
		Assert.assertTrue("Success message", successLoginMessage.contains(string));
	}

	/**
	 * @Description User should Click Continue without Selecting any Hotel name
	 */
	@And("User should Click Continue without Selecting any Hotel")
	public void user_should_click_continue_without_selecting_any_hotel() {
		pom.getSelectHotelPage().continueWithoutSelect();
	}

	/**
	 * @Description User should Verify without Selecting any Hotel error message
	 * @param expeted error message
	 */
	@Then("User should Verify without Selecting any Hotel error message  {string}")
	public void user_should_verify_without_selecting_any_hotel_error_message(String string) {
		String errorLoginMessage = pom.getSelectHotelPage().getErrorLoginMessage();
		Assert.assertTrue("Verify without Selecting any Hotel error message", errorLoginMessage.contains(string));
	}

}
