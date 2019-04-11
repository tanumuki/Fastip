package testCases;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import enums.DriverType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import managers.DriverManager;
import managers.DriverManagerFactory;
import properties.Data;

public class BaseTest {

	public static AndroidDriver<AndroidElement> driver = null;
	protected String env;
	protected String userDataFile;
	protected Data data;
	
	
	@Parameters({ "userDataFile" })
	@BeforeSuite
	public void setup(String userDataFile) throws JsonParseException, JsonMappingException, IOException {

		/*
		 * Creating the environment for configuration
		 * 
		 */

		System.out.println("calling setup !!");

		// getting data from data file
		this.userDataFile=userDataFile;
		DriverType deviceType = Data.get(userDataFile).getDeviceType();
		System.out.println("device Type " + deviceType);
		DriverManager driverManager = DriverManagerFactory.getManager(deviceType);
		try {
			if (driver == null)
				driver = driverManager.getDriver();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void stop() {

		try {
			System.out.println("quitting driiver homepage");
			System.out.println(driver.toString());
			if (driver != null) {
				driver.quit();
			}

		} catch (Exception e) {
			System.out.println("ypooo HomePage");
			e.printStackTrace();
		}

	}
	
}
