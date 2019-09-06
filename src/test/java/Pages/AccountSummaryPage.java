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

public class AccountSummaryPage {
private WebDriver driver;

	
	// *******************  Web Elements *************************************
	
	
	   @FindBy(xpath = "//*[@id=\"myAccountForm\"]/div/div/div[1]/div[1]")
	   private WebElement Txt_YourAccount;

	   @FindBy(id = "MEN")
	   private WebElement Menu_topcategory_MEN;
	   
	   @FindBy(id = "logout_Link")
	   private WebElement Link_Logout;
	   
	   @FindBy(id = "headerLogin")
	   private WebElement Link_Login;
	   

	// *******************  Constructor *************************************
	   public AccountSummaryPage (WebDriver driver){
	       this.driver=driver;
	       PageFactory.initElements(driver, this);
	   }


	// *******************  Page Methods *************************************
	   public boolean isPageOpened() throws InterruptedException{
		   Thread.sleep(1500);
	       return driver.getTitle().contains("adidas- My Account");
	   }

	   
	   public void NavigatetoMenFootwear(String searchText) throws InterruptedException {
		   isLoginSuccess();
		   SelectMenFootwear(searchText);
		   ValidateMenFootwear(searchText);
	   }
	   
	   
	   
	   
	   public void isLoginSuccess() throws InterruptedException{
		   if (isPageOpened()==true) {
			   System.out.println("Login Success !");
		   }else {
			   System.out.println("Login Failed !");
			   BrowserSetup.cleanUp();
			   
		   }
	   }
	   
	   public void SelectMenFootwear(String searchText) {
		   Actions action = new Actions(driver);
		   action.moveToElement(Menu_topcategory_MEN).perform();
		   WebElement ul = driver.findElement(By.xpath("//*[@id=\"Men\"]/div/div[1]/div[1]/ul"));
		   List<WebElement> li_ =  ul.findElements(By.tagName("li"));  
		   Integer j=0;
				   if (li_.size() != 0)
					   {
						   for (int i = 0; i <li_.size(); i++){
							   String str = li_.get(i).getText();
							   j=j+1;
							   if ((str.equals(searchText))== true) {
								   driver.findElement(By.xpath("//*[@id=\"Men\"]/div/div[1]/div[1]/ul/li["+j+"]/a")).click();
								   System.out.println("Selected Men Footwear : "+j+") "+str);
								   break;
							   }
					   }
				   }

	   }
	   
	   public void ValidateMenFootwear(String searchText) {
		   List<WebElement> text=  driver.findElements(By.id("appliedFilters"));
	        for(int i=0;i<text.size();i++)
	        {
	             if (text.get(i).getText().contains(searchText.toUpperCase())) {
	            	 System.out.println("ValidateMenFootwear : PASS");
	             }else {
	            	 System.out.println("ValidateMenFootwear : FAIL");
	             }
	        }
	   }

	   
	   public void Logout() throws InterruptedException {
		   Link_Logout.click();
		   Thread.sleep(1500);
		   if (Link_Login.isDisplayed()==true) {
			   System.out.println("Logout : Success !");
		   }
		   BrowserSetup.cleanUp();
	   }
	   
	 
	}
