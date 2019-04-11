package managers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import logger.MyLogger;

public class DriverConnection {
	private static DriverConnection driverInstance ;
	public static AndroidDriver<AndroidElement> driver;

	private DriverConnection(String type, DesiredCapabilities capabilities) throws MalformedURLException {
		

		if (type.contains("localHost")) {
			try {
				System.out.println("will create driver now");
				driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			}
			catch(Exception e) {
				e.getStackTrace();
			}
		
		}
		if (type.contains("sauceLabs")) {
			driver = new AndroidDriver<AndroidElement>(
					new URL("http://testsaavnandroid:0208cf09-abcf-408a-9f03-c7a1efc74d3b@ondemand.saucelabs.com:80/wd/hub"),
					capabilities);
		}
	}

	public static DriverConnection getDriverInstance(String type, DesiredCapabilities capabilities)
			throws MalformedURLException {
		if(driverInstance == null) {
			driverInstance = new DriverConnection(type, capabilities);
		}
				return driverInstance;
	}

	public AndroidDriver<AndroidElement> getDriver() {
		MyLogger.log.info("returning driver" + driver.toString());
		MyLogger.log.debug("Driver is here!!");
		return driver;
	}

	public static void getScreenshot(ITestResult result) throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("Screenshot/" + result + " ss.png"));

	}
}
