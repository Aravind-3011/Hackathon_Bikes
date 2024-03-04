package testBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Driver {
	
	 public WebDriver driver;
	 
	 @Parameters({"browser"})
	 @BeforeClass (groups = {"smoke","regression","master"})
	 public  void driverSetup(String string ) throws InterruptedException {
//		 ChromeOptions options1 = new ChromeOptions();
//			options1.addArguments("--disable-notifications");
//			options1.addArguments("--disable-popup-blocking");
//			driver = new ChromeDriver(options1);
		 
		 
			switch (string) {
			 
			case "1":
	 
				ChromeOptions options1 = new ChromeOptions();
				options1.addArguments("--disable-notifications");
				options1.addArguments("--disable-popup-blocking");
				driver = new ChromeDriver(options1);
				break;
	 
			case "2":
	 
				EdgeOptions options2 = new EdgeOptions();
	 
				options2.addArguments("--disable-notifications");
	 
				options2.addArguments("--disable-popup-blocking");
	 
				driver = new EdgeDriver(options2);
	 
				break;
	 
			}
	 
			 driver.manage().window().maximize();
		 driver.get("https://www.zigwheels.com/");
		
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		 
	 }

}

