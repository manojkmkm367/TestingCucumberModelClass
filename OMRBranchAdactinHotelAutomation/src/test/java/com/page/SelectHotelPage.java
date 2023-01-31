package com.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

/**
 * 
 * @author manoj
 * @Description User can maintain the SelectHotelPage locators and Page methods
 * @Date 21-09-2022
 *
 */
public class SelectHotelPage extends BaseClass {

	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "radiobutton_0")
	private WebElement btnRadio;

	@FindBy(id = "continue")
	private WebElement btnContinue;

	@FindBy(xpath = "(//*[@class=\"login_title\"])[2]")
	private WebElement verifyMessage;

	@FindBy(id = "radiobutton_span")
	private WebElement btnErrorMsg;

	public WebElement getBtnRadio() {
		return btnRadio;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	public WebElement getVerifyMessage() {
		return verifyMessage;
	}

	public WebElement getBtnErrorMsg() {
		return btnErrorMsg;
	}

	/**
	 * @Discription User should select Hotel with hotel name
	 */
	public void selectHotel() {
		btnClick(btnRadio);
		btnClick(btnContinue);
	}

	/**
	 * @Description User should get success message
	 * @return
	 */
	public String getSuccessLoginMessage() {
		WebElement msg = getVerifyMessage();
		return msg.getText();
	}

	/**
	 * @Description User should select Hotel without select hotel name
	 */
	public void continueWithoutSelect() {
		btnClick(btnContinue);
	}

	/**
	 * @Description User should get error message
	 * @return
	 */
	public String getErrorLoginMessage() {

		WebElement errorMsg = getBtnErrorMsg();
		return errorMsg.getText();

	}

}
