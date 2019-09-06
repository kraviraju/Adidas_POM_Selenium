package Framework;

import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;

import Pages.LoginPage;

public class LocalDriverManager {
	private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	static Logger log = Logger.getLogger(LocalDriverManager.class);
	
	
    public static WebDriver getDriver() {
    	
    	if (webDriver.get() == null) {
    		log.info("Thread has no WedDriver !");
    	}
    	
        return webDriver.get();
    }
 
    static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }
}
