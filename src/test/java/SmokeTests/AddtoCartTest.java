package SmokeTests;

import java.io.IOException;
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
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Framework.BrowserSetup;
import Framework.LocalDriverManager;
import Pages.AccountSummaryPage;
import Pages.LoginPage;
import Pages.SearchResultsPage;

public class AddtoCartTest {
	
	WebDriver driver;
	
	@Test
    public void TC1() throws InterruptedException, IOException {
		
		
		
	// ******************  Open Browser & click Login link ***********************	
		driver=BrowserSetup.invokeBrowser("https://shop.adidas.co.in/");
		Thread.sleep(2500);
		driver.findElement(By.id("headerLogin")).click();
		Thread.sleep(2500);
		
	// ****************** Enter login credentials ********************************	
		LoginPage LoginPage = new LoginPage(driver);
		LoginPage.Login();
		
	// ****************** Navigate to 	Men -> Basketball category ***************
		AccountSummaryPage AccountSummaryPage = new AccountSummaryPage(driver);
		String searchText = "Basketball";
		AccountSummaryPage.NavigatetoMenFootwear(searchText);
		
		
	// ****************** Add to cart from Search results** ***********************	
		SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
		searchResultsPage.AddtoCard();
		
		
		
	// ****************** Logout  *************************************************	
		AccountSummaryPage.Logout();
    }
 
    
 
   


}
