package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pagemanager.PageObjectManager;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

/**
 * @author manoj
 * @Description User can maintain step to validate book hotel page
 * @Date 21-09-2022
 * 
 */
public class TC4_BookHotelStep {

	PageObjectManager pom = new PageObjectManager();

	/**
	 * @Description User should book Hotel
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param dataTable
	 */
	@Then("User should book Hotel {string}, {string} and {string}")
	public void user_should_book_hotel(String firstName, String lastName, String address,
			io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps();
		Map<String, String> m = data.get(0);
		String ccNo = m.get("Credit Card No");
		String ccType = m.get("Credit Card Type");
		String expMonth = m.get("Expiry Month");
		String expYear = m.get("Expiry Year");
		String ccv = m.get("CVV Number");
		pom.getBookHotelPage().bookHotel(firstName, lastName, address, ccNo, ccType, expMonth, expYear, ccv);

	}

	/**
	 * @Description User should Verify after Booking success message
	 * @param Expected success message
	 */
	@Then("User should Verify after Booking success message {string}")
	public void user_should_verify_after_booking_success_message(String string) {
		String successLoginMessage = pom.getBookHotelPage().getSuccessLoginMessage();
		Assert.assertTrue("Verify after Booking success message", successLoginMessage.contains(string));
		String orderId = pom.getBookingConfirmPage().getOrderId();
		System.out.println("Your Order Id : " + orderId);

	}

	/**
	 * @Description User should Click Book now button without entering any fileds
	 */
	@Then("User should Click Book now button without entering any fileds")
	public void user_should_click_book_now_button_without_entering_any_fileds() {
		pom.getBookHotelPage().bookHotel();
	}

	/**
	 * @Description User should Verify after click book now button error message
	 * @param firstName ErrorMessage Expected
	 * @param lastName  ErrorMessage Expected
	 * @param address   ErrorMessage Expected
	 * @param ccNo      ErrorMessage Expected
	 * @param ccType    ErrorMessage Expected
	 * @param expMonth  ErrorMessage Expected
	 * @param ccv       ErrorMessage Expected
	 */
	@Then("User should Verify after click book now button error message  {string}, {string}, {string}, {string}, {string},{string} and {string}")
	public void user_should_verify_after_click_error_message(String firstNameError, String lastNameError,
			String addressError, String ccNoError, String ccTypeError, String expMonthError, String ccvError) {
		String firstError = pom.getBookHotelPage().getFirstErrorMessage();
		Assert.assertTrue("Verify error message", firstError.contains(firstNameError));

		String lastErrorMessage = pom.getBookHotelPage().getLastErrorMessage();
		Assert.assertTrue("Verify error message", lastErrorMessage.contains(lastNameError));

		String adderssErrorMessage = pom.getBookHotelPage().getAdderssErrorMessage();
		Assert.assertTrue("Verify error message", adderssErrorMessage.contains(addressError));

		String ccNoErrorMessage = pom.getBookHotelPage().getCCNoErrorMessage();
		Assert.assertTrue("Verify error message", ccNoErrorMessage.contains(ccNoError));

		String ccTypeErrorMessage = pom.getBookHotelPage().getCCTypeErrorMessage();
		Assert.assertTrue("Verify error message", ccTypeErrorMessage.contains(ccTypeError));

		String ccExpMonthErrorMessage = pom.getBookHotelPage().getCCExpMonthErrorMessage();
		Assert.assertTrue("Verify error message", ccExpMonthErrorMessage.contains(expMonthError));

		String ccvErrorMessage = pom.getBookHotelPage().getCCVErrorMessage();
		Assert.assertTrue("Verify error message", ccvErrorMessage.contains(ccvError));

	}

}
