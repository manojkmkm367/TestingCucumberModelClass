package com.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author manoj
 * @Description User can maintain the reusable method
 * @Date 21-09-2022
 *
 */
public class BaseClass {

	public static WebDriver driver;

	/**
	 * @Description Get cell value from this method
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return String
	 * @throws IOException
	 */
	public String getData(String sheetName, int rowNum, int cellNum) throws IOException {
		String res = null;
		File file = new File("C:\\Users\\ELCOT\\eclipse-workspace\\SeleniumMaven\\Excel\\New.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		CellType type = cell.getCellType();
		switch (type) {
		case STRING:
			res = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
				res = f.format(dateCellValue);
			} else {
				double d = cell.getNumericCellValue();
				// BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
				// res = valueOf.toString();
				long check = Math.round(d);
				if (check == d) {
					res = String.valueOf(check);
				} else {
					res = String.valueOf(d);

				}
			}
		default:
			break;
		}
		return res;
	}

	/**
	 * @Description Update cell value from this method
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param oldData
	 * @param newData
	 * @throws IOException
	 */
	public void updateDate(String sheetName, int rowNum, int cellNum, String oldData, String newData)
			throws IOException {
		File file = new File("C:\\Users\\ELCOT\\eclipse-workspace\\SeleniumMaven\\Excel\\New.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String stringCellValue = cell.getStringCellValue();
		if (stringCellValue.equals(oldData)) {
			cell.setCellValue(newData);
		}
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
	}

	/**
	 * @Description Can create new sheet and update cell value from this method
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param value
	 * @throws IOException
	 */
	public void writeData(String sheetName, int rowNum, int cellNum, String value) throws IOException {
		File file = new File("C:\\Users\\ELCOT\\eclipse-workspace\\SeleniumMaven\\Excel\\New.xlsx");
		// FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook();
		Sheet createSheet = workbook.createSheet(sheetName);
		Row createRow = createSheet.createRow(rowNum);
		Cell createCell = createRow.createCell(cellNum);
		createCell.setCellValue(value);
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);

	}

	/**
	 * @Description Create cell and update value from this method
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws IOException
	 */
	public void createNewCell(String sheetName, int rowNum, int cellNum, String data) throws IOException {
		File file = new File("C:\\Users\\ELCOT\\eclipse-workspace\\SeleniumMaven\\Excel\\New.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
	}

	/**
	 * @Description Create new row and cell and update value from this method
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws IOException
	 */

	public void createNewRowNewCell(String sheetName, int rowNum, int cellNum, String data) throws IOException {
		File file = new File("C:\\Users\\ELCOT\\eclipse-workspace\\SeleniumMaven\\Excel\\New.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.createRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
	}

	/**
	 * @Description Get screenshot from this method
	 * @return byte
	 */
	public byte[] getScreenshot() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
		return screenshot;
	}

	/**
	 * @Description Get property file values from this method
	 * @param key
	 * @return value
	 * @throws IOException
	 */
	public String getPropertyFileValue(String key) throws IOException {
		Properties properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream(
				System.getProperty("user.dir") + "\\Config\\Config.properties");
		properties.load(fileInputStream);
		String value = String.valueOf(properties.get(key));
		return value;

	}

	/**
	 * @Description Get selected getDriver from this method
	 * @param browser
	 */
	public static void getDriver(String browser) {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();

		default:
			break;
		}

	}

	/**
	 * @Description Get URL from this method
	 * @param url
	 */
	public static void url(String url) {
		driver.get(url);
	}

	/**
	 * @Description User get maximize the window from this method
	 */
	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	/**
	 * @Description User get Title of the webpage from this method
	 * @return title
	 */

	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	/**
	 * @Description GetCurrent URL of the webpage from this method
	 * @return Current URL
	 */
	public String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	/**
	 * @Description Type content automatically from this method
	 * @param element
	 * @param text
	 */
	public void sendkeys(WebElement element, String text) {
		element.sendKeys(text);
	}

	/**
	 * @Description Click element from this method
	 * @param element
	 */
	public void btnClick(WebElement element) {
		element.click();
	}

