package Framework;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class BrowserSetup {
	protected static WebDriver driver;
	

	public static WebDriver invokeBrowser(String url){
		driver=LocalDriverManager.getDriver();
		driver.get(url);
		return driver;
	}
	
	//@AfterSuite
	public static void cleanUp(){
		driver.manage().deleteAllCookies();
		driver.close();
	}
	

	
}
