package testBase;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObject.homePage;
import pageObject.login;
import pageObject.upmgBikes;
import pageObject.usedCars;
import utilities.ExcelUtlis;
import utilities.screenShot;

public class testCase  extends Driver{

	@Test(priority=1 ,groups = {"smoke","regression","master"})
	public void  upcmg () throws Exception {
		//To hover to new bikes
		homePage hmp=new homePage(driver);
		hmp.hoverNewbk();
		Thread.sleep(2000);
		screenShot.TakeScrShot(driver);
		
		//To click upcoming bikes
		hmp.upmgBike();
		
		//To click manufactures
		upmgBikes upb =new upmgBikes(driver);
		upb.manufactures();
		
		//To click honda
		upb.clickHonda();
				
		upb.SeeMore();
		screenShot.TakeScrShot(driver);
		ExcelUtlis excel=new ExcelUtlis();
		excel.createSheets();
		List<WebElement> bknames=upb.bkName();
		List<WebElement> bkprices=upb.bkPrice();
		List<WebElement> bklaunches=upb.lnDate();
		
		int j=1;
		for(int i=0;i<bknames.size();i++) {
	    	   String bikname=bknames.get(i).getText();
				String bikprice=bkprices.get(i).getText();
				String bklaunch=bklaunches.get(i).getText();
				
				
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
		

	@Test(priority=2 ,groups = {"smoke","regression","master"})
      public void usdcars () throws Exception {
    	  upmgBikes upb =new upmgBikes(driver);
    	  upb.logoClick();
    	  
    	  homePage hmp =new homePage(driver);
    	  hmp.hoverNewCars();
    	  Thread.sleep(2000);
    	  screenShot.TakeScrShot(driver);
    	  hmp.clickChn();
    	  
    	  usedCars usCars= new usedCars(driver);
    	  usCars.togetNewCars(); 
    	  Thread.sleep(2000);
    	  screenShot.TakeScrShot(driver);
    	  }
      
	@Test(priority=3 ,groups = {"smoke","regression","master"})
      public void invUsed() throws Exception {
    	  usedCars usCars= new usedCars(driver);
    	  usCars.toclicklogo();

          //login
    	  homePage hmp =new homePage(driver);
    	  hmp.toClickLogin();
    	  Thread.sleep(2000);
    	  screenShot.TakeScrShot(driver);
    	  
    	 //to click google
    	  Thread.sleep(3000);
    	  hmp.toClickGoogle();
    	  Thread.sleep(3000);
    	  
    	  
    	  Set<String> allWindowHandles = driver.getWindowHandles();
    	  String[] windowId=allWindowHandles.toArray(new String[allWindowHandles.size()] );
    	  driver.switchTo().window(windowId[1]);
    	  
    	  login lng=new login(driver);
    	  lng.enterMailId();
    	  
    	  lng.clickNext();
    	  Thread.sleep(10000);
    	  screenShot.TakeScrShot(driver);
    	  login lg = new login(driver);
    	  
    	  System.out.println("Error Message: "+lg.ErrorMsg() );
    	 
    	  
    	  driver.quit();
      }
}      

