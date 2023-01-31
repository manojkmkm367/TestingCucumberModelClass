package com.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

/**
 * 
 * @author manoj
 * @Description User can maintain the SearchHotelPage locators and page methods
 * @Date 21-09-2022
 *
 */
public class SearchHotelPage extends BaseClass {

	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "location")
	private WebElement dDnlocation;

	@FindBy(id = "hotels")
	private WebElement dDnhotels;

	@FindBy(id = "room_type")
	private WebElement dDNroomtype;

	@FindBy(id = "room_nos")
	private WebElement dDnnumberofroom;

	@FindBy(id = "datepick_in")
	private WebElement checkin;

	@FindBy(id = "datepick_out")
	private WebElement checkout;

	@FindBy(id = "adult_room")
	private WebElement dDnadultroom;

	@FindBy(id = "child_room")
	private WebElement dDnchildroom;

	@FindBy(id = "Submit")
	private WebElement btnsubmit;

	@FindBy(xpath = "//td[text()='Select Hotel ']")
	private WebElement verifyMessage;

	@FindBy(xpath = "//span[@id='checkin_span']")
	private WebElement checkINError;

	@FindBy(xpath = "//span[@id='checkout_span']")
	private WebElement checkOutError;

	@FindBy(id = "location_span")
	private WebElement locationError;

	@FindBy(id = "location_span")
	private WebElement locationSpan; // 1st error message

	@FindBy(id = "checkin_span")
	private WebElement checkInSpan;

	@FindBy(className = "login_title")
	private WebElement selectHotelTitle;

	public WebElement getSelectHotelTitle() {
		return selectHotelTitle;
	}

	public WebElement getLocationSpan() {
		return locationSpan;
	}

	public WebElement getCheckInSpan() {
		return checkInSpan;
	}

	public WebElement getCheckOutSpan() {
		return checkOutSpan;
	}

	@FindBy(id = "checkout_span")
	private WebElement checkOutSpan;

	public WebElement getdDnlocation() {
		return dDnlocation;
	}

	public WebElement getdDnhotels() {
		return dDnhotels;
	}

	public WebElement getdDNroomtype() {
		return dDNroomtype;
	}

	public WebElement getdDnnumberofroom() {
		return dDnnumberofroom;
	}

	public WebElement getCheckin() {
		return checkin;
	}

	public WebElement getCheckout() {
		return checkout;
	}

	public WebElement getdDnadultroom() {
		return dDnadultroom;
	}

	public WebElement getdDnchildroom() {
		return dDnchildroom;
	}

	public WebElement getBtnsubmit() {
		return btnsubmit;
	}

	public WebElement getVerifyMessage() {
		return verifyMessage;
	}

	public WebElement getCheckINError() {
		return checkINError;
	}

	public WebElement getCheckOutError() {
		return checkOutError;
	}

	public WebElement getLocationError() {
		return locationError;
	}

	/**
	 * @Description User should search hotel
	 * @param location
	 * @param hotel
	 * @param roomtype
	 * @param roomno
	 * @param indate
	 * @param outdate
	 * @param adult
	 * @param child
	 */
	public void searchHotels(String location, String hotel, String roomtype, String roomno, String indate,
			String outdate, String adult, String child) {
		System.out.println(location + "************" + child);
		getdDnlocation().sendKeys("New York");
		selectByText(location, getdDnlocation());

		selectByText(hotel, getdDnhotels());
		selectByText(roomtype, getdDNroomtype());
		selectByText(roomno, getdDnnumberofroom());
		clearMethod(getCheckin());
		clearMethod(getCheckout());
		sendkeys(getCheckin(), indate);
		sendkeys(getCheckout(), outdate);
		selectByText(adult, getdDnadultroom());
		selectByText(child, getdDnchildroom());
		btnClick(getBtnsubmit());

	}

	/**
	 * @Description User should Search hotel only with mandatory fields
	 * @param location
	 * @param roomno
	 * @param indate
	 * @param outdate
	 * @param adult
	 */
	public void searchHotels(String location, String roomno, String indate, String outdate, String adult) {

		selectByText(location, getdDnlocation());
		selectByText(roomno, getdDnnumberofroom());
		clearMethod(getCheckin());
		clearMethod(getCheckout());
		sendkeys(getCheckin(), indate);
		sendkeys(getCheckout(), outdate);
		selectByText(adult, getdDnadultroom());
		btnClick(getBtnsubmit());
	}

	/**
	 * @Description User should Search hotel without any fields
	 */
	public void searchHotels() {
		btnClick(getBtnsubmit());
	}

	/**
	 * @Description User should get success message
	 * @return Message
	 */
	public String getSuccessLoginMessage() {
		WebElement title = getSelectHotelTitle();
		return title.getText();
	}

	/**
	 * @Description User should get Location error message
	 * @return Message
	 */
	public String getErrorMessage() {
		WebElement error = getLocationError();
		return error.getText();
	}

	/**
	 * @Description User should get wrong checkIn date error message
	 * @return Message
	 */
	public String getcheckInErrorMessage() {
		WebElement checkIn = getCheckInSpan();
		return checkIn.getText();
	}

	/**
	 * @Description User should get wrong checkOut date error message
	 * @return Message
	 */
	public String getcheckOutErrorMessage() {
		WebElement checkOut = getCheckOutSpan();
		return checkOut.getText();
	}

}
