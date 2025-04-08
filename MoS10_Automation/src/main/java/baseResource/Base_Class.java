package baseResource;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import genericUtilities.FileUtility;
import genericUtilities.WebDriverUtilities;

public class Base_Class {
	public WebDriver driver;
	public WebDriverUtilities webDriverUtils = new WebDriverUtilities();
	public FileUtility fileUtils = new FileUtility();
	
	@BeforeTest
	public void initializeBrowser() {
		
	}
	
}
