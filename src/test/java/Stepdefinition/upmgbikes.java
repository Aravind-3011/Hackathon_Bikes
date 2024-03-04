package Stepdefinition;

import java.io.IOException;

import org.testng.Assert;

import factory.BaseClassFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.homePage;
import pageObject.upmgBikes;
import utilities.ExcelUtlis;

public class upmgbikes extends BaseClassFactory {

	
	homePage hmp=new homePage(BaseClassFactory.getDriver());
	upmgBikes upb =new upmgBikes(BaseClassFactory.getDriver());
	 Hooks hook = new Hooks();
	
@Given("to launch the website zigwheels")
public void to_launch_the_website_zigwheels() throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
  
   boolean title= BaseClassFactory.getDriver().getTitle().contains("ZigWheels");
   Assert.assertEquals(title, true);
}

@When("hover to new bikes")
public void hover_to_new_bikes() {
    // Write code here that turns the phrase above into concrete actions
	 hmp.hoverNewbk();
	
}

@Then("click upcoming bikes")
public void click_upcoming_bikes() {
    // Write code here that turns the phrase above into concrete actions
	hmp.upmgBike();
}

@When("click on manufacturers")
public void click_on_manufacturers() {
    // Write code here that turns the phrase above into concrete actions
	
	upb.manufactures();
	
	
}

@Then("click on honda")
public void click_on_honda() {
	//To click honda
		upb.clickHonda();
}

@Then("click see more")
public void click_see_more() {
    // Write code here that turns the phrase above into concrete actions
   upb.SeeMore();
}

@Then("get details of all bikes less than {int} lakhs")
public void get_details_of_all_bikes_less_than_lakhs(Integer int1) throws IOException {
    // Write code here that turns the phrase above into concrete actions
	ExcelUtlis excel=new ExcelUtlis();
	excel.createSheets();
	int j=1;
	for(int i=0;i<upb.bkName().size();i++) {
    	   String bikname=upb.bkName().get(i).getText();
			String bikprice=upb.bkPrice().get(i).getText();
			String bklaunch=upb.lnDate().get(i).getText();
			
			
			if(bikprice.contains("Lakh")) {
				String[] price=bikprice.split(" ");
				float value=Float.parseFloat(price[1]);
				if(value<=4.0) {
					System.out.println(bikname+"  ---  "+bikprice+"  ---  "+bklaunch);
					excel.writeData("Honda Bikes <4L", j, 0, bikname);
					excel.writeData("Honda Bikes <4L", j, 1, bikprice);
					excel.writeData("Honda Bikes <4L", j, 2, bklaunch);
					j=j+1;
					}
			}
			else {
				System.out.println(bikname+"  ---  "+bikprice+"  ---  "+bklaunch);
				excel.writeData("Honda Bikes <4L", j, 0, bikname);
				excel.writeData("Honda Bikes <4L", j, 1, bikprice);
				excel.writeData("Honda Bikes <4L", j, 2, bklaunch);
				j=j+1;
		     	}
		    	}
			
			}
}


