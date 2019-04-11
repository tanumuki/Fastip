/**
 * 
 */
package capabilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author aswin
 *
 */
public class GetConnectedDevices {
	
	/*
	 * A utility class to read the connected devices' info and use that info for setting the capabilities 
	 * 
	 */
	
	public static String deviceId = null;
	public static String model = null;
	public static String osVersion = null;
	static List<String> cmd = new ArrayList<String>();
	
	public static void getDetails() {
		System.out.println("\nInside getDetails...");
		System.out.println();
		String home = System.getenv("HOME");
		cmd.add (home + "/Library/Android/sdk/platform-tools/adb");
		cmd.add("shell");
		cmd.add("getprop");
		
		getDeviceID();
		getModel();
		getOSVersion();
		
	}
	
	/*
	 * Gets the device ID
	 */
	static void getDeviceID() {
		cmd.add("ro.serialno");
		deviceId = runCmd();
		System.out.println("deviceId: " + deviceId);
		cmd.remove(3);
	}
	
	/*
	 * Gets the OS version
	 */
	static void getOSVersion() {
		
		cmd.add("ro.build.version.release");
		osVersion = runCmd();
		System.out.println("osVersion: " + osVersion);
		cmd.remove(3);
	}
	
	/*
	 * Gets the model name
	 */
	static void getModel() {
		
		cmd.add("ro.product.model");
		model = runCmd();
		System.out.println("model: " + model);
		cmd.remove(3);
	}
	
	/*
	 * Runs the command gives an output
	 */
	static String runCmd() {
		ProcessBuilder pb = new ProcessBuilder(cmd);
		BufferedReader br = null;
		try {
			Process p = pb.start();
			
			p.waitFor();
			br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			
			return br.readLine();
			
		}catch(IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
