package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	//WebDriver driver;
	public HomePage(WebDriver driver){
		super(driver);
	}
	
	
	//Locators
	//List of WebElements.
	
	@FindBy (xpath = "//a[@class='zw i-b mt-10 pt-2 zw-srch-logo']")
	WebElement zigWheelsLogo;
	
	@FindBy(xpath = "//div[@class='col-lg-12 pl-0']/ul/li")
	List<WebElement> mainList;
	

	@FindBy(xpath = "//div[@class='col-lg-12 pl-0']/ul/li[3]/ul/li")
	List<WebElement> newBikesList;
	
	@FindBy(xpath="//div[@class='h-dd-r']//li/span")
	List<WebElement> citiesList;
	
	@FindBy(id="forum_login_wrap_lg")
	WebElement login;
	
	@FindBy(xpath="//span[@class='lgn-sp s ggle']")
	WebElement google;
	
	
	
	//Actions
	//Click on NewBikes option from Toggle 
	public void moveToNewBikes() {
		
		 for(WebElement x:mainList)
	      {
	    	  if(x.getText().equals("New Bikes")) {
	    		  hoverOnElement(x);
	    		  break;
	    	  }
	      }
	}
	
	
	//click on Upcoming bikes from the options available in NewBikes
	public void clickOnUpcomingBikes() {
	 for(WebElement x:newBikesList)
     {
   	if(x.getText().equalsIgnoreCase("Upcoming Bikes")) {
   		x.click();
   		break;
   	}		
   }
	}
	
	public void moveToUsedCars() {
		
		 for(WebElement x:mainList)
	      {
	    	  if(x.getText().equals("Used Cars")) {
	    		 hoverOnElement(x);
	    		  break;
	    	  }
	      }
	}
	
	
	public void selectCity() {

		 for(WebElement x:citiesList)
	      {
	    	  if(x.getText().equals("Chennai")) {
	    		x.click();
	    		  break;
	    	  }
	      }
	}
	
	public void clickLogin() {		
		login.click();
	}
	
	public void clickGoogle() {
		explicitWait(google);
		google.click();
	}
	
	public void clickLogo() {
		scrollToElement(zigWheelsLogo,zigWheelsLogo);
	}
	
}
