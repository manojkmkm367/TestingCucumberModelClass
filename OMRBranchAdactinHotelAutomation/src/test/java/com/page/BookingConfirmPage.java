package com.page;

import org.openqa.selenium.WebElement;
import com.baseclass.BaseClass;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author manoj
 * @Description User can maintain the Booking ConfirmPage locators  
 * @Date   21-09-2022
 */
public class BookingConfirmPage extends BaseClass {


	public BookingConfirmPage() {
		PageFactory.initElements(driver, this);
	}
	public static String orderId;

	@FindBy(id = "order_no")
	private WebElement orderNo;

	public WebElement getOrderNo() {
		return orderNo;
	}

	/**
	 * /**
	 * @Description User get orderId after Booking conform
	 * @return orderID
	 */
	 
	public String getOrderId() {
		orderId = getAttribute(getOrderNo());
		return orderId;

	}


}
