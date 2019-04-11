package capabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import managers.DriverConnection;
import managers.DriverManager;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;


public class SauceLabsCapabilities extends DriverManager {

	
	
	
    @Override
    public AndroidDriver<AndroidElement>  createDriver() throws Exception {
    						//new DesiredCapabilities();
		DesiredCapabilities capabilities = DesiredCapabilities.iphone();	
		capabilities.setCapability("appiumVersion", "1.8.1");
		capabilities.setCapability("deviceName","iPhone X Simulator");
		capabilities.setCapability("deviceOrientation", "portrait");
		capabilities.setCapability("platformVersion","11.3");
		capabilities.setCapability("browserName", "");
		
		
    	System.out.println("SCL 4");
	//	driver = DriverConnection.getDriverInstance("sauceLabs", capabilities).getDriver();
    	driver = new AndroidDriver<AndroidElement>(
				new URL("username"),
				capabilities);
		return driver;
		
	}
    }
