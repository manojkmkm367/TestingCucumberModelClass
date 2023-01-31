package com.pagemanager;

import com.page.BookHotelPage;
import com.page.BookingConfirmPage;
import com.page.CancelBookingPage;
import com.page.LoginPage;
import com.page.SearchHotelPage;
import com.page.SelectHotelPage;

/**
 * 
 * @author manoj
 * @Description User can create and maintain object for respective class
 * @Date 21-09-2022
 *
 */
public class PageObjectManager {
	private LoginPage loginPage;
	private SearchHotelPage searchHotelPage;
	private SelectHotelPage selectHotelPage;
	private BookHotelPage bookHotelPage;
	private BookingConfirmPage bookingConfirmPage;
	private CancelBookingPage cancelBookingPage;

	/**
	 * @Description User can create Object for LoginPage
	 * @return Object
	 */
	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage() : loginPage;
	}

	/**
	 * @Description User can create Object for SearchHotelPage
	 * @return Object
	 */
	public SearchHotelPage getSearchHotelPage() {
		return (searchHotelPage == null) ? searchHotelPage = new SearchHotelPage() : searchHotelPage;
	}

	/**
	 * @Description User can create Object for SelectHotelPage
	 * @return Object
	 */
	public SelectHotelPage getSelectHotelPage() {
		return (selectHotelPage == null) ? selectHotelPage = new SelectHotelPage() : selectHotelPage;
	}

	/**
	 * @Description User can create Object for BookHotelPage
	 * @return Object
	 */
	public BookHotelPage getBookHotelPage() {
		return (bookHotelPage == null) ? bookHotelPage = new BookHotelPage() : bookHotelPage;
	}

	/**
	 * @Description User can create Object for BookingConfirmPage
	 * @return Object
	 */
	public BookingConfirmPage getBookingConfirmPage() {
		return (bookingConfirmPage == null) ? bookingConfirmPage = new BookingConfirmPage() : bookingConfirmPage;
	}

	/**
	 * @Description User can create Object for CancelBookingPage
	 * @return Object
	 */
	public CancelBookingPage getCancelBookingPage() {
		return (cancelBookingPage == null) ? cancelBookingPage = new CancelBookingPage() : cancelBookingPage;
	}

}
