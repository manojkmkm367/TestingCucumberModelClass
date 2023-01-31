package com.page;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;
/**
 * 
 * @author manoj
 * @Description user can maintain the LoginPage locators and methods 
 * @Date   21-09-2022
 *
 */
public class LoginPage extends BaseClass {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}


	@FindBy(id="username")
	private WebElement txtUserName;

	@FindBy(id="password")
	private WebElement txtPassword;

	@FindBy(id="login")
	private WebElement btnLogin;

	@FindBy(id="username_show")
	private WebElement txtSuccess;

	@FindBy(xpath = "//*[@class='auth_error']")
	private WebElement txtErrorMsg;



	public WebElement getTxtSuccess() {
		return txtSuccess;
	}


	public WebElement getTxtErrorMsg() {
		return txtErrorMsg;
	}

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}












	/**
	 * @Description user login with username and password
	 * @param username
	 * @param password
	 */
	public void login(String username, String password) {
		sendkeys(getTxtUserName(), username);
		sendkeys(getTxtPassword(), password);
		btnClick(btnLogin);

	}

	// login with Enter Key
	/**
	 * @Description user login with username and password with using Enter key
	 * @param username
	 * @param password
	 * @throws AWTException
	 */
	public void loginUsingEnter(String username, String password) throws AWTException {
		sendkeys(getTxtUserName(), username);
		sendkeys(getTxtPassword(), password);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	/**
	 * @Description User should get error message after login
	 * @return message
	 */
	public String getTextErrorLogin() {
		WebElement message = getTxtErrorMsg();
		return message.getText();

	}

	/**
	 * @Description User should get confirmation message after login
	 * @return message
	 */		
	public String getTextSuccessLogin() {
		String attribute = getTxtSuccess().getAttribute("value");
		return attribute;


	}


}


