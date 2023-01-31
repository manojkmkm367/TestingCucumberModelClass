package com.page;

import org.openqa.selenium.WebElement;
import com.baseclass.BaseClass;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author manoj
 * @Description user can maintain the Cancel BookingPage locators and methods
 * @Date 21-09-2022
 *
 */
public class CancelBookingPage extends BaseClass {

	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "order_no")
	private WebElement orderNo;

	@FindBy(xpath = "//a[text()='Booked Itinerary']")
	private WebElement btnMyItinerary;

	@FindBy(id = "order_id_text")
	private WebElement orderSearch;

	@FindBy(id = "search_hotel_id")
	private WebElement searchHotelId;

	@FindBy(xpath = "//input[contains(@value,'Cancel ')]")
	private WebElement cancelorderid;

	@FindBy(id = "search_result_error")
	private WebElement searchResultError;

	public WebElement getOrderNo() {
		return orderNo;
	}

	public WebElement getBtnMyItinerary() {
		return btnMyItinerary;
	}

	public WebElement getOrderSearch() {
		return orderSearch;
	}

	public WebElement getSearchHotelId() {
		return searchHotelId;
	}

	public WebElement getCancelorderid() {
		return cancelorderid;
	}

	public WebElement getSearchResultError() {
		return searchResultError;
	}

	/**
	 * @Description User should Cancel OrderId
	 * @param orderID
	 */
	public void cancelOrderId(String orderNo) {
		btnClick(getBtnMyItinerary());
		sendkeys(getOrderSearch(), orderNo);
		btnClick(getOrderSearch());
		btnClick(getCancelorderid());
		acceptAlert();
	}

	/**
	 * @Description User should get confirmation message after canceling orderID
	 * @return
	 */
	public String getCancelConformationMessage() {
		String text = getSearchResultError().getText();
		return text;
	}

}
