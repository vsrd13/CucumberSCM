/*###################################################################################################
Name: CommonFunctions.java 
Description: Common used function accross the project
Author: Venkat
Date Created:01/17/2014
Date Modified:
Updated Comments:
#####################################################################################################*/


import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;



public class CommonFunctions {

	public static String FileName;
	public static String DownloadedFileName;
	public static String Filepath;

	/**
	 * it will wait until element invisible on the web page within specified
	 * time
	 * 
	 * @author Venkata
	 * @param int
	 *            Timeouty
	 * @param String
	 *            objxpath
	 * @param final
	 *            WebDriver aDriver
	 * @throws Exception
	 */

	public void waitUntilElementInvisibe(int Timeout, String objxpath, final WebDriver aDriver) throws Exception {
		try {
			new FluentWait<WebDriver>(aDriver).withTimeout(Timeout, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS)
					.ignoring(NoSuchElementException.class)
					.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(objxpath)));
		} catch (Exception e) {
		}
	}

	/**
	 * it will wait until element visible on the web page within specified time
	 * 
	 * @author Venkata
	 * @param int
	 *            Timeouty
	 * @param String
	 *            objxpath
	 * @param final
	 *            WebDriver aDriver
	 * @throws Exception
	 */

	public void waitforElement(int Timeout, String objxpath, final WebDriver aDriver) throws Exception {
		try {
			new FluentWait<WebDriver>(aDriver).withTimeout(Timeout, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS)
					.ignoring(NoSuchElementException.class)
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objxpath)));
		} catch (Exception e) {
		}
	}

	/**
	 * it will wait until element visible on the web page within specified time
	 * 
	 * @author Venkata
	 * @param int
	 *            Timeouty
	 * @param final
	 *            WebElement key
	 * @param final
	 *            WebDriver aDriver
	 * @throws Exception
	 */

	public void waitforElement(int Timeout, final WebElement key, final WebDriver aDriver) throws Exception {
		try {
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(aDriver).withTimeout(Timeout, TimeUnit.SECONDS)
					.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.visibilityOf(key));
		} catch (Exception e) {
		}
	}

	/**
	 * Type value in given webelement field
	 * 
	 * @author Venkata
	 * @param webelement
	 *            key
	 * @param String
	 *            value
	 * @throws Exception
	 */

	public void type(WebElement key, String value) throws Exception {
		if (key.isDisplayed()) {
			key.sendKeys(value);
		} else {
			throw new Exception(key + "is not found");
		}
	}

	/**
	 * it will perform the tab action on given webelement field
	 * 
	 * @author Venkata
	 * @param webelement
	 * @throws Exception
	 */

	public void sendkeysTab(WebElement key) throws Exception {
		if (key.isDisplayed()) {
			key.sendKeys(Keys.TAB);
		} else {
			throw new Exception(key + "is not found");
		}
	}

	/**
	 * it will perform the Back Space action on given webelement field
	 * 
	 * @author Venkata
	 * @param webelement
	 *            key
	 * @throws Exception
	 */

	public void sendkeybackSpace(WebElement key) throws Exception {
		if (key.isDisplayed()) {
			key.sendKeys(Keys.BACK_SPACE);
		} else {
			throw new Exception(key + "is not found");
		}
	}

	/**
	 * it will perform the Enter action on given webelement field
	 * 
	 * @author Venkata
	 * @param webelement
	 *            key
	 * @throws Exception
	 */

	public void sendkeysEnter(WebElement key) throws Exception {
		if (key.isDisplayed()) {
			key.sendKeys(Keys.ENTER);
		} else {
			throw new Exception(key + "is not found");
		}
	}

	/**
	 * it will perform the Return action on given webelement field
	 * 
	 * @author Venkata
	 * @param webelement
	 *            key
	 * @throws Exception
	 */

	public void sendkeysReturn(WebElement key) throws Exception {
		if (key.isDisplayed()) {
			key.sendKeys(Keys.RETURN);
		} else {
			throw new Exception(key + "is not found");
		}
	}

	/**
	 * Type value in given webelement field using JavaScript Executor
	 * 
	 * @author Venkata
	 * @param WebDriver
	 * @param webelement
	 * @param value
	 * @throws Exception
	 */

	public void JavaScripttype(final WebDriver aDriver, WebElement key, String value) throws Exception {
		if (key.isDisplayed()) {
			JavascriptExecutor jse = ((JavascriptExecutor) aDriver);
			jse.executeScript("arguments[0].value='" + value + "';", key);
		} else {
			throw new Exception(key + "is not found");
		}
	}

	/**
	 * it will perform the Back Space action on given webelement field using
	 * Javascript executor
	 * 
	 * @author Venkata
	 * @param WebDriver
	 * @param webelement
	 * @param value
	 * @throws Exception
	 */

	public void JavaScripttypespace(final WebDriver aDriver, WebElement key, String value) throws Exception {
		if (key.isDisplayed()) {
			JavascriptExecutor jse = ((JavascriptExecutor) aDriver);
			jse.executeScript("arguments[0].value='" + value + " " + "';", key);
		} else {
			throw new Exception(key + "is not found");
		}
	}

	/**
	 * Click on the given webelement field
	 * 
	 * @author Venkata
	 * @param webelement
	 *            key
	 * @throws Exception
	 * @throws InterruptedException
	 */

	public void click(WebElement key) throws Exception {

		if (key.isDisplayed()) {
			key.click();
		} else {
			throw new Exception(key + "is not found");
		}
	}

	/**
	 * Click on the given webelement field using JavaScript Executor
	 * 
	 * @author Venkata
	 * @param WebDriver
	 * @param webelement
	 * @throws Exception
	 * @throws InterruptedException
	 */

	public void JavaScriptclick(final WebDriver aDriver, WebElement key) throws Exception {

		if (key.isDisplayed()) {
			JavascriptExecutor jse = (JavascriptExecutor) aDriver;
			jse.executeScript("arguments[0].click();", key);
		} else {
			throw new Exception(key + "is not found");
		}
	}

	/**
	 * it will perform the Mouse Hover action on given webelement field using
	 * Javascript executor
	 * 
	 * @author Venkata
	 * @param WebDriver
	 * @param webelement
	 * @throws Exception
	 * @throws InterruptedException
	 */

	public void JavaScriptMousehover(final WebDriver aDriver, WebElement key) throws Exception {
		if (key.isDisplayed()) {
			String mouseOverScript = "if(document.createEvent){ " + "var evObj = document.createEvent('MouseEvents');"
					+ "evObj.initEvent('mouseover',true, false); " + "arguments[0].dispatchEvent(evObj);} "
					+ "else if(document.createEventObject) { " + "arguments[0].fireEvent('onmouseover');}";
			((JavascriptExecutor) aDriver).executeScript(mouseOverScript, key);
		} else {
			throw new Exception(key + "is not found");
		}
	}

	/**
	 * Click on the given maskedit textboxes webelement field and send the data
	 * into the WebElement Field
	 * 
	 * @author Venkata maskedit textboxes (Phone Number, Zip etc......)
	 * @param webelement
	 * @param String
	 * @throws Exception
	 * @throws InterruptedException
	 */

	public void clickandtype(WebElement key, String value) throws Exception {

		if (key.isDisplayed()) {
			key.click();
			key.sendKeys(value);
		} else {
			throw new Exception(key + "is not found");
		}
	}

	/**
	 * Get innerText of given webelement from html doc
	 * 
	 * @author Venkata
	 * @param key
	 * @return visible inner html text
	 * @throws Exception
	 */

	public String getText(WebElement key) throws Exception {

		if (key.isDisplayed()) {
			key.getText();
		} else {
			throw new Exception(key + "is not found");
		}
		return key.isDisplayed() ? key.getText() : null;
	}

	/**
	 * Get Attribute name based on id, name, class, value of given webelement
	 * from html doc
	 * 
	 * @author Venkata
	 * @param key
	 * @param String
	 * @return visible inner html text
	 * @throws Exception
	 */

	public String getAttribute(WebElement key, String AttributeName) throws Exception {

		if (key.isDisplayed()) {
			key.getAttribute(AttributeName);
		} else {
			throw new Exception(key + "is not found");
		}
		return key.isDisplayed() ? key.getAttribute(AttributeName) : null;
	}

	/**
	 * Verifying the webelement field using isDisplayed method
	 * 
	 * @author Venkata
	 * @param WebDriver
	 *            aDriver
	 * @param webelement
	 *            element
	 * @throws InterruptedException
	 */

	public boolean VerifyObject(final WebDriver aDriver, WebElement element) throws Exception {
		try {
			aDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			if (element.isDisplayed())
				;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Verifying the webelement field using isDisplayed method
	 * 
	 * @author Venkata
	 * @param WebDriver
	 *            aDriver
	 * @param String
	 *            objxpath
	 * @throws InterruptedException
	 */

	public boolean VerifyObject(final WebDriver aDriver, String objxpath) throws Exception {
		try {
			aDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			if (aDriver.findElement(By.xpath(objxpath)).isDisplayed())
				;
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * Clear the input value from webelement field
	 * 
	 * @author Venkata
	 * @param webelement
	 * @throws Exception
	 * @throws InterruptedException
	 */

	public void clear(final WebElement key) throws Exception {
		if (key.isDisplayed()) {
			key.clear();
		} else {
			throw new Exception(key + "is not found");
		}
	}

	/**
	 * Select value in given webelement field
	 * 
	 * @author Venkata
	 * @param webelement
	 * @param value
	 * @throws Exception
	 */

	public void selectByValue(final WebElement key, final String value) throws Exception {
		if (key.isDisplayed()) {
			new Select(key).selectByVisibleText(value);
			;
		} else {
			throw new Exception(key + "is not found");
		}
	}

	/**
	 * Select value in given webelement field based on Index
	 * 
	 * @author Venkata
	 * @param webelement
	 * @param int
	 *            index
	 * @throws Exception
	 */

	public void selectByIndex(final WebElement key, final int value) throws Exception {
		if (key.isDisplayed()) {
			new Select(key).selectByIndex(value);
			;
		} else {
			throw new Exception(key + "is not found");
		}
	}

	/*
	 * it is used to down the page based on WebElement
	 * 
	 * @author Venkata
	 * 
	 * @param webelement
	 * 
	 * @throws Exception
	 */

	public void sendKeysPagedown(final WebElement key) throws Exception {
		if (key.isDisplayed()) {
			key.sendKeys(Keys.PAGE_DOWN);
			;
		} else {
			throw new Exception(key + "is not found");
		}
	}

	/**
	 * Switch to the Frame based on the id or name
	 * 
	 * @author Venkata
	 * @param WebDriver
	 * @param String
	 */

	public void switchToFrame(final WebDriver aDriver, String frameName) {
		aDriver.switchTo().frame(frameName);
	}

	/**
	 * Switch to the Frame based on the frame index
	 * 
	 * @author Venkata
	 * @param WebDriver
	 * @param int
	 */

	public void switchToFrame(final WebDriver aDriver, int frameindex) {
		aDriver.switchTo().frame(frameindex);
	}

	/**
	 * Switch to the Frame based on the WebElement field
	 * 
	 * @author Venkata
	 * @param WebDriver
	 * @param WebElement
	 */

	public void switchToFrame(final WebDriver aDriver, WebElement frameName) {
		aDriver.switchTo().frame(frameName);
	}

	/**
	 * Switch to the default Content
	 * 
	 * @author Venkata
	 * @param WebDriver
	 */

	public void switchToMain(final WebDriver aDriver) {
		aDriver.switchTo().defaultContent();
	}

	/**
	 * Switch to the Alert window and then Accept
	 * 
	 * @author Venkata
	 * @param WebDriver
	 */

	public void switchToAlertAccept(final WebDriver aDriver) {
		Alert alert = aDriver.switchTo().alert();
		alert.accept();
	}

	/**
	 * Switch to the Alert window and then Dismiss
	 * 
	 * @author Venkata
	 * @param WebDriver
	 */

	public void switchToAlertDismiss(final WebDriver aDriver) {
		Alert alert = aDriver.switchTo().alert();
		alert.dismiss();
	}

	/**
	 * Switch to the Alert Prompt box and then type value and Accept
	 * 
	 * @author Venkata
	 * @param WebDriver
	 * @param String
	 */

	public void switchToAlertPrompttypeandAccept(final WebDriver aDriver, String value) {
		Alert alert = aDriver.switchTo().alert();
		alert.sendKeys(value);
		alert.accept();
	}

	/**
	 * Return true if alert present else return false
	 * 
	 * @author Venkata
	 * @param WebDriver
	 * @throws Exception
	 */

	public boolean isAlertPresent(final WebDriver aDriver) throws Exception {

		try {
			aDriver.switchTo().alert();
			return true;
		} catch (Exception e) {
			throw new Exception("alert is not found");
		}
	}

	/**
	 * if condition to compare expected and actual
	 * 
	 * @author Venkata
	 * @param String
	 *            expected
	 * @param String
	 *            actual
	 */

	public void ifcondition(String expected, String actual) {

		if (expected.equals(actual)) {

			System.out.println("expected matches with actual");
		}
	}

	/**
	 * Switch to the child window from parent window
	 * 
	 * @author Venkata
	 * @param String
	 * @param WebDriver
	 */

	public void switchToChildWindow(String parentHandler, final WebDriver aDriver) {

		for (String winHandle : aDriver.getWindowHandles()) {
			if (!winHandle.equals(parentHandler)) {
				aDriver.switchTo().window(winHandle);
			}
		}
	}

	/**
	 * Close the Child Window and Switch to the Parent Window
	 * 
	 * @author Venkata
	 * @param String
	 * @param WebDriver
	 */

	public void switchTomainWindow(String parentHandler, final WebDriver aDriver) {

		aDriver.close();
		aDriver.switchTo().window(parentHandler);
	}

	/**
	 * get the title of the page
	 * 
	 * @author Venkata
	 * @param WebDriver
	 */

	public String gettitle(final WebDriver aDriver) {

		return aDriver.getTitle();
	}

	/**
	 * Scroll down page using the Java script
	 * 
	 * @author Venkata
	 * @param WebDriver
	 */

	public void scrollDown(final WebDriver aDriver) {

		JavascriptExecutor js = (JavascriptExecutor) aDriver;
		js.executeScript("scroll(0,300)");
	}

	/**
	 * Scroll Up page using the Java script
	 * 
	 * @author Venkata
	 * @param WebDriver
	 */

	public void scrollUp(final WebDriver aDriver) {

		JavascriptExecutor js = (JavascriptExecutor) aDriver;
		js.executeScript("scroll(300,0)");
	}

	public boolean VerifyText(WebDriver driver, String Object, String text) throws Exception {

		try {
			WebElement element = driver.findElement(By.xpath(Object));
			String elementText = element.getText();
			System.out.println(elementText);
			if (elementText.equalsIgnoreCase(text)) {
				return true;
			}
		} catch (NoSuchElementException e) {
			throw new Exception(Object + "is not found");

		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public String LatestDownloadedFile(String FolderName, boolean isFromChrome) throws Exception {
		try {

			if (!isFromChrome) {
				File directory = new File(".//");
				String DownloadFilePath = directory.getCanonicalPath() + "\\" + "DownloadingFiles";
				File dir = new File(DownloadFilePath);
				File[] files = dir.listFiles();
				Arrays.sort(files);
				Arrays.sort(files, new Comparator() {
					public int compare(Object o1, Object o2) {
						return compare((File) o1, (File) o2);
					}

					private int compare(File f1, File f2) {
						long result = f2.lastModified() - f1.lastModified();
						if (result > 0) {
							return 1;
						} else if (result < 0) {
							return -1;
						} else {
							return 0;
						}
					}
				});
				String LatestDownloadedFile = Arrays.asList(files[0]).toString();
				String regex = "\\[|\\]";
				String DownloadPath = LatestDownloadedFile.replaceAll(regex, "");

				String[] arrFileName = LatestDownloadedFile.split("\\\\");
				FileName = arrFileName[arrFileName.length - 1];
				if (FileName.contains("(")) {
					String[] splitfilename = FileName.split("\\(");
					FileName = splitfilename[0];
					System.out.println("split filename " + splitfilename[0]);
				}
				String[] arrFileNames = FileName.split("\\.");
				String FileNames = arrFileNames[0];
				DownloadedFileName = FileNames;
				String s = xDownloadFiles(FolderName);
				Filepath = s + "\\" + FileName.replace("]", "");
				Path RSource = Paths.get(DownloadPath);
				Path RTarget = Paths.get(Filepath);
				Files.move(RSource, RTarget, REPLACE_EXISTING);
			} else {
				String DownloadFilePath = xDownloadFiles(FolderName);

				File dir = new File(DownloadFilePath);
				File[] files = dir.listFiles();
				Arrays.sort(files);
				Arrays.sort(files, new Comparator() {
					public int compare(Object o1, Object o2) {
						return compare((File) o1, (File) o2);
					}

					private int compare(File f1, File f2) {
						long result = f2.lastModified() - f1.lastModified();
						if (result > 0) {
							return 1;
						} else if (result < 0) {
							return -1;
						} else {
							return 0;
						}
					}
				});
				String LatestDownloadedFile = Arrays.asList(files[0]).toString();
				String regex = "\\[|\\]";
				String DownloadPath = LatestDownloadedFile.replaceAll(regex, "");
				Filepath = DownloadPath;
				String[] arrFileName = LatestDownloadedFile.split("\\\\");
				FileName = arrFileName[arrFileName.length - 1];
				if (FileName.contains("(")) {
					String[] splitfilename = FileName.split("\\(");
					FileName = splitfilename[0];
					System.out.println("split filename " + splitfilename[0]);
				}
				String[] arrFileNames = FileName.split("\\.");
				String FileNames = arrFileNames[0];
				DownloadedFileName = FileNames;
			}
		} catch (Exception e) {
			return e.getMessage();
		}
		return Filepath;
	}
}
