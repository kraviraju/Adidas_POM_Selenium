package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import Framework.BrowserSetup;
public class LoginPage {

	private WebDriver driver;
	static Logger log = Logger.getLogger(LoginPage.class);

	
	
	// *******************  Web Elements *************************************
	
	
	   @FindBy(id = "usrName")
	   private WebElement TxtBx_userName;

	   @FindBy(id = "password")
	   private WebElement TxtBx_password;
	   
	   @FindBy(xpath = "//*[@id=\"loginForm\"]/div[5]/input")
	   private WebElement Btn_Login;
	   

	// *******************  Constructor *************************************
	   public LoginPage (WebDriver driver){
	       this.driver=driver;
	       PageFactory.initElements(driver, this);
	   }


	// *******************  Page Methods *************************************
	   AccountSummaryPage AccountSummaryPage = new AccountSummaryPage(driver);
	   public void Login() throws InterruptedException{
		   WebDriverWait wait = new WebDriverWait(driver, 60);
		   try {
			   	   wait.until(ExpectedConditions.elementToBeClickable(By.id("usrName")));
			   	   TxtBx_userName.click();
				   TxtBx_userName.sendKeys("hotcoolden@gmail.com");
				   TxtBx_password.sendKeys("Tanuja1975Tanuja");
				   Btn_Login.click();
				   Thread.sleep(2500);
				   if (AccountSummaryPage.isPageOpened()==true) {
					   System.out.println("Login : Success !");
				   }else {
					   System.out.println("Login : Failed !");
					   BrowserSetup.cleanUp();
				   }
		   }catch (Exception e) {
				//log.error("Login() - > Unable to login : " + e.getMessage());
		   }
	   }
	}
