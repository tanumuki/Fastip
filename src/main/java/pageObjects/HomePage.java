package pageObjects;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import logger.MyLogger;
import properties.Data;
import utilities.Util;

public class HomePage {

	
	Data data;
	String dataFile;
	public AndroidDriver<AndroidElement> driver;

	public HomePage(AndroidDriver<AndroidElement>driver, String dataFile)
			throws JsonParseException, JsonMappingException, IOException {
		data = Data.get(dataFile);
		this.dataFile = dataFile;
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	// @CacheLookup
	@AndroidFindBy(id = "android:id/home")
	private AndroidElement logo;
	
	@AndroidFindBy(id = "android:id/action_bar_title")
	private AndroidElement title;
	
	@AndroidFindBy(id = "org.traeg.fastip:id/menu_settings")
	private AndroidElement settings;
	
	@AndroidFindBy(id = "org.traeg.fastip:id/billAmtEditText")
	private AndroidElement textBox;
	
	@AndroidFindBy(id = "org.traeg.fastip:id/calcTipButton")
	private AndroidElement calculateTipButton;
	
	@AndroidFindBy(id = "org.traeg.fastip:id/tipAmtTextView")
	private AndroidElement tipAmountTextView;
	
	
	@AndroidFindBy(id = "org.traeg.fastip:id/totalAmtTextView")
	private AndroidElement totalAmountTextView;
	


	
	public void verifyHomePageElements() {
		SoftAssert sa= new SoftAssert();
		sa.assertTrue(Util.isElementPresent(logo, driver));
		sa.assertTrue(Util.isElementPresent(title, driver));
		sa.assertTrue(Util.isElementPresent(settings, driver));
		sa.assertTrue(Util.isElementPresent(textBox, driver));
		sa.assertAll();
		MyLogger.log.info("Presence of elements verified!!");
	}
	
	/*
	 * TestCases:
	 * - Verify if the total bill amount that is displayed is being properly shown. This is done by using assert statements and verifying it against the input data
	 * -Verify if the tip amount is displayed as per the data fed from the json
	 *   
	 */
	
	
	public void caculateTip() {
		SoftAssert sa= new SoftAssert();
		textBox.sendKeys(data.billAmount());
		calculateTipButton.click();
		String totalAmount = totalAmountTextView.getText().substring(1, totalAmountTextView.getText().length()-1);
		String tipAmount = tipAmountTextView.getText().substring(1, tipAmountTextView.getText().length()-1);
		double totalAmountDisplayed = Double.parseDouble(totalAmount);
		double totalAmountEntered =((Double.parseDouble(data.billAmount())) * (Double.parseDouble(data.tipPercentage())/100) + Double.parseDouble(data.billAmount())); 
		sa.assertEquals(totalAmountDisplayed, totalAmountEntered);
		sa.assertEquals(Double.parseDouble(data.tipPercentage()), Double.parseDouble(tipAmount));		
		sa.assertAll();
		MyLogger.log.info("Calculator verification done!!");		
	}
	
	/*
	 * Testcase:
	 * -Verify the sanitization of the text box by feeding  lengthy inputs
	 */
	
	public void verifyTextBoxWithLengthyInput() {
		SoftAssert sa= new SoftAssert();
		//Util.calculate(element,  );
		textBox.sendKeys(data.enterLengthyBillAmount());
		calculateTipButton.click();
		String totalAmount = totalAmountTextView.getText().substring(1, totalAmountTextView.getText().length()-1);
		double totalAmountDisplayed = Double.parseDouble(totalAmount);
		double totalAmountEntered =((Double.parseDouble(data.enterLengthyBillAmount())) * (Double.parseDouble(data.tipPercentage())/100) + Double.parseDouble(data.enterLengthyBillAmount())); 
		sa.assertEquals(totalAmountDisplayed, totalAmountEntered);
		sa.assertAll();
		MyLogger.log.info("Text box verification with lengthy inputs done!!");		
		
	}
	
	/*
	 * Testcase:
	 * -Verify the sanitization of the text box by feeding negative chars.
	 */
	
	public void verifyTextBoxWithNegativeBillAmount() {
		SoftAssert sa= new SoftAssert();
		textBox.sendKeys(data.enterNegativeBillAmount());
		calculateTipButton.click();
		String totalAmount = totalAmountTextView.getText().substring(1, totalAmountTextView.getText().length()-1);
		double totalAmountDisplayed = Double.parseDouble(totalAmount);
		double totalAmountEntered =((Double.parseDouble(data.enterNegativeBillAmount())) * (Double.parseDouble(data.tipPercentage())/100) + Double.parseDouble(data.enterNegativeBillAmount())); 
		sa.assertEquals(totalAmountDisplayed, totalAmountEntered);
		sa.assertAll();
		MyLogger.log.info("Text box verification with negative inputs done!!");	
	}
	
	/*
	 * Testcase:
	 * -Verify the sanitization of the text box by feeding special charactersetc.
	 */
	
	public void verifyTextBoxWithSpecialChars() {
		SoftAssert sa= new SoftAssert();
		textBox.sendKeys(data.enterBillAmountWithSpecialChars());
		calculateTipButton.click();
		String totalAmount = totalAmountTextView.getText().substring(1, totalAmountTextView.getText().length()-1);
		double totalAmountDisplayed = Double.parseDouble(totalAmount);
		double totalAmountEntered =((Double.parseDouble(data.enterBillAmountWithSpecialChars())) * (Double.parseDouble(data.tipPercentage())/100) + Double.parseDouble(data.enterBillAmountWithSpecialChars())); 
		sa.assertEquals(totalAmountDisplayed, totalAmountEntered);
		sa.assertAll();
		MyLogger.log.info("Text box verification with special char inputs done!!");	
	}

	
}
