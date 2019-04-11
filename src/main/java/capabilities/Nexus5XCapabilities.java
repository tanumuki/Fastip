package capabilities;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import managers.DriverConnection;
import managers.DriverManager;

public class Nexus5XCapabilities extends DriverManager {

	
	@Override
	public AndroidDriver<AndroidElement> createDriver() throws Exception {
		File fs= null;
		System.out.println("start creating driver " + fs);
		try {
			 fs = new File(System.getProperty("user.home") + "/eclipse-workspace/fastip/wunderpool/src/main/java/properties/FasTip.apk");
			System.out.println("file is " + fs.toString());
		}
		catch(Exception e) {
			System.out.println("exception at createDriver");
			e.printStackTrace();
		}
		
		
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "NEXUS5X");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		capabilities.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		//capabilities.setCapability("noReset","true");
		System.out.println("calling driver connection");
		driver = DriverConnection.getDriverInstance("localHost", capabilities).getDriver();
		System.out.println("returned driver is " + driver.toString());
		System.out.println("alert1");
		
		System.out.println("alert acppeted!!");
		if (driver != null) {
			System.out.println("JUK not null");
		} else {
			System.out.println("JUK null");
		}
		return driver;
	}
}
