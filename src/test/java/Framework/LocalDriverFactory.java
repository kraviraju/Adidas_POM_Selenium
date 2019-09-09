package Framework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class LocalDriverFactory {

	static WebDriver createBrowserInstance(String browserName) throws IOException, InterruptedException {
        WebDriver driver = null;
        if (browserName.toLowerCase().contains("firefox")) {
            driver = new FirefoxDriver();
            return driver;
        }
        if (browserName.toLowerCase().contains("internet")) {
            driver = new InternetExplorerDriver();
            return driver;
        }
        if (browserName.toLowerCase().contains("chrome")) {
        	
        	String cName ="Chromedriver76_0_3809_68.exe";
        	Runtime.getRuntime().exec("taskkill /F /IM "+cName+" /T");
        	String chromebrowser =  System.getProperty("user.dir") + "\\Drivers\\"+cName;
        	System.out.println("Chrome Browser Path : "+ chromebrowser);
        	Thread.sleep(2500);
        	System.setProperty("webdriver.chrome.driver", chromebrowser);
			ChromeOptions cOptions = new ChromeOptions();
		    cOptions.addArguments("test-type");
		    cOptions.addArguments("start-maximized");
		    cOptions.addArguments("--js-flags=--expose-gc");  
		    cOptions.addArguments("--enable-precise-memory-info"); 
		    cOptions.addArguments("--disable-popup-blocking");
		    cOptions.addArguments("--disable-default-apps"); 
		    cOptions.addArguments("disable-infobars");
		    cOptions.addArguments("user-data-dir=/Logs/");
		    DesiredCapabilities dc = DesiredCapabilities.chrome();
		    dc.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
		    LoggingPreferences logs = new LoggingPreferences();
		    logs.enable(LogType.BROWSER, Level.ALL);
		    logs.enable(LogType.CLIENT, Level.ALL);
		    logs.enable(LogType.DRIVER, Level.ALL);
		    logs.enable(LogType.PERFORMANCE, Level.ALL);
		    logs.enable(LogType.PROFILER, Level.ALL);
		    logs.enable(LogType.SERVER, Level.ALL);     
		    dc.setCapability(ChromeOptions.CAPABILITY, cOptions);
		    driver  = new ChromeDriver(dc);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           
        }
        return driver;
    }
	
}
