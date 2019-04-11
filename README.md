# Fastip


Cases 



1.Verify the presence of elements
2.Verify the calculator for positive inputs
3.Verify how the app behaves when lengthy bill amounts are put as input
4.Verify how the app behaves when negative bill amount is put as input
5.Verify how the app behaves when special characters are put as input



Framework structure



Project deployment and build tool: Maven
Design Patterns: 1.Page Object Model - Factory pattern - All the locators are placed in page object class and the business logic are also implemented in the same class. So if any locators are changed in near future, just changing the same in the page-object page would suffice. This won’t also disturb the business logic cases. All the test cases are implemented in the test case class. The test case class would directly interact with the methods in the page object class. Singleton pattern is used for initiating the driver. DriverConnection.java is a singleton class

Capabilities: Different classes for different execution scenarios - Execute it on device or sauce labs or even emulators.
Listener:Would listen for any activity, say taking screenshot or reports
Logger: log4J is implemented as logging tool
Managers: Based upon the device input from xml, the object gets created. This is based upon factory design pattern. 
Utilities: Every small reusable  utility functions reside here
Properties: The apk file and other json data files are located there


Run


Pre-conditions:
-Java 1.8 installed
 -Android studio installed
-Eclipse oxygen installed
-Appium server and GUI app installed 
Link for appium: http://www.automationtestinghub.com/download-and-install-appium-1-6/
Import the project as a maven project - Import ->Maven ->Existing maven project
In order to run it from terminal or JENKINS - 
-Open android studio and launch AVD manager. 
-Select a emulator and update the Nexus5XCapabilities(device name , platform version) with the emulator that you have opened via AVD manager in android studio
-Go to the folder where it resides (make sure POM.XML is present)
-type mvn test -P<profile_id>  [for example - mvn test -Pnexus] or if you want to run it on device  [mvn test -Pdevice]
Running from eclipse directly - 
In pom.xml, the maven profile id is already added as an argument. So just running the pom.xml will work. By default it will run on nexus emulator (I chose nexus as emulator)
