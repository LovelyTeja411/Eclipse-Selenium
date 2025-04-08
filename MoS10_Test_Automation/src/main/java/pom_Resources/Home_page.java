package pom_Resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_page {
	WebDriver driver;
	
//	Constructor to initialize elements
	public Home_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(tagName = "img") WebElement minibar_Logo;
	@FindBy(xpath = "//span[text()='Rooms']") WebElement room_ModuleElement;
	@FindBy(linkText = "Rooms") WebElement room_ComponentElement;
	@FindBy(xpath = "//div[text()='Rooms']") WebElement roomScreenHeadLine;
	@FindBy(xpath = "//button[contains(text(),'Add')]") WebElement addButton;
	public void mb_Logo() {
		Boolean k = minibar_Logo.isDisplayed();
		System.out.println(k);
		String mini_URL = minibar_Logo.getDomAttribute("src");
		
		if (mini_URL.equalsIgnoreCase("assets/minibart.png")) {
			System.out.println(mini_URL);
		}
		else {
			System.out.println("The MiniBar Logo is not present, it seems you were on Wrong location");
		}
	}
	public void clickRoomModule() {
		room_ModuleElement.isDisplayed();
		room_ModuleElement.click();
	}
	public void navigateToRoomSubModule() {
		room_ComponentElement.click();
		if (roomScreenHeadLine.isDisplayed()) {
			System.out.println("Room Component Heading" + roomScreenHeadLine.getText());
		}
	}
	public void addRoom() {
		addButton.click();
	}
}
