package Utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonMethods {

	public static void sendKey(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public static void paolaWait(int seconds) {
		try {
			Thread.sleep(1000 * seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void clickRadioOrCheckbox(List<WebElement> radioOrCheckbox, String value) {
		String actualValue;
		for (WebElement eachElement : radioOrCheckbox) {
			actualValue = eachElement.getText();
			if (eachElement.isEnabled() && actualValue.equals(value)) {
				eachElement.click();
				break;
			}
		}
	}

	// select drop downs

	public static void selectDropDownByVisibleText(WebElement element, String textToSelect) {
		try {
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();
			for (WebElement faz : options) {
				if (faz.getText().equals(textToSelect)) {
					select.selectByVisibleText(textToSelect);
					break;
				}
			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}

	}

	public static void selectDropDownByIndex() {
		// homework
	}

	// alerts

	public static void acceptAlert() {
		try {
			Alert alert = BaseClass.getDriver().switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

	}

	public static void dismissAlert() {
		// homework
	}

	public static void alertGetText() {
		// homework
	}

	// switch iframe by index

	public static void switchToIFrameByIndext(int iFrameIndex) {
		try {
			BaseClass.getDriver().switchTo().frame(iFrameIndex);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	public static void switchToIFrameByElement(WebElement iframeElement) {
		// homework
	}

	public static void switchToIFrameByName(String iframeName) {
		// homework
	}

	//

	// the user should have already opened or have clicked a link where a new
	// tab/window opened
	public static void switchToChildWindow(String currentWindow) {
		try {
			// get all window handles
			Set<String> windowHandles = BaseClass.getDriver().getWindowHandles();
			// switch to the child window
			for (String handle : windowHandles) {
				if (!handle.equals(currentWindow)) {
					BaseClass.getDriver().switchTo().window(handle);
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Exception occured while switching to child window " + e.getMessage());
			e.printStackTrace();
		}
	}

	//

	public static WebDriverWait getWaitObject() {
		WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), 30);
		return wait;
	}

	public static WebElement waitForClickability(WebElement element) {
		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	public static WebElement waitForVisibility(WebElement element) {
		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}

	public static void click(WebElement element) {
		waitForVisibility(element).click();
	}

	public static void sendKey(String keys, WebElement element) {
		waitForVisibility(element).sendKeys(keys);
	}

	public static void hoverOverMouse(WebElement element) {
		Actions action = new Actions(BaseClass.getDriver());
		action.moveToElement(element).build().perform();
	}

	public static void dragAndDrop(WebElement source, WebElement target) {
		Actions action = new Actions(BaseClass.getDriver());
		action.dragAndDrop(source, target).build().perform();
	}

	public static void doubleClick(WebElement element) {
		Actions action = new Actions(BaseClass.getDriver());
		action.doubleClick(element).build().perform();
	}

	public static void takeScreenShot(WebDriver driver) {

		try {
			// create object of Simple date format class and decide format
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");

			// get the current date time with LocalDateTime
			LocalDateTime now = LocalDateTime.now();

			// convert the date into the string with the specified format
			String dateString = now.format(formatter);

			// casting webdriver to takescreenshot
			TakesScreenshot screenshot = (TakesScreenshot) driver;

			// get the screenshot as an outfile
			File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

			// define destination path with the unique name
			String destFilePath = "src/test/resources/screenshots/eachScreenShot" + dateString + ".png";

			File destFile = new File(destFilePath);

			// use the fileutils to copy the screenshot to the destination path
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	public static void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	
	
	
	
	
	

}
