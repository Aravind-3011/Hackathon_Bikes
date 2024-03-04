package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class homePage  extends  basePage{
	
	
	public homePage(WebDriver driver) {
	super(driver);
	}

//Elements
@FindBy(xpath="//*[@id='headerNewNavWrap']/nav/div/ul/li[3]/a")
public static
WebElement hoverNewBikes;

@FindBy(xpath ="//span[@onclick=\"goToUrl('/upcoming-bikes')\"]")
WebElement clickUpcmgbikes;

@FindBy(xpath= "//a[@href=\"/used-car\"]")
WebElement hoverToUsedCars;

@FindBy(xpath="//span[@onclick=\"goToUrl('/used-car/Chennai')\"]")
WebElement toClickChennai;

@FindBy(xpath= "//div[@id='forum_login_wrap_lg']")
WebElement ClickLogin;

@FindBy(xpath= "//div[@class='newgf-login']//div[@class='lgn-sc c-p txt-l pl-30 pr-30 googleSignIn']")
WebElement ClickGoogle;


//action class

public void hoverNewbk(){
	Actions actions = new Actions(driver);
	actions.moveToElement(hoverNewBikes).perform();
	
}

public void upmgBike() {
	clickUpcmgbikes.click();
}

public void hoverNewCars() {
	Actions action = new Actions(driver);
	  action.moveToElement(hoverToUsedCars).perform();
	  }

public void clickChn() {
	  toClickChennai.click();
}
public void toClickLogin() {
	ClickLogin.click();
}
public void toClickGoogle() {
	ClickGoogle.click();
}

}