package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class login extends basePage {
	

	public login(WebDriver driver) {
		super(driver);
	}

	//Elements
	
	@FindBy(id= "identifierId")
	WebElement mailId;
	
	@FindBy(xpath= "//*[@id=\"identifierNext\"]/div/button/span")
	WebElement ClickNext;
	
	@FindBy(xpath="//div[@class='o6cuMc Jj6Lae']")
	
	WebElement errorMsg;

//action class


public void enterMailId() {
	mailId.sendKeys("abc@gmail.com");
}
public void clickNext() {
	JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("arguments[0].click();", ClickNext);
}
public String ErrorMsg() {
	String error =errorMsg.getText();
	return error;
}
}
