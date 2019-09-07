package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Framework.BrowserSetup;

public class SearchResultsPage {
private WebDriver driver;

	
	// *******************  Web Elements *************************************
	




	
	   @FindBy(xpath = "//*[@id=\"searchResultHeader\"]/span")
	   private WebElement Txt_searchResultHeader;

	 
	   

	// *******************  Constructor *************************************
	   public SearchResultsPage (WebDriver driver){
	       this.driver=driver;
	       PageFactory.initElements(driver, this);
	   }


	// *******************  Page Methods *************************************
	   public String AddtoCard() throws InterruptedException{
		   Thread.sleep(1500);
		   String str = Txt_searchResultHeader.getText();
		// Store the current window handle
		   String winHandleBefore = driver.getWindowHandle();
		// Perform the click operation that opens new window
		   driver.findElement(By.xpath("//*[starts-with(@id,'productSearchTab_')]/a/img")).click();
		   Thread.sleep(2500);
		// Switch to new window opened
		   for(String winHandle : driver.getWindowHandles()){
		       driver.switchTo().window(winHandle);
		   }
		   driver.findElement(By.xpath("//*[@id=\"facetSizeDetails\"]/label[1]")).click();
		   driver.findElement(By.xpath("//*[@id=\"addToBagBtn\"]")).click();
		   Thread.sleep(2500);
		   String str1 = driver.findElement(By.xpath("//*[@id=\"cartLength\"]")).getText();
		   System.out.println("Succesfuly Added ["+str1+"] item to Cart !");
	      return str;
	   }

	   public void ValidateCart() {
		   String str1 = driver.findElement(By.xpath("//*[@id=\"cartLength\"]")).getText();
		   if (str1.equals("1")) {
			   System.out.println("Succesfuly Validated Cart with expected ["+str1+"] item in Cart !");
		   }else {
			   System.out.println("Failed to Validate Cart with expected ["+str1+"] item in Cart !");
		   }
	   }
	   
	   public void RemoveItem() throws InterruptedException{
		   driver.findElement(By.xpath("//*[@id=\"cartLength\"]")).click();
		   Thread.sleep(2500);
		   driver.findElement(By.xpath("//*[@id=\"shoppingCartTableBody\"]/tr/td[1]/div[2]/div/p/a[1]")).click();
		   Thread.sleep(2500);
		   String str1 = driver.findElement(By.xpath("//*[@id=\"cartLength\"]")).getText();
		   if (str1.equals("0")) {
			   System.out.println("Succesfuly Removed Item from Cart!");
		   }else {
			   System.out.println("Failed to Remove Item from Cart!");
		   }
	   }
	 
	}