	/**
	 * @Description Get text from the element from this method
	 * @param element
	 * @return string
	 */
	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}

	/**
	 * @Description Get value of the value attribute from this method
	 * @param element
	 * @return String
	 */
	public String getAttribute(WebElement element) {
		String text = element.getAttribute("value");
		return text;
	}

	/**
	 * @Description Find the locator based on id
	 * @param attributeValue
	 * @return WebElement
	 */
	public WebElement elementFindById(String attributeValue) {
		WebElement findElement = driver.findElement(By.id(attributeValue));
		return findElement;
	}

	/**
	 * @Description Find the locator based on Name
	 * @param attributeValue
	 * @return WebElement
	 */
	public WebElement findLocatorByName(String attributeValue) {
		WebElement txtUser = driver.findElement(By.name(attributeValue));
		return txtUser;
	}

	/**
	 * @Description Find the locator based on Class name
	 * @param attributeValue
	 * @return WebElement
	 */
	public WebElement findLocatorByClassName(String attributeValue) {
		WebElement findElement = driver.findElement(By.className(attributeValue));
		return findElement;
	}

	/**
	 * @Description Find the locator based on Xpath
	 * @param attributeValue
	 * @return WebElement
	 */
	public WebElement findLocatorByXpath(String attributeValue) {
		WebElement findElement = driver.findElement(By.xpath(attributeValue));
		return findElement;
	}

	/**
	 * @Description Get value of the particular attribute from this method
	 * @param element
	 * @return String
	 */
	public String getAttribute(String attributeName, WebElement element) {
		String attribute = element.getAttribute(attributeName);
		return attribute;
	}

	/**
	 * @Description Stop execution of script on particular time
	 * @param milliseconds
	 * @throws InterruptedException
	 */
	public void sleep(int milliseconds) throws InterruptedException {
		Thread.sleep(milliseconds);
	}

	/**
	 * @Description Move mouse to particular element location
	 * @param target
	 */
	public void moveToElement(WebElement target) {
		Actions actions = new Actions(driver);
		actions.moveToElement(target).perform();
	}

	/**
	 * @Description Drag the element from one location to another
	 * @param source
	 * @param target
	 */
	public void dragAndDrop(WebElement source, WebElement target) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target);
	}

	/**
	 * @Description Perform mouse right click
	 * @param element
	 */
	public void contextClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	/**
	 * @Description Press any key from this method
	 * @param keycode
	 * @throws AWTException
	 */
	public void robotKeyPress(int keycode) throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(keycode);
	}

	/**
	 * @Description Release any key from this method
	 * @param keycode
	 * @throws AWTException
	 */
	public void robotKeyRelease(int keycode) throws AWTException {
		Robot robot = new Robot();
		robot.keyRelease(keycode);
	}

	/**
	 * @Description Perform key down
	 * @param key
	 */
	public void keyDown(CharSequence key) {
		Actions actions = new Actions(driver);
		actions.keyDown(key);
	}

	/**
	 * @Description Perform key up
	 * @param key
	 */
	public void keyUp(CharSequence key) {
		Actions actions = new Actions(driver);
		actions.keyUp(key);
	}

	/**
	 * @Description Send keys with some action
	 * @param element
	 * @param keycode
	 * @param keysToSend
	 */
	public void sendkeysinactions(WebElement element, CharSequence keycode, String keysToSend) {
		element.sendKeys(keysToSend, keycode);
	}

	/**
	 * @Description Perform mouse doubleclick
	 * @param element
	 */
	public void doubleClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	/**
	 * @Description Accept alert
	 */
	public void acceptAlert() {
		Alert al = driver.switchTo().alert();
		al.accept();
	}

	/**
	 * @Description Dismiss alert
	 */
	public void dismissAlert() {
		Alert al = driver.switchTo().alert();
		al.dismiss();
	}

	/**
	 * @Description Type content automatically using javascript from this method
	 * @param element
	 * @param text
	 */
	public void insertTextJs(WebElement element, String text) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value'," + text + ")", element);
	}

	/**
	 * @Description Get values from the attribute using javascript from this method
	 * @param element
	 * @return
	 */
	public Object printTextJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Object executeScript = executor.executeScript("return arguemnt[0].getAttribute('value')", element);
		return executeScript;
	}

	/**
	 * @Description Get perform click using javascript from this method
	 * @param element
	 */
	public void clickjs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0],click()", element);
	}

	/**
	 * @Description Scroll down window
	 * @param element
	 */
	public void scrollDownJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].scrollIntoView(true)", element);
	}

	/**
	 * @Description Scroll Up window
	 * @param element
	 */
	public void scrolUpJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("argument[0].scrollIntoView(false)", element);
	}

	/**
	 * @Description Take Screenshot
	 * @return File
	 */
	public File screenShot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File file = screenshot.getScreenshotAs(OutputType.FILE);
		return file;
	}

	/**
	 * @Description Take Screenshot based on WebElement
	 * @return File
	 */
	public File screenshotWebElement(WebElement element) {
		File file = element.getScreenshotAs(OutputType.FILE);
		return file;
	}

	/**
	 * @Description Create new file
	 * @param location
	 * @return File
	 */
	public File newFile(String location) {
		File f = new File(location);
		return f;
	}

	/**
	 * @Description User can copy and paste file
	 * @param sourcelocation
	 * @param destlocation
	 * @throws IOException
	 */
	public void copypastefile(String sourcelocation, String destlocation) throws IOException {
		File s = new File(sourcelocation);
		File d = new File(destlocation);
		FileUtils.copyFile(s, d);
	}

	/**
	 * @Description User can navigate page to new url
	 * @param url
	 */
	public void urlNavigation(String url) {
		driver.navigate().to(url);
	}

	/**
	 * @Description Navigate page back
	 */
	public void moveback() {
		driver.navigate().back();
	}

	/**
	 * @Description Move page forword
	 */
	public void moveforward() {
		driver.navigate().forward();
	}

	/**
	 * @Description Refresh the current page
	 */
	public void refresh() {
		driver.navigate().refresh();
	}

	/**
	 * @Description Select dropdown based on value
	 * @param element
	 * @param value
	 */
	public void selectByValue(String value, WebElement element) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * @Description Select dropdown based on index
	 * @param element
	 * @param index
	 */
	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);

	}

	/**
	 * @Description Select dropdown based on visible text
	 * @param text
	 * @param element
	 */
	public void selectByText(String text, WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/**
	 * @Description Get all options in Drop down
	 * @param element
	 * @return List<WebElement>
	 */
	public List<WebElement> getoptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		return options;
	}

	/**
	 * @Description Get all selected options in Drop down
	 * @param element
	 * @return List<WebElement>
	 */
	public List<WebElement> getAllSelectedOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		return allSelectedOptions;
	}

	/**
	 * @Description Get first option
	 * @param element
	 */
	public void getFirstOption(WebElement element) {
		Select select = new Select(element);
		select.getFirstSelectedOption();
	}

	/**
	 * @Description Check the dropdown option have multiple selector
	 * @param element
	 * @return Boolean
	 */
	public boolean isMultiple(WebElement element) {
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}

	/**
	 * @Description Deselect option based on Index
	 * @param element
	 * @param Index
	 */
	public void deselectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	/**
	 * @Description Deselect All the option
	 * @param element
	 */
	public void deselectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}

	/**
	 * @Description Deselect option based on value
	 * @param element
	 * @param text
	 */
	public void deselectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}

	/**
	 * @Description Deselect option based on visible text
	 * @param element
	 * @param text
	 */
	public void deselectByText(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}

	/**
	 * @Description Switch frame control based on frame Id or Name
	 * @param frame Id or Name
	 */
	public void SwitchToFrameByNameOrId(String NameOrId) {
		driver.switchTo().frame(NameOrId);
	}

	/**
	 * @Description Switch frame control based on frame Index
	 * @param frameIndex
	 */
	public void SwitchToFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * @Description Switch frame control based on frame Webelement
	 * @param frameElement
	 */
	public void switchToFrameByWebElement(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	/**
	 * @Description Switch frame control to default
	 */
	public void defaultContent() {
		driver.switchTo().defaultContent();
	}

	/**
	 * @Description Get parent windows unique identity
	 * @return identity of Window
	 */
	public String getWindowHandle() {
		String parentWinId = driver.getWindowHandle();
		return parentWinId;
	}

	/**
	 * @Description Get entire windows unique identity
	 * @return identity of Window
	 */
	public Set<String> getWindowHandles() {
		Set<String> allWinId = driver.getWindowHandles();
		return allWinId;
	}

	/**
	 * @Description Switch driver access to particular windows
	 * @param nameOrHandle
	 */
	public void switchToWindow(String nameOrHandle) {
		driver.switchTo().window(nameOrHandle);
	}

	/**
	 * @Description Close current window associated with driver
	 */
	public void close() {
		driver.close();
	}

	/**
	 * @Description close every window associated with driver
	 */
	public static void quit() {
		driver.quit();
	}

	// wait

	public void waitMethod() throws InterruptedException {
		driver.wait();

	}

	/**
	 * @Description Clear the Webelement text
	 * @param element
	 */
	public void clearMethod(WebElement element) {
		element.clear();
	}

}
