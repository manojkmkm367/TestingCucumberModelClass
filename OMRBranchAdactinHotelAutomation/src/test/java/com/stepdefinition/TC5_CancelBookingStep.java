package com.stepdefinition;

import org.junit.Assert;

import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;

/**
 * 
 * @author manoj
 * @Description User can maintain step to validate cancel booking page
 * @Date 21-09-2022
 *
 */
public class TC5_CancelBookingStep {

	PageObjectManager pom = new PageObjectManager();

	/**
	 * @Description User should Cancel OrderId
	 */
	@Then("User should Cancel OrderId")
	public void user_should_cancel_order_id() {
		pom.getCancelBookingPage().cancelOrderId(pom.getBookingConfirmPage().orderId);

	}

	/**
	 * @Description User should Verify after Canceling OrderId success message
	 * @param Expected Message
	 */
	@Then("User should Verify after Cancelling OrderId success message {string}")
	public void user_should_verify_after_cancelling_order_id_success_message(String string) {
		String cancelConformationMessage = pom.getCancelBookingPage().getCancelConformationMessage();
		Assert.assertTrue("Verify Cancelling OrderId success message", cancelConformationMessage.contains(string));

	}

	/**
	 * @Description User should Cancel Existing orderId
	 * @param Exising orderid
	 */
	@Then("User should Cancel Existing {string}")
	public void user_should_cancel_existing(String id) {
		pom.getCancelBookingPage().cancelOrderId(id);

	}

}
