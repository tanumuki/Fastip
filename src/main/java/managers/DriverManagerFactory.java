package managers;

import capabilities.Device;
import capabilities.Nexus5XCapabilities;
import capabilities.SauceLabsCapabilities;
import enums.DriverType;

public class DriverManagerFactory {

	
	
	public static DriverManager getManager(DriverType type) {

		DriverManager driverManager = null;

		switch (type) {
		case SAUCE_LABS:
			driverManager = new SauceLabsCapabilities();
			break;
		case NEXUS5X:
			driverManager = new Nexus5XCapabilities();
			break;
		case ANDROID_DEVICE: 
			driverManager = new Device();
		
		default:
			break;
		}
		return driverManager;
	}
}
