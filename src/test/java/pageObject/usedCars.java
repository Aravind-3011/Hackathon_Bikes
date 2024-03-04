package pageObject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.ExcelUtlis;

public class usedCars extends basePage{

	public usedCars(WebDriver driver) {
	super(driver);
	}

	//Elements
	
	@FindBy(xpath="//div[@class='gsc_thin_scroll']/ul/li")
	List<WebElement> usdcars;
	
	@FindBy(xpath= "//img[@data-track-label='zw-header-logo']")
	WebElement clickLogo;
	
	//action class
	public List<WebElement> togetNewCars() throws IOException {
		ExcelUtlis excel=new ExcelUtlis();
		for(int i=0;i<usdcars.size();i++) {
			String carname=usdcars.get(i).getText();
					excel.writeData("Popular Model Cars", i, 0, carname);
					System.out.println(carname);
				}
		return usdcars;
		  }

	
	public void toclicklogo() {
		clickLogo.click();
	}
}
