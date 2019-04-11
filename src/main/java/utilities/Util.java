package utilities;

import org.openqa.selenium.NoSuchElementException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Util {

	
	public static boolean isElementPresent(AndroidElement elem, AndroidDriver<AndroidElement> driver) {

		try {			
			elem.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	
}
