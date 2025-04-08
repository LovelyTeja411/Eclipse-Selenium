package pom_Resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
//	Constructor to initialize elements
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	  Locators using @FindBy annotation	
	@FindBy(id="mat-input-0") WebElement textLoginId;
	@FindBy(xpath = "//input[@ng-reflect-name='User_WebPswrd']") WebElement textPassword;
	@FindBy(xpath = "//button[text()='Login']") WebElement loginButton;
	
//	Actions (Methods)
	public void enterusername(String username) {
		textLoginId.sendKeys(username);
	}
	public void enterPassword(String password) {
		textPassword.sendKeys(password);
	}
	public void clickLogin() {
		loginButton.click();
	}
	
}
