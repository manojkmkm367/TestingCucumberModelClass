package com.stepdefinition;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;

/**
 * 
 * @author manoj
 * @Description User can maintain step to validate SearchHotel feature
 * @Date 21-09-2022
 *
 */
public class TC2_SearchHotelStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	/**
	 * @Description User Search hotel
	 * @param location
	 * @param hotel
	 * @param roomType
	 * @param numberOfRoom
	 * @param checkIn
	 * @param checkOut
	 * @param adults
	 * @param children
	 */
	@Then("User Search hotel with {string}, {string},{string}, {string}, {string}, {string}, {string} and {string}")
	public void user_search_hotel_with(String location, String hotel, String roomType, String numberOfRoom,
			String checkIn, String checkOut, String adults, String children) {
		pom.getSearchHotelPage().searchHotels(location, hotel, roomType, numberOfRoom, checkIn, checkOut, adults,
				children);

	}

	/**
	 * @Description User Search hotel only with mandatory fields
	 * @param location
	 * @param numberOfRoom
	 * @param checkIn
	 * @param checkOut
	 * @param adult
	 */
	@Then("User Search hotel only with mandatory fields {string}, {string}, {string}, {string} and {string}")
	public void user_search_hotel_only_with_mandatory_fields_and(String location, String numberOfRoom, String checkIn,
			String checkOut, String adult) {

		pom.getSearchHotelPage().searchHotels(location, numberOfRoom, checkIn, checkOut, adult);
	}

	/**
	 * @Description User Search hotel without selecting any field
	 */
	@Then("User Search hotel without selecting any field")
	public void user_search_hotel_without_selecting_any_field() {
		pom.getSearchHotelPage().searchHotels();
	}

	/**
	 * @Description User after Search should verify success Message
	 * @param Expeted message
	 */
	@Then("User after Search should verify {string}")
	public void user_after_search_should_verify(String string) {

		String loginMessage = pom.getSearchHotelPage().getSuccessLoginMessage();
		Assert.assertTrue("User after Search should verify", loginMessage.contains(string));
	}

	/**
	 * @Description User after Search should verify error Message
	 * @param expeted error message
	 */
	@Then("User after Search should verify the error message {string} and {string}")
	public void user_after_search_should_verify_the_error_message_and(String msgIn, String msgOut) {
		String getcheckInErrorMessage = pom.getSearchHotelPage().getcheckInErrorMessage();
		String getcheckOutErrorMessage = pom.getSearchHotelPage().getcheckOutErrorMessage();
		Assert.assertTrue("checkIn Message", getcheckInErrorMessage.contains(msgIn));
		Assert.assertTrue("checkOut Message", getcheckOutErrorMessage.contains(msgOut));

	}

	/**
	 * @Description User after Search should verify error Message
	 * @param expeted error message
	 */
	@Then("User should Verify error message {string}")
	public void user_should_verify_error_message(String string) {
		String errorMessage = pom.getSearchHotelPage().getErrorMessage();
		Assert.assertTrue("User should Verify error message", errorMessage.contains(string));
	}

}
