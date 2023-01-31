package com.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

/**
 * 
 * @author manoj
 * @Description User can maintain the BookHotelPage locators and page methods
 * @Date 21-09-2022
 *
 */
public class BookHotelPage extends BaseClass {

	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "first_name")
	private WebElement txtFirstname;
	@FindBy(id = "last_name")
	private WebElement txtLastname;
	@FindBy(id = "address")
	private WebElement txtAddress;
	@FindBy(id = "cc_num")
	private WebElement txtCCnum;
	@FindBy(id = "cc_type")
	private WebElement ddnCCtype;
	@FindBy(id = "cc_exp_month")
	private WebElement ddnExpmonth;
	@FindBy(id = "cc_exp_year")
	private WebElement ddnExpyear;
	@FindBy(id = "cc_cvv")
	private WebElement txtCVV;
	@FindBy(xpath = "//input[@id=\"book_now\"]")
	private WebElement btnBook;

	@FindBy(xpath = "//td[text()='Booking Confirmation ']")
	private WebElement verrifyMessage;

	@FindBy(id = "first_name_span")
	private WebElement firstnameError;

	@FindBy(id = "last_name_span")
	private WebElement lastnameError;

	@FindBy(id = "address_span")
	private WebElement addressError;

	@FindBy(id = "cc_num_span")
	private WebElement ccNumError;

	@FindBy(id = "cc_type_span")
	private WebElement ccTypeError;

	@FindBy(id = "cc_expiry_span")
	private WebElement ccExpiryError;

	@FindBy(id = "cc_cvv_span")
	private WebElement cvvError;

	public WebElement getTxtFirstname() {
		return txtFirstname;
	}

	public WebElement getTxtLastname() {
		return txtLastname;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getTxtCCnum() {
		return txtCCnum;
	}

	public WebElement getDdnCCtype() {
		return ddnCCtype;
	}

	public WebElement getDdnExpmonth() {
		return ddnExpmonth;
	}

	public WebElement getDdnExpyear() {
		return ddnExpyear;
	}

	public WebElement getTxtCVV() {
		return txtCVV;
	}

	public WebElement getBtnBook() {
		return btnBook;
	}

	public WebElement getVerrifyMessage() {
		return verrifyMessage;
	}

	public WebElement getFirstnameError() {
		return firstnameError;
	}

	public WebElement getLastnameError() {
		return lastnameError;
	}

	public WebElement getAddressError() {
		return addressError;
	}

	public WebElement getCcNumError() {
		return ccNumError;
	}

	public WebElement getCcTypeError() {
		return ccTypeError;
	}

	public WebElement getCcExpiryError() {
		return ccExpiryError;
	}

	public WebElement getCvvError() {
		return cvvError;
	}

	/**
	 * @Description User bookHotel with all fields
	 * @param firstname
	 * @param lastname
	 * @param address
	 * @param creditcardnumber
	 * @param creditcardtype
	 * @param expirymonth
	 * @param expiryyear
	 * @param cvv
	 */
	public void bookHotel(String firstname, String lastname, String address, String creditcardnumber,
			String creditcardtype, String expirymonth, String expiryyear, String cvv) {
		sendkeys(getTxtFirstname(), firstname);
		sendkeys(getTxtLastname(), lastname);
		sendkeys(getTxtAddress(), address);
		sendkeys(getTxtCCnum(), creditcardnumber);
		selectByText(creditcardtype, getDdnCCtype());
		selectByText(expirymonth, getDdnExpmonth());
		selectByText(expiryyear, getDdnExpyear());
		sendkeys(getTxtCVV(), cvv);
		btnClick(getBtnBook());

	}

	/**
	 * @Description User bookHotel without any fields
	 */
	public void bookHotel() {
		btnClick(getBtnBook());
	}

	/**
	 * @Description User get Login message after bookHotel
	 * @return
	 */
	public String getSuccessLoginMessage() {
		WebElement msg = getVerrifyMessage();
		return msg.getText();
	}

	/**
	 * @Description User get firstname Error message
	 * @return Error message
	 */
	public String getFirstErrorMessage() {
		WebElement firstnameElement = getFirstnameError();
		return firstnameElement.getText();
	}

	/**
	 * @Description User get lastname Error message
	 * @return Error message
	 */
	public String getLastErrorMessage() {
		return getLastnameError().getText();

	}

	/**
	 * @Description User get Address Error message
	 * @return Error message
	 */
	public String getAdderssErrorMessage() {
		return getAddressError().getText();

	}

	/**
	 * @Description User get Credit card Error message
	 * @return Error message
	 */
	public String getCCNoErrorMessage() {
		return getCcNumError().getText();
	}

	/**
	 * @Description User get Credit card Type Error message
	 * @return Error message
	 */
	public String getCCTypeErrorMessage() {
		return getCcTypeError().getText();
	}

	/**
	 * @Description User get Credit card Month Error message
	 * @return Error message
	 */
	public String getCCExpMonthErrorMessage() {
		return getCcExpiryError().getText();

	}

	/**
	 * @Description User get Credit card CVV Error message
	 * @return Error message
	 */
	public String getCCVErrorMessage() {
		return getCvvError().getText();

	}

}
