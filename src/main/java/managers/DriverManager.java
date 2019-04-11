package managers;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public abstract class DriverManager {

	
	public AndroidDriver<AndroidElement> driver;

	protected DesiredCapabilities capabilities = new DesiredCapabilities();

	protected abstract AndroidDriver<AndroidElement> createDriver() throws Exception;

	public AndroidDriver<AndroidElement> getDriver() throws Exception {
		if ( driver == null) {
			System.out.println("driver is null, creating driver");
			createDriver();
		}
		System.out.println("driver is NOT null");

		return driver;
	}
	
	
}
