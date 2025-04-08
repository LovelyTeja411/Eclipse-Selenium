package baseResource;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import genericUtilities.FileUtility;
import genericUtilities.WebDriverUtilities;

public class Base_Class {
//	Driver Instantiation
	public WebDriver driver;
//	To provide the wait time to find the elements(Called from Generic Utilities > WebDriver Utilities Class(Implicit wait))
	public WebDriverUtilities webDriverUtils = new WebDriverUtilities();
//	To read the data from Properties (called from Generic utilities > File UtilitiesClass (Linked with Property File))
	public FileUtility fileUtils = new FileUtility();
	
//	Pre-Requisites
	@BeforeClass
	public void executeBeforeClass() throws IOException {
//		Verification of browser
		String browserName = fileUtils.readTheDataFromPropertyFile("browser");
		if (browserName.equals("chrome")) {
			driver=new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		webDriverUtils.impliciteWait(driver);
		driver.get(fileUtils.readTheDataFromPropertyFile("url"));
	}
	
//	Post-Requisites
	@AfterClass
	public void executeAfterClass() {
		driver.manage().window().minimize();
		driver.quit();
	}
	
}
