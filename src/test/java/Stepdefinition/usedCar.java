package Stepdefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import factory.BaseClassFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.homePage;
import pageObject.upmgBikes;
import pageObject.usedCars;

public class usedCar extends BaseClassFactory{
	upmgBikes upb =new upmgBikes(BaseClassFactory.getDriver());
    homePage hmp =new homePage(BaseClassFactory.getDriver());
    usedCars usCars= new usedCars(BaseClassFactory.getDriver());

	@Given("user to navigate homepage")
	public void user_to_navigate_homepage() {
		  
    	  upb.logoClick();
	}

	@When("hover to used cars")
	public void hover_to_used_cars() {

		  hmp.hoverNewCars();
    	 
	}

	@Then("click chennai and view results")
	public void click_chennai_and_view_results() {
		 hmp.clickChn();
	}

	@Then("get all the popular car models")
	public void get_all_the_popular_car_models() throws IOException {
		
   	  usCars.togetNewCars(); 
	}
}
