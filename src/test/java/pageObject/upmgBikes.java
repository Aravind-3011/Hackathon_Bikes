package pageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class upmgBikes  extends homePage {

	public upmgBikes(WebDriver driver) {
	super(driver);
	}

	
	//Elements
	@FindBy(xpath ="//select[@id='makeId']")
	WebElement clickManufactures;
	
	@FindBy(xpath ="//*[@id=\"makeId\"]/option[4]")
	WebElement ClickHonda;
	
	
	@FindBy(xpath ="//*[@id=\"modelList\"]/li[16]/span")
	WebElement seeMore;
	
	@FindBy(xpath ="//a[@data-track-label='model-name']")
	List<WebElement> bikeName;
	
	@FindBy(xpath= "//div[@class='b fnt-15']")
	List<WebElement> bikeprice;
	
	@FindBy(xpath="//div[@class='clr-try fnt-14']")
	List<WebElement> launchDate;
	
	@FindBy(xpath ="//img[@data-track-label='zw-header-logo']")
	WebElement clickOnLogo;
			
	
	//Action class
	
	public void manufactures() {
		clickManufactures.click();
	}
	
	
	public void clickHonda() {
		ClickHonda.click();
	}
	public void SeeMore() {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()",seeMore);
	}
		
	public List<WebElement> bkName() {
		return bikeName;
	}
	
	public List<WebElement> bkPrice() {
		return bikeprice;
	}
	
	public List<WebElement> lnDate() {
		return launchDate;
	}
	
	public void logoClick() {
		clickOnLogo.click();
	}
	
}
