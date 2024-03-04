package Stepdefinition;

import java.util.Set;

import factory.BaseClassFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.homePage;
import pageObject.login;
import pageObject.usedCars;
import utilities.screenShot;

public class Invduser extends BaseClassFactory{
	
	 usedCars usCars= new usedCars(BaseClassFactory.getDriver());
	 homePage hmp =new homePage(BaseClassFactory.getDriver());
	 login lng=new login(BaseClassFactory.getDriver());
	 
	@Given("user to navigate to home page")
	public void user_to_navigate_to_home_page() {
		
   	  usCars.toclicklogo();

       
	}

	@When("clicks login")
	public void clicks_login() {
		  //login
	   	 
	   	  hmp.toClickLogin();
	   	  
	}

	@Then("clicks google")
	public void clicks_google() throws InterruptedException {
	  hmp.toClickGoogle();
  	  Thread.sleep(5000);
  	  
  	  
  	  Set<String> allWindowHandles = BaseClassFactory.getDriver().getWindowHandles();
  	  String[] windowId=allWindowHandles.toArray(new String[allWindowHandles.size()] );
  	BaseClassFactory.getDriver().switchTo().window(windowId[1]);
	}

	@When("user enters the invalid mailId")
	public void user_enters_the_invalid_mail_id() {
		 
   	  lng.enterMailId();
   	  
   	  lng.clickNext();
   	  
	}

	@Then("shows a error message and take screenshot")
	public void shows_a_error_message_and_take_screenshot() throws Exception {
		 System.out.println("Error Message: " );
   	  screenShot.TakeScrShot(BaseClassFactory.getDriver());
   	  
  
	}

	




}
