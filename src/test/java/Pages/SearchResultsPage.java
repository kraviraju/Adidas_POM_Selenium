package Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Framework.BrowserSetup;
import Framework.ExcelOperations;

public class SearchResultsPage {
private WebDriver driver;

	
	// *******************  Web Elements *************************************
	

		static String CSV_FILE = System.getProperty("user.dir")+"\\ProductInfo.csv";


	
	   @FindBy(xpath = "//*[@id=\"searchResultHeader\"]/span")
	   private WebElement Txt_searchResultHeader;

	 
	   

	// *******************  Constructor *************************************
	   public SearchResultsPage (WebDriver driver){
	       this.driver=driver;
	       PageFactory.initElements(driver, this);
	   }


	// *******************  Page Methods *************************************
	   public String AddtoCard() throws InterruptedException, IOException{
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
		   
		   String ProductIdentifier  = driver.findElement(By.xpath("//*[@id=\"shoppingCartTableBody\"]/tr/td[1]/div[2]/p[4]/span[2]")).getText();
		   ExcelOperations.WriteCSV(CSV_FILE, ProductIdentifier);
		   System.out.println("Product Identifier Updated in CSV file : ["+ProductIdentifier+"]");
		   
	      return str;
	   }

	   public void ValidateCart() throws IOException, InterruptedException {
		   Thread.sleep(2500);
		   String str1 = driver.findElement(By.xpath("//*[@id=\"cartLength\"]")).getText();
		   
		   driver.findElement(By.xpath("//*[@id=\"cartLength\"]")).click();
		   String ProductIdentifier_act  = driver.findElement(By.xpath("//*[@id=\"shoppingCartTableBody\"]/tr/td[1]/div[2]/p[4]/span[2]")).getText().trim();
		   
		   String ProductIdentifier_exp = ExcelOperations.ReadCSV(CSV_FILE);
		   
		   if (str1.equals("1")==true) {
			   if (ProductIdentifier_act.equals(ProductIdentifier_exp.trim())==true) {
				   System.out.println("Product Identifier Validated against CSV file: ["+ProductIdentifier_act+"]");
			   }
		   }else {
			   System.out.println("Failed to Validate the Cart with current items ["+str1+"] with expected [1] Cart !");
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
