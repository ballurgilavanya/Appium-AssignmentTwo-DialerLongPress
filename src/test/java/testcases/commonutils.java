package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class commonutils {
	public static AndroidDriver driver;
	

	public static Properties prop=new Properties();
	public static String device_name;
	public static String automation_name;
	public static String platform_version;
	public static String app_package;
	public static String app_activity;

	public static void loadproperties(String propertyFileName) throws IOException
	
	{
		File classpathRoot = new File(System.getProperty("user.dir"));
		FileInputStream fis=new FileInputStream((classpathRoot)+"/src/test/java/testcases/global.properties");
		prop.load(fis);
		device_name=prop.getProperty("device.name");
		automation_name=prop.getProperty("automation.name");
		platform_version=prop.getProperty("platform.version");
		app_package=prop.getProperty("app.package");
		app_activity=prop.getProperty("app.activity");
		
		
	}
	
	@SuppressWarnings("rawtypes")
	public static void setCapabilities() throws MalformedURLException
	{
		
		DesiredCapabilities Capabilities = new DesiredCapabilities();
		Capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device_name);
		Capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, automation_name);
		Capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platform_version);
		Capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, app_package);
		Capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, app_activity);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), Capabilities);
		
	}
	
	public static AndroidDriver getDriver() {
		return driver;
	}
}
